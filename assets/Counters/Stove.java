package Counters;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import Classes.*;
public class Stove extends Counter{
    static String name = "Stove";
    static String ImagePath = "assets/Images/Counters/Stove.jpg";
    static Holdable holding;
    public void Update(){
        if (GetHolding() != null && GetHolding().GetType() == "Cookware"){
            Cookware cw = (Cookware) GetHolding();
            if (cw.GetName().equals( "Pot")&& cw.GetInventory().size() >0){
                cw.UpdateProcessedTime(cw.GetProcessedTime()+.01);
                GetFrame().Update();
            }
        }
    } 
    public Stove(){
        super(name,ImagePath);
    }
    
}
