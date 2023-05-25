package Recipes;

import Classes.Recipe;
import Classes.*;
public class SlicedTomato extends Recipe {
    static Item[] ingredients = new Item[] {
        Item.newItem("Tomato",false,false,true),
    };
    static String Image = "assets/Images/Items/Carrot/Carrot.png";
    static String name = "Sliced Tomato";
    static int Coins = 10;
    public SlicedTomato(){
     super(name,Image,ingredients, Coins);   
    }
}

