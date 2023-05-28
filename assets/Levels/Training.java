package Levels;
import java.awt.Color;


import Classes.*;

public class Training extends Level {
    private static String PreviewImage = "assets/Images/Levels/Train.png";
    private static Integer TimeLimit = 90;
    private static String name = "Training";
    private static Grid GridLayout = new Grid(13,7){
        {
            put("Trashcan", 1, 1); // creates a counter at 1,1
            put("Sink", 7, 1);
            put("CleanDishCounter",8,1);

            put("Stove", 2, 1,Cookware.newCookware("Pot"));
            put("Stove", 3, 1,Cookware.newCookware("Pot"));
            put("Stove", 4, 1,Cookware.newCookware("Pot"));

            put("counter", 5, 1,Item.newItem("Plate"));
            put("counter", 6, 1,Item.newItem("Plate"));

            put("counter", 9, 1,Item.newItem("Plate"));
            put("counter", 10, 1,Item.newItem("Plate"));
            put("counter", 11, 1,Item.newItem("Plate"));

            put("counter", 1, 2);
            put("counter", 1, 3);
            put("counter", 1, 4);
            put("counter", 1, 5);
            put("counter", 1, 6);
            put("counter", 1, 7);

            put("Carrot", 11, 7);
            put("Tomato", 12, 7);
            put("Lettuce", 13, 7);


             

            put("Receive", 12, 1);
            put("Server",13,1);
        }
    };
    private static String[] Orders = {
          "CarrotSoup",
          "LettuceSoup",
          "TomatoSoup"
    };
    private static int[][] StarRequirements = {
        {40,60,100}, 
        {60,100,130},
        {100,130,200}
    };

    private static Color[] Colors = {
        new Color(109, 226, 125),
        new Color(182, 91, 0),
        new Color(186,184,184),
        new Color(186,184,184)
    };//0 - background
    //1 - wall 
    //2 - white tile
    //3 black tile
    public Training(){
        super(name,PreviewImage, GridLayout, Orders, TimeLimit, StarRequirements,Colors);
    }
}
