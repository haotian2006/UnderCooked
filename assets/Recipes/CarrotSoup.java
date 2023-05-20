package Recipes;

import Classes.Recipe;
import Classes.*;
public class CarrotSoup extends Recipe {
    static Item[] ingredients = new Item[] {
        Item.newItem("Carrot")
    };
    static String Image = "assets/Images/Items/Carrot/Carrot.png";
    static String name = "Carrot Soup";
    public CarrotSoup(){
     super(name,Image,ingredients);   
    }
}
