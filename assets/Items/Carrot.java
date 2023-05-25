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
        put(new String[]{"Chop"}, "assets/Images/Items/Carrot/Sliced.png");
        put(new String[]{"Chop","fry"}, "assets/Images/Items/Carrot/Sliced.png");
        put(new String[]{"Cook"}, "assets/Images/Items/Carrot/Soup.png");
    }};
    static HashMap<String, Double> maxProcessTime = new HashMap<String, Double>(){{
        put("chop", 3.);
        put("cook", 4.);
        put("fry", 4.);
    }};
    public boolean canBeChopped(){ 
        return !isChopped();
    }
    public boolean canBeFried(){ 
        if (isChopped() && !isFried()){
            return true;
        }
        return false;
    }
    public boolean canBeCooked(){ 
        return !isChopped();
    }
    public boolean CanHold(){
        if (isCooked() || isFried()){
            return false;
        }
        return true;
    }
    public Carrot(){
        super(name, Images, maxProcessTime);
    }
}