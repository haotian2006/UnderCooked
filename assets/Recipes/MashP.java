package Recipes;

import Classes.Recipe;
import Classes.*;
public class MashP extends Recipe {
    static Item[] ingredients = new Item[] {
        Item.newItem("Potato",true,false,false),
        Item.newItem("Potato",true,false,false),
        Item.newItem("Potato",true,false,false)
    };
    static String Image = "assets/Images/Recipes/MashedPotato.png";
    static String name = "Mashed Potatoes";
    static int Coins = 10;
    public MashP(){
     super(name,Image,ingredients,Coins);   
    }
}
