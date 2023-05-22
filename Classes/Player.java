package Classes;

import java.io.Serializable;
import java.util.*;
import java.awt.Point;
public class Player implements Serializable{
    private int score;
    private ArrayList<Recipe> orders;
    private String name;
    private double timer;
    private int level;
    private int difficulty;
    private Holdable holding;
    private Counter InteractingCounter;
    private Boolean InGame;
    private Point CurrentMouse = new Point(0, 0);

    public void SetMouse(Point x){
        CurrentMouse = x;
    }
    public Point GetMouse(){ return CurrentMouse;}

    public void SetInGame(boolean x){
        InGame = x;
    }
    public boolean GetInGame(){ return InGame;}

    public void SetTimer(double x){
        timer = x;
    }
    public double GetTimer(){
        return timer;
    }
    public void SetCounter(Counter x){
        InteractingCounter = x;
    }
    public Counter GetCounter(){
        return InteractingCounter;
    }
    public Player(String n){
        name = n;
    }
    public void setHolding(Holdable x){
        holding = x;
    }
    public Holdable getHolding(){
        return holding;
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
    
}
