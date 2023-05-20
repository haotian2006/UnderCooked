package Recipes;

import Classes.Recipe;
import Classes.*;
public class CC extends Recipe {
    static Item[] ingredients = new Item[] {
        Item.newItem("Carrot",true,false,false)
    };
    static String Image = "assets/Images/Items/Carrot/Carrot.png";
    static String name = "Carrot Soup";
    public CC(){
     super(name,Image,ingredients);   
    }
}
