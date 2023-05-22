package Cookware;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

import Classes.*;
public class Pot extends Cookware{
    static String name = "Pot";
    static String Image = "assets/Images/Cookware/Pot/Pot.png";
    static String TypeOfCooking = "Cook";
    static int max = 3;
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
    public Pot(){
        super(name, Image,TypeOfCooking,max);
    }


}