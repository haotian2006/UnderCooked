import Classes.*;
import Items.Carrot;
import Recipes.*;
public class TestcaseR {
    public static void main(String[] args) {
        Dish x = new Dish("yes");
        x.AddItem(Item.newItem("Carrot",true,false,false));
        //x.AddItem(Item.newItem("Carrot",true,false,false));
        System.out.println("test");
        System.out.println((new Recipes.Carrot()).DishAlmostMatchesRecipe(x));
    }
}
