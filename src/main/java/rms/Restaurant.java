package rms;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public abstract class Restaurant {
    static final int available = 0;
    static final int reserved = 1;
    static final int occupied = 2;

    private String name;
    private List<Location> locations;
    private Menu menu;

    public Restaurant(String name) {
        this.name = name;
        this.locations = new ArrayList<Location>();
        this.menu = new Menu();
    }

    public Location addLocation(String name) {
        Location l = new Location(name);
        locations.add(l);
        return l;
    }

    public void removeLocation(Location loc) {
        locations.remove(loc);
    }

    public String getName() {
        return name;
    }

    public MenuItem addMenuItem(String name, double price) {
        MenuItem mi = new MenuItem(name, price);
        this.menu.addItem(mi);
        return mi;
    }

    public void displayRestaurantInfo() {
        System.out.println(this.name + "is open at the following locations:");
        for (Location l : locations) {
            System.out.println("  " + l.getName());
        }
        System.out.println(this.name + "serves the following foods:");
        for (MenuItem m : menu.getMenuItems()) {
            System.out.println("  " + m.getName());
        }
    }

    public Reservation addReservation(Location location, String name, LocalDateTime time) {
        for (Table t : location.getTables()) {
            if (t.getState() == available) {
                t.setState(reserved);
                Reservation newRes = new Reservation(name, t, time);
                t.addReservation(newRes);
                return newRes;
            }
        }
        return null;
    }

    public boolean cancelReservation(Location location, int tableNo) {
        for (Table t : location.getTables()) {
            if (t.getNumber() == tableNo && t.getState() == reserved) {
                t.setState(available);
                return true;
            }
        }
        return false;
    }

    public Order takeOrder(Location location, Table table) {
        System.out.println(this.name + " " + location.getName() + ": Please place your order!");
        return location.takeOrder(table, menu);
    }

    public void displaySales() {
        for (Location l : locations) {
            System.out.println(l.getName() + ":");
            l.calcTotalSales();
        }
    }
}



