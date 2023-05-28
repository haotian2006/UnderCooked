package Counters;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import Classes.*;
public class Tomato extends Counter{
    static String name = "Tomato";
    static String ImagePath = "assets/Images/Counters/TomatoCrate.png";
    static Holdable holding;
    public void LeftClick(Player plr){
        if (plr.getHolding() == null){
            plr.setHolding(Item.newItem("Tomato"));
        }
    }
    public Tomato(){
        super(name,ImagePath);
    }
    
}
