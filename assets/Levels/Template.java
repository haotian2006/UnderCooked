package Levels;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

import Classes.*;

public class Template extends Level {
    private Grid GridLayout = new Grid(800,800){
        {
            put("Counter", 0, 0);
        }
    };
    private Recipe[] Orders = {
         Recipe.newRecipe("recipe1"),
         Recipe.newRecipe("recipe2")
    };
    
    private int[][] StarRequirements = {
        {60,100,120}, 
        {80,120,140},
        {100,140,160}
    };

    private ArrayList<HashMap<String,Integer>> MaxIngredients= new ArrayList<HashMap<String,Integer>>(){
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
    
}
