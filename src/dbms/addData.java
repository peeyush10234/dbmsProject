package dbms;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class addData {

    public static void addTransaction(){

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter TransactionID");
        String tID = sc.nextLine();
        System.out.println("Enter StoreID");
        String sID = sc.nextLine();
        System.out.println("Enter CustomerID");
        String cID = sc.nextLine();
        System.out.println("Enter CashierID");
        int cashierID = sc.nextInt();
        String PurchaseDate = String.valueOf(java.time.LocalDate.now());
        System.out.println("Enter number of items purchased");
        int n = sc.nextInt();
        List<Integer> quantities = new ArrayList<>();
        List<String> productIds = new ArrayList<>();
        String pID;
        int quan;

        for(int i=0; i<n; i++){
            System.out.println("Enter ProductID - Enter Quantity");
            Scanner sd = new Scanner(System.in);
            String temp = sd.nextLine();
            String[] ta = temp.split(" - ");

            pID = ta[0];
            quan = Integer.parseInt(ta[1]);

            quantities.add(quan);
            productIds.add(pID);
        }

        try{
            initTables.addTransactionData(tID, sID, cID, cashierID, PurchaseDate);
            System.out.println("fe");
        } catch (Exception e){
            e.printStackTrace();
            System.out.println("Not able to add the given Transaction");
            return;
        }

        try{
            for(int i=0; i<n; i++){
                int sellPrice = billingRecords.getProductPrice(productIds.get(i), sID);
                float discount = billingRecords.getDiscount(productIds.get(i));

                if(sellPrice == -1){
                    // delete previously entered transaction entry
                    System.out.println("Not able to add the given Transaction");
                    return;
                }

                if (discount == -1F)
                    discount = 0.0F;

                float totalPrice = (sellPrice*quantities.get(i))*((100.0F - discount)/100F);

                initTables.addOrdersData(tID, productIds.get(i), sellPrice, quantities.get(i), totalPrice);
            }
        } catch(Exception e){
            e.printStackTrace();
            System.out.println("Not able to add the given Transaction");
        }

    }

    public static void addInventory(){

        System.out.println("Enter ProductID");
        Scanner sc = new Scanner(System.in);
        String pID = sc.nextLine();

        System.out.println("Enter StoreID");
        sc = new Scanner(System.in);
        String sID = sc.nextLine();

        System.out.println("Enter SupplierID");
        sc = new Scanner(System.in);
        String supplierID = sc.nextLine();

        System.out.println("Enter Product Name");
        sc = new Scanner(System.in);
        String pName = sc.nextLine();

        System.out.println("Enter Product Quantity");
        sc = new Scanner(System.in);
        int quantity = sc.nextInt();

        System.out.println("Enter Product Buy Price");
        sc = new Scanner(System.in);
        int buyPrice = sc.nextInt();

        System.out.println("Enter Product Sell Price");
        sc = new Scanner(System.in);
        int sellPrice = sc.nextInt();

        System.out.println("Enter Production Date");
        sc = new Scanner(System.in);
        String productionDate = sc.nextLine();

        System.out.println("Enter Expiration Date");
        sc = new Scanner(System.in);
        String expirationDate = sc.nextLine();

        initTables.addInventoryDetails(pID, sID, pName, quantity, buyPrice, sellPrice, productionDate, expirationDate, supplierID);
    }

    public static void main(String[] args){
//        int s  = billingRecords.getProductPrice("3001", "2001");
        addTransaction();
    }
}
