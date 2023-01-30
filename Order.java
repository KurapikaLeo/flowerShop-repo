import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
public class Order {
    //Arraylist
    ArrayList<Rose> roses = new ArrayList<Rose>();
    ArrayList<Tulip> tulip = new ArrayList<Tulip>();
    public int OrdersMenu(){
        System.out.println("-----Flowers Orders Menu------\n");
        System.out.println("1. Order new Flowers");
        System.out.println("2. Show Complete Orders");
        System.out.println("3. Show Incomplete Orders");
        System.out.println("4. Show All Orders");
        System.out.println("5. Exit Orders Menu");
        System.out.println("\nChoose an option");

        Scanner scanner = new Scanner(System.in);
        int choice  = scanner.nextInt();
        return choice;
    }

    public void CreateOrder() {
        int flower;
        int price = -1;
        System.out.println("\nChoose a flower");
        System.out.println("\n1. Rose");
        System.out.println("\n2. Tulip");
        Scanner in = new Scanner(System.in);
        flower = in.nextInt();
        System.out.println("\nChoose Quantity in number of bouqets");
        int Quantity = in.nextInt();
        String[] tokens = new String[4];
        if(flower == 1){
            //UpCasting
            Product p = (Product) new Rose();
            tokens[0] = Integer.toString(p.getFlowerID());
            // Performing Downcasting Explicitly
            Rose r = (Rose)p;
            tokens[1] = r.getName();
            tokens[2] = r.getColor();
            tokens[3] = Integer.toString(r.getPrice());
            price = r.getPrice()*Quantity;
            roses.add(r);
        }
        if(flower == 2){
            Tulip t = new Tulip();
            //Copy Constructor Invoked
            Tulip t2 = new Tulip(t);
            tokens[0] = Integer.toString(t.getFlowerID());
            tokens[1] = t2.getName();
            tokens[2] = t2.getColor();
            tokens[3] = Integer.toString(t.getPrice());
            price = t.getPrice()*Quantity;
            tulip.add(t);
        }
        addOrder(tokens, Integer.toString(Quantity), Integer.toString(price));
    }


