package dbms;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class displayResults {
    public static void getStoreInfo(){

        String sql = "SELECT * FROM `Store`";
        try {
            PreparedStatement stmtGetStore = initProject.connection.prepareStatement(sql);

            ResultSet result = stmtGetStore.executeQuery();
            if(result.next()){
                String storeID = result.getString("StoreID");
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

    public static void getStaffInfo() {

        String sql = "SELECT * FROM `Staff`";
        try {
            PreparedStatement stmtGetStaff = initProject.connection.prepareStatement(sql);

            ResultSet result = stmtGetStaff.executeQuery();
            if (result.next()) {
                int staffID = result.getInt("StaffID");
                String Name = result.getString("Name");
                int Age = result.getInt("Age");
                String StoreID = result.getString("StoreID");
                String JobTitle = result.getString("JobTitle");
                String Phone = result.getString("Phone");
                String Email = result.getString("Email");
                Date TimeOfEmployment = result.getDate("TimeOfEmployment");
                String HomeAddress = result.getString("HomeAddress");

                System.out.println("Staff ID: " + staffID + " | Name : " + Name + " | Age " + Age + " | StoreID : " + StoreID
                        + "\n\n" + " | JobTitle : " + JobTitle + " | Phone : " + Phone + " | Email : " + Email + " | Time of Employment  : " + TimeOfEmployment
                        + " | Home Address : " + HomeAddress);

            } else {
                System.out.println(("Staff ID does not exist. Please check and try again"));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }
    public static void getSuppliersInfo(){

        String sql = "SELECT * FROM `Supplier`";
        try {
            PreparedStatement stmtGetStore = initProject.connection.prepareStatement(sql);

            ResultSet result = stmtGetStore.executeQuery();
            while(result.next()){
                String SupplierID = result.getString("SupplierID");
                String Name = result.getString("Name");
                String PhoneNo = result.getString("PhoneNo");
                String EmailAddress = result.getString("EmailAddress");
                String Location = result.getString("Location");
                System.out.println("SupplierID: "+ SupplierID +" | Name : "+ Name +" | PhoneNo: "+  PhoneNo + " | EmailAddress : "+EmailAddress
                        + " | Location : "+Location);

            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }



    public static void getMerchandiseInfo(){

        String sql = "SELECT * FROM `Merchandise`";
        try {
            PreparedStatement stmtGetStore = initProject.connection.prepareStatement(sql);

            ResultSet result = stmtGetStore.executeQuery();
            if(result.next()){
                String productID  = result.getString("ProductID");
                String storeID = result.getString("StoreID");
                String productName = result.getString("productName");
                String ProductionDate = result.getString("ProductionDate");
                String ExpirationDate = result.getString("ExpirationDate");
                int SellPrice = result.getInt("SellPrice");
                System.out.println("ProductID: "+ productID +" | StoreID : "+ storeID +" | productName: "+  productName + " | ProductionDate : "+ ProductionDate +" | ExpirationDate: " + ExpirationDate + " | SellPrice" + SellPrice);

            }
            else{
                System.out.println(("Store ID does not exist. Please check and try again"));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }

    public static void getSupplyInfo(){

        String sql = "SELECT * FROM `Supply`";
        try {
            PreparedStatement stmtGetStore = initProject.connection.prepareStatement(sql);

            ResultSet result = stmtGetStore.executeQuery();
            if(result.next()){
                String SupplyID  = result.getString("SupplyID");
                String SupplierID = result.getString("SupplierID");
                String ProductID = result.getString("ProductID");
                String StoreID = result.getString("StoreID");
                int BuyPrice = result.getInt("BuyPrice");
                int Quantity = result.getInt("Quantity");
                System.out.println("SupplyID: "+ SupplyID +" | SupplierID : "+ SupplierID +" ProductID | : "+  ProductID + " | StoreID : "+ StoreID + " | BuyPrice: " + BuyPrice + " | Quantity" + Quantity);

            }
            else{
                System.out.println(("Store ID does not exist. Please check and try again"));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }

    public static void getTransactionInfo(){

        String sql = "SELECT * FROM `Transaction`";
        try {
            PreparedStatement stmtGetStore = initProject.connection.prepareStatement(sql);

            ResultSet result = stmtGetStore.executeQuery();
            if(result.next()){
                String TransactionID = result.getString("TransactionID");
                String StoreID = result.getString("StoreID");
                String CustomerID = result.getString("CustomerID");
                String CashierID = result.getString("CashierID");
                String PurchaseDate = result.getString("PurchaseDate");


                System.out.println("TransactionID: "+ TransactionID +" | StoreID : "+ StoreID +" | CustomerID: "+  CustomerID + " | CashierID : " + CashierID + " | PurchaseDate : " + PurchaseDate);

            }
            else{
                System.out.println(("Store ID does not exist. Please check and try again"));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }

    public static void getOrdersInfo(){

        String sql = "SELECT * FROM `Orders`";
        try {
            PreparedStatement stmtGetStore = initProject.connection.prepareStatement(sql);

            ResultSet result = stmtGetStore.executeQuery();
            if(result.next()){
                String TransactionID = result.getString("TransactionID");
                String ProductID = result.getString("ProductID");
                int Price = result.getInt("Price");
                int Quantity = result.getInt("Quantity");
                float TotalPrice = result.getFloat("TotalPrice");



                System.out.println("TransactionID: "+ TransactionID +" | ProductID : "+ ProductID +" | Price: "+  Price + " | Quantity : " + Quantity + " | TotalPrice : " + TotalPrice);

            }
            else{
                System.out.println(("Store ID does not exist. Please check and try again"));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }


}
