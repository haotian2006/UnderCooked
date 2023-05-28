package Levels;
import java.awt.Color;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

import Classes.*;

public class BurgerPlace extends Level {
    private static String PreviewImage = "assets/Images/Levels/BurgerPlace.png";
    private static Integer TimeLimit = 200;
    private static String name = "Burger Place";
    private static Grid GridLayout = new Grid(10,7){
        {
            put("Trashcan", 8, 7); 
            
            put("counter", 1, 1);
            put("Stove", 1, 2,Cookware.newCookware("Pan"));
            put("counter", 1, 3);
            put("Stove", 1, 4,Cookware.newCookware("Pan"));
            put("counter", 1, 5);
            put("Stove", 1, 6,Cookware.newCookware("Pan"));
            put("counter", 1, 7);


            put("Tomato", 2, 7);
            put("Lettuce", 3,7);
            put("Cheese", 4, 7);
            put("Bread", 5, 7);
            put("Meat", 6, 7);

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

            for (int x = 3;x<=8;x++){     put("counter", x ,3);}
            for (int x = 3;x<=8;x++){     put("counter", x ,4,Item.newItem("Plate"));}
            for (int x = 3;x<=8;x++){     put("counter", x ,5);}



            put("CuttingBoard", 7 ,7);
            put("Sink", 9, 7);
            put("CleanDishCounter",10,7);

            put("Receive",7, 1);
            put("Server",8,1);
            put("Server",9,1);
            put("counter", 10, 1);
        }
    };
    private static String[] Orders = {
          "Burger",
          "TBurger",
          "BigBurger",
          "LBurger",
          "CheeseBurger"
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
    public BurgerPlace(){
        super(name,PreviewImage, GridLayout, Orders, TimeLimit, StarRequirements,Colors);
    }
}
