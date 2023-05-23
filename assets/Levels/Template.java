package Levels;
import java.awt.Color;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

import Classes.*;

public class Template extends Level {
    private static String PreviewImage = "";
    private static Integer TimeLimit = 10000;
    private static Grid GridLayout = new Grid(13,10){
        {
            put("Trashcan", 1, 1); // creates a counter at 1,1
            put("Stove", 2, 1,Cookware.newCookware("Pot"));
            put("Stove", 3, 1);

            put("Carrot", 1, 2);
            put("CuttingBoard", 1,3);
            Item dirtyPlate = Item.newItem("Plate");
            dirtyPlate.setDirty(true);
            put("counter", 4, 1,Item.newItem("Plate"));
            put("counter", 5, 1,dirtyPlate);
            put("counter", 6, 1,DeepCopy.copy(dirtyPlate));

            put("Sink", 7, 1);

            put("CleanDishCounter",8,1);

            put("Receive", 12, 1);
            put("Server",13,1);
        }
    };
    private static String[] Orders = {
          "CarrotSoup","CC","C"
    };
    
    private static int[][] StarRequirements = {
        {60,100,120}, 
        {80,120,140},
        {100,140,160}
    };

    private static Color[] Colors = {
        new Color(0, 153, 0),
        new Color(182, 91, 0),
       // Color.white,
        //Color.black,
        new Color(186,184,184),
        new Color(186,184,184)
    };//0 - background
    //1 - wall 
    //2 - white tile
    //3 black tile

    private static ArrayList<HashMap<String,Integer>> MaxIngredients= new ArrayList<HashMap<String,Integer>>(){
        {
            add(new HashMap<String,Integer>(){{ //easy
                put("Item1", 100);
            }});
            add(new HashMap<String,Integer>(){{ // normal
                put("Item1", 50);
            }});
            add(new HashMap<String,Integer>(){{ // hard
                put("Item1", 20);
            }});
        }
    };
    public Template(){
        super(PreviewImage, GridLayout, Orders, TimeLimit, StarRequirements,Colors,MaxIngredients);
    }
}
