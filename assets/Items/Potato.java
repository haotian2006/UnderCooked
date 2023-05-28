package Items;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

import Classes.*;
public class Potato extends Item{
    static String name = "Carrot";
    static HashMap<String[], String> Images = new HashMap<String[], String>(){{
        put(new String[]{}, "assets/Images/Items/Potato/Potato.png");
        put(new String[]{"Chop"}, "assets/Images/Items/Potato/Sliced.png");
        put(new String[]{"Chop","fry"}, "assets/Images/Items/Potato/Fries.png");
        put(new String[]{"Cook"}, "assets/Images/Items/Potato/Mashed.png");
    }};
    static HashMap<String, Double> maxProcessTime = new HashMap<String, Double>(){{
        put("Chop", 1.);
        put("fry", 3.);
        put("cook", 3.);
    }};
    public boolean canBeChopped(){ 
        return !isChopped();
    }
    public boolean canBeFried(){ 
        if (isChopped()){
            return true;
        }
        return false;
    }
    public boolean canBeCooked(){ 
        if (isChopped()){
            return false;
        }
        return true;
    }
    public boolean canHold(){
        if (isCooked()){
            return false;
        }
        return true;
    }
    public Potato(){
        super(name, Images, maxProcessTime);
    }
}