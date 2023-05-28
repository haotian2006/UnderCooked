package Recipes;

import Classes.Recipe;
import Classes.*;
public class CheeseBurger extends Recipe {
    static Item[] ingredients = new Item[] {
        Item.newItem("Bread",false,false,true),
        Item.newItem("Cheese",false,false,true),
        Item.newItem("Meat",false,true,false)
    };
    static String Image = "assets/Images/Recipes/Burgers/CheeseBurger.png";
    static String name = "Cheese Burger";
    static int Coins = 20;
    public CheeseBurger(){
     super(name,Image,ingredients,Coins);   
    }
}
