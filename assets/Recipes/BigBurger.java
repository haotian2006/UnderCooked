package Recipes;

import Classes.Recipe;
import Classes.*;
public class BigBurger extends Recipe {
    static Item[] ingredients = new Item[] {
        Item.newItem("Bread",false,false,true),
        Item.newItem("Lettuce",false,false,true),
        Item.newItem("Cheese",false,false,true),
        Item.newItem("Tomato",false,false,true),
        Item.newItem("Meat",false,true,false)
    };
    static String Image = "assets/Images/Recipes/Burgers/BigBurger.png";
    static String name = "Big Burger";
    static int Coins = 30;
    public BigBurger(){
     super(name,Image,ingredients,Coins);   
    }
}
