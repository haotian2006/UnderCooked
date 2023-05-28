package Recipes;

import Classes.Recipe;
import Classes.*;
public class Steak extends Recipe {
    static Item[] ingredients = new Item[] {
        Item.newItem("Meat",false,true,false)
    };
    static String Image = "assets/Images/Items/Meat/cooked.png";
    static String name = "Steak";
    static int Coins = 15;
    public Steak(){
     super(name,Image,ingredients,Coins);   
    }
}
