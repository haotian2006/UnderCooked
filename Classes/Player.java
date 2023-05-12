package Classes;

import java.io.Serializable;
import java.util.*;

public class Player implements Serializable{
    private int score;
    private ArrayList<Recipe> orders;
    private String name;
    private double timer;
    private int level;
    private int difficulty;
    private Holdable holding;

    public Player(String n){
        name = n;
    }
    public String getName(){
        return name;
    }
    
    public void setName(String newName){
        name = newName;
    }
    public int getScore(){
        return score;
    }
    public void addOrder(Recipe newRecipe){
        orders.add(newRecipe);
    }
    public ArrayList<Recipe> getOrders(){
        return orders;
    }
    public void removeOrder(Recipe removed){
        boolean isin = false;

        if(orders.contains(removed)== true){
            orders.remove(removed);
        }
        else{
            System.out.println("That item does not exist");
        }
    }
    public void setDifficulty(int diff){
        difficulty = diff;
    }
    public int getDifficulty(){
        return difficulty;
    }
    public static void main(String[] args) {
        Player g = new Player("bob");
        
    }
}
