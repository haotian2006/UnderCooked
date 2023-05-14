package Levels;
import java.awt.Color;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

import Classes.*;

public class Template extends Level {
    private static String PreviewImage = "";
    private static Integer TimeLimit = 10;
    private static Grid GridLayout = new Grid(13,10){
        {
            put("Counter", 1, 1); // creates a counter at 1,1
            put("Counter", 2, 1);
            put("Counter", 3, 1);
            put("Counter", 4, 1);

            put("Counter", 1, 2);
            put("Counter", 1,3);
            //put(Counter.newCounter("Counter",Item.newItem("Tomato") ), 0, 1);
             // creates a counter at 0,1 with a tomato on top
            // put("Counter", 0, 1);
        }
    };
    private static Recipe[] Orders = {
        //  Recipe.newRecipe("recipe1"),
        //  Recipe.newRecipe("recipe2")
    };
    
    private static int[][] StarRequirements = {
        {60,100,120}, 
        {80,120,140},
        {100,140,160}
    };

    private static Color[] Colors = {
        new Color(0, 153, 0),
        new Color(182, 91, 0),
        Color.WHITE,
        Color.black,
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
