package PremadeElements;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Point;

import javax.swing.BorderFactory;
import javax.swing.border.Border;

import Classes.Item;
import Classes.Kitchen;
import Classes.Recipe;
import UiClasses.*;
import easingTypes.EaseFunc;
import easingTypes.EaseType;
import easingTypes.Tween;

class ItemFrame extends Frame{
    //this class creates the icon on the right
    public ItemFrame(Item x){
        super("ItemFrame");
        setBackground(new Color(158, 229, 232));

        Frame itemBg = new Frame("assets/Images/Other/Plate.png");
        itemBg.setSize(25, 25);
       // itemBg.SetImageSize(23, 23);
        itemBg.setLocation(0, 0);
        itemBg.setBackground(new Color(197, 196, 202));

        ImageLabel item = new ImageLabel(x.GetImage(true));
        item.setSize(26, 26);
        item.SetImageSize(26, 26);
        item.setLocation(0, 0);

        Border border = BorderFactory.createLineBorder(Color.BLACK, 1);
        setBorder(border);
        itemBg.setBorder(border);

        int size =0;
        if (x.isChopped()){
            ImageLabel itm = new ImageLabel("assets/Images/Other/ChoppingBoard.png");
            itm.setSize(23, 23);
            itm.SetImageSize(23, 23);
            itm.setLocation(25*(size+1)+2, 1);
            add(itm);
            size++;
        }
        if (x.isCooked()){
            ImageLabel itm = new ImageLabel("assets/Images/Other/Pot.png");
            itm.setSize(23, 23);
            itm.SetImageSize(23, 23);
            itm.setLocation(25*(size+1)+2, -1);
            add(itm);
            size++;
        }
        if (x.isFried()){
            ImageLabel itm = new ImageLabel("assets/Images/Other/Pan.png");
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
    private Recipe rp;
    private Frame Percent;
    private int amt;
    private ImageLabel checkmark;
    private Frame bg;
    public OrderFrame(Recipe x){
        super("Frame");
        rp = x;
        setSize(230,130);
        setOpaque(false);
        setLocation(0, 2100);
        ImageLabel Plate = new ImageLabel();
        Plate.setSize(100,100);
        Plate.SetImage("assets/Images/Other/Plate.png");
        Plate.SetImageSize(100,100);
        Plate.setLocation(10, 30);

        ImageLabel icon = new ImageLabel(x.GetImage());
        icon.setSize(100, 100);
        icon.SetImageSize(100, 100);
        icon.setLocation(10, 30);
        icon.setOpaque(false);

        TextLable textL = new TextLable(x.GetName());
     //   textL.setText("Lettuce Cheese Burger");//Max of 21 characters
        textL.setLocation(0, 11);
        textL.setSize(120, 20);
        textL.CenterText();
        textL.setOpaque(false);
        textL.setFont(new Font("SansSerif Plain", 1,10));

        bg = new Frame();
        bg.setSize(120, 100);
        bg.setLocation(0, 30);
        bg.setBackground(new Color(158, 229, 232));

        checkmark = new ImageLabel("");
        checkmark.setSize(120, 100);
        checkmark.setLocation(0, 30);
        checkmark.SetImageSize(120, 100);
        checkmark.setVisible(false);

        Frame PercentBg = new Frame();
        PercentBg.setSize(120, 20);
        PercentBg.setLocation(0, 10);
        PercentBg.setBackground(new Color(202, 202, 202));

        Percent = new Frame();
        Percent.setSize(120, 20);
        Percent.setLocation(0, 10);
        Percent.setBackground(new Color(184, 229, 59));

        //Display the ingredients
        Frame ingF = new Frame();
        ingF.setSize(110, 125);
        ingF.setLocation(120, 10);
        ingF.setBackground(Color.BLACK);
        ingF.setOpaque(false);




        for (int n =0;n<x.GetIngredients().length;n++){
            addItem(x.GetIngredients()[n], ingF);
        }

        // //display them in this order
        add(checkmark);
        add(ingF);
        add(textL);
        add(Percent);
        add(PercentBg);
        add(icon);
        add(Plate);
        add(bg);
        update();
    }
    public void update(){
        double percent = rp.GetTime()/Kitchen.GetMaxTime();
        UiTween newT = new UiTween(Percent, EaseFunc.Linear, EaseType.easeInOut,1);
        // UiTween bgT = new UiTween(bg, EaseFunc.Linear, EaseType.easeInOut,1);
        // bgT.TweenBackgroundColor(Color.red,new Color(158, 229, 232), percent);
        newT.TweenSize(new Dimension(0, 20),new Dimension(120,20), percent);
    }
    public void visibleCheck(boolean x){
        if (!x){
            checkmark.SetImage("assets/Images/Other/Cross.png");
        }else{
            checkmark.SetImage("assets/Images/Other/Checkmark.png");
        }
        checkmark.setVisible(true);
    }
    public void addItem(Item x,Frame ingF){
        ItemFrame newI = new ItemFrame(x);
        newI.setLocation(0,25*amt);
        ingF.add(newI);
        amt++;
    }
}
