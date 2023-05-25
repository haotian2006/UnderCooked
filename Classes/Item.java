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
        maxProcessTime = new HashMap<String,Double>();;

        //lower cases everything
        for (Map.Entry<String,Double> entry : MaxProcessTime.entrySet()) {
            String key = entry.getKey();
            Double value = entry.getValue();
            maxProcessTime.put(key.toLowerCase(), value);
        }
    }
    public Item(String Name,HashMap<String[], String> Image){//super constructor without MPT
        name = Name;
        Images = Image;
        maxProcessTime = new HashMap<String,Double>();
        
    }
    public boolean equals(Item obj){
        if (obj == null) return false;
        return (
            cooked == obj.isCooked() &&
            fried == obj.isFried() &&
            chopped == obj.isChopped() &&
            dirty == obj.isDirty() &&
            name == obj.getName() 
        );
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
    public boolean isModified(){
        return (isChopped()||isCooked()||isFried());
    }
    public boolean canBeState(String x){
        x = x.toLowerCase();
        switch (x){
            case "chop":
                return canBeChopped();
            case "cook":
                return canBeCooked();
            case "fry":
                return canBeFried();
            default:
                return false;
        }
    }
    public void setState(String x,boolean y){
        x = x.toLowerCase();
        switch (x){
            case "chop":
                setChopped(y);
                break;
            case "cook":
                setCooked(y);
                break;
            case "fry":
                setFried(y);
                break;
            default:
                return;
        }
    }
    public boolean isState(String x){
        x = x.toLowerCase();
        return

        (x.equals("chop") && isChopped())
        || ((x.equals("fry") && isFried())) 
        || ((x.equals("cook") && isCooked()))
        || ((x.equals("dirty") && isDirty()))  ;
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
                    (state.equals("chop") && !isChopped())
                || ((state.equals("fry") && !isFried())) 
                || ((state.equals("cook") && !isCooked()))
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
    //returns the default image instead of a modified one if given a boolean
    public String GetImage(boolean x) {
        if (Images == null) return"";
        String NormalImage = "";
        for (Map.Entry<String[],String> entry : Images.entrySet()) {
            String[] states = entry.getKey();
            String image = entry.getValue();
            boolean IsEmpty = states.length == 0;
            if (IsEmpty)return image;

        }
        return NormalImage; 
    }
    public double getMaxProcessTime(String x) {
        if (x == null) return 0;
        Double val = maxProcessTime.get(x.toLowerCase());
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
