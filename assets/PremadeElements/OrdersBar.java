package PremadeElements;

import UiClasses.*;

import java.awt.Color;
import java.util.ArrayList;

import Classes.*;

public class OrdersBar extends Frame {
    private ArrayList<OrderFrame> OrderFrames;
    private Frame Order;
    public OrdersBar(){
        super("Orders");
        OrderFrames = new ArrayList<OrderFrame>();
        ScreenSize ss = new ScreenSize();
        setLocation(0, 20);
        setSize(310, (ss.Get().y)-20);
        // TextLable title = new TextLable("Orders");
        // title.setSize(120, 20);
        // title.CenterText();
        // title.setBackground(Color.ORANGE);
        // add(title);
        Order = new Frame("Order");
        Order.setLocation(0, 0);
        Order.setSize(310, (ss.Get().y));
        Order.setOpaque( false);
        setOpaque(false);
        add(Order);
        AddFrame();
    }
    public void AddFrame(){
        OrderFrame x = new OrderFrame(Recipe.newRecipe("CC"));

        Order.add(x);
    }
    public void Reset(){

    }
}
