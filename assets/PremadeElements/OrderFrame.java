package PremadeElements;

import java.awt.Color;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.border.Border;

import Classes.Item;
import Classes.Recipe;
import UiClasses.*;

class ItemFrame extends Frame{
    //this class creates the icon on the right
    public ItemFrame(Item x){
        super("ItemFrame");
        setBackground(new Color(158, 229, 232));

        Frame itemBg = new Frame("assets/Images/Menu/LoadingScreen/Plate.png");
        itemBg.setSize(25, 25);
       // itemBg.SetImageSize(23, 23);
        itemBg.setLocation(0, 0);
        itemBg.setBackground(new Color(197, 196, 202));

        ImageLable item = new ImageLable(x.GetImage(true));
        item.setSize(26, 26);
        item.SetImageSize(26, 26);
        item.setLocation(0, 0);

        Border border = BorderFactory.createLineBorder(Color.BLACK, 1);
        setBorder(border);
        itemBg.setBorder(border);

        int size =0;
        if (x.isChopped()){
            ImageLable itm = new ImageLable("assets/Images/Other/ChoppingBoard.png");
            itm.setSize(23, 23);
            itm.SetImageSize(23, 23);
            itm.setLocation(25*(size+1)+2, 1);
            add(itm);
            size++;
        }
        if (x.isCooked()){
            ImageLable itm = new ImageLable("assets/Images/Other/Pot.png");
            itm.setSize(23, 23);
            itm.SetImageSize(23, 23);
            itm.setLocation(25*(size+1)+2, -1);
            add(itm);
            size++;
        }
        if (x.isFried()){
            ImageLable itm = new ImageLable("assets/Images/Other/Pan.png");
            itm.setSize(23, 23);
            itm.SetImageSize(23, 23);
            itm.setLocation(25*(size+1)+2, 0);
            add(itm);
            size++;
        }

        setSize(25+26*size, 25);
        
        add(item);
        add(itemBg);
    }
}
public class OrderFrame extends Frame {
    private double Time;
    private Frame Percent;
    private int amt;

    public OrderFrame(Recipe x){
        super("Frame");
        setSize(230,130);
        setOpaque(false);
        
        ImageLable Plate = new ImageLable();
        Plate.setSize(100,100);
        Plate.SetImage("assets/Images/Menu/LoadingScreen/Plate.png");
        Plate.SetImageSize(100,100);
        Plate.setLocation(10, 30);

        ImageLable icon = new ImageLable(x.GetImage());
        icon.setSize(100, 100);
        icon.SetImageSize(100, 100);
        icon.setLocation(10, 30);
        icon.setOpaque(false);

        TextLable textL = new TextLable(x.GetName());
     //   textL.setText("Lettuce Cheese Burger");//Max of 21 characters
        textL.setLocation(0, 8);
        textL.setSize(120, 20);
        textL.CenterText();
        textL.setOpaque(false);
        textL.setFont(new Font("SansSerif Plain", 1,10));

        Frame bg = new Frame();
        bg.setSize(120, 100);
        bg.setLocation(0, 30);
        bg.setBackground(new Color(158, 229, 232));

        Frame PercentBg = new Frame();
        PercentBg.setSize(120, 20);
        PercentBg.setLocation(0, 10);
        PercentBg.setBackground(new Color(202, 202, 202));

        Percent = new Frame();
        Percent.setSize(100, 20);
        Percent.setLocation(0, 10);
        Percent.setBackground(new Color(184, 229, 59));

        //Display the ingredients
        Frame ingF = new Frame();
        ingF.setSize(110, 100);
        ingF.setLocation(120, 30);
        ingF.setBackground(Color.BLACK);
        ingF.setOpaque(false);


        //  addItem(Item.newItem("Carrot",true,true,true), ingF);
        //  addItem(Item.newItem("Carrot",true,true,false), ingF);
        //  addItem(Item.newItem("Carrot",true,true,false), ingF);
        //  addItem(Item.newItem("Carrot",true,true,false), ingF);

        for (int n =0;n<x.GetIngredients().length;n++){
            addItem(x.GetIngredients()[n], ingF);
        }

        //display them in this order
        add(ingF);
        add(textL);
        add(Percent);
        add(PercentBg);
        add(icon);
        add(Plate);
        add(bg);


    }
    public void addItem(Item x,Frame ingF){
        ItemFrame newI = new ItemFrame(x);
        newI.setLocation(0,25*amt);
        ingF.add(newI);
        amt++;
    }
}
