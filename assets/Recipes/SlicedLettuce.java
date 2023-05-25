package Recipes;

import Classes.Recipe;
import Classes.*;
public class SlicedLettuce extends Recipe {
    static Item[] ingredients = new Item[] {
        Item.newItem("Lettuce",false,false,true),
    };
    static String Image = "assets/Images/Items/Carrot/Carrot.png";
    static String name = "Sliced Lettuce";
    static int Coins = 10;
    public SlicedLettuce(){
     super(name,Image,ingredients, Coins);   
    }
}

