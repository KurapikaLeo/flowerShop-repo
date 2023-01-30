public abstract class Product implements Flower {
    private int flowerID; //encapsulation

    public abstract int getPrice();
    public int getFlowerID() {
        int max = 1000;   //2. primitive variable
        int min = 1;
        flowerID = (int) (Math.random() * (max - min + 1) + min);
        return flowerID;
    }


    public void setFlowerID(int flowerID) {
        this.flowerID = flowerID;
    }


}
