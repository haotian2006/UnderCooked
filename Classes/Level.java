package Classes;

import java.awt.List;
import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;

public class Level implements Serializable{
    private Grid GridLayout;
    private Recipe[] Orders;
    private String BackgroundImage;
    private int[][] StartRequirements;
    private ArrayList<HashMap<String,Integer>> MaxIngredients;

    public static Level newLayout(String x){
        try {
            Class<?> myClass = Class.forName(("Levels."+x));
            return (Level) myClass.getDeclaredConstructor().newInstance();      
        } catch (ClassNotFoundException e) {
            e.printStackTrace(); 
            System.exit(1);
        }catch (NoSuchMethodException | InstantiationException | InvocationTargetException | IllegalAccessException e) {
            e.printStackTrace();
            System.exit(1);
        }
        return null;
    }
    public Grid getGrid(){
        return GridLayout;
    }
    public Recipe[] GetOrders(){
        return Orders;
    }
    public String GetImage(){
        return BackgroundImage;
    }
    public int[] GetRequirements(int difficulty){
        int len = StartRequirements.length;
        if (len >=difficulty){ return new int[3];}
        return StartRequirements[difficulty];
    }
    public int GetRequirements(int difficulty,int score){
        int[] list = GetRequirements(difficulty);
        int stars = 0;
        for (int i =0;i<list.length;i++){
            if (list[i] <= score){
                stars = i;
            }
        }
        return stars;
        
    }
    public HashMap<String,Integer> GetMaxIngredients(int difficulty){
        int len = MaxIngredients.size();
        if (len >=difficulty){ return new HashMap<String,Integer>();}
        return MaxIngredients.get(difficulty);
    }
    public int GetMaxIngredients(int difficulty,String ingredient){
        HashMap<String,Integer> data = GetMaxIngredients(difficulty);
        if (data.containsKey(ingredient)){
            return data.get(ingredient);
        }else{ return 0;}
    }
}
 