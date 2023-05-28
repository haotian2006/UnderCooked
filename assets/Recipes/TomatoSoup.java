package Recipes;

import Classes.Recipe;
import Classes.*;
public class TomatoSoup extends Recipe {
    static Item[] ingredients = new Item[] {
        Item.newItem("Tomato",true,false,false),
        Item.newItem("Tomato",true,false,false),
        Item.newItem("Tomato",true,false,false)
    };
    static String Image = "assets/Images/Recipes/TomatoSoup.png";
    static String name = "Tomato Soup";
    static int Coins = 20;
    public TomatoSoup(){
     super(name,Image,ingredients,Coins);   
    }
}
