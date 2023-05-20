package Counters;
import java.util.ArrayList;

import Classes.*;
public class Sink extends Counter{
    static String name = "Sink";
    static String ImagePath = "assets/Images/Counters/Trashcan.jpg";
    private ArrayList<Item> items;
    public void RightClick(Player player){

    }
    public void OnInteract(Player player, String Key){
        Holdable x = player.getHolding();
        if (x.GetType() == "Item"){
            if(((Item)x).isDirty() == true){   
                
            }
        }
    }
    public Sink(ArrayList<Item> i){
        super(name, ImagePath);
        items = i;
    }
}
