package Classes;

import java.awt.Color;
import java.awt.List;
import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;

public class Level implements Serializable{
    private Grid GridLayout;
    private Recipe[] Orders;
    private int TimeLimit;
    private int[][] StarRequirements;
    private String PreviewImage;
    private Color[] Colors=  {
        new Color(0, 153, 0),
        new Color(182, 91, 0),
        Color.WHITE,
        Color.black,
    };
    private ArrayList<HashMap<String,Integer>> MaxIngredients;
    public Level(String PreviewImage,Grid grid,Recipe[] orders,int bg,int[][] startReq,Color[] Colors,ArrayList<HashMap<String,Integer>> MaxIng){//super constructor
        this.Colors = Colors;
        this.PreviewImage = PreviewImage;GridLayout = grid;Orders = orders; TimeLimit = bg; StarRequirements = startReq;MaxIngredients = MaxIng;
    }
    public Level(String PreviewImage,Grid grid,Recipe[] orders,int bg,int[][] startReq,Color[] Colors){//super constructor
        this.Colors = Colors;
        this.PreviewImage = PreviewImage;GridLayout = grid;Orders = orders; TimeLimit = bg; StarRequirements = startReq;
    }
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
    public int GetTimeLimit(){
        return TimeLimit;
    }
    public String GetImage(){
        return PreviewImage;
    }
    public Color GetColor(int x){
        if (x >= Colors.length){return null;}
        return Colors[x];
    }
    public int[] GetRequirements(int difficulty){
        int len = StarRequirements.length;
        if (len >=difficulty){ return new int[3];}
        return StarRequirements[difficulty];
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
 