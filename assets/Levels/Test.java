package Levels;
import java.awt.Color;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

import Classes.*;

public class Test extends Level {
    private static String PreviewImage = "assets/Images/Levels/Test.png";
    private static Integer TimeLimit = 240;
    private static String name = "Test";
    private static Grid GridLayout = new Grid(13,10){
        {
            put("Trashcan", 1, 1); // creates a counter at 1,1
            put("Stove", 2, 1,Cookware.newCookware("Pot"));
            put("Stove", 3, 1,Cookware.newCookware("Pan"));

            put("Carrot", 1, 2);
            put("CuttingBoard", 1,3);
            Item dirtyPlate = Item.newItem("Plate");
            //dirtyPlate.setDirty(true);
            put("counter", 4, 1,Item.newItem("Plate"));
            put("counter", 5, 1,dirtyPlate);
            put("counter", 6, 1,DeepCopy.copy(dirtyPlate));

            put("Cheese", 1, 4);
            put("Meat", 1, 5);
            put("Potato", 1, 6);
            put("Lettuce", 1, 7);
            put("Tomato", 1, 8);
            put("Bread", 2, 4);
            put("counter", 2, 3);
            put("counter", 3, 3);

            put("Sink", 7, 1);

            put("CleanDishCounter",8,1);

            put("Receive", 12, 1);
            put("Server",13,1);
        }
    };
    private static String[] Orders = {
        //   "Burger"
        //   ,"BigBurger"
        //   ,"LBurger"
        //   ,"CheeseBurger" 
        //   ,"TBurger"
        "Salad",
        "MashP",
        "SteakM"
    };
    
    private static int[][] StarRequirements = {
        {10,20,30}, 
        {10,20,30},
        {10,20,30}
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
    public Test(){
        super(name,PreviewImage, GridLayout, Orders, TimeLimit, StarRequirements,Colors);
    }
}
