package rms;

import java.time.LocalDateTime;

public class Reservation {

    String customerName;
    Table table;
    private LocalDateTime time;

    public Reservation(String name, Table table, LocalDateTime time) {
        this.customerName = name;
        this.table = table;
        this.time = time;
    }

    public String getCustomerName() {
        return customerName;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public Table getTable() {
        return table;
    }
}
