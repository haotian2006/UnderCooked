package Recipes;

import Classes.Recipe;
import Classes.*;
public class PotatoSalad extends Recipe {
    static Item[] ingredients = new Item[] {
        Item.newItem("Potato",true,false,true),
        Item.newItem("Tomato",false,false,true),
        Item.newItem("Lettuce",false,false,true)
    };
    static String Image = "assets/Images/Items/Carrot/Carrot.png";
    static String name = "Potato Salad";
    static int Coins = 30;
    public PotatoSalad(){
     super(name,Image,ingredients,Coins);   
    }
}
