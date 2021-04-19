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
                break;
        }

    }
}
