package Recipes;

import Classes.Recipe;
import Classes.*;
public class SteakM extends Recipe {
    static Item[] ingredients = new Item[] {
        Item.newItem("Meat",false,true,false),
        Item.newItem("Potato",true,false,false),
        Item.newItem("Potato",true,false,false),
        Item.newItem("Potato",true,false,false),
    };
    static String Image = "assets/Images/Recipes/SteakMash.png";
    static String name = "Steak with Mashed P";
    static int Coins = 20;
    public SteakM(){
     super(name,Image,ingredients,Coins);   
    }
}
