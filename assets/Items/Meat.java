package Items;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

import Classes.*;
public class Meat extends Item{
    static String name = "Meat";
    static HashMap<String[], String> Images = new HashMap<String[], String>(){{
        put(new String[]{}, "assets/Images/Items/Meat/Meat.png");
        put(new String[]{"fry"}, "assets/Images/Items/Meat/cooked.png");
    }};
    static HashMap<String, Double> maxProcessTime = new HashMap<String, Double>(){{
        put("fry", 5.);
    }};
    public boolean canBeFried(){ 
        return !isFried();
    }

    public boolean canHold(){
        if (isCooked()){
            return false;
        }
        return true;
    }
    public Meat(){
        super(name, Images, maxProcessTime);
    }
}