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
            if ( cw.GetInventory().size() >0){
                cw.UpdateProcessedTime(cw.GetProcessedTime()+.01);
                double[] per = cw.GetPercentage();
                int amt = (int) Math.floor((per[0]/per[1]*10)/(10/cw.GetInventory().size()));
                if (amt > cw.GetInventory().size()) amt = cw.GetInventory().size();
                for (int n =0; n< amt; n++ ){
                    Item x = cw.GetInventory().get(n);
                    if (!x.isState(cw.getTypeOfCooking())){

                        x.setState(cw.getTypeOfCooking(), true);
                        GetFrame().GetItem().UpdateIcons();
                    }
                }
                GetFrame().Update();
            }
        }
    } 
    public Stove(){
        super(name,ImagePath);
    }
    
}
