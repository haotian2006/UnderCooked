package Counters;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import Classes.*;
public class Potato extends Counter{
    static String name = "Potato";
    static String ImagePath = "assets/Images/Counters/PotatoCrate.jpg";
    static Holdable holding;
    public void LeftClick(Player plr){
        if (plr.getHolding() == null){
            plr.setHolding(Item.newItem("Potato"));
        }
    }
    public Potato(){
        super(name,ImagePath);
    }
    
}
