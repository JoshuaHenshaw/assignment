package rms;

import java.util.List;
import java.util.ArrayList;

public class Menu {
    private List<MenuItem> menuItems;

    public Menu() {
        this.menuItems = new ArrayList<MenuItem>();
    }

    public List<MenuItem> getMenuItems() {
        return menuItems;
    }
    
    public void addItem(MenuItem item) {
        this.menuItems.add(item);
    }

    public void removeItem(MenuItem item) {
        this.menuItems.remove(item);
    }
}