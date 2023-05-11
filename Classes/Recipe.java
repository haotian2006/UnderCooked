package Classes;
public class Recipe {
    private double time;
    private Item[] ingredients;
    private String name;
    private String image;

    public Recipe(double t, Item[] ing, String n, String i){
        time = t;
        ingredients = ing;
        name = n;
        image = i;
    }
    public Item[] GetIngredients(){
        return ingredients;
    }
    public double GetTime(){
        return time;
    }
    public void SetTime(double x){
        time = x;
    }
    public boolean DishMatchesRecipe(Dish x){
        if ()
    }

}
