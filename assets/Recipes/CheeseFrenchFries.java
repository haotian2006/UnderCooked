package Recipes;

import Classes.Recipe;
import Classes.*;
public class CheeseFrenchFries extends Recipe {
    static Item[] ingredients = new Item[] {
        Item.newItem("Potato",false,true,true),
        Item.newItem("Cheese",false,false,true)
    };
    static String Image = "assets/Images/Recipes/CheeseFry.png";
    static String name = "Cheese French Fries";
    static int Coins = 15;
    public CheeseFrenchFries(){
     super(name,Image,ingredients, Coins);   
    }
}

