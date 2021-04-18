package dbms;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;
import java.sql.PreparedStatement;
public class infoProcess {
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




    //OPERATIONS RELATED TO STAFF TABLE
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
}
