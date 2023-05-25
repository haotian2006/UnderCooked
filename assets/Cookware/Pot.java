package Cookware;

import Classes.*;
public class Pot extends Cookware{
    static String name = "Pot";
    static String Image = "assets/Images/Cookware/Pot/Pot.png";
    static String TypeOfCooking = "cook";
    static int max = 3;

    public Pot(){
        super(name, Image,TypeOfCooking,max);
    }


}