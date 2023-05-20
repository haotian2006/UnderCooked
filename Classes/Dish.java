package Classes;
import java.util.*;
public class Dish implements Holdable{

    private ArrayList<Item> items ;
    private String name;

    public void UpdateProcessedTime(double x){};//these two functions are here so that the interface is met 
    public double GetProcessedTime(){return 0;};
    public String getName(){
        return name;
    }
    public double[] GetPercentage(){
        return new double[]{0,0};
    }
    public Dish(String name) {
        this.name = name;
        items = new ArrayList<Item>();
    }
    public boolean AddItem(Item x) {
        items.add(x);
        if (Recipe.GetRecipeFromDish(this) == null){
            items.remove(x);
            return false;
        }
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
        return x.GetImage();
    }
    public String GetType() {return "Dish";}


}
