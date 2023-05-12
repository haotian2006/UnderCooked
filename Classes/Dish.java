package Classes;
import java.util.*;
public class Dish implements Holdable{
    private ArrayList<Item> items;
    public void AddItem(Item x) {
        items.add(x);
    }
    public ArrayList<Item> getItems(){
        return items;
    }
    
    public String GetType() {return "Dish";}
}
