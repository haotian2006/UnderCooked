package Items;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

import Classes.*;
public class Cheese extends Item{
    static String name = "Cheese";
    static HashMap<String[], String> Images = new HashMap<String[], String>(){{
        put(new String[]{}, "assets/Images/Items/Cheese/Cheese.png");
        //put(new String[]{"Chop"}, "assets/Images/Items/Carrot/Sliced.png");
    }};
    static HashMap<String, Double> maxProcessTime = new HashMap<String, Double>(){{
       // put("Chop", 3.);
        put("cook", 4.);
    }};
    public boolean CanBeFried(){ 
        if (isChopped()){
            return true;
        }
        return false;
    }
    public boolean canBeCooked(){ 
        return !isChopped();
    }
    public boolean CanHold(){
        if (isCooked()){
            return false;
        }
        return true;
    }
    public Cheese(){
        super(name, Images, maxProcessTime);
    }
}