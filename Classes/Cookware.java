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
    private int maxAmount = 1;
    public String getName(){
        return name;
    }
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
            double[] percent = GetPercentage();
            Inventory.add(x);
            if (percent[0]> percent[1]){
                UpdateProcessedTime(percent[1]);
            }
            return true;
        }
        return false;
    }
    public boolean CanAdd(Item x){
        if (GetInventory().size() == 0 ||GetInventory().get(0).getName() == x.getName() && GetInventory().size() < maxAmount){
            return x.canBeState(TypeOfCooking);
        }
        return false;
    }
    public boolean PlaceOn(Counter x){
        CurrentlyOn = x;
        return true;
    }
    public void OnInteract(Player player){
        
    }
    public boolean OnDish(Dish x){
        double[] p = GetPercentage();
        //if the cooked percentage is bigger then 1 and max amount is reached 
        if (Inventory.size() == maxAmount && p[0]/p[1] >= 1){
            ArrayList<Item> added = new ArrayList<Item>();
            for (int n = 0;n<Inventory.size();n++){
                Item itm = Inventory.get(n);
                itm.setState(TypeOfCooking, true);
                if (!x.AddItem(itm)){
                    for (int z = 0;z<added.size();z++){
                        x.RemoveItem(added.get(z));
                    }
                    added = null;
                    return false;
                }
                added.add(itm);
            }
            ProcessedTime = 0;
            Inventory.clear();
            return true;
        }
        return false;

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
    public Cookware(String Name,String Image,String TypeOfCooking,int max){
        this.name = Name; this.Image = Image;
        this.TypeOfCooking = TypeOfCooking;
        maxAmount = max;
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
 