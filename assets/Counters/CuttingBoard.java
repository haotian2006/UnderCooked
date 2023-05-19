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
        if(Memory.player.GetCounter() == this){
            Holdable hold = GetHolding();
            if (hold == null ||!hold.GetType().equals("Item")) return;
            Item item = (Item) hold;
            if (!item.canBeChopped()) return;
            double maxTime = item.getMaxProcessTime("Chopping");
            double currentTime = item.GetProcessedTime();
            if (currentTime <= maxTime){
                hold.UpdateProcessedTime(currentTime+0.01);
            }else{
                item.setChopped(true);
                hold.UpdateProcessedTime(0);
                GetFrame().UpdateIcons();
            }
            GetFrame().Update();
        }
    }
    public CuttingBoard(){
        super(name,ImagePath);
    }
    
}
