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

    public static void addTransfers(){
        System.out.println("Enter the source StoreID");
        Scanner sc = new Scanner(System.in);
        String sourceStoreID = sc.nextLine();

        System.out.println("Enter the destination StoreID");
        sc = new Scanner(System.in);
        String destinationStoreID = sc.nextLine();

        System.out.println("Enter ProductID");
        sc = new Scanner(System.in);
        String pID= sc.nextLine();

        System.out.println("Enter the transfer Quantity");
        sc = new Scanner(System.in);
        int quantity = sc.nextInt();

        System.out.println("Enter Operator ID");
        sc = new Scanner(System.in);
        int oID = sc.nextInt();

        if(billingRecords.isTransferPossible(sourceStoreID, pID, quantity) == false){
            System.out.println("Transfer Not Possible - Insufficient Quantity");
            return;
        }

        try {
            updateProcess.updateTransfer(pID, sourceStoreID, destinationStoreID, quantity);
        }catch (Exception e){
            e.printStackTrace();
        }

        initTables.addTransferData(sourceStoreID, destinationStoreID, oID, quantity, pID);
    }

    public static void addReturn(){

        System.out.println("Enter Transaction ID");
        Scanner sc = new Scanner(System.in);
        String tID = sc.nextLine();

        System.out.println("Enter Product ID");
        sc = new Scanner(System.in);
        String pID = sc.nextLine();

        System.out.println("Enter Return Quantity");
        sc = new Scanner(System.in);
        int quantity = sc.nextInt();

        try{
            Float discount = billingRecords.getDiscount(pID);
            if (discount == -1F)
                discount = 0F;

            updateProcess.updateOrders(tID, pID, quantity, (float) (discount/100.0));
        } catch(Exception e){
            System.out.println("Transaction Update Failed");
            e.printStackTrace();
            return;
        }

        try{
            String storeID = billingRecords.getStoreIDFromTransactionID(tID);
            updateProcess.updateSells(pID, storeID, quantity);
        } catch (Exception e){
            System.out.println("Transaction Update Failed");
            e.printStackTrace();
        }
    }


    public static void addSupply(){

        System.out.println("Enter ProductID");
        Scanner sc = new Scanner(System.in);
        String pID = sc.nextLine();

        System.out.println("Enter StoreID");
        sc = new Scanner(System.in);
        String sID = sc.nextLine();

        System.out.println("Enter SupplierID");
        sc = new Scanner(System.in);
        String supplierID = sc.nextLine();

        System.out.println("Enter BuyPrice");
        sc = new Scanner(System.in);
        int buyPrice = Integer.parseInt(sc.nextLine());
        System.out.println("Enter Quantity");
        sc = new Scanner(System.in);
        int quantity = Integer.parseInt(sc.nextLine());

        initTables.addSupplyData(pID, sID, supplierID, buyPrice, quantity);

    }


    public static void addStore(){
        System.out.println("Enter StoreID");
        Scanner sc = new Scanner(System.in);
        String sID = sc.nextLine();

        System.out.println("Enter ManagerID");
        sc = new Scanner(System.in);
        int mID = Integer.parseInt(sc.nextLine());

        System.out.println("Enter Store Address");
        sc = new Scanner(System.in);
        String sADD = sc.nextLine();

        System.out.println("Enter Phoneno");
        sc = new Scanner(System.in);
        String Phoneno = sc.nextLine();


        initTables.addStoreData(sID, mID, sADD, Phoneno);
    }

    public static void addClubMember(){
        System.out.println("Enter CustomorID");
        Scanner sc = new Scanner(System.in);
        String cID = sc.nextLine();

        System.out.println("Enter First Name");
        sc = new Scanner(System.in);
        String fname = sc.nextLine();

        System.out.println("Enter Last Name");
        sc = new Scanner(System.in);
        String lname = sc.nextLine();

        System.out.println("Enter MembershipLevel");
        sc = new Scanner(System.in);
        String mlevel = sc.nextLine();

        System.out.println("Enter Phoneno");
        sc = new Scanner(System.in);
        String Phoneno = sc.nextLine();

        System.out.println("Enter Active Status");
        sc = new Scanner(System.in);
        String activeStatus = sc.nextLine();

        System.out.println("Enter Email");
        sc = new Scanner(System.in);
        String email = sc.nextLine();

        System.out.println("Enter Address");
        sc = new Scanner(System.in);
        String address = sc.nextLine();

        initTables.addClubMemberData(cID, fname, lname, mlevel, Phoneno, activeStatus, email, address);

    }

    public static void addDiscount(){
        System.out.println("Enter DiscountId");
        Scanner sc = new Scanner(System.in);
        String dID = sc.nextLine();

        System.out.println("Enter ProductID that you want to apply the discount on");
        sc = new Scanner(System.in);
        String pID = sc.nextLine();

        System.out.println("Enter Amount of Discount");
        sc = new Scanner(System.in);
        float amount = Float.parseFloat(sc.nextLine());

        System.out.println("Enter Start Date");
        sc = new Scanner(System.in);
        String sDate = sc.nextLine();

        System.out.println("Enter End Date");
        sc = new Scanner(System.in);
        String eDate = sc.nextLine();

        initTables.addDiscountData(dID, pID, amount, sDate, eDate);
    }


    public static void addMemberships(){
        System.out.println("Enter MembershipLevel");
        Scanner sc = new Scanner(System.in);
        String mlevel = sc.nextLine();

        System.out.println("Enter Reward");
        sc = new Scanner(System.in);
        float reward = Float.parseFloat(sc.nextLine());

        initTables.addMembershipsData(mlevel, reward);
    }

    public static void addSignUp(){
        System.out.println("Enter StoreID");
        Scanner sc = new Scanner(System.in);
        String sID = sc.nextLine();

        System.out.println("Enter StaffID");
        sc = new Scanner(System.in);
        int staffID = Integer.parseInt(sc.nextLine());

        System.out.println("Enter CustomerID");
        sc = new Scanner(System.in);
        String cID = sc.nextLine();

        System.out.println("Enter Sign Up Date");
        sc = new Scanner(System.in);
        String sdate = sc.nextLine();

        try{
            initTables.addSignUpData(sID, staffID, cID, sdate);
            addClubMember();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }


}
