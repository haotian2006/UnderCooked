package Recipes;

import Classes.Recipe;
import Classes.*;
public class CarrotSoup extends Recipe {
    static Item[] ingredients = new Item[] {
        Item.newItem("Carrot",true,false,false),
        Item.newItem("Carrot",true,false,false),
        Item.newItem("Carrot",true,false,false)
    };
    static String Image = "assets/Images/Items/Carrot/Carrot.png";
    static String name = "Carrot Soup";
    public CarrotSoup(){
     super(name,Image,ingredients,40);   
    }
}
