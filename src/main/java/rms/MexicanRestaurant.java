package rms;

public class MexicanRestaurant extends Restaurant {

    public MexicanRestaurant (String name) {
        super(name);
    }

    public void displayRestaurantInfo() {
        System.out.println("This is a Mexican restaurant.");
        super.displayRestaurantInfo();
    }
}
