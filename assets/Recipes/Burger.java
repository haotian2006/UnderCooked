package Recipes;

import Classes.Recipe;
import Classes.*;
public class Burger extends Recipe {
    static Item[] ingredients = new Item[] {
        Item.newItem("Bread",false,false,true),
        Item.newItem("Meat",false,true,false)
    };
    static String Image = "assets/Images/Recipes/Burgers/Burger.png";
    static String name = "Burger";
    static int Coins = 15;
    public Burger(){
     super(name,Image,ingredients,Coins);   
    }
}
