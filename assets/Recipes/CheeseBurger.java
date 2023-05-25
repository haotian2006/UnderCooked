package Recipes;

import Classes.Recipe;
import Classes.*;
public class CheeseBurger extends Recipe {
    static Item[] ingredients = new Item[] {
        Item.newItem("Bread"),
        Item.newItem("Lettuce",false,false,true),
        Item.newItem("Cheese"),
        Item.newItem("Meat",false,true,false)
    };
    static String Image = "assets/Images/Items/Carrot/Carrot.png";
    static String name = "Cheese Burger";
    static int Coins = 40;
    public CheeseBurger(){
     super(name,Image,ingredients,Coins);   
    }
}
