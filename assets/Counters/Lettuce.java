package Counters;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import Classes.*;
public class Lettuce extends Counter{
    static String name = "Lettuce";
    static String ImagePath = "assets/Images/Counters/CarrotCrate.jpg";
    static Holdable holding;
    public void LeftClick(Player plr){
        if (plr.getHolding() == null){
            plr.setHolding(Item.newItem("Lettuce"));
        }
    }
    public Lettuce(){
        super(name,ImagePath);
    }
    
}
