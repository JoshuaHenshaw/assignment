package rms;

public class ItalianRestaurant extends Restaurant {

    public ItalianRestaurant(String name) {
        super(name);
    }

    public void displayRestaurantInfo() {
        System.out.println("This is an Italian restaurant.");
        super.displayRestaurantInfo();
    }
}
