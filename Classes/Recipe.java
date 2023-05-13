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
        //clones both arrays
        Item[] y = (Item[]) x.getItems().toArray();
        Item[] z = (Item[]) ingredients.clone();
        if (y.length != z.length)return false; // if the lengths do not match
        boolean found = true;
        for (int yy =0;yy<y.length;yy++){
            found = false;
            for (int zz =0;zz<z.length;zz++){
                if (y[yy] == z[zz] && y[yy] != null){ // if it equals but not equal to null then
                    z[zz] = null; // set them to null so it won't be found again
                    found = true; break;
                }
            }
        }
        return found;
    }

}
