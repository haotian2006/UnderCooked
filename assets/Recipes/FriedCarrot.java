package Recipes;

import Classes.Recipe;
import Classes.*;
public class FriedCarrot extends Recipe {
    static Item[] ingredients = new Item[] {
        Item.newItem("Carrot",false,true,true),
    };
    static String Image = "assets/Images/Items/Carrot/Carrot.png";
    static String name = "Fried Carrot";
    static int Coins = 20;
    public FriedCarrot(){
     super(name,Image,ingredients, Coins);   
    }
}

