package Items;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

import Classes.*;
public class Plate extends Item{
    static String name = "Plate";
    static HashMap<String[], String> Images = new HashMap<String[], String>(){{
        put(new String[]{}, "assets/Images/Menu/LoadingScreen/Plate.png");
    }};
    public Plate(){
        super(name, Images);
    }
}