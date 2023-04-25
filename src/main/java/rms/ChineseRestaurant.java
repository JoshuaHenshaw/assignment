package rms;

public class ChineseRestaurant extends Restaurant {

    public ChineseRestaurant(String name) {
        super(name);
    }

    public void displayRestaurantInfo() {
        System.out.println("This is a Chinese restaurant.");
        super.displayRestaurantInfo();
    }
}
