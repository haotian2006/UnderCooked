package Counters;
import Classes.*;
import java.util.ArrayList;
public class Receive extends Counter{
    static String name = "Receive";
    static String ImagePath = "assets/Images/Counters/Receive.png";
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

    public Receive(){
        super(name,ImagePath);
        items = new  ArrayList<Item>();
    }  
}
