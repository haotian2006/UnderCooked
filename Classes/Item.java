package Classes;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

 
public class Item implements Holdable{
    private String name;
    private boolean plate;
    private boolean cooked;
    private boolean chopped;
    private boolean fried;
    private boolean dirty;
    private HashMap<String[],String> Images;
    private HashMap<String,Double> maxProcessTime;
    private double ProcessedTime;
    private String LastAction;
    public Item(){}

    public Item(String Name,HashMap<String[], String> Image,HashMap<String,Double> MaxProcessTime){//super constructor 
        name = Name;
        Images = Image;
        maxProcessTime = MaxProcessTime;
    }
    public Item(String Name,HashMap<String[], String> Image){//super constructor without MPT
        name = Name;
        Images = Image;
        
    }
    
    public String getName() {
        return name;
    }
    public void UpdateProcessedTime(double x){
        ProcessedTime = x;
    }
    public double GetProcessedTime(){
        return ProcessedTime;
    }
    public double[] GetPercentage() {
        return new double[]{ProcessedTime,getMaxProcessTime(LastAction)};
    }
    public String GetImage() {
        if (Images == null) return"";
        String NormalImage = "";
        for (Map.Entry<String[],String> entry : Images.entrySet()) {
            String[] states = entry.getKey();
            String image = entry.getValue();
            boolean match = true;
            boolean IsEmpty = states.length == 0;
            if (IsEmpty)NormalImage = image;
            for (String state : states){
                state = state.toLowerCase();
                if (
                    //apparently it is recommended to use the equals method instead of == 
                    //found it while looking through the string documents 
                    (state.equals("chopped") && !isChopped())
                || ((state.equals("fried") && !isFried())) 
                || ((state.equals("cooked") && !isCooked()))
                || ((state.equals("dirty") && !isDirty()))  
                ){ 
                    //if this passes it means that it didn't match
                    match = false;
                    break;
                }
            }
            if (match && !IsEmpty) return image;
        }
        return NormalImage;
    }
    public double getMaxProcessTime(String x) {
        Double val = maxProcessTime.get(x);
        LastAction= x;
        return val != null ? val :0;
    }
    public boolean isPlate() {
        return this.plate;    
    }

    public boolean isCooked() {
        return this.cooked;  
    }

    public boolean isFried() {
        return this.fried;
    }

    public boolean isDirty() {
        return this.dirty;  
    }

    public boolean isChopped() {
        return this.chopped;
    }

    public void setCooked(boolean cooked){
        this.cooked = cooked;
    }
    public void setFried(boolean fried){
        this.fried = fried;
    }
    public void setDirty(boolean dirty){
        this.dirty = dirty;
    }

    public void setChopped(boolean chopped) {
        this.chopped = chopped;
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


    public static Item newItem(String name){
        try {
            Class<?> myClass = Class.forName(("Items."+name));//gets the class in assets/Items/name
            return (Item) myClass.getDeclaredConstructor().
            newInstance(); //creates a new class and convert it to an Item   
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
        x.cooked = Cooked;
        x.fried = Fried;
        x.chopped = Chopped;
        return x;
    }
    public String GetType() {return "Item";}


    
}
