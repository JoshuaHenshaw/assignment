package rms;

import java.util.List;

public class Order {

    List<MenuItem> items;
    double totalPrice;

    public Order(List<MenuItem> items) {
        this.items = items;
        this.totalPrice = calcTotalPrice();
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public double calcTotalPrice() {
        double total = 0;
        for (MenuItem i : items) {
            total += i.getPrice();
        }
        return total;
    }

    public void calcBill() {
        for (MenuItem mi : items) {
            System.out.println(mi.getName() + "    " + mi.getPrice());
        }
        System.out.println("Total: " + this.totalPrice);
    }
}
