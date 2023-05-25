package Recipes;

import Classes.Recipe;
import Classes.*;
public class PotatoSoup extends Recipe {
    static Item[] ingredients = new Item[] {
        Item.newItem("Potato",true,false,false),
        Item.newItem("Potato",true,false,false),
        Item.newItem("Potato",true,false,false)
    };
    static String Image = "assets/Images/Items/Carrot/Carrot.png";
    static String name = "Potato Soup";
    static int Coins = 20;
    public PotatoSoup(){
     super(name,Image,ingredients,Coins);   
    }
}
