import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;
import javax.imageio.ImageIO;
import javax.swing.*;
// A ui class made by hao 
// It acts similar to how the GUI classes in roblox work
class ScreenSize{
    public Point Get(){
        Dimension screenDimension = Toolkit.getDefaultToolkit().getScreenSize();
        int jFrameWidth = screenDimension.width;
        int jFrameHeight = screenDimension.height;
        return new Point(jFrameWidth,jFrameHeight);
    }
    public Point GetCenter(){
        Point size = Get();
        return new Point(size.x/2,size.y/2);
    }
}

class ScreenGui extends JFrame{
    private JComponent Topbar;
    public ScreenGui(String name){
        super(name);
        setUndecorated(true);
        setVisible(true);
        setLayout(null);
        setResizable(false);
        ExitButton();
    };
    public void setBackground(Color x){
        JPanel contentPane = (JPanel) getContentPane();
        contentPane.setBackground(x);
    }
    
    public void setTopBarColor(Color x){
        Topbar.setBackground(x);
    }
    public JComponent GetTopBar(){
        return Topbar;
    }
    public void SetTopBar(JComponent x){
        Topbar = x;
    }
    private void ExitButton(){//creates a red X on the top right corner 
        Frame x = new Frame();//the x frame is just a red frame 
        TextLable y = new TextLable("X");// the y frame is a red background and has "X" written on it and is 5 pixels above the x so that the "X" is centered 
        //x and y frames might be replaced by a image instead 
        TextLable name = new TextLable("UnderCooked");
        Frame z = new Frame(null);
        Point s = new ScreenSize().Get(); 
        z.setBounds(0, 0, s.x, 20);
        Topbar = z;
        y.SetEditable();
        y.setBounds(s.x-17, -5, 20, 25);
        y.SetFont(new Font("Impact", Font.PLAIN, 20));
        y.SetEditable();
        y.setBackground(Color.red);
        x.setBackground(Color.red);
        x.setBounds(s.x-20, 0, 20, 20);
        MouseAdapter exit = new MouseAdapter() { // listens when a mouse clicked on the frame
            public void mousePressed(MouseEvent e) {
                System.exit(0);
            }
        };
        name.setBounds(0, 0, s.x, 20);
        name.setOpaque(false);
        x.addMouseListener(exit);
        y.addMouseListener(exit);
        z.add(name);
        z.add(y,null,0);
        z.add(x,null,-1);
        add(z);
    }
    public void FullScreen(){
        Point size = new ScreenSize().Get();
        //System.out.println("Mouse clicked at x=" + size[0] + ", y=" +  size[1]); // get size of screen
        setSize(size.x, size.y);
        setLocationRelativeTo(null);;
    }
}

class Frame extends JPanel {
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
    public void LerpXSize(int x,double t){
        x = (int) (x*t);
        setSize(x,getSize().height);
    }
    public void LerpYSize(int y,double t){
        y = (int) (y*t);
        setSize(getSize().width,y);
    }
    public Frame(FlowLayout x){
        super(x);
    }
    public Frame(){
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
class TextBox extends JTextArea{
    private boolean editable = true;
    public void LerpXSize(int x,double t){
        x = (int) Math.ceil(x*t);
        setSize(x,getSize().height);
    }
    public void LerpYSize(int y,double t){
        y = (int) Math.ceil(y*t);
        setSize(getSize().width,y);
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
class ImageLable extends JLabel{
    public void LerpXSize(int x,double t){
        x = (int) Math.ceil(x*t);
        setSize(x,getSize().height);
    }
    public void LerpYSize(int y,double t){
        y = (int) Math.ceil(y*t);
        setSize(getSize().width,y);
    }
    public void LerpImageXSize(int x,double t){
        x = (int) Math.ceil(x*t);
        SetImageSize(x,this.sizey);
    }
    public void LerpImageYSize(int y,double t){
        y = (int) Math.ceil(y*t);
        SetImageSize(this.sizex,y);
    }
    private ImageIcon image;
    private int sizex,sizey;
    public ImageLable(String image){
       SetImage(image);
    }
    public ImageLable(){// makes it so sending an image is optional 
    }
    public void SetImage(String imagePath) {
        try {
            File path = new File(imagePath);
            FileInputStream fis = new FileInputStream(path);  
            BufferedImage image = ImageIO.read(fis);
            ImageIcon icon = new ImageIcon(image);
            this.image = icon;
            setIcon(icon);
            if (sizex != 0 && sizey != 0) SetImageSize(sizex, sizey);
        } catch (IOException e) {
            System.out.println("Failed to load image: " + e.getMessage());
        }
    }
    public void SetImageSize(int x,int y){
        if (this.image == null) return;
        Image scaledImage = image.getImage().getScaledInstance(x, y, Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(scaledImage);
        image = scaledIcon;
        sizex = x;
        sizey = y;
        setIcon(scaledIcon);
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

    public ImageLable Clone(){// creates a new imagelable with similar properties 
        ImageLable newi = new ImageLable();
        newi.setBackground(getBackground());
        newi.setBounds(getBounds());
        newi.setIcon(image);
        newi.image = image;
        newi.SetImageSize(sizex, sizey);
        return newi;
    }
}
class TextLable extends JTextPane{
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