package Levels;
import java.awt.Color;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

import Classes.*;

public class SteakHouse extends Level {
    private static String PreviewImage = "assets/Images/Levels/SH.png";
    private static Integer TimeLimit = 150;
    private static String name = "SteakHouse";
    private static Grid GridLayout = new Grid(10,7){
        {
            put("Trashcan", 1, 7); 
            put("counter", 1, 1); 
            
            put("Potato", 9, 4);
            put("Meat", 10, 4);
            

            put("counter", 3, 4);
            put("counter", 4, 4);
            put("counter", 5, 4);
            put("counter", 6, 4);
            put("counter", 7, 4);
            put("counter", 8, 4);


            put("counter", 2, 1);
            put("CuttingBoard", 3, 1);
            put("counter", 4, 1);
            put("CuttingBoard", 5, 1);
            put("counter", 6, 1);
            put("CuttingBoard", 7, 1);
            put("counter", 8, 1);

            put("counter", 2, 7);
            put("Stove", 3, 7,Cookware.newCookware("Pan"));
            put("counter", 4, 7);
            put("Stove", 5, 7,Cookware.newCookware("Pan"));
            put("counter", 6, 7);
            put("Stove", 7, 7,Cookware.newCookware("Pot"));
            put("counter", 8, 7);

            put("counter", 1, 6,Item.newItem("Plate"));
            put("counter", 1, 5,Item.newItem("Plate"));
            put("counter", 1, 4,Item.newItem("Plate"));
            put("counter", 1, 3,Item.newItem("Plate"));
            put("counter",1, 2,Item.newItem("Plate"));


            put("Sink", 10, 7);
            put("CleanDishCounter",9,7);

            put("Receive",9, 1);
            put("Server",10,1);
        }
    };
    private static String[] Orders = {
          "Steak",
          "Steak",
          "SteakM",
          "MashP",

    };
    private static int[][] StarRequirements = {
        {120,200,240}, 
        {140,240,300},
        {160,240,330}
    };

    private static Color[] Colors = {
        new Color(109, 226, 125),
        new Color(182, 91, 0),
       // Color.white,
        //Color.black,
        new Color(186,184,184),
        new Color(186,184,184)
    };//0 - background
    //1 - wall 
    //2 - white tile
    //3 black tile
    public SteakHouse(){
        super(name,PreviewImage, GridLayout, Orders, TimeLimit, StarRequirements,Colors);
    }
}
