package Recipes;

import Classes.Recipe;
import Classes.*;
public class LargeBurger extends Recipe {
    static Item[] ingredients = new Item[] {
        Item.newItem("Bread"),
        Item.newItem("Lettuce",false,false,true),
        Item.newItem("Cheese"),
        Item.newItem("Tomato",false,false,true),
        Item.newItem("Meat",false,true,false)
    };
    static String Image = "assets/Images/Items/Carrot/Carrot.png";
    static String name = "Large Burger";
    static int Coins = 60;
    public LargeBurger(){
     super(name,Image,ingredients,Coins);   
    }
}
