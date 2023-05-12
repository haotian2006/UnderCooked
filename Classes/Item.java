package Classes;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
 
public class Item implements Holdable{
    private String name;
    private boolean plate;
    private boolean cooked;
    private boolean chopped;
    private boolean fried;
    private boolean dirty;
    private HashMap Images;
    private HashMap maxProcessTime;
    private double processedTime;

    
    public String getName() {
        return name;
    }
    public double[] getPercentage() {
        return new double[2];
    }
    public String getImage() {
        return Image;
    }
    public double getMaxProcessTime(String x) {

    }
    public boolean isPlate() {

    }
    public boolean isCooked() {
        
    }
    public boolean isFried() {

    }
    public boolean isDirty() {
        
    }
    public boolean isChopped() {

    }
    public void setCooked(boolean x){


    }
    public void setFried(boolean x){

    }
    public void setDirty(boolean x){

    }
    public void setChopped(boolean x) {

    }
    public boolean canBeChopped() {
        
        return false;
    }
    public boolean canBeCooked() {
        return false;
    }
    public boolean canBeFried() {
        return false;
    }
    public boolean canHold() {
        return true;
    }

    public boolean equals(Item other){ 
    }

    public static Item newItem(String name){
        try {
            Class<?> myClass = Class.forName(("Items."+name));//gets the class in assets/Items/name
            return (Item) myClass.getDeclaredConstructor().newInstance(); //creates a new class and convert it to an Item   
        } catch (ClassNotFoundException e) {
            e.printStackTrace(); 
            System.exit(1);
        }catch (NoSuchMethodException | InstantiationException | InvocationTargetException | IllegalAccessException e) {
            e.printStackTrace();
            System.exit(1);
        }
        return null;
    }
    public static Item newItem(String name,boolean Cooked,boolean Fried, boolean Chopped){
        Item x = newItem(name);
        if (x == null) return null;
        // add to this

        return x;
    }
    public String GetType() {return "Item";}


    
}
