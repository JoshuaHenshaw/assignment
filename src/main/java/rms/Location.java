package rms;

import java.util.ArrayList;
import java.util.List;

public class Location {

    private String name;
    private List<Table> tables;
    
    public Location(String name) {
        this.name = name;
        this.tables = new ArrayList<Table>();
    }

    public String getName() {
        return name;
    }

    public List<Table> getTables() {
        return tables;
    }

    public void addTable(Table table) {
        this.tables.add(table);
    }

    public void displayTables() {
        int a = 0;
        int o = 0;
        int r = 0;

        for (Table t : tables) {
            switch(t.getState()) {
                case 0:
                    a++; break;
                case 1:
                    r++; break;
                case 2:
                    o++; break;
            }
        }

        System.out.println("Available: " + a);
        System.out.println("Reserved: " + r);
        System.out.println("Occupied: " + o);
    }

    public Order takeOrder(Table table, Menu menu) {
        return table.takeOrder(menu);
    }

    public void calcTotalSales() {
        int totalSales = 0;
        double totalProfit = 0;
        for (Table t : tables) {
            List<Object> list = t.getSales();
            totalSales += ((Integer) list.get(0)).intValue();
            totalProfit += (Double.parseDouble(list.get(1).toString()));
        }
        System.out.println("  Total Sales: " + totalSales);
        System.out.println("  Total Income: " + totalProfit);
    }
}
