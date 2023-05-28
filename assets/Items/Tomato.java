package Items;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

import Classes.*;
public class Tomato extends Item{
    static String name = "Tomato";
    static HashMap<String[], String> Images = new HashMap<String[], String>(){{
        put(new String[]{}, "assets/Images/Items/Tomato/Tomato.png");
        put(new String[]{"Chop"}, "assets/Images/Items/Tomato/Sliced.png");
        put(new String[]{"Cook"}, "assets/Images/Items/Tomato/Soup.png");
    }};
    static HashMap<String, Double> maxProcessTime = new HashMap<String, Double>(){{
        put("Chop", 2.);
        put("Cook", 4.);
    }};
    public boolean canBeChopped(){ 
        return !isChopped();
    }
    public boolean canBeCooked(){ 
        return !isCooked()&&!isChopped();
    }
    public boolean canHold(){
        if (isCooked()){
            return false;
        }
        return true;
    }
    public Tomato(){
        super(name, Images, maxProcessTime);
    }
}