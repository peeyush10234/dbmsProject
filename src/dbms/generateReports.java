package dbms;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class generateReports {
//Operation related to Yearly Sales Report
    public static void totalSalesReportYearly(String Year){
        String sqlStatement = "SELECT SUM(o.TotalPrice) AS TotalSales FROM Orders o, Transaction t "
                    + "WHERE o.TransactionID = t.TransactionID AND YEAR(t.PurchaseDate) = ?;";

        try{
            PreparedStatement yearlyReport = initProject.connection.prepareStatement(sqlStatement);
            yearlyReport.setString(1, Year);
            ResultSet rs = yearlyReport.executeQuery();
            rs.beforeFirst();
            while(rs.next()) {
                System.out.println("Query Executed Successfully");
                System.out.println("Total_Sales for Year " + Year + " : " + rs.getFloat("TotalSales"));
            }
        } catch(SQLException e){
            e.printStackTrace();
        }
    }
    //Operation related to Total Sales Report For a day
    public static void totalSalesReportDay(String date){
        String sqlStatement = "SELECT SUM(o.TotalPrice) AS TotalSales FROM Orders o, Transaction t "
                + "WHERE o.TransactionID = t.TransactionID AND t.PurchaseDate = ?;";

        try{
            PreparedStatement yearlyReport = initProject.connection.prepareStatement(sqlStatement);
            yearlyReport.setString(1, date);
            ResultSet rs = yearlyReport.executeQuery();
            rs.beforeFirst();
            while(rs.next()) {
                System.out.println("Query Executed Successfully");
                System.out.println("Total_Sales for Date " + date + " : " + rs.getFloat("TotalSales"));
            }
        } catch(SQLException e){
            e.printStackTrace();
        }
    }
    //Operation related to Monthly Sales Report
    public static void totalSalesReportMonthly(String year, String month){
        String sqlStatement = "SELECT SUM(o.TotalPrice) AS TotalSales FROM Orders o, Transaction t "
                + "WHERE o.TransactionID = t.TransactionID AND YEAR(t.PurchaseDate) = ? AND MONTH(t.PurchaseDate) = ?;";

        try{
            PreparedStatement monthlyReport = initProject.connection.prepareStatement(sqlStatement);
            monthlyReport.setString(1, year);
            monthlyReport.setString(2, month);
            ResultSet rs = monthlyReport.executeQuery();
            rs.beforeFirst();
            while(rs.next()) {
                System.out.println("Query Executed Successfully");
                System.out.println("Total_Sales for Year " + year + " And Month " + month + " : " + rs.getFloat("TotalSales"));
            }
        } catch(SQLException e){
            e.printStackTrace();
        }
    }
    //Operation related to Store Sales Report Between Dates
    public static void storeSalesReportPeriod(String date1, String date2, String StoreID){
        String sqlStatement = "SELECT StoreID, SUM(o.TotalPrice) AS TotalSales FROM Orders o, Transaction t "
                + "WHERE o.TransactionID = t.TransactionID AND t.StoreID = ? AND t.PurchaseDate BETWEEN ? AND ?;";

        try{
            PreparedStatement periodReport = initProject.connection.prepareStatement(sqlStatement);
            periodReport.setString(2, date1);
            periodReport.setString(3, date2);
            periodReport.setString(1, StoreID);
            ResultSet rs = periodReport.executeQuery();
            rs.beforeFirst();
            while(rs.next()) {
                System.out.println("Query Executed Successfully");
                System.out.println("StoreID" + " - " + rs.getString("StoreID") + " Total_Sales between Date " + date1 + " and " + date2 + " : " + rs.getFloat("TotalSales"));
            }
        } catch(SQLException e){
            e.printStackTrace();
        }
    }
    //Operation related to Yearly Store Sales Report
    public static void storeSalesYearly(String Year, String StoreID){
        String sqlStatement = "SELECT t.StoreID, SUM(o.TotalPrice) AS TotalSales FROM Orders o, Transaction t "
                + "WHERE o.TransactionID = t.TransactionID AND YEAR(t.PurchaseDate) = ? AND t.StoreID = ?;";

        try{
            PreparedStatement yearlyReport = initProject.connection.prepareStatement(sqlStatement);
            yearlyReport.setString(1, Year);
            yearlyReport.setString(2, StoreID);
            ResultSet rs = yearlyReport.executeQuery();
            rs.beforeFirst();
            while(rs.next()) {
                System.out.println("Query Executed Successfully");
                System.out.println("StoreID" + " - " + rs.getString("StoreID") + " Total_Sales for Year " + Year + " : " + rs.getFloat("TotalSales"));
            }
        } catch(SQLException e){
            e.printStackTrace();
        }
    }
    //Operation related to Monthly Store Sales Report
    public static void storeSalesReportMonthly(String year, String month, String StoreID){
        String sqlStatement = "SELECT StoreID, SUM(o.TotalPrice) AS TotalSales FROM Orders o, Transaction t "
                + "WHERE o.TransactionID = t.TransactionID AND YEAR(t.PurchaseDate) = ? AND MONTH(t.PurchaseDate) = ? AND t.StoreID = ?;";

        try{
            PreparedStatement monthlyReport = initProject.connection.prepareStatement(sqlStatement);
            monthlyReport.setString(1, year);
            monthlyReport.setString(2, month);
            monthlyReport.setString(3, StoreID);
            ResultSet rs = monthlyReport.executeQuery();
            rs.beforeFirst();
            while(rs.next()) {
                System.out.println("Query Executed Successfully");
                System.out.println("StoreID" + " - " + rs.getString("StoreID") + " Total_Sales for Year " + year + " And Month " + month + " : " + rs.getFloat("TotalSales"));
            }
        } catch(SQLException e){
            e.printStackTrace();
        }
    }
    //Operation related to Merchandise Report for a specific Product
    public static void merchandiseReportProduct(String productID){
        String sqlStatement = "SELECT StoreID,  ProductID, SUM(Quantity) as TotalStock FROM Sells " +
                "WHERE ProductID = ? GROUP BY StoreID;";

        try{
            PreparedStatement merchandiseReport = initProject.connection.prepareStatement(sqlStatement);
            merchandiseReport.setString(1, productID);
            ResultSet rs = merchandiseReport.executeQuery();
            rs.beforeFirst();
            while(rs.next()) {
                System.out.println("Query Executed Successfully");
                System.out.println("StoreID - " + rs.getString("StoreID") + "  ProductID - " + rs.getString("ProductID") + "  Quantity - " + rs.getInt("TotalStock"));
            }
        } catch(SQLException e){
            e.printStackTrace();
        }
    }
    //Operation related to All Merchandise Report
    public static void merchandiseReport(){
        String sqlStatement = "SELECT StoreID,  ProductID, SUM(Quantity) as TotalStock FROM Sells " +
                " GROUP BY StoreID, ProductID";

        try{
            PreparedStatement merchandiseReport = initProject.connection.prepareStatement(sqlStatement);
            ResultSet rs = merchandiseReport.executeQuery();
            rs.beforeFirst();
            while(rs.next()) {
                System.out.println("Query Executed Successfully");
                System.out.println("StoreID - " + rs.getString("StoreID") + "  ProductID - " + rs.getString("ProductID") + "  Quantity - " + rs.getInt("TotalStock"));
            }
        } catch(SQLException e){
            e.printStackTrace();
        }
    }
    //Operation related to Get Customers Growth Report For a given period
    public static void getCustomerReportPeriod(String date1, String date2){
        String sqlStatement = "SELECT Count(CustomerID) AS CustomerGrowth FROM SignUp Where date(SignUpDate) between ? AND ?;";
        try{
            PreparedStatement customerReport = initProject.connection.prepareStatement(sqlStatement);
            customerReport.setString(1, date1);
            customerReport.setString(2, date2);
            ResultSet rs = customerReport.executeQuery();
            rs.beforeFirst();
            while(rs.next()) {
                System.out.println("Query Executed Successfully");
                System.out.println("Total Customers joined between " + date1 + " AND " + date2 + " " + rs.getString("CustomerGrowth"));
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
    //Operation related to Get Customers Yearly Growth Report
    public static void getCustomerReportYearly(String year){
        String sqlStatement = "SELECT Count(CustomerID) AS CustomerGrowth FROM SignUp Where YEAR(SignUpDate)  = ?;";
        try{
            PreparedStatement customerReport = initProject.connection.prepareStatement(sqlStatement);
            customerReport.setString(1, year);
            ResultSet rs = customerReport.executeQuery();
            rs.beforeFirst();
            while(rs.next()) {
                System.out.println("Query Executed Successfully");
                System.out.println("Total Customers joined in " + year + " - " + rs.getString("CustomerGrowth"));
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
    //Operation related to Get Customers Monthly Growth Report
    public static void getCustomerReportMonthly(String year, String month){
        String sqlStatement = "SELECT Count(CustomerID) AS CustomerGrowth FROM SignUp Where YEAR(SignUpDate)  = ? AND MONTH(SignUpDate) = ?;";
        try{
            PreparedStatement customerReport = initProject.connection.prepareStatement(sqlStatement);
            customerReport.setString(1, year);
            customerReport.setString(2, month);
            ResultSet rs = customerReport.executeQuery();
            rs.beforeFirst();
            while(rs.next()) {
                System.out.println("Query Executed Successfully");
                System.out.println("Total Customers joined in " + year + " And Month " + month + " - " + rs.getString("CustomerGrowth"));
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
    //Operation related to Get All Customer Purchase History for a given period
    public static void getPurchaseReportPeriod(String date1, String date2){
        String sqlStatement = "SELECT t.CustomerID, SUM(o.totalPrice) AS TotalPurchase FROM Orders o, Transaction t WHERE o.TransactionID = t.TransactionID AND t.PurchaseDate BETWEEN  ? AND ? GROUP BY t.CustomerID;";
        try{
            PreparedStatement customerReport = initProject.connection.prepareStatement(sqlStatement);
            customerReport.setString(1, date1);
            customerReport.setString(2, date2);
            ResultSet rs = customerReport.executeQuery();
            rs.beforeFirst();

            if(!rs.isBeforeFirst()){
                System.out.println("No Record Found");
            }
            while(rs.next()){
                System.out.println("Query Executed Successfully");
                System.out.println("Total Purchase for CustomerID - " + rs.getString("CustomerID") + " is " + rs.getString("TotalPurchase") + " Between " + date1 + " AND " + date2);
            }

        }catch(SQLException e){
            e.printStackTrace();
        }
    }
    //Operation related to Get Purchase History for a specific Customer for a given period
    public static void getCustomerPurchaseReportPeriod(String CustomerID, String date1, String date2){
        String sqlStatement = "SELECT t.CustomerID, SUM(o.totalPrice) AS TotalPurchase FROM Orders o, Transaction t WHERE o.TransactionID = t.TransactionID AND t.PurchaseDate BETWEEN  ? AND ? AND t.CustomerID = ?;";
        try{
            PreparedStatement customerReport = initProject.connection.prepareStatement(sqlStatement);

            customerReport.setString(1, date1);
            customerReport.setString(2, date2);
            customerReport.setString(3, CustomerID);
            ResultSet rs = customerReport.executeQuery();
            rs.beforeFirst();

            if(!rs.isBeforeFirst()){
                System.out.println("No Record Found");
            }
            while(rs.next()){
                System.out.println("Query Executed Successfully");
                System.out.println("Total Purchase for CustomerID - " + rs.getString("CustomerID") + " is " + rs.getString("TotalPurchase") + " Between " + date1 + " AND " + date2);
            }

        }catch(SQLException e){
            e.printStackTrace();
        }
    }


    public static void testQueriesReport() {
        totalSalesReportYearly("2020");
        totalSalesReportMonthly("2020", "5");
        totalSalesReportDay("2020-05-01");
        storeSalesYearly("2020", "2001");
        storeSalesReportMonthly("2020", "5", "2001");
        storeSalesReportPeriod("2020-05-01", "2020-07-01", "2001");
        merchandiseReportProduct("3002");
        merchandiseReport();
        getCustomerReportMonthly("2019", "01");
        getPurchaseReportPeriod("2020-05-01", "2020-07-01");
        getCustomerPurchaseReportPeriod("5001", "2020-05-01", "2020-07-01");
    }



}
