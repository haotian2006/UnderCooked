package Recipes;

import Classes.Recipe;
import Classes.*;
public class C extends Recipe {
    static Item[] ingredients = new Item[] {
        Item.newItem("Carrot"),
        Item.newItem("Carrot"),
    };
    static String Image = "assets/Images/Items/Carrot/Carrot.png";
    static String name = "C";
    public C(){
     super(name,Image,ingredients);   
    }
}
