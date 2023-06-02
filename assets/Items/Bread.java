package Items;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

import Classes.*;
public class Bread extends Item{
    static String name = "Carrot";
    static HashMap<String[], String> Images = new HashMap<String[], String>(){{
        put(new String[]{}, "assets/Images/Items/Bread/Bread.png");
        put(new String[]{"chop"}, "assets/Images/Items/Bread/SlicedBread.png");
    }};
    static HashMap<String, Double> maxProcessTime = new HashMap<String, Double>(){{
        put("chop", 1.);
    }};
    public boolean canBeChopped(){ 
        return !isChopped();
    }
    public Bread(){
        super(name, Images, maxProcessTime);
    }
}