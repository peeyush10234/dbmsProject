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
                    + "FOREIGN KEY (`StoreID`) REFERENCES Store(`StoreID`));");

            initProject.statement.executeUpdate("CREATE TABLE IF NOT EXISTS `Supplier` ("
                    + "`SupplierID` VARCHAR(20) NOT NULL, "
                    + "`Location` VARCHAR(100) NOT NULL, "
                    + "`PhoneNo` VARCHAR(20) NOT NULL, "
                    + "`EmailAddress` VARCHAR(20), "
                    + "`Name` VARCHAR(20) NOT NULL, "
                    + "PRIMARY KEY (`SupplierID`));");

            initProject.statement.executeUpdate("CREATE TABLE IF NOT EXISTS `Merchandise` ("
                    + "`ProductID` varchar(20) PRIMARY KEY NOT NULL ,"
                    + "`ProductName`  VARCHAR(50) NOT NULL, "
                    + "`ExpirationDate` DATE, "
                    + "`ProductionDate` DATE, "
                    + "`SellPrice` INT NOT NULL);");

            initProject.statement.executeUpdate("CREATE TABLE IF NOT EXISTS `Discount` ("
                    + "`DiscountID` varchar(20) PRIMARY KEY NOT NULL, "
                    + "`ProductID` varchar(20) NOT NULL, "
                    + "`StartDate` DATE NOT NULL, "
                    + "`EndDate` DATE NOT NULL, "
                    + "`Amount` INT NOT NULL, "
                    + "FOREIGN KEY (`ProductID`) REFERENCES Merchandise(`ProductID`)); ");

            initProject.statement.executeUpdate("CREATE TABLE IF NOT EXISTS `Memberships` ("
                    + "`MembershipLevel` VARCHAR(50) NOT NULL PRIMARY KEY, "
                    + "`Reward` FLOAT NOT NULL); ");

            initProject.statement.executeUpdate("CREATE TABLE IF NOT EXISTS `Supply` ("
                    + "`SupplyID` varchar(20) NOT NULL,"
                    + "`StoreAddress` VARCHAR(100) NOT NULL, "
                    + "`SupplierID` varchar(20) NOT NULL, "
                    + "`ProductID` varchar(20) NOT NULL, "
                    + "`StoreID` varchar(20) NOT NULL,"
                    + "`BuyPrice` int NOT NULL, "
                    + "`Quantity` int NOT NULL, "
                    + "PRIMARY KEY (`SupplyID`), "
                    + "FOREIGN KEY (`SupplierID`) REFERENCES Supplier(`SupplierID`),"
                    + "FOREIGN KEY (`ProductID`) REFERENCES Merchandise(`ProductID`),"
                    + "FOREIGN KEY (`StoreID`) REFERENCES Store(`StoreID`));");

            initProject.statement.executeUpdate("CREATE TABLE IF NOT EXISTS `ClubMembers` ("
                    + "`CustomerID` varchar(20) PRIMARY KEY NOT NULL, "
                    + "`FirstName` VARCHAR(40) NOT NULL, "
                    + "`LastName` VARCHAR(40) NOT NULL, "
                    + "`PhoneNo` VARCHAR(40) NOT NULL, "
                    + "`ActiveStatus` VARCHAR(5) NOT NULL, "
                    + "`MembershipLevel` VARCHAR(50) NOT NULL, "
                    + "`Email` VARCHAR(50) NOT NULL, "
                    + "`Address` VARCHAR(100) NOT NULL, "
                    + "FOREIGN KEY (`MembershipLevel`) REFERENCES Memberships(`MembershipLevel`)); ");

            initProject.statement.executeUpdate("CREATE TABLE IF NOT EXISTS `Transfer` ("
                    + "`TransferID` varchar(20) PRIMARY KEY NOT NULL,"
                    + "`SourceID` varchar(20) NOT NULL, "
                    + "`DestinationID` varchar(20) NOT NULL, "
                    + "`OperatorID` int NOT NULL, "
                    + "`Quantity` INT NOT NULL, "
                    + "`ProductID` varchar(20) NOT NULL, "
                    + "FOREIGN KEY (`SourceID`) REFERENCES `Store`(`StoreID`), "
                    + "FOREIGN KEY (`DestinationID`) REFERENCES `Store`(`StoreID`), "
                    + "FOREIGN KEY (`OperatorID`) REFERENCES `Staff`(`StaffID`), "
                    + "FOREIGN KEY (`ProductID`) REFERENCES `Merchandise`(`ProductID`)); ");

            initProject.statement.executeUpdate("CREATE TABLE IF NOT EXISTS `Returns` ("
                    + "`ReturnID` varchar(20) PRIMARY KEY NOT NULL, "
                    + "`SupplierID` varchar(20) NOT NULL, "
                    + "`StoreID` varchar(20) NOT NULL, "
                    + "`ProductID` varchar(20) NOT NULL,"
                    + "`Quantity` INT NOT NULL, "
                    + "`OperatorID` int NOT NULL, "
                    + "FOREIGN KEY (`SupplierID`) REFERENCES `Supply`(`SupplierID`), "
                    + "FOREIGN KEY (`StoreID`) REFERENCES `Store`(`StoreID`), "
                    + "FOREIGN KEY (`OperatorID`) REFERENCES `Staff`(`StaffID`), "
                    + "FOREIGN KEY (`ProductID`) REFERENCES `Merchandise`(`ProductID`)); " );

            initProject.statement.executeUpdate("CREATE TABLE IF NOT EXISTS `Sells` ("
                    + "`StoreID` varchar(20) NOT NULL, "
                    + "`ProductID` varchar(20) NOT NULL, "
                    + "`Quantity` INT NOT NULL, "
                    + "PRIMARY KEY(`StoreID`, `ProductID`), "
                    + "FOREIGN KEY (`StoreID`) REFERENCES `Store`(`StoreID`), "
                    + "FOREIGN KEY (`ProductID`) REFERENCES `Merchandise`(`ProductID`)); ");

            initProject.statement.executeUpdate("CREATE TABLE IF NOT EXISTS `Manage` ("
                    + "`StoreID` varchar(20) PRIMARY KEY NOT NULL,"
                    + "`StaffID` int NOT NULL, "
                    + "FOREIGN KEY (`StoreID`) REFERENCES `Store`(`StoreID`), "
                    + "FOREIGN KEY (`StaffID`) REFERENCES `Staff`(`StaffID`)); ");

            initProject.statement.executeUpdate("CREATE TABLE IF NOT EXISTS `Transaction` ("
                    + "`TransactionID` varchar(20) PRIMARY KEY NOT NULL,"
                    + "`StoreID` varchar(20) NOT NULL, "
                    + "`CustomerID` varchar(20) NOT NULL, "
                    + "`CashierID` INT NOT NULL, "
                    + "`PurchaseDate` DATE NOT NULL, "
                    + "FOREIGN KEY (`StoreID`) REFERENCES Store(`StoreID`), "
                    + "FOREIGN KEY (`CustomerID`) REFERENCES ClubMembers(`CustomerID`), "
                    + "FOREIGN KEY (`CashierID`) REFERENCES Staff(`StaffID`)); ");

            initProject.statement.executeUpdate("CREATE TABLE IF NOT EXISTS `Orders` ("
                    + "`TransactionID` varchar(20) NOT NULL,"
                    + "`ProductID` varchar(20) NOT NULL, "
                    + "`Price` INT NOT NULL, "
                    + "`Quantity` INT NOT NULL, "
                    + "`totalPrice` FLOAT NOT NULL, "
                    + "PRIMARY KEY(`TransactionID`, `ProductID`), "
                    + "FOREIGN KEY (`TransactionID`) REFERENCES Transaction(`TransactionID`), "
                    + "FOREIGN KEY (`ProductID`) REFERENCES Merchandise(`ProductID`)); ");

            initProject.statement.executeUpdate("CREATE TABLE IF NOT EXISTS `SignUp` ("
                    + "`StoreID` varchar(20) NOT NULL,"
                    + "`StaffID` INT NOT NULL, "
                    + "`CustomerID` varchar(20) NOT NULL, "
                    + "`SignUpDate` DATE NOT NULL, "
                    + "PRIMARY KEY(`CustomerID`), "
                    + "FOREIGN KEY (`StoreID`) REFERENCES Store(`StoreID`), "
                    + "FOREIGN KEY (`CustomerID`) REFERENCES ClubMembers(`CustomerID`), "
                    + "FOREIGN KEY (`StaffID`) REFERENCES Staff(`StaffID`)); ");


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


    public static void addData(){
//        addStoreData("2001", 1001, "2221, B Street, NC", "919-2222-123");
//        addStoreData("2002", 1002, "2222, C Street, NC", "919-2222-456");
//
//        addStaffData(1001, "2001", "John ", 32, "1101, S Street, NC",
//                "Manager", "919-1111-123", "john01@gmail.com", "2018-10-10");
//        addStaffData(1002, "2002", "Alex ", 42, "1102, T Street, NC",
//                "Manager", "919-1111-456", "alex12@gmail.com", "2015-07-19");
//        addStaffData(1003, "2001", "Mary ", 28, "1103, U Street, NC",
//                "cashier", "919-1111-789", "mary34@gmail.com", "2019-07-19");

//        addSupplierData("4001", "A Food Wholesale", "919-4444-123", "afood@gmail.com",
//                "4401, A Street, NC");
//        addSupplierData("4002", "US Foods", "919-4444-456", "usfoods@gmail.com",
//                "4402, G Street, NC");

//        addMembershipsData("Platinum", 2.5F);
//        addMembershipsData("Gold", 1.0F);
        addClubMemberData("5001", "James", "Smith", "Gold",
                "919-5555-123", "True", "James5001@gmail.com", "5500, E Street, NC");

        addClubMemberData("5002", "David", "Smith", "Platinum",
                "919-5555-456", "True", "David5002@gmail.com", " 5501 F Street, NC");


    }


}
