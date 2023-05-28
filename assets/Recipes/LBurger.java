package Recipes;

import Classes.Recipe;
import Classes.*;
public class LBurger extends Recipe {
    static Item[] ingredients = new Item[] {
        Item.newItem("Bread",false,false,true),
        Item.newItem("Cheese",false,false,true),
        Item.newItem("Meat",false,true,false),
        Item.newItem("Lettuce",false,false,true),
    };
    static String Image = "assets/Images/Recipes/Burgers/LettuceBurger.png";
    static String name = "Lettuce Cheese Burger";
    static int Coins = 25;
    public LBurger(){
     super(name,Image,ingredients,Coins);   
    }
}
