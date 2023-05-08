import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Test {
    public static void main(String[] args) {
        ScreenGui ui = new ScreenGui("hello");
        Frame bb = new Frame(null);
        bb.setOpaque(true);
        bb.setLocation(60, 60);
        bb.setSize(800, 820);
        Frame fidk = new Frame(null);
        fidk.setBounds(100, 100, 100, 100);
        fidk.setBackground(Color.green);
        ui.add(fidk,1);
        TextBox fidk2 = new TextBox("Eat This");
        
        fidk2.setBackground(Color.red);
        fidk2.setBounds(0,0, 1000, 100);
        fidk.add(fidk2);
        fidk.setBounds(100,20, 100, 100);
        bb.add(fidk);
        MouseAdapter t = new MouseAdapter() { // listens when a mouse clicked on the frame
            public void mouseMoved(MouseEvent evt){
                fidk.setLocation(evt.getPoint());
                System.out.println(evt.getPoint().x + ", " + evt.getPoint().y);
            }
        };
        bb.addMouseMotionListener(t);
        ImageLable idk = new ImageLable("Images/red.jpg");
        idk.setBounds(100, 150, 40, 40);
        idk.SetImageSize(20, 20);
        ImageLable idk2 = idk.Clone();
        idk2.SetImage("Images/green.jpg");
        idk2.setLocation(102, 162);
        idk2.setSize(15, 15);
        ui.add(idk,1);
        ui.add(idk2,1);
        ui.add(bb,0);
        ui.setBackground(Color.BLACK);
        ui.FullScreen();
        
    }
}