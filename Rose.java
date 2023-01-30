public class Rose extends Product{//inheritance
    private String color;
    private String Name;
    private int price; //encapsulation
    public Rose(){
        super.getFlowerID();
        setValues("Rose", "Red");
        price = getPrice();
    }

    public void setValues(String name, String Color){
        setName(name);
        setColor(Color);
    }
    public void setValues(String name, String Color, int Price){
        setName(name);
        setColor(Color);
        price = getPrice();
    }
    public String getColor() {
        return color;
    }

    public String getName() {
        return Name;
    }

    public int getPrice() {
        return 500;
    }

    public void setName(String name) {
        Name = name;
    }

    public void setColor(String color) {
        this.color = color;             //3. reference variables
    }


}
