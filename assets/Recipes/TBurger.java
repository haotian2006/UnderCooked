package Recipes;

import Classes.Recipe;
import Classes.*;
public class TBurger extends Recipe {
    static Item[] ingredients = new Item[] {
        Item.newItem("Bread",false,false,true),
        Item.newItem("Cheese",false,false,true),
        Item.newItem("Tomato",false,false,true),
        Item.newItem("Meat",false,true,false)
    };
    static String Image = "assets/Images/Recipes/Burgers/tomatoBurger.png";
    static String name = "Tomato Cheese Burger";
    static int Coins = 25;
    public TBurger(){
     super(name,Image,ingredients,Coins);   
    }
}
