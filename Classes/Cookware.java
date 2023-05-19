package Classes;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;

public class Cookware implements Holdable{
    private ArrayList<Item> Inventory;
    private String Image;
    private Counter CurrentlyOn;
    private String name;
    private double ProcessedTime;
    private String TypeOfCooking;

    public void UpdateProcessedTime(double x){
        ProcessedTime = x;
    }
    public double GetProcessedTime(){
        return ProcessedTime;
    }
    public double[] GetPercentage(){
        double Needed = 0;
        for (int n =0;n<Inventory.size();n++){
            Needed += Inventory.get(n).getMaxProcessTime(TypeOfCooking);
        }
        return new double[]{ProcessedTime,Needed};
    }
    public ArrayList<Item> GetInventory(){
        return Inventory;
    }
    public boolean Add(Holdable y){
        if (y.GetType() != "Item") return false;
        Item x = (Item) y;
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
    public void OnInteract(Player player){
        
    }
    public String GetImage(){
        return Image;
    }
    public String GetName(){
        return name;
    }
    public void Update(){
        
    }
    public Cookware(String Name,String Image,String TypeOfCooking){
        this.name = Name; this.Image = Image;
        this.TypeOfCooking = TypeOfCooking;
        Inventory = new ArrayList<Item>();
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
 