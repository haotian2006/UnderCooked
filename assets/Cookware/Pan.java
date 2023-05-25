package Cookware;

import Classes.*;
public class Pan extends Cookware{
    static String name = "Pan";
    static String Image = "assets/Images/Cookware/Pan.png";
    static String TypeOfCooking = "fry";
    static int max = 1;

    public Pan(){
        super(name, Image,TypeOfCooking,max);
    }


}