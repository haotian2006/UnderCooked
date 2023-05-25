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
        put(new String[]{"fry"}, "assets/Images/Items/Carrot/Sliced.png");
    }};
    static HashMap<String, Double> maxProcessTime = new HashMap<String, Double>(){{
        put("Chop", 3.);
        put("fry", 4.);
    }};
    public boolean CanBeFried(){ 
        return !isFried();
    }

    public boolean CanHold(){
        if (isCooked()){
            return false;
        }
        return true;
    }
    public Meat(){
        super(name, Images, maxProcessTime);
    }
}