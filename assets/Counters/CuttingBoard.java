package Counters;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import Classes.*;
public class CuttingBoard extends Counter{
    static String name = "CuttingBoard";
    static String ImagePath = "assets/Images/Counters/Cutting.jpg";
    static Holdable holding;
    public void RightClick(Player plr){

    }
    public void Update(){
        if(Memory.player.GetCounter() == this){//if the players is currently not right clicking on it
            Holdable hold = GetHolding();
            if (hold == null ||!hold.GetType().equals("Item")) return;//checks if the player is holding an item and if not stop the code 
            Item item = (Item) hold;
            if (!item.canBeChopped()) return;//if it can be chopped 
            double maxTime = item.getMaxProcessTime("Chop");
            double currentTime = item.GetProcessedTime();
            if (currentTime <= maxTime || false){//|| false is for debugging 
                hold.UpdateProcessedTime(currentTime+0.01);//increase time 
            }else{
                // this means that it is done chopping 
                item.setChopped(true);
                hold.UpdateProcessedTime(0);
                //we call UpdateIcons because we changed the chopping state 
                GetFrame().UpdateIcons();
            }
            //call the update method in the frame
            GetFrame().Update();
        }
    }
    public CuttingBoard(){
        super(name,ImagePath);
    }
    
}
