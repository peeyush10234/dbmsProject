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
                            displayMenu.printMenu("Information processing");
                            currMenu = "Information processing";
                            break;
                        case "2":
                            displayMenu.printMenu("Maintaining inventory records");
                            currMenu = "Maintaining inventory records";
                            break;

                        case "3":
                            displayMenu.printMenu("Maintaining billing and transaction records");
                            currMenu = "Maintaining billing and transaction records";
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
                    break;
                case "Reports":
//                    System.out.println("Enter Required OptionL");
//                    userInput = scanner.nextLine();
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
                            break;

                        case "8":
                            System.out.println("Enter ProductID");
                            sc = new Scanner(System.in);
                            String productID = sc.nextLine();
                            generateReports.merchandiseReportProduct(productID);
                            break;

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
                            System.out.println("Enter CustomerID");
                            sc = new Scanner(System.in);
                            String customerID = sc.nextLine();
                            generateReports.getCustomerPurchaseReportPeriod(customerID, date1, date2);
                            break;

                        case "14":
                            displayMenu.printMenu("Main Menu");
                            currMenu = "Main Menu";
                            break;

                        case "15":
                            quit = true;
                            break;
                    }
                    break;
                case "Maintaining inventory records":

                    switch (userInput){
                        case "1":
                            addData.addInventory();
                            // Display all three tables
                        case "2":
                            addData.addReturn();
                            // Display the two tables involved
                        case "3":
                            addData.addTransfers();
                            // Display the tables involved
                        case "4":
                            displayMenu.printMenu("Main Menu");
                            currMenu = "Main Menu";
                            break;
                        case "5":
                            quit = true;
                            break;

                    }
                    break;
                case "Maintaining billing and transaction records":

                    switch (userInput){
                        case "1":
                            System.out.println("Enter Supplier ID");
                            Scanner sa = new Scanner(System.in);
                            String SupplierID = sa.nextLine();
                            billingRecords.generateSupplierBill(SupplierID);
                            break;

                        case "2":
                            billingRecords.generateAllSuppliersBill();
                            break;

                        case "3":
                            System.out.println("Enter the Year for Rewards needs to be calculated");
                            Scanner sf = new Scanner(System.in);
                            String Year = sf.nextLine();
                            billingRecords.generatePlatinumCustomersYearlyReward(Year);
                            break;
                        case "4":
                            addData.addTransaction();

                        case "5":
                            displayMenu.printMenu("Main Menu");
                            currMenu = "Main Menu";
                            break;

                        case "6":
                            quit = true;
                            break;
                    }
                    break;
                default:
                    break;

            }

        }
    }


}

