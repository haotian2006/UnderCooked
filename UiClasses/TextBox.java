package UiClasses;
import java.awt.Dimension;
import java.awt.Point;
import javax.swing.*;
public class TextBox extends JTextArea{
    private boolean editable = true;
    public void LerpXSize(int x,double t){
        x = (int) Math.ceil(x*t);
        setSize(x,getSize().height);
    }
    public void LerpYSize(int y,double t){
        y = (int) Math.ceil(y*t);
        setSize(getSize().width,y);
    }
    public void LerpPosition(int x,int y,double t){
        x = (int) (x*t);
        y = (int) (y*t);
        setLocation(x,y);
    }
    public TextBox(String Text){
        super(Text);
        setLineWrap(false);
        setWrapStyleWord(true);
    }
    public void SetEditable(){// can it be hightlighted? set to false if not params are sent 
        editable = false;
        setEditable(false);
        setFocusable(false);
    }
    public void SetEditable(boolean x){// this one accepts a bool parameter 
        editable = x;
        setEditable(x);
        setFocusable(x);
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

    public Point GetPositionRelativeToFrame(Point p){
        Point location = getLocation();
        return new Point(p.x+location.x,p.y+location.y);
    }
    public TextLable Clone(){
        TextLable newf = new TextLable(getText());
        newf.setEditable(editable);
        newf.SetFont(getFont());
        newf.setBounds(getBounds());
        newf.setBackground(getBackground());
        return newf;
    }
}
