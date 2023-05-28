package Recipes;

import Classes.Recipe;
import Classes.*;
public class FSteak extends Recipe {
    static Item[] ingredients = new Item[] {
        Item.newItem("Meat",false,true,false),
        Item.newItem("Lettuce",false,false,true),
        Item.newItem("Tomato",false,false,true),
        Item.newItem("Carrot",false,false,true),
    };
    static String Image = "assets/Images/Recipes/FancySteak.png";
    static String name = "Fancy Steak";
    static int Coins = 35;
    public FSteak(){
     super(name,Image,ingredients,Coins);   
    }
}
