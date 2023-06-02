package Classes;

import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.awt.event.MouseEvent;
import Counters.*;
import PremadeElements.*;
public class Counter implements Serializable {
    private String name;
    private String ImagePath;
    private Holdable Holding;
    private TileElement CounterFrame;
    public static Counter newCounter(String name){
        try {
            Class<?> myClass = Class.forName(("Counters."+name));//gets the class in assets/Counters/name
            return (Counter) myClass.getDeclaredConstructor().newInstance();//creates a new class and convert it to an Counter   
        } catch (ClassNotFoundException e) {
            e.printStackTrace(); 
            System.exit(1);
        }catch (NoSuchMethodException | InstantiationException | InvocationTargetException | IllegalAccessException e) {
            e.printStackTrace();
            System.exit(1);
        }
        return null;
    }
    
    public void SetFrame(TileElement x){
        CounterFrame = x;
    }

    public TileElement GetFrame(){
        return CounterFrame;
    }

    public static Counter newCounter(String name,Holdable holding){
        Counter x = newCounter(name);
        if (x == null) return null;
        x.SetHolding(holding);
        return x;
    }

    public Counter(String name,String ImagePath){
        this.name = name; this.ImagePath = ImagePath;
    }

    public String GetName() {
        return name;
    }

    public Holdable GetHolding() {
        return Holding;
    }
    public void SetHolding(Holdable obj) {
        Holding = obj;

    }

    public String GetImage() {
        return ImagePath;
    }

    public double[] GetPercentage() {
        if (Holding.GetType() == "Cookware") {
            return  ((Cookware) Holding).GetPercentage();
        }
        return new double[]{};
    }

    //subclass method
    public void Update() {

    }
    
    public boolean CanPlace(Holdable obj) {
        return true;
    }

    public void LeftClick(Player player) {
        Holdable plrHolding = player.getHolding();
        Kitchen kit = Memory.Kitchen;

        //checks if it is a plate
        if (plrHolding != null  && GetHolding() != null){
            String PHN = plrHolding.getName();
            String HN = GetHolding().getName();
            String PHT = plrHolding.GetType();
            String HT = GetHolding().GetType();
            if (PHN.equals("Plate") ||HN.equals("Plate") || PHT.equals("Dish")|| HT.equals("Dish")) {
                Dish newD = null;

                if ((PHN.equals("Plate") && !((Item)plrHolding).isDirty()) ||(HN.equals("Plate") && !((Item)GetHolding()).isDirty()) ) {
                    newD = new Dish("");
                }
                else if(PHT.equals("Dish")) {
                    newD = (Dish)plrHolding;
                }
                else if (HT.equals("Dish")) {
                    newD = (Dish)GetHolding();
                }
                Boolean Condition = false;
                Holdable plrHold = newD;
                Holdable countHold = newD;

                // we have to have two conditions for the first two because Plate is an Item so we need to check if the Item the player is holding is not a Plate
                if (PHT.equals("Item") && !PHN.equals("Plate")) {
                    plrHold = null;
                    Condition = newD.AddItem((Item) plrHolding);
                }
                else if((HT.equals("Item")) && !HN.equals("Plate")) {
                    countHold = null;
                    Condition = newD.AddItem((Item) GetHolding());
                }
                else if (PHT.equals("Cookware")) {
                    plrHold = (Cookware)plrHolding;
                    Condition = ((Cookware) plrHolding).OnDish(newD);
                }
                else if((HT.equals("Cookware"))) {
                    countHold = (Cookware)GetHolding();
                    Condition = ((Cookware) GetHolding()).OnDish(newD);
                }

                if (Condition){
                    player.setHolding(plrHold);
                    kit.UpdateHolding(player);
                    SetHolding(countHold);
                    CounterFrame.UpdateIcons();
                    return;
                }
            }  
        }

        //everything else 
        if (plrHolding != null && GetHolding() == null) {
            if (!CanPlace(plrHolding)) return;
            SetHolding(plrHolding);
            player.setHolding(null);
            CounterFrame.UpdateIcons();
        }
        else if(plrHolding == null && GetHolding() != null) {
            player.setHolding(GetHolding());
            SetHolding(null);
            CounterFrame.UpdateIcons();
        }
        else if(plrHolding != null && GetHolding() != null && plrHolding.GetType() == "Dish" && GetHolding().GetType() == "Cookware") {
            player.setHolding(GetHolding());
            SetHolding(plrHolding);
            CounterFrame.UpdateIcons();
            Memory.Kitchen.UpdateHolding(player);
        }
        else if(plrHolding != null && GetHolding() != null && GetHolding().GetType() == "Cookware") {
            Cookware cookware = (Cookware) GetHolding();
            if (cookware.Add(plrHolding)) {
                player.setHolding(null);
                CounterFrame.UpdateIcons();
            }
        }
        else if (plrHolding != null && GetHolding() != null) {
            player.setHolding(GetHolding());
            SetHolding(plrHolding);
            CounterFrame.UpdateIcons();
            Memory.Kitchen.UpdateHolding(player);
        }
    }

    public void RightClick(Player player){

    }

    public void OnInteract(Player player,String Key) {
        if (Key == "Left"){
            LeftClick(player);
        }
        else {
            RightClick(player);
        }
    }

}