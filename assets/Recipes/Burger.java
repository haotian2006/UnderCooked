package Recipes;

import Classes.Recipe;
import Classes.*;
public class Burger extends Recipe {
    static Item[] ingredients = new Item[] {
        Item.newItem("Bread"),
        Item.newItem("Meat",false,true,false)
    };
    static String Image = "assets/Images/Items/Carrot/Carrot.png";
    static String name = "Burger";
    static int Coins = 30;
    public Burger(){
     super(name,Image,ingredients,Coins);   
    }
}
