package Items;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

import Classes.*;
class Template extends Item{
    static String name = "Template";
    static HashMap<String[], String> Images = new HashMap<String[], String>(){{
        put(new String[]{}, "Template.png");//empty Array so a normal image
        put(new String[]{"Chopped"}, "ChoppedTemplate.png");//Array  with a Chopped string so a Chopped image 
    }};
    static HashMap<String, Double> maxProcessTime = new HashMap<String, Double>(){{
        put("Chopping", 3.);//should take 3 seconds to chop
        put("Frying", 4.);//should take 4 second to fry
    }};
    public boolean CanBeFried(){ // if its chopped then it can be fried 
        if (isChopped()){
            return true;
        }
        return false;
    }
    public boolean CanHold(){//  if its been cooked(soup form) then you can't hold it without a plate
        if (isCooked()){
            return false;
        }
        return true;
    }
    public Template(){
        super(name, Images, maxProcessTime);
    }
}