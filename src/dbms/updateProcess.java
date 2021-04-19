package dbms;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.*;
import  java.sql.Date;
import java.sql.PreparedStatement;
public class updateProcess {
    public static Scanner sc = new Scanner(System.in);





    // Operations related to Store Table
    public static void getStoreInfo(String storeID){

        String sql = "SELECT * FROM `Store`" + " WHERE StoreID = ?;";
        try {
            PreparedStatement stmtGetStore = initProject.connection.prepareStatement(sql);
            stmtGetStore.setString(1,storeID);
            ResultSet result = stmtGetStore.executeQuery();
            if(result.next()){
                String storeAddress = result.getString("StoreAddress");
                String PhoneNo = result.getString("PhoneNo");
                int managerId = result.getInt("ManagerID");

                System.out.println("Store ID: "+ storeID +" | StoreAddress : "+ storeAddress +" | Phone No: "+  PhoneNo + " | ManagerId : "+managerId);

            }
            else{
                System.out.println(("Store ID does not exist. Please check and try again"));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }

    public static void toUpdateStoreData(){
        String storeID;
        String attributeToChange;
        String newValue;
        try{
            System.out.println("Enter the store id that you want to update");
            storeID = sc.nextLine();

            System.out.println("\n The store information that you have chosen is as follows: \n");;
            getStoreInfo(storeID);

            System.out.println((" \n Select the attribute you want to update [StoreAddress, PhoneNo, ManagerID]"));
            attributeToChange = sc.nextLine();

            System.out.println("Enter the new value");
            newValue = sc.nextLine();
            updateStoreData(storeID, attributeToChange, newValue);

        }
        catch (Exception e){
            System.out.println(e);
        }

    }

    public static void updateStoreData(String storeID, String attributeToChange, String newValue){
        try {
            initProject.connection.setAutoCommit(false);
            try{
                switch(attributeToChange.toUpperCase()){
                    case "STOREADDRESS":
                        String addressUpdatestmt = "UPDATE `Store`" + "SET `StoreAddress` = ?" + " WHERE StoreID = ?;";
                        PreparedStatement addprepUpdate = initProject.connection.prepareStatement(addressUpdatestmt);
                        addprepUpdate.setString(1, newValue);
                        addprepUpdate.setString(2, storeID);

                        addprepUpdate.executeUpdate();
                        break;

                    case "PHONENO":
                        String phoneUpdatestmt = "UPDATE `Store`" + "SET `PhoneNo` = ?" + " WHERE StoreID = ?;";
                        PreparedStatement phoneprepUpdate = initProject.connection.prepareStatement(phoneUpdatestmt);
                        phoneprepUpdate.setString(1, newValue);
                        phoneprepUpdate.setString(2, storeID);
                        phoneprepUpdate.executeUpdate();
                        break;

                    case "MANAGERID":
                        String managerUpdatestmt = "UPDATE `Store`" + "SET `ManagerID` = ?" + " WHERE StoreID = ?;";
                        PreparedStatement managerprepUpdate = initProject.connection.prepareStatement(managerUpdatestmt);
                        managerprepUpdate.setInt(1, Integer.parseInt(newValue));
                        managerprepUpdate.setString(2, storeID);
                        managerprepUpdate.executeUpdate();
                        break;

                    default:
                        System.out.println("Enter the field correctly");
                        break;

                }
                initProject.connection.commit();
            }
            catch (SQLException  e){
                initProject.connection.rollback();
                e.printStackTrace();
            }
            finally {
                initProject.connection.setAutoCommit(true);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }




    //OPERATIONS RELATED TO STAFF TABLE###########################################

    public static void getStaffInfo(String staffID){

        String sql = "SELECT * FROM `Staff`" + " WHERE StaffID = ?;";
        try {
            PreparedStatement stmtGetStaff = initProject.connection.prepareStatement(sql);
            stmtGetStaff.setString(1,staffID);
            ResultSet result = stmtGetStaff.executeQuery();
            if(result.next()){
                String Name = result.getString("Name");
                int Age = result.getInt("Age");
                String StoreID = result.getString("StoreID");
                String JobTitle = result.getString("JobTitle");
                String Phone = result.getString("Phone");
                String Email = result.getString("Email");
                Date TimeOfEmployment = result.getDate("TimeOfEmployment");
                String HomeAddress = result.getString("HomeAddress");

                System.out.println("Staff ID: "+ staffID +" | Name : "+ Name +" | Age "+  Age + " | StoreID : "+ StoreID
                +"\n\n"+ " | JobTitle : " + JobTitle + " | Phone : " + Phone + " | Email : " + Email + " | Time of Employment  : " + TimeOfEmployment
                +" | Home Address : "+ HomeAddress);

            }
            else{
                System.out.println(("Staff ID does not exist. Please check and try again"));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }

    public static void toUpdateStaffData(){
        String StaffID;
        String attributeToChange;
        String newValue;
        try{
            System.out.println("Enter the Staff id that you want to update");
            StaffID = sc.nextLine();

            System.out.println("\n The Staff information that you have chosen is as follows: \n");;
            getStaffInfo(StaffID);

            System.out.println((" \n Select the attribute you want to update [staffID, Name, Age, StoreID, JobTitle, Phone, Email, TimeOfEmployment, HomeAddress]"));
            attributeToChange = sc.nextLine();

            System.out.println("Enter the new value");
            newValue = sc.nextLine();
            updateStaffData(StaffID, attributeToChange, newValue);

        }
        catch (Exception e){
            System.out.println(e);
        }

    }

    public static void updateStaffData(String staffID, String attributeToChange, String newValue){
        try {
            initProject.connection.setAutoCommit(false);
            try{
                switch(attributeToChange.toUpperCase()){
                    case "NAME":
                        String nameUpdatestmt = "UPDATE `Staff`" + "SET `Name` = ?" + " WHERE StaffID = ?;";
                        PreparedStatement nameprepUpdate = initProject.connection.prepareStatement(nameUpdatestmt);
                        nameprepUpdate.setString(1, newValue);
                        nameprepUpdate.setString(2, staffID);
                        nameprepUpdate.executeUpdate();
                        break;

                    case "AGE":
                        String ageUpdatestmt = "UPDATE `Staff`" + "SET `Age` = ?" + " WHERE StaffID = ?;";
                        PreparedStatement ageprepUpdate = initProject.connection.prepareStatement(ageUpdatestmt);
                        ageprepUpdate.setInt(1, Integer.parseInt(newValue));
                        ageprepUpdate.setString(2, staffID);
                        ageprepUpdate.executeUpdate();
                        break;

                    case "STOREID":
                        String storeidUpdatestmt = "UPDATE `Staff`" + "SET `StoreID` = ?" + " WHERE StaffID = ?;";
                        PreparedStatement storeIDprepUpdate = initProject.connection.prepareStatement(storeidUpdatestmt);
                        storeIDprepUpdate.setString(1, newValue);
                        storeIDprepUpdate.setString(2, staffID);
                        storeIDprepUpdate.executeUpdate();
                        break;

                    case "JOBTITLE":
                        String jtUpdatestmt = "UPDATE `Staff`" + "SET `JobTitle` = ?" + " WHERE StaffID = ?;";
                        PreparedStatement jtprepUpdate = initProject.connection.prepareStatement(jtUpdatestmt);
                        jtprepUpdate.setString(1, newValue);
                        jtprepUpdate.setString(2, staffID);
                        jtprepUpdate.executeUpdate();
                        break;

                    case "PHONE":
                        String phoneUpdatestmt = "UPDATE `Staff`" + "SET `Phone` = ?" + " WHERE StaffID = ?;";
                        PreparedStatement phoneprepUpdate = initProject.connection.prepareStatement(phoneUpdatestmt);
                        phoneprepUpdate.setString(1, newValue);
                        phoneprepUpdate.setString(2, staffID);
                        phoneprepUpdate.executeUpdate();
                        break;

                    case "EMAIL":
                        String emailUpdatestmt = "UPDATE `Staff`" + "SET `Email` = ?" + " WHERE StaffID = ?;";
                        PreparedStatement emailprepUpdate = initProject.connection.prepareStatement(emailUpdatestmt);
                        emailprepUpdate.setString(1, newValue);
                        emailprepUpdate.setString(2, staffID);
                        emailprepUpdate.executeUpdate();
                        break;

                    case "TIMEOFEMPLOYMENT":
                        String toeUpdatestmt = "UPDATE `Staff`" + "SET `TimeOfEmployment` = ?" + " WHERE StaffID = ?;";
                        PreparedStatement toeprepUpdate = initProject.connection.prepareStatement(toeUpdatestmt);
                        Date date1 = Date.valueOf(newValue);
                        toeprepUpdate.setDate(1, date1);
                        toeprepUpdate.setString(2, staffID);
                        toeprepUpdate.executeUpdate();
                        break;

                    case "HOMEADDRESS":
                        String haUpdatestmt = "UPDATE `Staff`" + "SET `HomeAddress` = ?" + " WHERE StaffID = ?;";
                        PreparedStatement haprepUpdate = initProject.connection.prepareStatement(haUpdatestmt);

                        haprepUpdate.setString(1, newValue);
                        haprepUpdate.setString(2, staffID);
                        haprepUpdate.executeUpdate();
                        break;

                    default:
                        System.out.println("Enter the field correctly");
                        break;

                }
                initProject.connection.commit();
            }
            catch (SQLException  e){
                initProject.connection.rollback();
                e.printStackTrace();
            }
            finally {
                initProject.connection.setAutoCommit(true);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }



//    OPERATIONS RELATED TO SUPPLIER TABLE #########################################


    public static void getSupplierInfo(String SupplierID){

        String sql = "SELECT * FROM `Supplier`" + " WHERE SupplierID = ?;";
        try {
            PreparedStatement stmtGetSupplier = initProject.connection.prepareStatement(sql);
            stmtGetSupplier.setString(1,SupplierID);
            ResultSet result = stmtGetSupplier.executeQuery();
            if(result.next()){
                String Location = result.getString("Location");
                String PhoneNo = result.getString("PhoneNo");
                String EmailAddress = result.getString("EmailAddress");
                String Name = result.getString("Name");
                System.out.println("Supplier ID: "+ SupplierID +" | Location : "+ Location +" | Phone No: "+  PhoneNo + " | Email Address : "+ EmailAddress  + " | Name : "+ Name);

            }
            else{
                System.out.println(("Supplier ID does not exist. Please check and try again"));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }

    public static void toUpdateSupplierData(){
        String SupplierID;
        String attributeToChange;
        String newValue;
        try{
            System.out.println("Enter the Supplier id that you want to update");
            SupplierID = sc.nextLine();

            System.out.println("\n The Supplier information that you have chosen is as follows: \n");;
            getSupplierInfo(SupplierID);

            System.out.println((" \n Select the attribute you want to update [Location, PhoneNo, EmailAddress, Name]"));
            attributeToChange = sc.nextLine();

            System.out.println("Enter the new value");
            newValue = sc.nextLine();
            updateSupplierData(SupplierID, attributeToChange, newValue);

        }
        catch (Exception e){
            System.out.println(e);
        }

    }

    public static void updateSupplierData(String SupplierID, String attributeToChange, String newValue){
        try {
            initProject.connection.setAutoCommit(false);
            try{
                switch(attributeToChange.toUpperCase()){
                    case "LOCATION":
                        String locUpdatestmt = "UPDATE `Supplier`" + "SET `Location` = ?" + " WHERE SupplierID = ?;";
                        PreparedStatement locprepUpdate = initProject.connection.prepareStatement(locUpdatestmt);
                        locprepUpdate.setString(1, newValue);
                        locprepUpdate.setString(2, SupplierID);

                        locprepUpdate.executeUpdate();
                        break;

                    case "PHONENO":
                        String phoneUpdatestmt = "UPDATE `Supplier`" + "SET `PhoneNo` = ?" + " WHERE SupplierID = ?;";
                        PreparedStatement phoneprepUpdate = initProject.connection.prepareStatement(phoneUpdatestmt);
                        phoneprepUpdate.setString(1, newValue);
                        phoneprepUpdate.setString(2, SupplierID);
                        phoneprepUpdate.executeUpdate();
                        break;

                    case "EMAILADDRESS":
                        String emailUpdatestmt = "UPDATE `Supplier`" + "SET `EmailAddress` = ?" + " WHERE SupplierID = ?;";
                        PreparedStatement emailprepUpdate = initProject.connection.prepareStatement(emailUpdatestmt);
                        emailprepUpdate.setString(1, newValue);
                        emailprepUpdate.setString(2, SupplierID);
                        emailprepUpdate.executeUpdate();
                        break;

                    case "NAME":
                        String nameUpdatestmt = "UPDATE `Supplier`" + "SET `Name` = ?" + " WHERE SupplierID = ?;";
                        PreparedStatement nameprepUpdate = initProject.connection.prepareStatement(nameUpdatestmt);
                        nameprepUpdate.setString(1, newValue);
                        nameprepUpdate.setString(2, SupplierID);
                        nameprepUpdate.executeUpdate();
                        break;

                    default:
                        System.out.println("Enter the field correctly");
                        break;

                }
                initProject.connection.commit();
            }
            catch (SQLException  e){
                initProject.connection.rollback();
                e.printStackTrace();
            }
            finally {
                initProject.connection.setAutoCommit(true);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }



//    OPERATIONS RELATED TO MERCHANDISE TABLE #########################################


    public static void getMerchandiseInfo(String ProductID, String StoreID){

        String sql = "SELECT * FROM `Merchandise`" + " WHERE StoreID = ? AND ProductID = ?";
        try {
            PreparedStatement stmtGetMerchandise = initProject.connection.prepareStatement(sql);
            stmtGetMerchandise.setString(1,StoreID);
            stmtGetMerchandise.setString(2,ProductID);
            ResultSet result = stmtGetMerchandise.executeQuery();
            if(result.next()){
                String ProductName = result.getString("ProductName");
                int SellPrice = result.getInt("SellPrice");
                Date ExpirationDate = result.getDate("ExpirationDate");
                Date ProductionDate = result.getDate("ProductionDate");


                System.out.println("Product ID : " + ProductID + " | Store ID : "+ StoreID +" | Product Name : "+ ProductName +" | Expiration Date : "+  ExpirationDate + " | Production Date : "+ ProductionDate + " | Sell Price : "+SellPrice);

            }
            else{
                System.out.println(("Product ID and Store ID do not exist. Please check and try again"));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }

    public static void toUpdateMerchandiseData(){
        String ProductID;
        String StoreID;
        String attributeToChange;
        String newValue;
        try{
            System.out.println("Enter the Product id that you want to update");
            ProductID = sc.nextLine();
            System.out.println("Enter the Store id that you want to update");
            StoreID = sc.nextLine();
            System.out.println("\n The Merchandise information that you have chosen is as follows: \n");;
            getMerchandiseInfo(ProductID, StoreID);

            System.out.println((" \n Select the attribute you want to update [ProductName, ExpirationDate, ProductionDate, SellPrice]"));
            attributeToChange = sc.nextLine();

            System.out.println("Enter the new value");
            newValue = sc.nextLine();
            updateMerchandiseData(ProductID, StoreID, attributeToChange, newValue);

        }
        catch (Exception e){
            System.out.println(e);
        }

    }

    public static void updateMerchandiseData(String ProductID, String StoreID, String attributeToChange, String newValue){
        try {
            initProject.connection.setAutoCommit(false);
            try{
                switch(attributeToChange.toUpperCase()){
                    case "PRODUCTNAME":
                        String pnameUpdatestmt = "UPDATE `Merchandise`" + "SET `ProductName` = ?" + " WHERE ProductID = ? AND StoreID = ?;";
                        PreparedStatement pnameprepUpdate = initProject.connection.prepareStatement(pnameUpdatestmt);
                        pnameprepUpdate.setString(1, newValue);
                        pnameprepUpdate.setString(2, ProductID);
                        pnameprepUpdate.setString(3, StoreID);
                        pnameprepUpdate.executeUpdate();
                        break;

                    case "EXPIRATIONDATE":
                        String edateUpdatestmt = "UPDATE `Merchandise`" + "SET `ExpirationDate` = ?" + " WHERE ProductID = ? AND StoreID = ?;";
                        PreparedStatement edateprepUpdate = initProject.connection.prepareStatement(edateUpdatestmt);
                        Date date1 = Date.valueOf(newValue);
                        edateprepUpdate.setDate(1, date1);
                        edateprepUpdate.setString(2, ProductID);
                        edateprepUpdate.setString(3, StoreID);
                        edateprepUpdate.executeUpdate();
                        break;

                    case "PRODUCTIONDATE":
                        String pdateUpdatestmt = "UPDATE `Merchandise`" + "SET `ProductionDate` = ?" + " WHERE ProductID = ? AND StoreID = ?;";
                        PreparedStatement pdateprepUpdate = initProject.connection.prepareStatement(pdateUpdatestmt);
                        Date date2 = Date.valueOf(newValue);
                        pdateprepUpdate.setDate(1, date2);
                        pdateprepUpdate.setString(2, ProductID);
                        pdateprepUpdate.setString(3, StoreID);
                        pdateprepUpdate.executeUpdate();
                        break;

                    case "SELLPRICE":
                        String spUpdatestmt = "UPDATE `Merchandise`" + "SET `SellPrice` = ?" + " WHERE ProductID = ? AND StoreID = ?;";
                        PreparedStatement spprepUpdate = initProject.connection.prepareStatement(spUpdatestmt);
                        spprepUpdate.setInt(1, Integer.parseInt(newValue));
                        spprepUpdate.setString(2, ProductID);
                        spprepUpdate.setString(3, StoreID);
                        spprepUpdate.executeUpdate();
                        break;

                    default:
                        System.out.println("Enter the field correctly");
                        break;

                }
                initProject.connection.commit();
            }
            catch (SQLException  e){
                initProject.connection.rollback();
                e.printStackTrace();
            }
            finally {
                initProject.connection.setAutoCommit(true);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }




//    OPERATIONS RELATED TO DISCOUNT TABLE #############################################################

    public static void getDiscountInfo(String DiscountID){

        String sql = "SELECT * FROM `Discount`" + " WHERE DiscountID = ?;";
        try {
            PreparedStatement stmtGetDiscount = initProject.connection.prepareStatement(sql);
            stmtGetDiscount.setString(1,DiscountID);
            ResultSet result = stmtGetDiscount.executeQuery();
            if(result.next()){
                String ProductID = result.getString("ProductID");
                Date StartDate = result.getDate("StartDate");
                Date EndDate = result.getDate("EndDate");
                float Amount = result.getFloat("Amount");

                System.out.println("DiscountID : "+ DiscountID +" | ProductID : "+ ProductID +" | StartDate: "+  StartDate + " | EndDate : "+EndDate + " | Amount :"+ Amount);

            }
            else{
                System.out.println(("Discount ID does not exist. Please check and try again"));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }

    public static void toUpdateDiscountData(){
        String DiscountID;
        String attributeToChange;
        String newValue;
        try{
            System.out.println("Enter the Discount id that you want to update");
            DiscountID = sc.nextLine();

            System.out.println("\n The Discount information that you have chosen is as follows: \n");;
            getDiscountInfo(DiscountID);

            System.out.println((" \n Select the attribute you want to update [ProductID, StartDate, EndDate, Amount]"));
            attributeToChange = sc.nextLine();

            System.out.println("Enter the new value");
            newValue = sc.nextLine();
            updateDiscountData(DiscountID, attributeToChange, newValue);

        }
        catch (Exception e){
            System.out.println(e);
        }

    }

    public static void updateDiscountData(String DiscountID, String attributeToChange, String newValue){
        try {
            initProject.connection.setAutoCommit(false);
            try{
                switch(attributeToChange.toUpperCase()){
                    case "PRODUCTID":
                        String pidUpdatestmt = "UPDATE `Discount`" + "SET `ProductID` = ?" + " WHERE DiscountID = ?;";
                        PreparedStatement pipprepUpdate = initProject.connection.prepareStatement(pidUpdatestmt);
                        pipprepUpdate.setString(1, newValue);
                        pipprepUpdate.setString(2, DiscountID);
                        pipprepUpdate.executeUpdate();
                        break;

                    case "STARTDATE":
                        String sdateUpdatestmt = "UPDATE `Discount`" + "SET `StartDate` = ?" + " WHERE DiscountID = ?;";
                        PreparedStatement sdateprepUpdate = initProject.connection.prepareStatement(sdateUpdatestmt);
                        Date date1 = Date.valueOf(newValue);
                        sdateprepUpdate.setDate(1, date1);
                        sdateprepUpdate.setString(2, DiscountID);
                        sdateprepUpdate.executeUpdate();
                        break;

                    case "ENDDATE":
                        String edateUpdatestmt = "UPDATE `Discount`" + "SET `EndDate` = ?" + " WHERE DiscountID = ?;";
                        PreparedStatement edateprepUpdate = initProject.connection.prepareStatement(edateUpdatestmt);
                        Date date2 = Date.valueOf(newValue);
                        edateprepUpdate.setDate(1, date2);
                        edateprepUpdate.setString(2, DiscountID);
                        edateprepUpdate.executeUpdate();
                        break;

                    case "AMOUNT":
                        String amountUpdatestmt = "UPDATE `Discount`" + "SET `Amount` = ?" + " WHERE DiscountID = ?;";
                        PreparedStatement amountprepUpdate = initProject.connection.prepareStatement(amountUpdatestmt);
                        amountprepUpdate.setFloat(1, Float.parseFloat(newValue));
                        amountprepUpdate.setString(2, DiscountID);
                        amountprepUpdate.executeUpdate();
                        break;

                    default:
                        System.out.println("Enter the field correctly");
                        break;

                }
                initProject.connection.commit();
            }
            catch (SQLException  e){
                initProject.connection.rollback();
                e.printStackTrace();
            }
            finally {
                initProject.connection.setAutoCommit(true);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }


//    OPERATIONS RELATED TO MEMBERSHIPS TABLE ###################################################################

    public static void getMembershipInfo(String MerbershipLevel){

        String sql = "SELECT * FROM `Memberships`" + " WHERE MembershipLevel = ?;";
        try {
            PreparedStatement stmtGetMemberships = initProject.connection.prepareStatement(sql);
            stmtGetMemberships.setString(1,MerbershipLevel);
            ResultSet result = stmtGetMemberships.executeQuery();
            if(result.next()){
                float Reward = result.getFloat("Reward");

                System.out.println("MerbershipLevel: "+ MerbershipLevel +" | Reward : "+ Reward );

            }
            else{
                System.out.println(("MerbershipLeveldoes not exist. Please check and try again"));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }

    public static void toUpdateMembershipData(){
        String MerbershipLevel;
        String attributeToChange;
        String newValue;
        try{
            System.out.println("Enter the MerbershipLevel that you want to update");
            MerbershipLevel = sc.nextLine();

            System.out.println("\n The Merbership information that you have chosen is as follows: \n");;
            getMembershipInfo(MerbershipLevel);

            System.out.println((" \n Select the attribute you want to update [Reward]"));
            attributeToChange = sc.nextLine();

            System.out.println("Enter the new value");
            newValue = sc.nextLine();
            updateMembershipData(MerbershipLevel, attributeToChange, newValue);

        }
        catch (Exception e){
            System.out.println(e);
        }

    }

    public static void updateMembershipData(String MerbershipLevel, String attributeToChange, String newValue){
        try {
            initProject.connection.setAutoCommit(false);
            try{
                switch(attributeToChange.toUpperCase()){
                    case "REWARD":
                        String rewardUpdatestmt = "UPDATE `Memberships`" + "SET `Reward` = ?" + " WHERE MembershipLevel = ?;";
                        PreparedStatement rewardprepUpdate = initProject.connection.prepareStatement(rewardUpdatestmt);
                        rewardprepUpdate.setFloat(1, Float.parseFloat(newValue));
                        rewardprepUpdate.setString(2, MerbershipLevel);

                        rewardprepUpdate.executeUpdate();
                        break;


                    default:
                        System.out.println("Enter the field correctly");
                        break;

                }
                initProject.connection.commit();
            }
            catch (SQLException  e){
                initProject.connection.rollback();
                e.printStackTrace();
            }
            finally {
                initProject.connection.setAutoCommit(true);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }




//    OPERATIONS RELATED TO SUPPLY TABLE #########################################################


    public static void getSupplyInfo(String SupplyID){

        String sql = "SELECT * FROM `Supply`" + " WHERE SupplyID = ?;";
        try {
            PreparedStatement stmtGetSupply = initProject.connection.prepareStatement(sql);
            stmtGetSupply.setString(1,SupplyID);
            ResultSet result = stmtGetSupply.executeQuery();
            if(result.next()){
                String SupplierID = result.getString("SupplierID");
                String ProductID = result.getString("ProductID");
                String StoreID = result.getString("StoreID");
                int BuyPrice = result.getInt("BuyPrice");
                int Quantity = result.getInt("Quantity");

                System.out.println("SupplyID: "+ SupplyID +" | SupplierID : "+ SupplierID +" | ProductID: "+  ProductID + " | StoreID : "+StoreID + " | BuyPrice : " + BuyPrice + " | Quantity : "+Quantity) ;

            }
            else{
                System.out.println(("SupplyID does not exist. Please check and try again"));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }

    public static void toUpdateSupplyData(){
        String SupplyID;
        String attributeToChange;
        String newValue;
        try{
            System.out.println("Enter the SupplyID that you want to update");
            SupplyID = sc.nextLine();

            System.out.println("\n The Supply information that you have chosen is as follows: \n");;
            getSupplyInfo(SupplyID);

            System.out.println((" \n Select the attribute you want to update [SupplierID, ProductID, StoreID, BuyPrice, Quantity]"));
            attributeToChange = sc.nextLine();

            System.out.println("Enter the new value");
            newValue = sc.nextLine();
            updateSupplyData(SupplyID, attributeToChange, newValue);

        }
        catch (Exception e){
            System.out.println(e);
        }

    }

    public static void updateSupplyData(String SupplyID, String attributeToChange, String newValue){
        try {
            initProject.connection.setAutoCommit(false);
            try{
                switch(attributeToChange.toUpperCase()){
                    case "SUPPLIERID":
                        String sidUpdatestmt = "UPDATE `Supply`" + "SET `SupplierID` = ?" + " WHERE SupplyID = ?;";
                        PreparedStatement sidprepUpdate = initProject.connection.prepareStatement(sidUpdatestmt);
                        sidprepUpdate.setString(1, newValue);
                        sidprepUpdate.setString(2, SupplyID);
                        sidprepUpdate.executeUpdate();
                        break;

                    case "PRODUCTID":
                        String pidUpdatestmt = "UPDATE `Supply`" + "SET `ProductID` = ?" + " WHERE SupplyID = ?;";
                        PreparedStatement pidprepUpdate = initProject.connection.prepareStatement(pidUpdatestmt);
                        pidprepUpdate.setString(1, newValue);
                        pidprepUpdate.setString(2, SupplyID);
                        pidprepUpdate.executeUpdate();
                        break;

                    case "STOREID":
                        String stidUpdatestmt = "UPDATE `Supply`" + "SET `StoreID` = ?" + " WHERE SupplyID = ?;";
                        PreparedStatement stidprepUpdate = initProject.connection.prepareStatement(stidUpdatestmt);
                        stidprepUpdate.setString(1, newValue);
                        stidprepUpdate.setString(2, SupplyID);
                        stidprepUpdate.executeUpdate();
                        break;

                    case "BUYPRICE":
                        String buypriceUpdatestmt = "UPDATE `Supply`" + "SET `BuyPrice` = ?" + " WHERE SupplyID = ?;";
                        PreparedStatement buypriceprepUpdate = initProject.connection.prepareStatement(buypriceUpdatestmt);
                        buypriceprepUpdate.setInt(1, Integer.parseInt(newValue));
                        buypriceprepUpdate.setString(2, SupplyID);
                        buypriceprepUpdate.executeUpdate();
                        break;

                    case "QUANTITY":
                        String QuantityUpdatestmt = "UPDATE `Supply`" + "SET `Quantity` = ?" + " WHERE SupplyID = ?;";
                        PreparedStatement QuantityprepUpdate = initProject.connection.prepareStatement(QuantityUpdatestmt);
                        QuantityprepUpdate.setInt(1, Integer.parseInt(newValue));
                        QuantityprepUpdate.setString(2, SupplyID);
                        QuantityprepUpdate.executeUpdate();
                        break;

                    default:
                        System.out.println("Enter the field correctly");
                        break;

                }
                initProject.connection.commit();
            }
            catch (SQLException  e){
                initProject.connection.rollback();
                e.printStackTrace();
            }
            finally {
                initProject.connection.setAutoCommit(true);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }





//    OPERATIONS RELATED TO SELLS TABLE

    public static void getSellInfo(String StoreID, String ProductID){

        String sql = "SELECT * FROM `Sells`" + " WHERE StoreID = ? and ProductID = ?;";
        try {
            PreparedStatement stmtGetSells = initProject.connection.prepareStatement(sql);
            stmtGetSells.setString(1,StoreID);
            stmtGetSells.setString(2,ProductID);
            ResultSet result = stmtGetSells.executeQuery();
            if(result.next()){

                int Quantity = result.getInt("Quantity");

                System.out.println("StoreID: "+ StoreID +" | ProductID : "+ ProductID + " | Quantity : "+Quantity) ;

            }
            else{
                System.out.println(("StoreID or ProductID does not exist. Please check and try again"));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }

    public static void toUpdateSellData(){
        String StoreID;
        String ProductID;
        String attributeToChange;
        String newValue;
        try{
            System.out.println("Enter the StoreID that you want to update");
            StoreID = sc.nextLine();
            System.out.println("Enter the ProductID that you want to update");
            ProductID = sc.nextLine();


            System.out.println("\n The Sell information that you have chosen is as follows: \n");;
            getSellInfo(StoreID, ProductID);

            System.out.println((" \n Select the attribute you want to update [Quantity]"));
            attributeToChange = sc.nextLine();

            System.out.println("Enter the new value");
            newValue = sc.nextLine();
            updateSellData(StoreID, ProductID,attributeToChange, newValue);

        }
        catch (Exception e){
            System.out.println(e);
        }

    }

    public static void updateSellData(String StoreID,String ProductID,  String attributeToChange, String newValue){
        try {
            initProject.connection.setAutoCommit(false);
            try{
                switch(attributeToChange.toUpperCase()){

                    case "QUANTITY":
                        String QuantityUpdatestmt = "UPDATE `Sells`" + "SET `Quantity` = ?" + " WHERE StoreID = ? AND ProductID = ?;";
                        PreparedStatement QuantityprepUpdate = initProject.connection.prepareStatement(QuantityUpdatestmt);
                        QuantityprepUpdate.setInt(1, Integer.parseInt(newValue));
                        QuantityprepUpdate.setString(2, StoreID);
                        QuantityprepUpdate.setString(3, ProductID);
                        QuantityprepUpdate.executeUpdate();
                        break;

                    default:
                        System.out.println("Enter the field correctly");
                        break;

                }
                initProject.connection.commit();
            }
            catch (SQLException  e){
                initProject.connection.rollback();
                e.printStackTrace();
            }
            finally {
                initProject.connection.setAutoCommit(true);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }



//OPERATIONS RELATED TO CLUBMEMBERS TABLE ##############################################



    public static void getClubMembersInfo(String CustomerID){

        String sql = "SELECT * FROM `ClubMembers`" + " WHERE CustomerID = ?;";
        try {
            PreparedStatement stmtGetClubMembers = initProject.connection.prepareStatement(sql);
            stmtGetClubMembers.setString(1,CustomerID);
            ResultSet result = stmtGetClubMembers.executeQuery();
            if(result.next()){
                String FirstName = result.getString("FirstName");
                String LastName = result.getString("LastName");
                String PhoneNo = result.getString("PhoneNo");
                String ActiveStatus = result.getString("ActiveStatus");
                String MembershipLevel = result.getString("MembershipLevel");
                String Email = result.getString("Email");
                String Address = result.getString("Address");

                System.out.println("CustomerID: "+ CustomerID +" | FirstName : "+ FirstName +" | LastName: "+  LastName + " | PhoneNo : "+PhoneNo + " \n" +
                        "\n" +
                        "| ActiveStatus : " + ActiveStatus + " | MembershipLevel : "+MembershipLevel+" | Email : "+Email+" | Address : "+Address) ;

            }
            else{
                System.out.println(("CustomerID does not exist. Please check and try again"));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }

    public static void toUpdateClubMembersData(){
        String CustomerID;
        String attributeToChange;
        String newValue;
        try{
            System.out.println("Enter the CustomerID that you want to update");
            CustomerID = sc.nextLine();

            System.out.println("\n The CustomerID information that you have chosen is as follows: \n");;
            getClubMembersInfo(CustomerID);

            System.out.println((" \n Select the attribute you want to update [FirstName, LastName, PhoneNo, ActiveStatus, MembershipLevel, Email, Address]"));
            attributeToChange = sc.nextLine();

            System.out.println("Enter the new value");
            newValue = sc.nextLine();
            updateClubMembersData(CustomerID, attributeToChange, newValue);

        }
        catch (Exception e){
            System.out.println(e);
        }

    }

    public static void updateClubMembersData(String CustomerID, String attributeToChange, String newValue){
        try {
            initProject.connection.setAutoCommit(false);
            try{
                switch(attributeToChange.toUpperCase()){
                    case "FIRSTNAME":
                        String fnameUpdatestmt = "UPDATE `ClubMembers`" + "SET `FirstName` = ?" + " WHERE CustomerID = ?;";
                        PreparedStatement fnameprepUpdate = initProject.connection.prepareStatement(fnameUpdatestmt);
                        fnameprepUpdate.setString(1, newValue);
                        fnameprepUpdate.setString(2, CustomerID);
                        fnameprepUpdate.executeUpdate();
                        break;

                    case "LASTNAME":
                        String lnameUpdatestmt = "UPDATE `ClubMembers`" + "SET `LastName` = ?" + " WHERE CustomerID = ?;";
                        PreparedStatement lnameprepUpdate = initProject.connection.prepareStatement(lnameUpdatestmt);
                        lnameprepUpdate.setString(1, newValue);
                        lnameprepUpdate.setString(2, CustomerID);
                        lnameprepUpdate.executeUpdate();
                        break;

                    case "PHONENO":
                        String pnoUpdatestmt = "UPDATE `ClubMembers`" + "SET `PhoneNo` = ?" + " WHERE CustomerID = ?;";
                        PreparedStatement pnoprepUpdate = initProject.connection.prepareStatement(pnoUpdatestmt);
                        pnoprepUpdate.setString(1, newValue);
                        pnoprepUpdate.setString(2, CustomerID);
                        pnoprepUpdate.executeUpdate();
                        break;

                    case "ACTIVESTATUS":
                        String statusUpdatestmt = "UPDATE `ClubMembers`" + "SET `ActiveStatus` = ?" + " WHERE CustomerID = ?;";
                        PreparedStatement statusprepUpdate = initProject.connection.prepareStatement(statusUpdatestmt);
                        statusprepUpdate.setString(1, newValue);
                        statusprepUpdate.setString(2, CustomerID);
                        statusprepUpdate.executeUpdate();
                        break;

                    case "MEMBERSHIPLEVEL":
                        String mlUpdatestmt = "UPDATE `ClubMembers`" + "SET `MembershipLevel` = ?" + " WHERE CustomerID = ?;";
                        PreparedStatement mlprepUpdate = initProject.connection.prepareStatement(mlUpdatestmt);
                        mlprepUpdate.setString(1, newValue);
                        mlprepUpdate.setString(2, CustomerID);
                        mlprepUpdate.executeUpdate();
                        break;

                    case "EMAIL":
                        String emailUpdatestmt = "UPDATE `ClubMembers`" + "SET `Email` = ?" + " WHERE CustomerID = ?;";
                        PreparedStatement emailprepUpdate = initProject.connection.prepareStatement(emailUpdatestmt);
                        emailprepUpdate.setString(1, newValue);
                        emailprepUpdate.setString(2, CustomerID);
                        emailprepUpdate.executeUpdate();
                        break;

                    case "ADDRESS":
                        String addressUpdatestmt = "UPDATE `ClubMembers`" + "SET `Address` = ?" + " WHERE CustomerID = ?;";
                        PreparedStatement addressprepUpdate = initProject.connection.prepareStatement(addressUpdatestmt);
                        addressprepUpdate.setString(1, newValue);
                        addressprepUpdate.setString(2, CustomerID);
                        addressprepUpdate.executeUpdate();
                        break;

                    default:
                        System.out.println("Enter the field correctly");
                        break;

                }
                initProject.connection.commit();
            }
            catch (SQLException  e){
                initProject.connection.rollback();
                e.printStackTrace();
            }
            finally {
                initProject.connection.setAutoCommit(true);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }






}
