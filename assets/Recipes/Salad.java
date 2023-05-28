package Recipes;

import Classes.Recipe;
import Classes.*;
public class Salad extends Recipe {
    static Item[] ingredients = new Item[] {
        Item.newItem("Carrot",false,false,true),
        Item.newItem("Tomato",false,false,true),
        Item.newItem("Lettuce",false,false,true)
    };
    static String Image = "assets/Images/Recipes/Salad.png";
    static String name = "Salad";
    static int Coins = 20;
    public Salad(){
     super(name,Image,ingredients,Coins);   
    }
}
