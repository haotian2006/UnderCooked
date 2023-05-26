package UiClasses;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Point;
import java.lang.reflect.Field;
import java.util.EventListener;
import javax.swing.event.EventListenerList;
import java.lang.reflect.Field;
import java.util.EventListener;
import javax.swing.*;
import javax.swing.event.EventListenerList;

import easingTypes.*;
public class Frame extends JPanel implements UiElement {
    /* 
    private ArrayList<JComponent> children = new ArrayList<JComponent>();
    public boolean InsertChildren(JComponent x){//the children would be Frames,TextLabels,ImageLabels,etc..
       return children.add(x);
    }
    public boolean RemoveChildren(JComponent x){
        return children.remove(x);
    }
    public void Move(int x,int y){//allows you to move all the children with the frame
        Point oldlocation = getLocation();
        setLocation(x, y);
        Point distance =new Point(x-oldlocation.x, y-oldlocation.y);
        for(Iterator<JComponent> iter = children.iterator(); iter.hasNext();){
            JComponent obj = iter.next();
            Point CurrentLoc = obj.getLocation();
            obj.setLocation(CurrentLoc.x+distance.x,CurrentLoc.y+distance.y );
        }
    }
    */ //found out there is already a pre made method that handles this 
    public void LerpPosition(int x,int y,double t){
        x = (int) (x*t);
        y = (int) (y*t);
        setLocation(x,y);
    }
    public void LerpXSize(int x,double t){
        x = (int) (x*t);
        setSize(x,getSize().height);
    }
    public void LerpYSize(int y,double t){
        y = (int) (y*t);
        setSize(getSize().width,y);
    }

    public void TweenSize(EaseFunc func,EaseType type,int x,int y,double t){
        
        setSize(getSize().width,y);
    }
    public Frame(FlowLayout x){
        super(x);
    }
    public Frame(){
        super(null);
    }  
    public Frame(String name){
        super(null);
        setName(name);
    }  
    public void SetCenter(Point p){
        Dimension size = getSize();
        int[] half = new int[]{size.width/2, size.height/2};
        setLocation(p.x-half[0], p.y-half[1]);
        
    }
    public Point GetCenter(){
        Dimension size = getSize();
        Point loc = getLocation();
        return new Point(size.width/2+loc.x, size.height/2+loc.y);
    }
    public Point GetCenterRelativeToFrame(){//deprecated 
        Dimension size = getSize();
        return new Point(size.width/2, size.height/2);
    }

    public Point GetPositionRelativeToFrame(Point p){
        Point location = getLocation();
        return new Point(p.x+location.x,p.y+location.y);
    }
    public Frame Clone(){
        Frame newf = new Frame();
        newf.setBounds(getBounds());
        newf.setBackground(getBackground());
        return newf;
    }
}
