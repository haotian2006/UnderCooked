package Items;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

import Classes.*;
public class Plate extends Item{
    static String name = "Plate";
    static HashMap<String[], String> Images = new HashMap<String[], String>(){{
        put(new String[]{}, "assets/Images/Other/Plate.png");
        put(new String[]{"Dirty"}, "assets/Images/Items/DirtyPlate.png");
    }};
    static HashMap<String, Double> maxProcessTime = new HashMap<String, Double>(){{
        put("Dirty", 2.3);
    }};
    public Plate(){
        super(name, Images,maxProcessTime);
    }
}