package Classes;

import java.lang.reflect.InvocationTargetException;

public class Level {
    private Grid GridLayout;
    private Recipe[] Orders;
    private String BackgroundImage;
    private int[][] StartRequirements;

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
            if (score <= list[i]){
                score = i;
            }
        }
        return stars;
        
    }
}
 