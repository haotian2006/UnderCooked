package Recipes;

import Classes.Recipe;
import Classes.*;
public class FrenchFries extends Recipe {
    static Item[] ingredients = new Item[] {
        Item.newItem("Potato",false,true,true),
    };
    static String Image = "assets/Images/Items/Carrot/Carrot.png";
    static String name = "French Fries";
    static int Coins = 20;
    public FrenchFries(){
     super(name,Image,ingredients, Coins);   
    }
}

