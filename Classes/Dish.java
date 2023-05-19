package Classes;
import java.util.*;
public class Dish implements Holdable{

    private ArrayList<Item> items = new ArrayList<Item>();
    private String name;
    public double[] GetPercentage(){
        return new double[]{0,0};
    }
    public Dish(String name) {
        this.name = name;
    }
    public boolean AddItem(Item x) {
        for (Item item:(Item[]) items.toArray()){
            if (item.getName().equals(x.getName())){
                return false;
            }
        }
        items.add(x);
        return true;
    }
    public ArrayList<Item> getItems(){
        return this.items;
    }

    public void RemoveItem(Item x) {
        Item itemFound = null;
        for (Item item : this.items) {
            if (item.getName().equals(x.getName())) {
                itemFound = item;
                break;
            }
        }
        if (itemFound != null) {
            this.items.remove(itemFound);
        }
    }
    
    public String GetImage() {
        Recipe x = Recipe.GetRecipeFromDish(this);
        return "";
    }
    public String GetType() {return "Dish";}


}
