package Counters;
import Classes.*;
public class Trashcan extends Counter{
    static String name = "Trashcan";
    static String ImagePath = "assets/Images/Counters/Trashcan.jpg";
    static Holdable holding;
    public void OnInteract(Player player,String Key) {
        Holdable x = player.getHolding();
        if (x != null){
            if (x.GetType() == "Cookware"){
                ((Cookware)x).GetInventory().clear();
                ((Cookware)x).UpdateProcessedTime(0);
                Memory.Kitchen.UpdateHolding(player);
            }else{
                player.setHolding(null);
            }
        }
    }
    public Trashcan(){
        super(name,ImagePath);
    }
    
}
