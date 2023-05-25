package Classes;
import java.util.*;
public class Dish implements Holdable{

    private ArrayList<Item> items ;
    private String name;
    private String image;

    //these three functions are here so that the interface is met 
    public void UpdateProcessedTime(double x){};
    public double GetProcessedTime(){return 0;};
    public double[] GetPercentage(){return new double[2];}

    public String getName(){
        return name;
    }
    public Dish(String name) {
        this.name = name;
        items = new ArrayList<Item>();
    }
    public boolean AddItem(Item x) {
        items.add(x);
        Recipe r = Recipe.GetRecipeFromDish(this);
        if (Recipe.GetClosestRecipeFromDish(this) == null){
            items.remove(x);
            return false;
        }
        if (r == null){
            if (items.size() == 1){
                image=  items.get(0).GetImage();
            }
        }else{
            image = r.GetImage();
        }
        return true;
    }
    public ArrayList<Item> getItems(){
        return this.items;
    }

    //deprecated 
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
        if (image != null && x == null){
            return image;
        }
        Recipe close = Recipe.GetClosestRecipeFromDish(this);
        if (x == null){
            if (items.size() == 1){
                return items.get(0).GetImage();
            }else if(close != null){
                return close.GetImage();
            }
        };
        return x.GetImage();
    }
    public String GetType() {return "Dish";}


}
