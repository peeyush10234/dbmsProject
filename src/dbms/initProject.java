package dbms;

import java.sql.*;
import java.util.Scanner;

public class initProject {
    // Establish connection
    public static Connection connection;
    public static Statement statement;
    public static ResultSet result;
    public static final String jdbcURL = "jdbc:mariadb://classdb2.csc.ncsu.edu:3306/ptaneja";
    public static final String user = "ptaneja";
    public static final String password = "200371037";
    public static String curr = "Main Menu";
    public static String userInput = "";
    public static boolean quit = false;
    public static void connectToDatabase() {
        try {
            // Loading the driver. This creates an instance of the driver
            // and calls the registerDriver method to make MySql(MariaDB) Thin available to
            // clients.
            Class.forName("org.mariadb.jdbc.Driver");
            connection = null;
            statement = null;
            result = null;

            try {
                // Get a connection instance from the first driver in the
                // DriverManager list that recognizes the URL jdbcURL
                connection = DriverManager.getConnection(jdbcURL, user, password);
                // Create a statement instance that will be sending
                // your SQL statements to the DBMS
                statement = connection.createStatement();
            } finally {
                System.out.println("Database connected");
            }
        } catch (Throwable oops) {
            oops.printStackTrace();
        }
    }

    public static void main(String[] args) throws SQLException {
        System.out.println("Hello");
        connectToDatabase();
        addData.addInventory();
//        initTables.createTable();
//        initTables.addData();
        // generateReports.testQueriesReport();
        String currMenu  = "Main Menu";

        displayMenu.printMenu(currMenu);
        Scanner scanner = new Scanner(System.in);
        while(!quit){
            System.out.println("Enter Required Option");
            userInput = scanner.nextLine();
            switch (currMenu){
                case "Main Menu":
                    switch(userInput){
                        case "1":
                            displayMenu.printMenu("");
                            currMenu = "";
                            break;
                        case "2":
                            displayMenu.printMenu("2");
                            currMenu = "1";
                            break;

                        case "3":
                            displayMenu.printMenu("3");
                            currMenu = "3";
                            break;

                        case "4":
                            displayMenu.printMenu("Reports");
                            currMenu = "Reports";
                            break;

                        case "5":
                            quit = true;
                            break;

                        default:
                            displayMenu.printMenu("Main Menu");
                            break;
                    }

                case "Reports":
                    System.out.println("Enter Required Option");
                    userInput = scanner.nextLine();
                    switch(userInput){
                        case "1":
                            System.out.println("Enter the Year");
                            Scanner sc = new Scanner(System.in);
                            String year = sc.nextLine();
                            generateReports.totalSalesReportYearly(year);
                            break;

                        case "2":
                            System.out.println("Enter the Year");
                            sc = new Scanner(System.in);
                            year = sc.nextLine();
                            System.out.println("Enter the Month");
                            sc = new Scanner(System.in);
                            String month = sc.nextLine();
                            generateReports.totalSalesReportMonthly(year, month);
                            break;

                        case "3":
                            System.out.println("Enter date");
                            sc = new Scanner(System.in);
                            String date  = sc.nextLine();
                            generateReports.totalSalesReportDay(date);
                            break;

                        case "4":
                            System.out.println("Enter Year");
                            sc = new Scanner(System.in);
                            year = sc.nextLine();
                            System.out.println("Enter StoreID");
                            sc = new Scanner(System.in);
                            String storeID = sc.nextLine();
                            generateReports.storeSalesYearly(year, storeID);
                            break;

                        case "5":
                            System.out.println("Enter Year");
                            sc = new Scanner(System.in);
                            year = sc.nextLine();
                            System.out.println("Enter the Month");
                            sc = new Scanner(System.in);
                            month = sc.nextLine();
                            System.out.println("Enter StoreID");
                            sc = new Scanner(System.in);
                            storeID = sc.nextLine();
                            generateReports.storeSalesReportMonthly(year, month, storeID);
                            break;

                        case "6":
                            System.out.println("Enter date1");
                            sc = new Scanner(System.in);
                            String date1 = sc.nextLine();
                            System.out.println("Enter date2");
                            sc = new Scanner(System.in);
                            String date2 = sc.nextLine();
                            System.out.println("Enter StoreID");
                            sc = new Scanner(System.in);
                            storeID = sc.nextLine();
                            generateReports.storeSalesReportPeriod(date1, date2, storeID);
                            break;

                        case "7":
                            generateReports.merchandiseReport();

                        case "8":
                            System.out.println("Enter ProductID");
                            sc = new Scanner(System.in);
                            String productID = sc.nextLine();
                            generateReports.merchandiseReportProduct(productID);

                        case "9":
                            System.out.println("Enter the Year");
                            sc = new Scanner(System.in);
                            year = sc.nextLine();
                            generateReports.getCustomerReportYearly(year);
                            break;

                        case "10":
                            System.out.println("Enter the Year");
                            sc = new Scanner(System.in);
                            year = sc.nextLine();
                            System.out.println("Enter the Month");
                            sc = new Scanner(System.in);
                            month = sc.nextLine();
                            generateReports.getCustomerReportMonthly(year, month);
                            break;

                        case "11":
                            System.out.println("Enter date1");
                            sc = new Scanner(System.in);
                            date1 = sc.nextLine();
                            System.out.println("Enter date2");
                            sc = new Scanner(System.in);
                            date2 = sc.nextLine();
                            generateReports.getCustomerReportPeriod(date1, date2);
                            break;

                        case "12":
                            System.out.println("Enter date1");
                            sc = new Scanner(System.in);
                            date1 = sc.nextLine();
                            System.out.println("Enter date2");
                            sc = new Scanner(System.in);
                            date2 = sc.nextLine();
                            System.out.println("Enter StoreID");
                            sc = new Scanner(System.in);
                            generateReports.getPurchaseReportPeriod(date1, date2);
                            break;

                        case "13":
                            System.out.println("Enter date1");
                            sc = new Scanner(System.in);
                            date1 = sc.nextLine();
                            System.out.println("Enter date2");
                            sc = new Scanner(System.in);
                            date2 = sc.nextLine();
                            System.out.println("Enter StoreID");
                            sc = new Scanner(System.in);
                            System.out.println("Enter CustomerID");
                            sc = new Scanner(System.in);
                            String customerID = sc.nextLine();
                            generateReports.getCustomerPurchaseReportPeriod(customerID, date1, date2);
                            break;
                    }
            }
        }
    }

}

