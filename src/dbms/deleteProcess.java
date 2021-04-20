package dbms;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

//The class deleteProcess provides methods to delete entries in particular tables
public class deleteProcess {
    public static Scanner sc = new Scanner(System.in);

//    Delete operation on the Store Table
    public static void deleteStoreInfo(){
        System.out.println("Enter StoreID that you want to delete");
        String StoreID = sc.nextLine();

        try{
            String sql = "DELETE FROM `Store` Where StoreID = ?";
            PreparedStatement deletestmtStore = initProject.connection.prepareStatement(sql);
            deletestmtStore.setString(1, StoreID);
            deletestmtStore.executeQuery();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

//    Delete Operation on the Staff Table
    public static void deleteStaffInfo(){
        System.out.println("Enter StaffID that you want to delete");
        String StaffID = sc.nextLine();

        try{
            String sql = "DELETE FROM `Staff` Where StaffID = ?";
            PreparedStatement staffstmtStore = initProject.connection.prepareStatement(sql);
            staffstmtStore.setString(1, StaffID);
            staffstmtStore.executeQuery();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

//Delete operation on the Supplier Table
    public static void deleteSupplierInfo(){
        System.out.println("Enter SupplierID that you want to delete");
        String SupplierID = sc.nextLine();

        try{
            String sql = "DELETE FROM `Supplier` Where SupplierID = ?";
            PreparedStatement supplierstmtStore = initProject.connection.prepareStatement(sql);
            supplierstmtStore.setString(1, SupplierID);
            supplierstmtStore.executeQuery();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

//    Delete operation on the Merchandise Table

    public static void deleteMerchandiseInfo(){
        System.out.println("Enter Product Id that you want to delete");
        String ProductID = sc.nextLine();
        System.out.println("Enter Store Id from which the product should be deleted");
        String StoreID = sc.nextLine();

        try{
            String sql = "DELETE FROM `Merchandise` Where ProductID = ? and StoreID =?";
            PreparedStatement merchandisestmtStore = initProject.connection.prepareStatement(sql);
            merchandisestmtStore.setString(1, ProductID);
            merchandisestmtStore.setString(2, StoreID);
            merchandisestmtStore.executeQuery();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }


//    Delete operation on the Discount Table


    public static void deleteDiscountInfo(){
        System.out.println("Enter DiscountID that you want to delete");
        String DiscountID = sc.nextLine();


        try{
            String sql = "DELETE FROM `Discount` Where DiscountID = ?";
            PreparedStatement discountstmtStore = initProject.connection.prepareStatement(sql);
            discountstmtStore.setString(1, DiscountID);
            discountstmtStore.executeQuery();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    //    Delete operation on the Memberships Table

    public static void deleteMembershipInfo(){
        System.out.println("Enter MembershipLevel that you want to delete");
        String MembershipLevel = sc.nextLine();


        try{
            String sql = "DELETE FROM `Memberships` Where MembershipLevel = ?";
            PreparedStatement memstmtStore = initProject.connection.prepareStatement(sql);
            memstmtStore.setString(1, MembershipLevel);
            memstmtStore.executeQuery();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }


//    Delete operation on the SUPPLY Table

    public static void deleteSupplyInfo(){
        System.out.println("Enter SupplyID that you want to delete");
        String SupplyID = sc.nextLine();


        try{
            String sql = "DELETE FROM `Supply` Where SupplyID = ?";
            PreparedStatement supplystmtStore = initProject.connection.prepareStatement(sql);
            supplystmtStore.setString(1, SupplyID);
            supplystmtStore.executeQuery();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }


//    Delete operation on the SELLS Table

    public static void deleteSellsInfo(){
        System.out.println("Enter StoreID that you want to delete the product from");
        String StoreID = sc.nextLine();

        System.out.println("Enter Product ID that you want to delete");
        String ProductID = sc.nextLine();

        try{
            String sql = "DELETE FROM `Sells` Where StoreID = ? and ProductID = ?";
            PreparedStatement sellsstmtStore = initProject.connection.prepareStatement(sql);
            sellsstmtStore.setString(1, StoreID);
            sellsstmtStore.setString(2, ProductID);
            sellsstmtStore.executeQuery();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }


    //    Delete operation on the ClubMembers Table

    public static void deleteClubMembersInfo(){
        System.out.println("Enter CustomerID that you want to delete the product from");
        String CustomerID = sc.nextLine();


        try{
            String sql = "DELETE FROM `ClubMembers` Where CustomerID = ? ";
            PreparedStatement cmstmtStore = initProject.connection.prepareStatement(sql);
            cmstmtStore.setString(1, CustomerID);
            cmstmtStore.executeQuery();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

}
