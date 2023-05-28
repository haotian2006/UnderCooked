package Levels;
import java.awt.Color;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

import Classes.*;

public class Test2 extends Level {
    private static String PreviewImage = "assets/Images/Levels/Test2.png";
    private static Integer TimeLimit = 60;
    private static String name = "Test2";
    private static Grid GridLayout = new Grid(13,10){
        {
            put("Trashcan", 1, 1); // creates a counter at 1,1
            put("Sink", 7, 1);

            put("CleanDishCounter",8,1);

            put("Receive", 12, 1);
            put("Server",13,1);
        }
    };
    private static String[] Orders = {
          "CarrotSoup"
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
    public Test2(){
        super(name,PreviewImage, GridLayout, Orders, TimeLimit, StarRequirements,Colors);
    }
}
