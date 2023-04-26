package rms;

import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;

public class Table {
    static int count = 0;
    static final int available = 0;
    static final int reserved = 1;
    static final int occupied = 2;

    private Scanner input = new Scanner(System.in);
    private int number;
    private int state;
    private List<Reservation> reservations;
    private List<Order> orders;

    public Table() {
        this.number = count;
        count++;
        this.state = available;
        this.reservations = new ArrayList<Reservation>();
        this.orders = new ArrayList<Order>();
    }

    public int getNumber() {
        return number;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public List<Reservation> getReservations() {
        return reservations;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void addReservation(Reservation r) {
        reservations.add(r);
    }

    //make this an exception if possible
    public Order takeOrder(Menu menu) {
        if (this.state == occupied) {
            System.out.println("Table is occupied.");
            return null;
        }

        List<MenuItem> items = new ArrayList<MenuItem>();
        while (input.hasNext()) {
            String item = input.next();
            if (item.equals("end")) {
                break;
            }
            boolean contains = false;
            for (MenuItem mi : menu.getMenuItems()) {
                if (mi.getName().equalsIgnoreCase(item)) {
                    items.add(mi);
                    contains = true;
                    break;
                }
            }
            if (!contains) {
                System.out.println("Requested item is not on the menu.");
            }
        }
        if (items.isEmpty()) {
            return null;
        }

        Order newOrder = new Order(items);
        orders.add(newOrder);
        System.out.println("Order complete!");
        this.state = occupied;
        return newOrder;
    }

    public List<Object> getSales() {
        int totalOrders = orders.size();
        double totalPrice = 0;
        for (Order o : orders) {
            totalPrice += o.getTotalPrice();
        }
        List<Object> res = new ArrayList<Object>();
        res.add(totalOrders);
        res.add(totalPrice);
        return res;
    }
}
