package Cookware;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

import Classes.*;
public class Pot extends Cookware{
    static String name = "Pot";
    static String Image = "assets/Images/Cookware/Pot/Pot.png";
    static String TypeOfCooking = "Cooking";
    public String GetImage(){
        if (GetInventory().size() >0){
            switch (GetInventory().get(0).getName()){
                case ("Carrot"):
                    return "assets/Images/Cookware/Pot/Carrot.png";
                default:
                    return Image;
            }
        }
        return Image;
    }
    public boolean CanAdd(Item x){
        if (GetInventory().size() == 0 ||GetInventory().get(0).getName() == x.getName() && GetInventory().size() <= 2){
            return x.canBeCooked();
        }
        return false;
    }
    public Pot(){
        super(name, Image,TypeOfCooking);
    }


}