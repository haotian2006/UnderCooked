package Classes;

import java.io.Serializable;
import java.util.*;

import Levels.*;
import PremadeElements.OrdersBar;

import java.awt.Point;
public class Player implements Serializable{
    public int Command;

    private int score;
    private ArrayList<Recipe> orders;
    private String name;
    private double timer;
    private int level;
    private int difficulty;
    private Holdable holding;
    private Counter InteractingCounter;
    private int InGame;
    private Point CurrentMouse = new Point(0, 0);
    private int[] Data;
    private HashMap<String,Integer[]> LevelData ;

    public static int[] StarRequirement = {
        0,3,6,9,16
    };
    public static Level[] LevelOrder = {
        new Training(),
        new FastFood(),
        new SteakHouse(),
        new BurgerPlace(),
        new FancyRestaurant(),
    };

    public void Clear(){
        Data = new int[5];
        holding = null;
        InteractingCounter = null;
        orders.clear();
        score = 0;
        CurrentMouse = new Point(0, 0);

    }
    public int[] GetData(){
        return Data;
    }
    public static Level GetLevelFromStage(int stage){
        if (stage < LevelOrder.length && stage >-1){
            return LevelOrder[stage];
        }
        return null;
    }
    public static int GetReqFromStage(int stage){
        if (stage < StarRequirement.length && stage >-1){
            return StarRequirement[stage];
        }
        return -100;
    }
    public int GetStars(String name){
        if (LevelData.containsKey(name) ){
            Integer value = LevelData.get(name)[difficulty];
            return value == null?0:value;
        }
        return 0;
    }
    public void SetLevelData(int stars){
        String level = Memory.Kitchen.GetLevel().GetName();
        if (LevelData.containsKey(level) ){
            Integer[] d =LevelData.get(level);
            Integer value = d[difficulty];
            value = value == null?0:value;
            if (value < stars) d[difficulty] = stars; // if the new stars is higher then old one
        }else{
            // if the entry does not exist 
            Integer[] d = new Integer[3];
            d[difficulty] =stars;
            LevelData.put(level, d);
        }
    }
    public int getTotalStars(){
        int total = 0;
        for (String key : LevelData.keySet()) {//loops the hashmap
            Integer[] value = LevelData.get(key); // loops the difficulties 
            for (Integer x : value){
                if (x  == null){
                    continue;
                }
                total += x;
            }
        }
        return total;
    }

    static Random Random = new Random();
    
    public void SetMouse(Point x){
        CurrentMouse = x;
    }
    public Point GetMouse(){ return CurrentMouse;}

    public void SetInGame(int x){
        //0 = not in game
        //1 = in game
        //2 = burned
        //3 = went to hub
        InGame = x;
    }
    public int GetInGame(){ return InGame;}

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
    public void setScore(int x){
        score = x;
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
    public String getDifficultyAsString(){
        switch (getDifficulty()){
            case 0:
                return "Easy";
            case 1:
                return "Normal";
            case 2:
                return "Hard";
        }
        return "Unknown";
    }
    public boolean first;
    public void Update(){
        //Orders section
        OrdersBar oB= Memory.Kitchen.getOrdersBar();
        if (orders.size()<Kitchen.MaxOrders && Random.nextInt(Kitchen.GetRate()) ==1 || !first){
            first = true;
            Recipe newR = Recipe.newRecipe(Recipe.GetRandomRecipeFromTable(Memory.Kitchen.GetLevel().GetOrders()));
            newR.SetTime(Kitchen.GetMaxTime());
            orders.add(newR);   
            oB.AddFrame(newR);
        }
        int x = 0;
        int size = orders.size();
        for (x = 0; x <size;x++){
            Recipe rp = orders.get(x);
            rp.SetTime(rp.GetTime()-.01);
            if (rp.IsDone && !rp.IsDestroyed){
                rp.IsDestroyed = true;
                rp.SetTime(0);
                oB.SetMark(x, true);
            }else if (rp.GetTime() <=0 && !rp.IsDestroyed){
                rp.IsDestroyed = true;
                setScore(getScore()-Kitchen.GetLoseAmt());
                GetData()[3]-=Kitchen.GetLoseAmt();
                GetData()[4] ++;
                oB.SetMark(x, false);
            }else if(rp.IsDestroyed && rp.GetTime() <=-.5){
                oB.RemoveFrame(x);
                orders.remove(x);
                if (x == size -1){
                    oB.repaint();
                }
                x--;
                size--;   
                
            }
        }
        oB.Update();
    }
    public Player(String n){
        name = n;
        Data = new int[5];
        orders = new ArrayList<Recipe>();
        LevelData = new HashMap<String,Integer[]>();
        if (n.equals("TEST_MODE")){
            LevelData.put("Test", new Integer[]{100,0,0});
        }

    }
}
