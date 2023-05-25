package Recipes;

import Classes.Recipe;
import Classes.*;
public class LettuceSoup extends Recipe {
    static Item[] ingredients = new Item[] {
        Item.newItem("Lettuce",true,false,false),
        Item.newItem("Lettuce",true,false,false),
        Item.newItem("Lettuce",true,false,false)
    };
    static String Image = "assets/Images/Items/Carrot/Carrot.png";
    static String name = "Lettuce Soup";
    static int Coins = 20;
    public LettuceSoup(){
     super(name,Image,ingredients,Coins);   
    }
}
