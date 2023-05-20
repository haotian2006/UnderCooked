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
            }else if(x.GetType() == "Item"){
                if (((Item)x).getName().equals("Plate") ) return;
                player.setHolding(null);
                Memory.Kitchen.UpdateHolding(player);
            }else if(x.GetType() == "Dish"){
                player.setHolding(Item.newItem("Plate"));
                Memory.Kitchen.UpdateHolding(player);
            }
        }
    }
    public Trashcan(){
        super(name,ImagePath);
    }
    
}
