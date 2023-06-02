package Levels;
import java.awt.Color;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

import Classes.*;

public class FancyRestaurant extends Level {
    private static String PreviewImage = "assets/Images/Levels/FR.png";
    private static Integer TimeLimit = 220;
    private static String name = "Fancy Restaurant";
    private static Grid GridLayout = new Grid(10,8){
        {
            put("Trashcan", 1, 8); 
            
            put("counter", 1, 1);
            put("Stove", 1, 2,Cookware.newCookware("Pan"));
            put("counter", 1, 3);
            put("Stove", 1, 4,Cookware.newCookware("Pan"));
            put("counter", 1, 5);
            put("Stove", 1, 6,Cookware.newCookware("Pan"));
            put("counter", 8, 8);
            put("counter", 2, 8);

            for (int x = 3;x<=8;x++){     put("counter", x ,4);}
            for (int x = 3;x<=8;x++){     put("counter", x ,5);}


            put("counter", 8, 6);
            put("counter", 8, 3);
            put("Tomato", 1, 3);
            put("Lettuce", 1,4);
            put("Cheese", 1, 5);
            put("Bread", 1, 6);
            put("Carrot", 1, 2);
            put("Meat", 1, 7);

            put("counter", 8, 1);
            put("counter", 3, 6);
            put("counter", 3, 3);
            put("counter", 6, 1);
            put("counter", 10, 1);
            put("CuttingBoard", 7 ,1);
            put("CuttingBoard", 5 ,1);
            put("CuttingBoard", 9 ,1);
            put("CuttingBoard", 3 ,1);

            put("counter", 2, 1);
            put("CuttingBoard", 3, 1);
            put("counter", 4, 1);
            put("CuttingBoard", 5, 1);
            put("counter", 6, 1);

            put("counter", 10 ,6);
            put("counter", 10 ,5);
            put("counter", 10 ,4);
            put("counter", 10 ,3);
            put("counter", 10 ,2);
            put("counter", 10 ,1);
            put("counter", 10 ,7);


            for (int x = 3;x<=10;x++){     put("counter", x ,8);}



            put("CuttingBoard", 7 ,8);
            put("CuttingBoard", 5 ,8);
            put("CuttingBoard", 9 ,8);
            put("CuttingBoard", 3 ,8);
            put("Sink", 8, 4);
            put("CleanDishCounter",8,5);

            put("counter", 5 ,6);
            put("counter", 6 ,6);
            put("Receive",8, 1);
            put("Server",9,1);
            put("counter", 10, 1);
            for (int x = 1;x<=8;x++){     put("counter", 10 ,x,Item.newItem("Plate"));}
            put("Stove", 4, 3,Cookware.newCookware("Pan"));
            put("Stove", 7, 3,Cookware.newCookware("Pan"));
            put("Stove", 6, 3,Cookware.newCookware("Pan"));
            put("Stove", 5, 3,Cookware.newCookware("Pan"));
            put("Stove", 4, 6,Cookware.newCookware("Pot"));
            put("Stove", 6, 6,Cookware.newCookware("Pot"));
            put("Stove", 5, 6,Cookware.newCookware("Pot"));
            put("Stove", 7, 6,Cookware.newCookware("Pot"));
        }

    };
    private static String[] Orders = {
          "MashP",
          "Salad",
          "TomatoSoup",
          "CheeseFrenchFries",
          "FSteak",
          "BigBurger"

    };
    private static int[][] StarRequirements = {
        {120,200,240}, 
        {100,160,200},
        {80,140,180}
    };

    private static Color[] Colors = {
        new Color(109, 226, 125),
        new Color(0,0,0),
       // Color.white,
        //Color.black,
        new Color(232,232,232),
        new Color(232,232,232)
    };//0 - background
    //1 - wall 
    //2 - white tile
    //3 black tile
    public FancyRestaurant(){
        super(name,PreviewImage, GridLayout, Orders, TimeLimit, StarRequirements,Colors);
    }
}
