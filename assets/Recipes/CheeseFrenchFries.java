package Recipes;

import Classes.Recipe;
import Classes.*;
public class CheeseFrenchFries extends Recipe {
    static Item[] ingredients = new Item[] {
        Item.newItem("Potato",false,true,true),
        Item.newItem("Cheese")
    };
    static String Image = "assets/Images/Items/Carrot/Carrot.png";
    static String name = "Cheese French Fries";
    static int Coins = 25;
    public CheeseFrenchFries(){
     super(name,Image,ingredients, Coins);   
    }
}

