package UiClasses;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Point;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;
import javax.swing.*;
public class TextLable extends JTextPane{
    public void LerpXSize(int x,double t){
        x = (int) Math.ceil(x*t);
        setSize(x,getSize().height);
    }
    public void LerpYSize(int y,double t){
        y = (int) Math.ceil(y*t);
        setSize(getSize().width,y);
    }
    private boolean editable = true;
    public TextLable(String Text){
        setText(Text);
        SetEditable();
    }
    public void SetEditable(){//allows highlighting/editing 
        editable= false;
        setEditable(false);
        setFocusable(false);
    }
    public void SetEditable(boolean x){
        editable = x;
        setEditable(x);
        setFocusable(x);
    }
    public void LerpPosition(int x,int y,double t){
        x = (int) (x*t);
        y = (int) (y*t);
        setLocation(x,y);
    }
    public void SetFont(Font font){
        SimpleAttributeSet fontAttributes = new SimpleAttributeSet();
        StyledDocument doc = getStyledDocument();
        StyleConstants.setFontFamily(fontAttributes, font.getFamily());
        StyleConstants.setFontSize(fontAttributes, font.getSize());
        StyleConstants.setBold(fontAttributes, font.isBold());
        StyleConstants.setItalic(fontAttributes, font.isItalic());
        doc.setCharacterAttributes(0, doc.getLength(), fontAttributes, false);
    }
    public void CenterText(){
        StyledDocument doc = getStyledDocument();
        SimpleAttributeSet center = new SimpleAttributeSet();
        StyleConstants.setAlignment(center, StyleConstants.ALIGN_CENTER);
        doc.setParagraphAttributes(0, doc.getLength(), center, false);
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
    public Point GetCenterRelativeToFrame(){
        Dimension size = getSize();
        return new Point(size.width/2, size.height/2);
    }

    public TextLable Clone(){
        TextLable newf = new TextLable(getText());
        newf.setEditable(editable);
        newf.setStyledDocument(getStyledDocument());
        newf.SetFont(getFont());
        newf.setBounds(getBounds());
        newf.setBackground(getBackground());
        return newf;
    }
}