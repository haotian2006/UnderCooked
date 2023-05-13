package Classes;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;

public class Cookware implements Holdable{
    private ArrayList<Item> Inventory;
    private String Image;
    private Counter CurrentlyOn;
    private String name;
    private double ProcessedTime;

    public double[] GetPercentage(){
        return new double[2];
    }
    public ArrayList<Item> GetInventory(){
        return Inventory;
    }
    public boolean Add(Item x){
        if (CanAdd(x)){
            Inventory.add(x);
            return true;
        }
        return false;
    }
    public boolean CanAdd(Item x){
        return true;
    }
    public boolean PlaceOn(Counter x){
        CurrentlyOn = x;
        return true;
    }
    public void OnIntereact(Player player){
        
    }
    public String GetImage(){
        return Image;
    }
    public String GetName(){
        return name;
    }
    public void Update(){
        
    }
    public static Cookware newCookware(String name){
        try {
            Class<?> myClass = Class.forName(("Cookware."+name));//gets the class in assets/Cookware/name
            return (Cookware) myClass.getDeclaredConstructor().newInstance();//creates a new class and convert it to an Cookware   
        } catch (ClassNotFoundException e) {
            e.printStackTrace(); 
            System.exit(1);
        }catch (NoSuchMethodException | InstantiationException | InvocationTargetException | IllegalAccessException e) {
            e.printStackTrace();
            System.exit(1);
        }
        return null;
    }

    public String GetType() {return "Cookware";}


}
 