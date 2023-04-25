package rms;

public class IndianRestaurant extends Restaurant {

    public IndianRestaurant(String name) {
        super(name);
    }

    public void displayRestaurantInfo() {
        System.out.println("This is an Indian restaurant.");
        super.displayRestaurantInfo();
    }
}
