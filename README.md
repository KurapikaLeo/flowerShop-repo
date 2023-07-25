# Flower Shop Application Overview

This Java application manages a flower shop. It provides the following functionalities:

- Customer registration
- Customer login
- New flower orders
- Displays complete orders post-payment
- Displays incomplete orders awaiting payment
- View all orders
- Exiting the flower shop menu
- Exiting the main application menu

## OOP Concepts Demonstrated

### Primitive and Reference Variables

`product.java` uses a primitive variable `int max = 1000;`, and `Customer.java` uses a reference variable `this.name = name;`.

### Classes and Objects

`public class Customer` in `Customer.java` models a customer, and `main.java` creates a new customer object: `Customer c1 = new Customer();`.

### Encapsulation

`private int flowerID` in `Product.java` is an example of encapsulation. Public getters and setters are used for this private variable.

### Aggregation

`Customer.java` demonstrates aggregation with `CustomerAddress address`.

### Inheritance

`Rose.java` and `Tulip.java` both inherit from `Product.java`.

### Class Hierarchy

`Product.java` is the parent class, with `Tulip.java` and `Rose.java` as child classes.

### Overloading (Compile-Time Polymorphism)

`Tulip.java` overloads the `setValues()` method with two different parameter signatures.

### Overriding (Run-Time Polymorphism)

The `toString()` method in `Orders.java` overrides the inherited method: `tokens[0] = Integer.toString(p.getFlowerID());`.

### Abstract Class

`Product.java` is an abstract class with an abstract method. This method is then overridden in the `Flower.java` interface.

### Interface

`Flower.java` is an interface implemented by the abstract class `Product.java`.

### User and Developer Isolation

The user interface presents a menu with various functionalities. The code implementing these functionalities is hidden from the user.

### Upcasting/Widening

`order.java` shows an example of upcasting with `Product p = (Product) new Rose();`.

### Static Fields and Methods

`Main.java` contains a static field `final static String welcome = “welcome to the flower shop”` and a static method `final static void welcome();`.

### Final Fields, Methods, Classes

Examples in the code include the `final static String welcome` in `Main.java` and the final method `final static void welcome()`.

### Data Structures

`ArrayList` is used in `Orders.java` to hold instances of roses and tulips: `ArrayList tulip = new ArrayList();`.

### Java Generics

`Orders.java` uses an `ArrayList` with Java Generics to allow lists of different types.

### Downcasting

`Orders.java` contains an example of downcasting with `Rose r = (Rose)p;`.

### Exception Handling

`Customer.java` uses a try-catch block to handle cases where a user inputs an incorrect password.

### File Reading and Writing

`Customer.java` demonstrates file reading and writing with `File file = new File("Customers.txt");` and `FileReader fis = new FileReader(file);`.

### Default Constructor and Copy Constructor

`Customer.java` contains a default constructor `Public customer(){}`, and `Order.java` contains a copy constructor `Tulip t = new Tulip(); Tulip t2 = new Tulip(t);`.







