package dbms;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class billingRecords {

    public static void generateSupplierBill(String supplierID){
        String sqlStatement = "SELECT SupplierID, SUM(BuyPrice*Quantity) AS Bill FROM Supply WHERE SUPPLIERID = ?;";

        try{
            PreparedStatement supplierBill = initProject.connection.prepareStatement(sqlStatement);
            supplierBill.setString(1, supplierID);

            ResultSet rs = supplierBill.executeQuery();
            rs.beforeFirst();

            if(!rs.isBeforeFirst()){
                System.out.println("No Record Found");
            }
            while(rs.next()){
                System.out.println("Query Executed Successfully");
                System.out.println("Total Bill for Supplier - " + supplierID + " = " + rs.getString("Bill"));
            }

        }catch(SQLException e){
            e.printStackTrace();
        }
    }

    public static void generateAllSuppliersBill(){
        String sqlStatement = "SELECT SupplierID, SUM(BuyPrice*Quantity) AS Bill FROM Supply WHERE SUPPLIERID = ?;";

        try{
            PreparedStatement supplierBill = initProject.connection.prepareStatement(sqlStatement);

            ResultSet rs = supplierBill.executeQuery();
            rs.beforeFirst();

            if(!rs.isBeforeFirst()){
                System.out.println("No Record Found");
            }
            while(rs.next()){
                System.out.println("Query Executed Successfully");
                System.out.println("Total Bill for Supplier - " + rs.getString("SupplierID") + " = " + rs.getString("Bill"));
            }

        }catch(SQLException e){
            e.printStackTrace();
        }
    }

    public void generateCustomersYearlyReward(String year){
        String date1 = year + "-01-01";
        String date2 = year + "-12-31";

        String sqlStatement = "SELECT t.CustomerID, SUM(o.TotalPrice*0.01*m.Reward) AS TotalReward FROM ClubMembers c"
                + "Transaction t, Orders o, Memberships m WHERE c.CustomerID = t.CustomerID AND c.MembershipLevel = m.MembershipLevel" +
                "AND o.TransactionID = t.TransactionID AND t.PurchaseDate BETWEEN ? AND ? Group By t.CustomerID;";

        try{
            PreparedStatement customerReward = initProject.connection.prepareStatement(sqlStatement);
            customerReward.setString(1, date1);
            customerReward.setString(2, date2);
            ResultSet rs = customerReward.executeQuery();
            rs.beforeFirst();

            if(!rs.isBeforeFirst()){
                System.out.println("No Record Found");
            }
            while(rs.next()){
                System.out.println("Query Executed Successfully");
                System.out.println("Total Reward Earned by Customer - " + rs.getString("CustomerID") + " = " + rs.getString("TotalReward"));
            }

        }catch(SQLException e){
            e.printStackTrace();
        }
    }

    public void generatePlatinumCustomersYearlyReward(String year){
        String date1 = year + "-01-01";
        String date2 = year + "-12-31";

        String sqlStatement = "SELECT t.CustomerID, SUM(o.TotalPrice*0.01*m.Reward) AS TotalReward FROM ClubMembers c"
                + "Transaction t, Orders o, Memberships m WHERE c.CustomerID = t.CustomerID AND c.MembershipLevel = m.MembershipLevel" +
                "AND o.TransactionID = t.TransactionID AND t.PurchaseDate BETWEEN ? AND ?  AND m.MembershipLevel = Platinum Group By t.CustomerID;";

        try{
            PreparedStatement customerReward = initProject.connection.prepareStatement(sqlStatement);
            customerReward.setString(1, date1);
            customerReward.setString(2, date2);
            ResultSet rs = customerReward.executeQuery();
            rs.beforeFirst();

            if(!rs.isBeforeFirst()){
                System.out.println("No Record Found");
            }
            while(rs.next()){
                System.out.println("Query Executed Successfully");
                System.out.println("Total Reward Earned by Platinum Customer - " + rs.getString("CustomerID") + " = " + rs.getString("TotalReward"));
            }

        }catch(SQLException e){
            e.printStackTrace();
        }
    }

    public static int getProductPrice(String productID, String StoreID){
        String sqlStatement = "SELECT SellPrice FROM Merchandise Where ProductID = ? AND StoreID = ? ;";
        try{
            PreparedStatement customerReward = initProject.connection.prepareStatement(sqlStatement);
            customerReward.setString(1, productID);
            customerReward.setString(2, StoreID);
            ResultSet rs = customerReward.executeQuery();
            rs.beforeFirst();

            if(!rs.isBeforeFirst()){
                return -1;
            }
            while(rs.next()){

                return rs.getInt("SellPrice");
            }

        }catch(SQLException e){
            e.printStackTrace();

        }
        return -1;
    }

    public static Float getDiscount(String productID){
        String sqlStatement = "SELECT Amount FROM Discount where ProductID = ?;";
        try{
            PreparedStatement customerReward = initProject.connection.prepareStatement(sqlStatement);
            customerReward.setString(1, productID);
            ResultSet rs = customerReward.executeQuery();
            rs.beforeFirst();

            if(!rs.isBeforeFirst()){
                return -1F;
            }
            while(rs.next()){

                return rs.getFloat("Amount");
            }

        }catch(SQLException e){
            e.printStackTrace();

        }
        return -1F;
    }

}
