package rms;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class RMSController {
    private List<Restaurant> restaurants;

    public RMSController() {
        this.restaurants = new ArrayList<Restaurant>();
    }

    public Restaurant addRestaurant(String name, String cuisine) {
        Restaurant r = null;
        switch(cuisine.toLowerCase()) {
            case "indian":
                r = new IndianRestaurant(name);
                this.restaurants.add(r);
                return r;
            case "italian":
                r = new ItalianRestaurant(name);
                this.restaurants.add(r);
                return r;
            case "chinese":
                r = new ChineseRestaurant(name);
                this.restaurants.add(r);
                return r;
            case "mexican":
                r = new MexicanRestaurant(name);
                this.restaurants.add(r);
                return r;
            default:
                return r;
        }
    }

    public static void main(String[] args) {
        RMSController rms = new RMSController();

        Restaurant r = rms.addRestaurant("Dominos", "Italian");
        Restaurant r2 = rms.addRestaurant("CNK", "cHinEse");

        r.addMenuItem("chicken", 8.99);
        r.addMenuItem("pizza", 5);
        r2.addMenuItem("dumpling", 3);
        r2.addMenuItem("buns", 5.90);
        r2.addMenuItem("noodles", 1.99);

        Location l = r.addLocation("Sydney");
        Location l2 = r2.addLocation("Bankstown");
        Location l3 = r.addLocation("north syd");
        Location l4 = r2.addLocation("randwick");

        //3 tables per location
        l.addTable(new Table());
        l2.addTable(new Table());
        l3.addTable(new Table());
        l4.addTable(new Table());
        l.addTable(new Table());
        l2.addTable(new Table());
        l3.addTable(new Table());
        Table t1 = new Table();
        l4.addTable(t1);
        l.addTable(new Table());
        l2.addTable(new Table());
        l3.addTable(new Table());
        l4.addTable(new Table());

        // Copy and paste for each of the reservation
        Reservation rv = r.addReservation(l, "james", LocalDateTime.now());
        Reservation rv2 = r.addReservation(l2, "john", LocalDateTime.now());
        Reservation rv3 = r.addReservation(l3, "jasper", LocalDateTime.now());

        r.takeOrder(l, rv.getTable());
        r2.takeOrder(l2, rv2.getTable());
        r.takeOrder(l3, rv3.getTable());
        r2.takeOrder(l4, t1);
        r.takeOrder(l, rv.getTable()); // PRINTS OCCUPIED

        r.displaySales();
        r2.displaySales();
    }
}