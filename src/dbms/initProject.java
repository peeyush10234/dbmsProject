package dbms;

import java.sql.*;
import java.util.Scanner;

public class initProject {
    // Establish connection
    public static Connection connection;
    public static Statement statement;
    public static ResultSet result;



//    public static final String jdbcURL = "jdbc:mariadb://classdb2.csc.ncsu.edu:3306/ptaneja";
//    public static final String user = "ptaneja";
//    public static final String password = "200371037";


//    User Credentials
    public static final String jdbcURL = "jdbc:mariadb://localhost:3310/jsukhad";
    public static final String user = "root";

    public static final String password = "1234";

    public static String curr = "Main Menu";
    public static String userInput = "";
    public static boolean quit = false;

//    Helper functions to close the connection established with the DB
    static void close(Connection connection) {
        if (connection != null) {
            try {
                connection.close();
            } catch (Throwable whatever) {
            }
        }
    }

    static void close(Statement statement) {
        if (statement != null) {
            try {
                statement.close();
            } catch (Throwable whatever) {
            }
        }
    }

    static void close(ResultSet result) {
        if (result != null) {
            try {
                result.close();
            } catch (Throwable whatever) {
            }
        }
    }

//    Function to connect with the Database
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
        initTables.createTable();
        initTables.addData();
//        Prints the menu
        String currMenu  = "Main Menu";

        displayMenu.printMenu(currMenu);
        Scanner scanner = new Scanner(System.in);
        try {
            while (!quit) {
//                Different type of menu''s are printed based on the option chosen
                System.out.println("Enter Required Option");
                userInput = scanner.nextLine();
                switch (currMenu) {
                    case "Main Menu":
                        switch (userInput) {
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
                        switch (userInput) {
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
                                String date = sc.nextLine();
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

                        switch (userInput) {
                            case "1":
                                addData.addInventory();
                                displayResults.getMerchandiseInfo();
                                System.out.println("");
                                displayResults.getSellsInfo();
                                System.out.println("");
                                displayResults.getSuppliersInfo();
                                System.out.println("");
                                break;
                            case "2":
                                addData.addReturn();
                                // Display the two tables involved
                                displayResults.getOrdersInfo();
                                System.out.println("");
                                displayResults.getSellsInfo();
                                System.out.println("");
                                displayResults.getReturnsInfo();
                                System.out.println("");
                                break;
                            case "3":
                                addData.addTransfers();
                                displayResults.getTransferInfo();
                                System.out.println("");
                                displayResults.getSellsInfo();
                                System.out.println("");
                                break;
                                // Display the tables involve
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

                        switch (userInput) {
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
                                System.out.println("");
                                displayResults.getTransactionInfo();
                                System.out.println("");
                                displayResults.getOrdersInfo();
                                break;
                            case "5":
                                displayMenu.printMenu("Main Menu");
                                currMenu = "Main Menu";
                                break;

                            case "6":
                                quit = true;
                                break;
                        }
                        break;

                    case "Information processing":

                        switch (userInput){
                            case "1.1":
                                addData.addStaff();
                                displayResults.getStaffInfo();
                                System.out.println();
                                break;

                            case "1.2":
                                updateProcess.toUpdateStaffData();
                                displayResults.getStaffInfo();
                                System.out.println();
                                break;

                            case "1.3":
                                deleteProcess.deleteStaffInfo();
                                displayResults.getStaffInfo();
                                System.out.println();
                                break;
                            case "2.1":
                                addData.addStore();
                                displayResults.getStoreInfo();
                                System.out.println();
                                break;

                            case "2.2":
                                updateProcess.toUpdateStoreData();
                                displayResults.getStoreInfo();
                                System.out.println();
                                break;

                            case "2.3":
                                deleteProcess.deleteStoreInfo();
                                displayResults.getStoreInfo();
                                System.out.println();
                                break;

                            case "3.1":
                                addData.addSupplier();
                                displayResults.getSuppliersInfo();
                                System.out.println();
                                break;

                            case "3.2":
                                updateProcess.toUpdateSupplierData();
                                displayResults.getSuppliersInfo();
                                System.out.println();
                                break;

                            case "3.3":
                                deleteProcess.deleteSupplierInfo();
                                displayResults.getSuppliersInfo();
                                System.out.println();
                                break;
                            case "4.1":
                                addData.addClubMember();
                                displayTables.getClubMembersInfo();
                                System.out.println();
                                displayTables.getSignUpInfo();
                                System.out.println();
                                break;

                            case "4.2":
                                updateProcess.toUpdateClubMembersData();
                                displayTables.getClubMembersInfo();
                                System.out.println();
                                break;

                            case "4.3":
                                deleteProcess.deleteClubMembersInfo();
                                displayTables.getClubMembersInfo();
                                System.out.println();
                                break;

                            case "5.1":
                                addData.addMemberships();
                                displayTables.getMembershipLevelInfo();
                                System.out.println();
                                break;

                            case "5.2":
                                updateProcess.toUpdateMembershipData();
                                displayTables.getMembershipLevelInfo();
                                System.out.println();
                                break;

                            case "5.3":
                                deleteProcess.deleteMembershipInfo();
                                displayTables.getMembershipLevelInfo();
                                System.out.println();
                                break;

                            case "6.1":
                                addData.addDiscount();
                                displayTables.getDiscountInfo();
                                System.out.println();
                                break;

                            case "6.2":
                                updateProcess.toUpdateDiscountData();
                                displayTables.getDiscountInfo();
                                System.out.println();
                                break;

                            case "6.3":
                                deleteProcess.deleteDiscountInfo();
                                displayTables.getDiscountInfo();
                                System.out.println();
                                break;

                            case "7":
                                displayMenu.printMenu("Main Menu");
                                currMenu = "Main Menu";
                                break;

                            case "8":
                                quit = true;
                                break;
                        }
                        break;

                    default:
                        break;

                }

            }
        }catch(Exception e){
            e.printStackTrace();;
        } finally {
            close(connection);
            close(statement);
            close(result);
        }
    }


}

