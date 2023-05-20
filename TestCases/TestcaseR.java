import Classes.*;
import Recipes.*;
public class TestcaseR {
    public static void main(String[] args) {
        Dish x = new Dish("yes");
        x.AddItem(Item.newItem("Carrot",false,false,false));
        x.AddItem(Item.newItem("Carrot",true,false,false));
        System.out.println((new CarrotSoup()).DishMatchesRecipe(x));
    }
}
