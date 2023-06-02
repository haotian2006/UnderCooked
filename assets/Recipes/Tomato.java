package Recipes;

import Classes.Recipe;
import Classes.*;
public class Tomato extends Recipe {
    static Item[] ingredients = new Item[] {
        Item.newItem("Tomato"),
    };
    static String Image = "assets/Images/Items/Tomato/Tomato.png";
    static String name = "Tomato";
    public Tomato(){
     super(name,Image,ingredients);   
    }
}
