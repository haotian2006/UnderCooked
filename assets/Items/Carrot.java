package Items;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

import Classes.*;
public class Carrot extends Item{
    static String name = "Carrot";
    static HashMap<String[], String> Images = new HashMap<String[], String>(){{
        put(new String[]{}, "assets/Images/Items/Carrot/Carrot.png");
        put(new String[]{"Chopped"}, "assets/Images/Items/Carrot/Sliced.png");
    }};
    static HashMap<String, Double> maxProcessTime = new HashMap<String, Double>(){{
        put("Chopping", 3.);
        put("Cooking", 5.);
    }};
    public boolean canBeChopped(){ 
        return !isChopped();
    }
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
    public Carrot(){
        super(name, Images, maxProcessTime);
    }
}