package Recipes;

import Classes.Recipe;
import Classes.*;
public class CarrotSoup extends Recipe {
    static Item[] ingredients = new Item[] {
        Item.newItem("Carrot",true,false,false),
        Item.newItem("Carrot",true,false,false),
        Item.newItem("Carrot",true,false,false)
    };
    static String Image = "assets/Images/Recipes/CarrotSoup.png";
    static String name = "Carrot Soup";
    static int Coins = 20;
    public CarrotSoup(){
     super(name,Image,ingredients,Coins);   
    }
}
