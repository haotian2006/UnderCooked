package Counters;
import java.util.ArrayList;

import Classes.*;
import PremadeElements.TileElement;
public class Sink extends Counter{
    static String name = "Sink";
    static String ImagePath = "assets/Images/Counters/Sink.png";
    private ArrayList<Item> items;
    public void RightClick(Player player){

    }
    public void LeftClick(Player player){
        Holdable plrHolding = player.getHolding();
        if (!plrHolding.GetType().equals("Item")) {return;}
        Item item = (Item) plrHolding;
        Kitchen kit = Memory.Kitchen;
        if (((plrHolding != null && plrHolding.GetType().equals("Item")) && item.getName().equals("Plate")) && item.isDirty()){
            items.add(item);
            player.setHolding(null);
            kit.UpdateHolding(player);
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
        if(Memory.player.GetCounter() == this ){//if the players is currently not right clicking on it
            Holdable hold = GetHolding();
            if (hold == null ||!hold.GetType().equals("Item")) return;//checks if the player is holding an item and if not stop the code 
            Item item = (Item) hold;
            if (!item.getName().equals("Plate") && item.isDirty()) return;//if the item is a plate and is ditry
            double maxTime = item.getMaxProcessTime("Dirty");
            double currentTime = item.GetProcessedTime();
            Player plr = Memory.player;
            if (currentTime <= maxTime || false){//|| false is for debugging 
                hold.UpdateProcessedTime(currentTime+0.01);//increase time 
            }else {
                // this means that it is done cleaning 
                item.setDirty(false);
                hold.UpdateProcessedTime(0);
                TileElement CDC =  Memory.Kitchen.GetTileFromName("CleanDishCounter");
                if (CDC != null){
                    ((CleanDishCounter)CDC.getCounter()).getItems().add(item);
                    SetHolding(null);
                }else if(plr.getHolding() == null){
                    plr.setHolding(item);
                    SetHolding(null);
                }
                //we call UpdateIcons because we changed the cleaning state 
                GetFrame().UpdateIcons();
            }
            //call the update method in the frame
            GetFrame().Update();
        }
    }
    public Sink(){
        super(name, ImagePath);
        items = new  ArrayList<Item>();
    }
}
