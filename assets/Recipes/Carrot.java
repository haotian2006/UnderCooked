package Recipes;

import Classes.Recipe;
import Classes.*;
public class Carrot extends Recipe {
    static Item[] ingredients = new Item[] {
        Item.newItem("Carrot"),
    };
    static String Image = "assets/Images/Items/Carrot/Carrot.png";
    static String name = "Carrot";
    public Carrot(){
     super(name,Image,ingredients);   
    }
}
