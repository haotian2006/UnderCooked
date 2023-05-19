package Counters;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import Classes.*;
public class counter extends Counter{
    static String name = "Counter";
    static String ImagePath = "assets/Images/Counters/Counter.jpg";
    static Holdable holding;
    public void OnInteract(Player plr){
        // plr.setHolding(new Item());
    }
    public counter(){
        super(name,ImagePath);
    }
    
}
