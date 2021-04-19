package dbms;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class displayTables {

    public static void getClubMembersInfo(){

        String sql = "SELECT * FROM `ClubMembers`";
        try {
            PreparedStatement stmtGetStore = initProject.connection.prepareStatement(sql);

            ResultSet result = stmtGetStore.executeQuery();
            while(result.next()){
                String CustomerID = result.getString("CustomerID");
                String FirstName = result.getString("FirstName");
                String LastName = result.getString("LastName");
                String MembershipLevel = result.getString("MembershipLevel");
                String PhoneNo = result.getString("PhoneNo");
                String ActiveStatus = result.getString("ActiveStatus");
                String Email = result.getString("Email");
                String Address = result.getString("Address");
                System.out.println("Customer ID: "+ CustomerID +" | FirstName : "+ FirstName +" | LastName: "+  LastName + " | MembershipLevel : "+MembershipLevel +"\n"
                        + " | PhoneNo : "+PhoneNo+ " | ActiveStatus : "+ActiveStatus+ " | Email : "+Email+ " | Address : "+Address);

            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }

    public static void getDiscountInfo(){

        String sql = "SELECT * FROM `Discount`";
        try {
            PreparedStatement stmtGetStore = initProject.connection.prepareStatement(sql);

            ResultSet result = stmtGetStore.executeQuery();
            while(result.next()){
                String DiscountID = result.getString("DiscountID");
                String ProductID = result.getString("ProductID");
                Float Amount = result.getFloat("Amount");
                String StartDate = result.getDate("StartDate").toString();
                String EndDate = result.getDate("EndDate").toString();

                System.out.println("DiscountID : "+ DiscountID +" | ProductID : "+ ProductID +" | Amount: "+  Amount + " | StartDate : "+StartDate
                        + " | EndDate : "+EndDate);

            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }


    public static void getMembershipLevelInfo(){

        String sql = "SELECT * FROM `Memberships`";
        try {
            PreparedStatement stmtGetStore = initProject.connection.prepareStatement(sql);

            ResultSet result = stmtGetStore.executeQuery();
            while(result.next()){
                String MembershipLevel = result.getString("MembershipLevel");

                Float Reward = result.getFloat("Reward");

                System.out.println("MembershipLevel : "+ MembershipLevel +" | Reward : "+ Reward);

            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }

    public static void getSignUpInfo(){

        String sql = "SELECT * FROM `SignUp`";
        try {
            PreparedStatement stmtGetStore = initProject.connection.prepareStatement(sql);

            ResultSet result = stmtGetStore.executeQuery();
            while(result.next()){
                String StoreID = result.getString("StoreID");
                String StaffID = result.getString("StaffID");
                String CustomerID = result.getString("CustomerID");
                String SignUpDate = result.getDate("SignUpDate").toString();


                System.out.println("StoreID : "+ StoreID +" | StaffID : "+ StaffID +" | CustomerID: "+  CustomerID + " | SignUpDate : "+SignUpDate);

            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }
}
