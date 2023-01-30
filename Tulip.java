public class Tulip extends Product{
    private String color;
    private String Name;
    private int Price;
    public Tulip(){
        super.getFlowerID();
        setValues("Tulip", "White", 1000);
    }

    //Copy Constructor
    Tulip(Tulip t)
    {
        //System.out.println("Copy constructor called");

        color = t.color;
        Name = t.Name;
    }
    public void setValues(String name, String Color){//overloading
        setName(name);
        setColor(Color);
    }
    public void setValues(String name, String Color, int Price){//overloading
        setName(name);
        setColor(Color);
        Price = getPrice();
    }


    public void setColor(String color) {
        this.color = color;
    }

    public void setName(String name) {
        Name = name;
    }

    //overriding
    public int getPrice() {
        return 500;
    }

    public String getColor() {
        return color;
    }

    public String getName() {
        return Name;
    }
}
