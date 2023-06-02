package Levels;
import java.awt.Color;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

import Classes.*;

public class FastFood extends Level {
    private static String PreviewImage = "assets/Images/Levels/BP.png";
    private static Integer TimeLimit = 120;
    private static String name = "Fast Food Place";
    private static Grid GridLayout = new Grid(8,5){
        {
            put("Trashcan", 1, 5); 
            
            put("Potato", 3, 3);
            put("Cheese", 4, 3);
            put("Bread", 5, 3);
            put("Meat", 6, 3);

            put("counter", 2, 1);
            put("CuttingBoard", 3, 1);
            put("counter", 4, 1);
            put("CuttingBoard", 5, 1);
            put("counter", 6, 1);

            put("counter", 2, 5);
            put("Stove", 3, 5,Cookware.newCookware("Pan"));
            put("counter", 4, 5);
            put("Stove", 5, 5,Cookware.newCookware("Pan"));
            put("counter", 6, 5);

            put("counter", 1, 4,Item.newItem("Plate"));
            put("counter", 1, 3,Item.newItem("Plate"));
            put("counter",1, 2,Item.newItem("Plate"));
            put("counter", 1, 1,Item.newItem("Plate"));

            put("Sink", 7, 5);
            put("CleanDishCounter",8,5);

            put("Receive",7, 1);
            put("Server",8,1);
        }
    };
    private static String[] Orders = {
          "Burger",
          "FrenchFries",
          "CheeseBurger"
    };
    private static int[][] StarRequirements = {
        {120,200,240}, 
        {140,180,220},
        {100,140,180}
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
    public FastFood(){
        super(name,PreviewImage, GridLayout, Orders, TimeLimit, StarRequirements,Colors);
    }
}
