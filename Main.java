import java.util.Scanner;

public class Main {
    //static field
    final static String welcome= "Welcome to FLower Shop";
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice = 0;
        Welcome();
        do {
            //menu
            System.out.println("-----Menu------\n");
            System.out.println("1. Sign up as Customer");
            System.out.println("2. Login as Customer");
            System.out.println("3. Exit Main Menu");
            System.out.println("\nChoose an option");

            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    Scanner scanner2 = new Scanner(System.in);

                    System.out.println("Enter Username: ");
                    String username = scanner2.nextLine();
                    System.out.println("Enter Password: ");
                    String password = scanner2.nextLine();
                    System.out.println("Enter City: ");
                    String City = scanner2.nextLine();
                    System.out.println("Enter State: ");
                    String State = scanner2.nextLine();
                    System.out.println("Enter Country: ");
                    String Country = scanner2.nextLine();
                    CustomerAddress address = new CustomerAddress(City, State, Country); //using aggregation
                    Customer c = new Customer(username,address,password);
                    c.addCustomer();
                    break;
                case 2:
                    //2. Object Calling
                    Customer c1 = new Customer();
                    int counter = c1.searchCustomer();
                    if(counter == 1){
                        Order o = new Order();
                        int ch = 0;
                        do {
                            ch = o.OrdersMenu();
                            if (ch == 1)
                                o.CreateOrder();
                            else if (ch == 2)
                                o.CompleteOrders();
                            else if (ch == 3)
                                o.InCompleteOrders();
                            else if (ch == 4)
                                o.AllOrders();
                        } while (ch != 5);
                    }
                    break;
            }
        }while(choice != 3);
    }
    //static method
    final static void Welcome(){
        System.out.println(welcome);
    }
}