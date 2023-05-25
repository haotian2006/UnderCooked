package Recipes;

import Classes.Recipe;
import Classes.*;
public class CC extends Recipe {
    static Item[] ingredients = new Item[] {
        Item.newItem("Carrot",false,false,true),
        Item.newItem("Carrot",false,false,false),
        Item.newItem("Carrot",false,false,false),
    };
    static String Image = "assets/Images/Items/Carrot/Sliced.png";
    static String name = "Chopped Carrots";
    public CC(){
     super(name,Image,ingredients);   
    }
}