    public void addOrder(String[] tokens, String quantity, String price) {
        try {
            File fout = new File("Orders.txt");
            FileOutputStream fos = new FileOutputStream(fout, true);
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fos));
            bw.write(tokens[0] + ";" + tokens[1] + ";" + tokens[2] + ";" + tokens[3] + ";"  + quantity + ";" + price + ";" + "Incomplete");
            bw.newLine();
            System.out.println("\n------Order Placed Successfully, for recieving your Order and Payment Please Check Incomplete Orders List------\n");
            bw.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }


    public void CompleteOrders(){
        BufferedReader br = null;
        try {
            File file2 = new File("Orders.txt");
            FileReader fis2 = new FileReader(file2);     //opens a connection to an actual file
            br = new BufferedReader(fis2);
            String line;
            System.out.println("FlowerID\t\tFlower\t\tPrice\t\tQuantity\t\tTotal Price");
            while ((line = br.readLine()) != null) {
                if (line.contains("Complete")) {
                    String[] tokens= line.split(";");
                    System.out.println(tokens[0] + "\t\t     " + tokens[1] + "\t\t     " + tokens[3] + "\t\t     " + tokens[4] + "\t\t     " + tokens[5]);
                }
            }
            br.close();
        }catch (Exception ex){
            System.out.println(ex);
        }
    }

    public void InCompleteOrders(){
        try {
            File file2 = new File("Orders.txt");
            FileReader fis2 = new FileReader(file2);     //opens a connection to an actual file
            BufferedReader br = new BufferedReader(fis2);
            String line;
            System.out.println("FlowerID\t\tFlower\t\tPrice\t\tQuantity\t\tTotal Price");
            while ((line = br.readLine()) != null) {
                if (line.contains("Incomplete")) {
                    String[] tokens= line.split(";");
                    System.out.println(tokens[0] + "\t\t     " + tokens[1] + "\t\t     " + tokens[3] + "\t\t     " + tokens[4] + "\t\t     " + tokens[5]);
                }
            }
            br.close();
        }catch (Exception ex){
            System.out.println(ex);
        }
        System.out.println("\nPlease select your FlowerID for Payment");
        Scanner scanner = new Scanner(System.in);
        String item = scanner.nextLine();
        System.out.println("Please Pay the Required Amount");
        int pay = scanner.nextInt();
        ClearOrder(item,pay);
    }

    public void ClearOrder(String item, int pay){
        BufferedReader br = null;
        try {
            File file2 = new File("Orders.txt");
            FileReader fis2 = new FileReader(file2);     //opens a connection to an actual file
            br = new BufferedReader(fis2);
            String line;
            int count = 0;
            int Price = 0;
            while ((line = br.readLine()) != null) {
                if (line.contains(item)) {
                    count++;
                    String[] tokens= line.split(";");
                    Price = Integer.parseInt(tokens[5]);
                    if(Price == pay){
                        System.out.println("Payment Cleared\nChange $0");
                        tokens[6] = "Complete";
                        Update(tokens,item);
                        break;
                    }
                    else if(Price > pay){
                        System.out.println("Insufficient Payment! Come Again");
                        break;
                    }
                    else{
                        int change = pay - Price;
                        System.out.println("Payment Cleared\nChange $"+change);
                        tokens[6] = "Complete";
                        Update(tokens,item);
                        break;
                    }
                }
            }
            if(count == 0)
                System.out.println("Flower Order not Found! Please place order first");
            br.close();
        }catch (Exception ex){
            System.out.println(ex);
        }
    }

    public void Update(String[] tokens, String item){
        try{
            File file2 = new File("Orders.txt");
            FileReader fis2 = new FileReader(file2);     //opens a connection to an actual file
            BufferedReader br = new BufferedReader(fis2);
            File fout = new File("temp.txt");
            FileOutputStream fos = new FileOutputStream(fout);
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fos));
            String line;
            while ((line = br.readLine()) != null) {
                if (line.contains(item)) {
                    bw.write(tokens[0] + ";" + tokens[1] + ";" + tokens[2] + ";" + tokens[3] + ";" + tokens[4] + ";" + tokens[5] + ";" + tokens[6]);
                    bw.newLine();
                }
                else {
                    bw.write(line);
                    bw.newLine();
                }
            }
            br.close();
            bw.close();
            FileRenew();
        }
        catch(IOException e){
            System.out.println(e);
        }
    }

    public void FileRenew(){
        try{
            File file2 = new File("temp.txt");
            FileReader fis2 = new FileReader(file2);     //opens a connection to an actual file
            BufferedReader br = new BufferedReader(fis2);
            File fout = new File("Orders.txt");
            FileOutputStream fos = new FileOutputStream(fout);
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fos));
            String line;
            while ((line = br.readLine()) != null) {
                bw.write(line);
                bw.newLine();
            }
            br.close();
            bw.close();
        }
        catch(IOException e){
            System.out.println(e);
        }
    }

    public void AllOrders(){
        try {
            File file2 = new File("Orders.txt");
            FileReader fis2 = new FileReader(file2);     //opens a connection to an actual file
            BufferedReader br = new BufferedReader(fis2);
            String line;

            System.out.println("FlowerID\t\tFlower\t\tPrice\t\tQuantity\t\tTotal Price");
            while ((line = br.readLine()) != null) {
                String[] tokens= line.split(";");
                System.out.println(tokens[0] + "\t\t     " + tokens[1] + "\t\t     " + tokens[3] + "\t\t     " + tokens[4] + "\t\t     " + tokens[5]);
            }
            br.close();
        }catch (Exception ex){
            System.out.println(ex);
        }
    }
}
