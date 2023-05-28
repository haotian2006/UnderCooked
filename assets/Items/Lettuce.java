package Items;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

import Classes.*;
public class Lettuce extends Item{
    static String name = "Lettuce";
    static HashMap<String[], String> Images = new HashMap<String[], String>(){{
        put(new String[]{}, "assets/Images/Items/Lettuce/Lettuce.png");
        put(new String[]{"Chop"}, "assets/Images/Items/Lettuce/Sliced.png");
        put(new String[]{"cook"}, "assets/Images/Items/Lettuce/soup.png");
    }};
    static HashMap<String, Double> maxProcessTime = new HashMap<String, Double>(){{
        put("Chop", 2.);
        put("cook", 4.);
    }};
    public boolean canBeChopped(){ 
        return !isChopped();
    }
    public boolean canBeCooked(){ 
        return !isChopped() && ! isCooked();
    }
    public Lettuce(){
        super(name, Images, maxProcessTime);
    }
}