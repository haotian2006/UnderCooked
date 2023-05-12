package Classes;
import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
 
public class Recipe implements Serializable{
    private double time;
    private Item[] ingredients;
    private String name;
    private String image;

    public static Recipe newRecipe(String name){
        try {
            Class<?> myClass = Class.forName(("Recipes."+name));//gets the class in assets/Recipes/name
            return (Recipe) myClass.getDeclaredConstructor().newInstance();//creates a new class and convert it to an Recipe   
        } catch (ClassNotFoundException e) {
            e.printStackTrace(); 
            System.exit(1);
        }catch (NoSuchMethodException | InstantiationException | InvocationTargetException | IllegalAccessException e) {
            e.printStackTrace();
            System.exit(1);
        }
        return null;
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
