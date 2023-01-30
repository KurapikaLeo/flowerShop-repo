# flowerShop-repo
This application manages a flower shop , it contains a menu from which the user can choose a range of options. 
Functionality 
Signing up a customer to the shop
Logging in session for the customer
Order new flowers
Show the complete orders once payment has been made
Show the incomplete orders where the customer still needs to make a payment
Show all orders
Exiting the flower menu
Exiting the main menu


Technical Difficulty: OOP Concepts Demonstrated in the Java Application
Primitive and reference variables : product.java has primitive variable - int max = 1000; and reference type in Customer.java - this.name = name.
Classes and objects: public class Customer in Customer.java models the customer and main.java creates the customer object - Customer c1 = new Customer();.
Encapsulation: private int flowerID in Product.java has encapsulation and the getters and setters of flowerID are set to public. 
Aggregation: in Customer.java - CustomerAddress address.
Inheritance: Rose.java and Tulip.java inherit from Product.java.
Class hierarchy: a small hierarchy is created where the Product.java is the parent and Tulip.java and Rose.java are the children.
Overloading - compile time polymorphism: Tulip.java has 2 versions of the method setValues(), both have different sets of parameter signatures. 
Overwriting - run time polymorphism:tokens[0] = Integer.toString(p.getFlowerID()); the toString() method in Orders.java.
Abstract class: class Product.java is abstract , it contains an abstract method with no body. It is overwritten by the Flower.java interface. 
Interface: Flower.java is the interface. It is implemented by the abstract class Product.java. 
User and developer isolation: the user interface is the menu that can be seen with the various functionality options. The user does not know how this functionality has been implemented in the code. This is only known by the developer of the program. 
Upcasting/ widening : order.java has upcating Product p = (Product) new Rose();
Where the Product is the superclass and the Rose is the subclass.
Static fields and methods: Main.java has a static field at the top of the file - final static String welcome = “welcome to the flower shop”; and a static method final static void welcome();
Final fields, methods, classes: final static String welcome in Main.java and the final method -  final static void welcome() .
Data structures: ArrayList implementation in Orders.java for roses and tulips. ArrayList<Tulip> tulip = new ArrayList<Tulip>(); 
Java generics: Orders.java has an ArrayList<Rose>. Generics allows to have lists of different types.
Downcasting: in Orders.java - Rose r = (Rose)p;
Exception handling: Customer.java has a try block, if something goes wrong eg the Customer puts the incorrect password in then the catch block is executed. 
File reading and writing: in Customer.java - File file = new File("Customers.txt"); this creates a new file, FileReader fis = new FileReader(file); - this creates a connection to an actual file. 
Default constructor and copy constructor: in Customer.java there is a default constructor 
Public customer(){}; this has the same name as the class and the main constructor. 
Order.java has a copy constructor - Tulip t = new Tulip(); Tulip t2 = new Tulip(t);









