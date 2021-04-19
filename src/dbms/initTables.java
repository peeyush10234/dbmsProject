package dbms;


import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class initTables {
    public static void createTable() throws SQLException {
        initProject.connection.setAutoCommit(false);
        try{
            initProject.statement.executeUpdate("CREATE TABLE IF NOT EXISTS `Store` ("
                    + "`StoreID` VARCHAR(20) NOT NULL, "
                    + "`StoreAddress` VARCHAR(100) NOT NULL, "
                    + "`PhoneNo` VARCHAR(20) NOT NULL, "
                    + "`ManagerID` int NOT NULL, "
                    + "PRIMARY KEY (`StoreID`));");

            initProject.statement.executeUpdate("CREATE TABLE IF NOT EXISTS `Staff` ("
                    + "`StaffID` INT NOT NULL, "
                    + "`Name` varchar(50) NOT NULL, "
                    + "`Age` int NOT NULL, "
                    + "`StoreID` VARCHAR(20) NOT NULL, "
                    + "`JobTitle` varchar(40) NOT NULL, "
                    + "`Phone` varchar(30) NOT NULL, "
                    + "`Email` varchar(50) NOT NULL, "
                    + "`TimeOfEmployment` Date NOT NULL, "
                    + "`HomeAddress` varchar(50), "
                    + "PRIMARY KEY (`StaffID`), "
                    + "FOREIGN KEY (`StoreID`) REFERENCES Store(`StoreID`) ON UPDATE CASCADE ON DELETE CASCADE);");

            initProject.statement.executeUpdate("CREATE TABLE IF NOT EXISTS `Supplier` ("
                    + "`SupplierID` VARCHAR(20) NOT NULL, "
                    + "`Location` VARCHAR(100) NOT NULL, "
                    + "`PhoneNo` VARCHAR(20) NOT NULL, "
                    + "`EmailAddress` VARCHAR(20), "
                    + "`Name` VARCHAR(20) NOT NULL, "
                    + "PRIMARY KEY (`SupplierID`));");

            initProject.statement.executeUpdate("CREATE TABLE IF NOT EXISTS `Merchandise` ("
                    + "`ProductID` varchar(20) NOT NULL ,"
                    + "`StoreID` varchar(20) NOT NULL, "
                    + "`ProductName`  VARCHAR(50) NOT NULL, "
                    + "`ExpirationDate` DATE, "
                    + "`ProductionDate` DATE, "
                    + "`SellPrice` INT NOT NULL, "
                    + "FOREIGN KEY (`StoreID`) REFERENCES Store(`StoreID`) ON UPDATE CASCADE  ON DELETE CASCADE,"
                    + "PRIMARY KEY (`ProductID`, `StoreID`));");

            initProject.statement.executeUpdate("CREATE TABLE IF NOT EXISTS `Discount` ("
                    + "`DiscountID` varchar(20) PRIMARY KEY NOT NULL, "
                    + "`ProductID` varchar(20) NOT NULL, "
                    + "`StartDate` DATE NOT NULL, "
                    + "`EndDate` DATE NOT NULL, "
                    + "`Amount` FLOAT NOT NULL, "
                    + "FOREIGN KEY (`ProductID`) REFERENCES Merchandise(`ProductID`) ON UPDATE CASCADE  ON DELETE CASCADE); ");

            initProject.statement.executeUpdate("CREATE TABLE IF NOT EXISTS `Memberships` ("
                    + "`MembershipLevel` VARCHAR(50) NOT NULL PRIMARY KEY, "
                    + "`Reward` FLOAT NOT NULL); ");

            initProject.statement.executeUpdate("CREATE TABLE IF NOT EXISTS `Supply` ("
                    + "`SupplyID` int NOT NULL AUTO_INCREMENT,"
                    + "`SupplierID` varchar(20) NOT NULL, "
                    + "`ProductID` varchar(20) NOT NULL, "
                    + "`StoreID` varchar(20) NOT NULL,"
                    + "`BuyPrice` int NOT NULL, "
                    + "`Quantity` int NOT NULL, "
                    + "PRIMARY KEY (`SupplyID`), "
                    + "FOREIGN KEY (`SupplierID`) REFERENCES Supplier(`SupplierID`) ON UPDATE CASCADE  ON DELETE CASCADE,"
                    + "FOREIGN KEY (`ProductID`) REFERENCES Merchandise(`ProductID`) ON UPDATE CASCADE  ON DELETE CASCADE,"
                    + "FOREIGN KEY (`StoreID`) REFERENCES Store(`StoreID`) ON UPDATE CASCADE  ON DELETE CASCADE) ;");

            initProject.statement.executeUpdate("CREATE TABLE IF NOT EXISTS `ClubMembers` ("
                    + "`CustomerID` varchar(20) PRIMARY KEY NOT NULL, "
                    + "`FirstName` VARCHAR(40) NOT NULL, "
                    + "`LastName` VARCHAR(40) NOT NULL, "
                    + "`PhoneNo` VARCHAR(40) NOT NULL, "
                    + "`ActiveStatus` VARCHAR(5) NOT NULL, "
                    + "`MembershipLevel` VARCHAR(50) , "
                    + "`Email` VARCHAR(50) NOT NULL, "
                    + "`Address` VARCHAR(100) NOT NULL, "
                    + "FOREIGN KEY (`MembershipLevel`) REFERENCES Memberships(`MembershipLevel`) ON UPDATE CASCADE  ON DELETE SET NULL); ");

            initProject.statement.executeUpdate("CREATE TABLE IF NOT EXISTS `Transfer` ("
                    + "`TransferID` varchar(20) PRIMARY KEY NOT NULL AUTO_INCREMENT,"
                    + "`SourceID` varchar(20) NOT NULL, "
                    + "`DestinationID` varchar(20) NOT NULL, "
                    + "`OperatorID` int NOT NULL, "
                    + "`Quantity` INT NOT NULL, "
                    + "`ProductID` varchar(20) NOT NULL, "
                    + "FOREIGN KEY (`SourceID`) REFERENCES `Store`(`StoreID`) ON UPDATE CASCADE  ON DELETE CASCADE, "
                    + "FOREIGN KEY (`DestinationID`) REFERENCES `Store`(`StoreID`) ON UPDATE CASCADE  ON DELETE CASCADE, "
                    + "FOREIGN KEY (`OperatorID`) REFERENCES `Staff`(`StaffID`) ON UPDATE CASCADE  ON DELETE CASCADE, "
                    + "FOREIGN KEY (`ProductID`) REFERENCES `Merchandise`(`ProductID`) ON UPDATE CASCADE  ON DELETE CASCADE); ");

            initProject.statement.executeUpdate("CREATE TABLE IF NOT EXISTS `Returns` ("
                    + "`ReturnID` varchar(20) PRIMARY KEY NOT NULL, "
                    + "`SupplierID` varchar(20) NOT NULL, "
                    + "`StoreID` varchar(20) NOT NULL, "
                    + "`ProductID` varchar(20) NOT NULL,"
                    + "`Quantity` INT NOT NULL, "
                    + "`OperatorID` int NOT NULL, "
                    + "FOREIGN KEY (`SupplierID`) REFERENCES `Supply`(`SupplierID`) ON UPDATE CASCADE  ON DELETE CASCADE, "
                    + "FOREIGN KEY (`StoreID`) REFERENCES `Store`(`StoreID`) ON UPDATE CASCADE  ON DELETE CASCADE, "
                    + "FOREIGN KEY (`OperatorID`) REFERENCES `Staff`(`StaffID`) ON UPDATE CASCADE  ON DELETE CASCADE, "
                    + "FOREIGN KEY (`ProductID`) REFERENCES `Merchandise`(`ProductID`) ON UPDATE CASCADE  ON DELETE CASCADE); " );

            initProject.statement.executeUpdate("CREATE TABLE IF NOT EXISTS `Sells` ("
                    + "`StoreID` varchar(20) NOT NULL, "
                    + "`ProductID` varchar(20) NOT NULL, "
                    + "`Quantity` INT NOT NULL, "
                    + "PRIMARY KEY(`StoreID`, `ProductID`), "
                    + "FOREIGN KEY (`StoreID`) REFERENCES `Store`(`StoreID`) ON UPDATE CASCADE  ON DELETE CASCADE, "
                    + "FOREIGN KEY (`ProductID`) REFERENCES `Merchandise`(`ProductID`) ON UPDATE CASCADE  ON DELETE CASCADE); ");

            initProject.statement.executeUpdate("CREATE TABLE IF NOT EXISTS `Manage` ("
                    + "`StoreID` varchar(20) PRIMARY KEY NOT NULL,"
                    + "`StaffID` int NOT NULL, "
                    + "FOREIGN KEY (`StoreID`) REFERENCES `Store`(`StoreID`) ON UPDATE CASCADE  ON DELETE CASCADE, "
                    + "FOREIGN KEY (`StaffID`) REFERENCES `Staff`(`StaffID`)ON UPDATE CASCADE  ON DELETE CASCADE); ");

            initProject.statement.executeUpdate("CREATE TABLE IF NOT EXISTS `Transaction` ("
                    + "`TransactionID` varchar(20) PRIMARY KEY NOT NULL,"
                    + "`StoreID` varchar(20) NOT NULL, "
                    + "`CustomerID` varchar(20) NOT NULL, "
                    + "`CashierID` INT NOT NULL, "
                    + "`PurchaseDate` DATE NOT NULL, "
                    + "FOREIGN KEY (`StoreID`) REFERENCES Store(`StoreID`) ON UPDATE CASCADE  ON DELETE CASCADE, "
                    + "FOREIGN KEY (`CustomerID`) REFERENCES ClubMembers(`CustomerID`) ON UPDATE CASCADE  ON DELETE CASCADE, "
                    + "FOREIGN KEY (`CashierID`) REFERENCES Staff(`StaffID`) ON UPDATE CASCADE  ON DELETE CASCADE); ");

            initProject.statement.executeUpdate("CREATE TABLE IF NOT EXISTS `Orders` ("
                    + "`TransactionID` varchar(20) NOT NULL,"
                    + "`ProductID` varchar(20) NOT NULL, "
                    + "`Price` INT NOT NULL, "
                    + "`Quantity` INT NOT NULL, "
                    + "`totalPrice` FLOAT NOT NULL, "
                    + "PRIMARY KEY(`TransactionID`, `ProductID`), "
                    + "FOREIGN KEY (`TransactionID`) REFERENCES Transaction(`TransactionID`) ON UPDATE CASCADE  ON DELETE CASCADE, "
                    + "FOREIGN KEY (`ProductID`) REFERENCES Merchandise(`ProductID`) ON UPDATE CASCADE  ON DELETE CASCADE); ");

            initProject.statement.executeUpdate("CREATE TABLE IF NOT EXISTS `SignUp` ("
                    + "`StoreID` varchar(20) NOT NULL,"
                    + "`StaffID` INT NOT NULL, "
                    + "`CustomerID` varchar(20) NOT NULL, "
                    + "`SignUpDate` DATE NOT NULL, "
                    + "PRIMARY KEY(`CustomerID`), "
                    + "FOREIGN KEY (`StoreID`) REFERENCES Store(`StoreID`) ON UPDATE CASCADE  ON DELETE CASCADE, "
                    + "FOREIGN KEY (`CustomerID`) REFERENCES ClubMembers(`CustomerID`) ON UPDATE CASCADE  ON DELETE CASCADE, "
                    + "FOREIGN KEY (`StaffID`) REFERENCES Staff(`StaffID`) ON UPDATE CASCADE  ON DELETE CASCADE); ");


        }catch (Exception e){
            initProject.connection.rollback();
            e.printStackTrace();
        } finally {
            initProject.connection.setAutoCommit(true);
        }
    }

    public static  void addStoreData(String StoreID, int ManagerID, String StoreAddress, String PhoneNo){
        String sqlStatement = "INSERT INTO `Store` (`StoreID`, `ManagerID`, `StoreAddress`, `PhoneNo`) "
                + "VALUES (?, ?, ?, ?);";

        try{
            initProject.connection.setAutoCommit(false);

            try{
                PreparedStatement insertStoreData = initProject.connection.prepareStatement(sqlStatement);
                insertStoreData.setString(1, StoreID);
                insertStoreData.setInt(2, ManagerID);
                insertStoreData.setString(3, StoreAddress);
                insertStoreData.setString(4, PhoneNo);
                insertStoreData.executeUpdate();
                initProject.connection.commit();

            } catch (SQLException e){
                initProject.connection.rollback();
                e.printStackTrace();
            } finally {
                initProject.connection.setAutoCommit(true);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public static void addStaffData(int  StaffID, String StoreID, String Name, int Age, String HomeAddress,
                                    String JobTitle, String Phone, String Email, String TimeOfEmployment){
        String sqlStatement = "INSERT INTO `Staff` (`StaffID`, `StoreID`, `Name`, `Age`, `HomeAddress`, `JobTitle`, `Phone`, `Email`, `TimeOfEmployment`) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?);";

        try{
            initProject.connection.setAutoCommit(false);

            try{
                PreparedStatement insertStaffData = initProject.connection.prepareStatement(sqlStatement);
                insertStaffData.setInt(1, StaffID);
                insertStaffData.setString(2, StoreID);
                insertStaffData.setString(3, Name);
                insertStaffData.setInt(4, Age);
                insertStaffData.setString(5, HomeAddress);
                insertStaffData.setString(6, JobTitle);
                insertStaffData.setString(7, Phone);
                insertStaffData.setString(8, Email);
                insertStaffData.setDate(9, Date.valueOf(TimeOfEmployment));
                insertStaffData.executeUpdate();
                initProject.connection.commit();

            } catch (SQLException e){
                initProject.connection.rollback();
                e.printStackTrace();
            } finally {
                initProject.connection.setAutoCommit(true);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }

    public static  void addSupplierData(String SupplierID, String Name, String PhoneNo, String EmailAddress, String Location){
        String sqlStatement = "INSERT INTO `Supplier` (`SupplierID`, `Name`, `PhoneNo`, `EmailAddress`, `Location`) "
                + "VALUES (?, ?, ?, ?, ?);";

        try{
            initProject.connection.setAutoCommit(false);

            try{
                PreparedStatement insertSupplierData = initProject.connection.prepareStatement(sqlStatement);
                insertSupplierData.setString(1, SupplierID);
                insertSupplierData.setString(2, Name);
                insertSupplierData.setString(3, PhoneNo);
                insertSupplierData.setString(4, EmailAddress);
                insertSupplierData.setString(5, Location);


                insertSupplierData.executeUpdate();
                initProject.connection.commit();

            } catch (SQLException e){
                initProject.connection.rollback();
                e.printStackTrace();
            } finally {
                initProject.connection.setAutoCommit(true);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public static void addMembershipsData(String MembershipLevel, Float Reward){
        String sqlStatement = "INSERT INTO `Memberships` (`MembershipLevel`, `Reward`)"
                + "VALUES (?, ?);";
        try{
            initProject.connection.setAutoCommit(false);
            try{
                PreparedStatement insertMembershipsData = initProject.connection.prepareStatement(sqlStatement);
                insertMembershipsData.setString(1, MembershipLevel);
                insertMembershipsData.setFloat(2, Reward);
                insertMembershipsData.executeUpdate();
                initProject.connection.commit();

            } catch (SQLException e){
                initProject.connection.rollback();
                e.printStackTrace();
            } finally {
                initProject.connection.setAutoCommit(true);
            }
        } catch(SQLException throwables){
            throwables.printStackTrace();
        }
    }

    public static void addClubMemberData(String CustomerID, String FirstName,  String LastName, String MembershipLevel,
                                         String PhoneNo, String ActiveStatus,   String Email, String Address){
        String sqlStatement = "INSERT INTO `ClubMembers` (`CustomerID`, `FirstName`, `LastName`, `MembershipLevel`, `PhoneNo`, `ActiveStatus`, `Email`, `Address`) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?, ?);";

        try{
            initProject.connection.setAutoCommit(false);

            try{
                PreparedStatement insertClubMemberData = initProject.connection.prepareStatement(sqlStatement);
                insertClubMemberData.setString(1, CustomerID);
                insertClubMemberData.setString(2, FirstName);
                insertClubMemberData.setString(3, LastName);
                insertClubMemberData.setString(4, MembershipLevel);
                insertClubMemberData.setString(5, PhoneNo);
                insertClubMemberData.setString(6, ActiveStatus);
                insertClubMemberData.setString(7, Email);
                insertClubMemberData.setString(8, Address);

                insertClubMemberData.executeUpdate();
                initProject.connection.commit();

            } catch (SQLException e){
                initProject.connection.rollback();
                e.printStackTrace();
            } finally {
                initProject.connection.setAutoCommit(true);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public static void addMerchandiseData(String ProductID, String StoreID, String ProductName,
                                          int SellPrice, String ProductionDate, String ExpirationDate){
        String sqlStatement = "INSERT INTO `Merchandise` (`ProductID`, `StoreID`, `ProductName`, `SellPrice`, `ProductionDate`, `ExpirationDate`) "
                + "VALUES (?, ?, ?, ?, ?, ?);";

        try{
            initProject.connection.setAutoCommit(false);

            try{
                PreparedStatement insertMerchandiseData = initProject.connection.prepareStatement(sqlStatement);
                insertMerchandiseData.setString(1, ProductID);
                insertMerchandiseData.setString(2, StoreID);
                insertMerchandiseData.setString(3, ProductName);
                insertMerchandiseData.setInt(4, SellPrice);
                insertMerchandiseData.setDate(5, Date.valueOf(ProductionDate));
                insertMerchandiseData.setDate(6, Date.valueOf(ExpirationDate));

                insertMerchandiseData.executeUpdate();
                initProject.connection.commit();

            } catch (SQLException e){
                initProject.connection.rollback();
                e.printStackTrace();
            } finally {
                initProject.connection.setAutoCommit(true);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public static void addSellsData(String ProductID, String StoreID, int Quantity){
        String sqlStatement = "INSERT INTO `Sells` (`ProductID`, `StoreID`, `Quantity`) "
                + "VALUES (?, ?, ?);";

        try{
            initProject.connection.setAutoCommit(false);

            try{
                PreparedStatement insertSellsData = initProject.connection.prepareStatement(sqlStatement);
                insertSellsData.setString(1, ProductID);
                insertSellsData.setString(2, StoreID);
                insertSellsData.setInt(3, Quantity);

                insertSellsData.executeUpdate();
                initProject.connection.commit();

            } catch (SQLException e){
                initProject.connection.rollback();
                e.printStackTrace();
            } finally {
                initProject.connection.setAutoCommit(true);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public static void addSupplyData(String ProductID, String StoreID, String SupplierID, int BuyPrice,
                                          int Quantity){
        String sqlStatement = "INSERT INTO `Supply` (`SupplierID`, `ProductID`, `StoreID`,  `BuyPrice`, `Quantity`) "
                + "VALUES (?, ?, ?, ?, ?);";

        try{
            initProject.connection.setAutoCommit(false);

            try{
                PreparedStatement insertSupplyData = initProject.connection.prepareStatement(sqlStatement);
                insertSupplyData.setString(1, SupplierID);
                insertSupplyData.setString(2, ProductID);
                insertSupplyData.setString(3, StoreID);
                insertSupplyData.setInt(4, BuyPrice);
                insertSupplyData.setInt(5, Quantity);

                insertSupplyData.executeUpdate();
                initProject.connection.commit();

            } catch (SQLException e){
                initProject.connection.rollback();
                e.printStackTrace();
            } finally {
                initProject.connection.setAutoCommit(true);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public static void addSignUpData(String StoreID, int StaffID, String CustomerID, String SignUpDate){
        String sqlStatement = "INSERT INTO `SignUp` (`StoreID`, `StaffID`, `CustomerID`,  `SignUpDate`) "
                + "VALUES (?, ?, ?, ?);";

        try{
            initProject.connection.setAutoCommit(false);

            try{
                PreparedStatement insertSignUpData = initProject.connection.prepareStatement(sqlStatement);
                insertSignUpData.setString(1, StoreID);
                insertSignUpData.setInt(2, StaffID);
                insertSignUpData.setString(3, CustomerID);
                insertSignUpData.setDate(4, Date.valueOf(SignUpDate));

                insertSignUpData.executeUpdate();
                initProject.connection.commit();

            } catch (SQLException e){
                initProject.connection.rollback();
                e.printStackTrace();
            } finally {
                initProject.connection.setAutoCommit(true);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public static void addTransactionData(String TransactionID, String StoreID, String CustomerID, int CashierID,
                                          String PurchaseDate){
        String sqlStatement = "INSERT INTO `Transaction` (`TransactionID`, `StoreID`, `CustomerID`,  `CashierID`, `PurchaseDate`) "
                + "VALUES (?, ?, ?, ?, ?);";

        try{
            initProject.connection.setAutoCommit(false);

            try{
                PreparedStatement insertTransactionData = initProject.connection.prepareStatement(sqlStatement);
                insertTransactionData.setString(1, TransactionID);
                insertTransactionData.setString(2, StoreID);
                insertTransactionData.setString(3, CustomerID);
                insertTransactionData.setInt(4, CashierID);
                insertTransactionData.setDate(5, Date.valueOf(PurchaseDate));

                insertTransactionData.executeUpdate();
                initProject.connection.commit();

            } catch (SQLException e){
                initProject.connection.rollback();
                e.printStackTrace();
            } finally {
                initProject.connection.setAutoCommit(true);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public static void addOrdersData(String TransactionID, String ProductID, int Price, int Quantity, Float TotalPrice){
        String sqlStatement = "INSERT INTO `Orders` (`TransactionID`, `ProductID`, `Price`,  `Quantity`, `TotalPrice`) "
                + "VALUES (?, ?, ?, ?, ?);";

        try{
            initProject.connection.setAutoCommit(false);

            try{
                PreparedStatement insertOrdersData = initProject.connection.prepareStatement(sqlStatement);
                insertOrdersData.setString(1, TransactionID);
                insertOrdersData.setString(2, ProductID);
                insertOrdersData.setInt(3, Price);
                insertOrdersData.setInt(4, Quantity);
                insertOrdersData.setFloat(5, TotalPrice);

                insertOrdersData.executeUpdate();
                initProject.connection.commit();

            } catch (SQLException e){
                initProject.connection.rollback();
                e.printStackTrace();
            } finally {
                initProject.connection.setAutoCommit(true);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public static void addDiscountData(String DiscountID, String ProductID, Float Amount, String StartDate,
                                          String EndDate){
        String sqlStatement = "INSERT INTO `Discount` (`DiscountID`, `ProductID`, `Amount`,  `StartDate`, `EndDate`) "
                + "VALUES (?, ?, ?, ?, ?);";

        try{
            initProject.connection.setAutoCommit(false);

            try{
                PreparedStatement insertDiscountData = initProject.connection.prepareStatement(sqlStatement);
                insertDiscountData.setString(1, DiscountID);
                insertDiscountData.setString(2, ProductID);
                insertDiscountData.setFloat(3, Amount);
                insertDiscountData.setDate(4, Date.valueOf(StartDate));
                insertDiscountData.setDate(5, Date.valueOf(EndDate));

                insertDiscountData.executeUpdate();
                initProject.connection.commit();

            } catch (SQLException e){
                initProject.connection.rollback();
                e.printStackTrace();
            } finally {
                initProject.connection.setAutoCommit(true);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public static void addTransferData(String TransferID, String SourceID, String DestinationID, int OperatorID,
                                       int Quantity, String ProductID){
        String sqlStatement = "INSERT INTO `Transfer` (`TransferID`, `SourceID`, `DestinationID`,  `OperatorID`, `Quantity`, `ProductID`) "
                + "VALUES (?, ?, ?, ?, ?, ?);";

        try{
            initProject.connection.setAutoCommit(false);

            try{
                PreparedStatement insertDiscountData = initProject.connection.prepareStatement(sqlStatement);
                insertDiscountData.setString(1, TransferID);
                insertDiscountData.setString(2, SourceID);
                insertDiscountData.setString(3, DestinationID);
                insertDiscountData.setInt(4,OperatorID);
                insertDiscountData.setInt(5, Quantity);
                insertDiscountData.setString(6, ProductID);


                insertDiscountData.executeUpdate();
                initProject.connection.commit();

            } catch (SQLException e){
                initProject.connection.rollback();
                e.printStackTrace();
            } finally {
                initProject.connection.setAutoCommit(true);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public static void addInventoryDetails(String ProductID, String StoreID, String ProductName, int Quantity,
                                           int BuyPrice, int SellPrice, String ProductionDate, String ExpirationDate,
                                           String SupplierID){

        try{
            addMerchandiseData(ProductID, StoreID, ProductName, SellPrice, ProductionDate, ExpirationDate);
            addSellsData(ProductID, StoreID, Quantity);
            addSupplyData(ProductID, StoreID, SupplierID, BuyPrice, Quantity);
        }catch(Exception e){
            e.printStackTrace();
        }

    }
    public static void addData(){
        addStoreData("2001", 1001, "2221, B Street, NC", "919-2222-123");
        addStoreData("2002", 1002, "2222, C Street, NC", "919-2222-456");

        addStaffData(1001, "2001", "John ", 32, "1101, S Street, NC",
                    "Manager", "919-1111-123", "john01@gmail.com", "2018-10-10");
        addStaffData(1002, "2002", "Alex ", 42, "1102, T Street, NC",
                    "Manager", "919-1111-456", "alex12@gmail.com", "2015-07-19");
        addStaffData(1003, "2001", "Mary ", 28, "1103, U Street, NC",
                    "cashier", "919-1111-789", "mary34@gmail.com", "2019-07-19");

        addSupplierData("4001", "A Food Wholesale", "919-4444-123", "afood@gmail.com",
                    "4401, A Street, NC");
        addSupplierData("4002", "US Foods", "919-4444-456", "usfoods@gmail.com",
                    "4402, G Street, NC");

        addMembershipsData("Platinum", 2.5F);
        addMembershipsData("Gold", 1.0F);
        addClubMemberData("5001", "James", "Smith", "Gold",
                    "919-5555-123", "True", "James5001@gmail.com", "5500, E Street, NC");

        addClubMemberData("5002", "David", "Smith", "Platinum",
                    "919-5555-456", "True", "David5002@gmail.com", " 5501 F Street, NC");

        addInventoryDetails("3001", "2001", "AAA Paper Towels", 100,
                    10, 20, "2020-01-01", "2025-01-01", "4001");

        addInventoryDetails("3002", "2001", "BBB Hand soap", 200,
                    5, 10, "2020-01-01", "2022-01-01", "4002");

        addInventoryDetails("3001", "2002", "AAA Paper Towels", 150,
                    10, 20, "2020-01-01", "2025-01-01", "4001");


        addInventoryDetails("3002", "2002", "BBB Hand soap", 0,
                    5, 10, "2020-01-01", "2022-01-01", "4002");

        addInventoryDetails("3003", "2001", "CCC Red Wine", 100,
                   15, 30, "2021-01-01", "2022-01-01", "4002");

        addSignUpData("2001", 1003, "5001", "2019-08-01");
        addSignUpData("2001", 1003, "5002", "2018-01-01");

        addTransactionData("6001", "2001", "5002", 1003, "2020-05-01");
        addTransactionData("6002", "2001", "5002", 1003, "2020-06-01");
        addTransactionData("6003", "2001", "5001", 1003, "2020-07-01");

        addOrdersData("6001", "3001", 20, 5, 80F);
        addOrdersData("6001", "3002", 10, 2, 20F);
        addOrdersData("6002", "3002", 10, 10, 100F);
        addOrdersData("6003", "3001", 20, 10, 160F);

        addDiscountData("7001", "3001", 20F, "2020-01-01", "2021-05-01");
        addDiscountData("7002", "3003", 20F, "2020-01-01", "2021-05-01");

    }


}
