package PremadeElements;

import UiClasses.*;
import easingTypes.EaseFunc;
import easingTypes.EaseType;

import java.awt.Color;
import java.awt.Point;
import java.util.ArrayList;

import Classes.*;

public class OrdersBar extends Frame {
    private ArrayList<OrderFrame> OrderFrames;
    public Frame Order;
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
        Order.setLocation(0, 5);
        Order.setSize(310, (ss.Get().y));
        Order.setOpaque( false); 
        setOpaque(false);
        add(Order);

    }
    public void AddFrame(Recipe rP){
        OrderFrame x = new OrderFrame(rP);
        int pos = OrderFrames.size()*130;
        OrderFrames.add(x);
        Order.add(x);
        UiTween tween = new UiTween(x, EaseFunc.Linear, EaseType.easeNone,1);
        ScreenSize ss = new ScreenSize();
        x.setLocation( new Point(0,pos));
        //tween.Play(TweenProperty.TweenLocation, new Point(0,ss.Get().y+130), new Point(0,pos), 2);
    }
    public void SetMark(int x,boolean done){//if a boolean is sent then set visible
        OrderFrame f = OrderFrames.get(x);
        f.visibleCheck(done);
    }
    public void RemoveFrame(int x){
        OrderFrame f = OrderFrames.get(x);
        OrderFrames.remove(x);
        Order.remove(f);
        for (int n = x; n<OrderFrames.size();n++){
            OrderFrame fv = OrderFrames.get(n);
            UiTween tween = new UiTween(fv, EaseFunc.Linear, EaseType.easeNone,1);
            fv.setLocation(new Point(0,n*130));
            //tween.Play(TweenProperty.TweenLocation, new Point(0,fv.getLocation().y), new Point(0,n*130), .5);
        }
       // Order.repaint();
    }
    public void Update(){
        for (int n = 0; n<OrderFrames.size();n++){
            OrderFrame fv = OrderFrames.get(n);
            fv.update();
        }

    }
}
