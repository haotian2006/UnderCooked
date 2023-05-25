package Recipes;

import Classes.Recipe;
import Classes.*;
public class FriedTomato extends Recipe {
    static Item[] ingredients = new Item[] {
        Item.newItem("Tomato",false,true,true),
    };
    static String Image = "assets/Images/Items/Carrot/Carrot.png";
    static String name = "Fried Tomato";
    static int Coins = 20;
    public FriedTomato(){
     super(name,Image,ingredients, Coins);   
    }
}

