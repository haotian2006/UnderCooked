package Classes;
import java.io.File;
import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.io.File;
public class Recipe implements Serializable{
    private double time;
    private Item[] ingredients;
    private String name;
    private String image;
    private int Score = 20;

    public boolean IsDestroyed;
    public boolean IsDone;

    public static ArrayList<Recipe> Recipes = new ArrayList<Recipe>();
    public static Random Random = new Random();

    public Recipe(String Name,String Image,Item[] Ingredients){
        name = Name;image = Image;ingredients = Ingredients;
    }
    public Recipe(String Name,String Image,Item[] Ingredients,int score){
        name = Name;image = Image;ingredients = Ingredients;Score = score;
    }
    public int GetScore(){ return Score;}
    public String GetName(){return name;}
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
    public String GetImage(){
        return image;
    }
    public static Recipe GetRecipeFromDish(Dish d){
        //if this is the first time then loop thru the recipes file, create the recipe object and insert them into the recipes arraylist
        if (Recipes.size() == 0){
            for (File file : new File("assets/Recipes").listFiles()) {
                Recipe rp = newRecipe(file.getName().replace(".java", ""));
                Recipes.add(rp);
            }
        }
        //this will loop thru the arraylist checking if the recipe matches 
        for (int n = 0;n<Recipes.size();n++){
            Recipe rp = Recipes.get(n);
            if (rp.DishMatchesRecipe(d)){     
                return rp;
            }
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
    public static String GetRandomRecipeFromTable(String[] Orders){
        return Orders[Random.nextInt(Orders.length)];// simple formula 
    }
    public boolean DishMatchesRecipe(Dish x){
        //clones/converts them into arrays
        Item[] y = x.getItems().toArray(new Item[x.getItems().size()]);
        Item[] z = (Item[]) ingredients.clone();
        if (y.length != z.length)return false; // if the lengths do not match
        boolean found = true;
        for (int yy =0;yy<y.length;yy++){
            found = false;
            for (int zz =0;zz<z.length;zz++){
                if (y[yy] != null && y[yy].equals(z[zz])){ // if it equals but not equal to null then
                    z[zz] = null; // set them to null so it won't be found again
                    found = true; break;
                }
            }
            if (!found) return false;
        }
        return found;
    }

}
