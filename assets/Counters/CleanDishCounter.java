package Counters;
import Classes.*;
import java.util.ArrayList;
public class CleanDishCounter extends Counter{
    static String name = "CleanDishCounter";
    static String ImagePath = "assets/Images/Counters/SinkPlates.png";
    static Holdable holding;
    private ArrayList<Item> items;
    public ArrayList<Item> getItems(){
        return items;
    }
    public void LeftClick(Player plr){
        Holdable pHold = plr.getHolding();
        if (pHold == null){
            plr.setHolding(GetHolding());
            SetHolding(null);
            GetFrame().Update();
            GetFrame().UpdateIcons();
            Memory.Kitchen.UpdateHolding(plr);
            
            
        }
    }
    public void Update(){
        if (GetHolding() == null){
        if (items.size() > 0){
            SetHolding(items.get(0));
            items.remove(items.get(0));
            GetFrame().Update();
            GetFrame().UpdateIcons();
        }
        }
    }

    public CleanDishCounter(){
        super(name,ImagePath);
        items = new  ArrayList<Item>();
    }  
}
