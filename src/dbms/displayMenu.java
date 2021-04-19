package dbms;

public class displayMenu {
    public static void printMenu(String menu){
        System.out.println(menu);
        switch (menu){
            case "Main Menu":
                System.out.println("1 - " + "Information processing");
                System.out.println("2 - " + "Maintaining inventory records");
                System.out.println("3 - " + "Maintaining billing and transaction records");
                System.out.println("4 - " + "Reports");
                System.out.println("5 - " + "Quit");
                break;

            case "Reports":
                System.out.println("1 - " + "Yearly Sales Report");
                System.out.println("2 - " + "Monthly Sales Report");
                System.out.println("3 - " + "Total Sales Report For a day");
                System.out.println("4 - " + "Yearly Store Sales Report");
                System.out.println("5 - " + "Monthly Store Sales Report");
                System.out.println("6 - " + "Store Sales Report Between Dates");
                System.out.println("7 - " + "All Merchandise Report");
                System.out.println("8 - " + "Merchandise Report for a specific Product");
                System.out.println("9 - " + "Get Customers Yearly Growth Report");
                System.out.println("10 - " + "Get Customers Monthly Growth Report");
                System.out.println("11 - " + "Get Customers Growth Report For a given period");
                System.out.println("12 - " + "Get All Customer Purchase History for a given period");
                System.out.println("13 - " + "Get Purchase History for a specific Customer");
                System.out.println("14 - " + "Main Menu");
                System.out.println("15 - " + "Quit");
                break;

            case "Maintaining inventory records":
                System.out.println("1 - " + "Create Inventory for newly arrived products");
                System.out.println("2 - " + "Update Inventory with returns");
                System.out.println("3 - " + "Transfers between Stores");
                System.out.println("4 - " + "Main Menu");
                System.out.println("5 - " + "Quit");
                break;

            case "Maintaining billing and transaction records":
                System.out.println("1 - " + "Generate Specific Supplier Bills");
                System.out.println("2 - " + "Generate All Supplier Bills");
                System.out.println("3 - " + "Generate Reward for Platinum Customers");
                System.out.println("4 - " + "Add new Transaction (Calculate Discount)");
                System.out.println("5 - " + "Main Menu");
                System.out.println("6 - " + "Quit");
                break;

            case "Information processing":
                System.out.println("Work in Progress");
                break;
        }

    }
}
