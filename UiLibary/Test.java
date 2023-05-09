import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Test {
    public static void main(String[] args) {
        ScreenGui ui = new ScreenGui("UnderCooked");
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

        Frame mousefinder = new Frame();
        mousefinder.setSize(900, 900);
        mousefinder.setOpaque(false);
        bb.add(mousefinder, 0);
        bb.add(fidk,1);
        MouseAdapter t = new MouseAdapter() { // listens when a mouse clicked on the frame
            public void mouseMoved(MouseEvent evt){
                fidk.setLocation(evt.getPoint());
                System.out.println(evt.getPoint().x + ", " + evt.getPoint().y);
            }
        };
        mousefinder.addMouseMotionListener(t);


        Frame fidk3 = new Frame(null);
        fidk3.setBounds(900, 900, 200, 40);
        fidk3.setBackground(Color.red);
        Frame b2 = new Frame(null);

        b2.setBackground(Color.green);
        b2.setSize(0, 40);
        Thread thread = new Thread(new Runnable() {
            public void run() {
                double x = 0.1;
                while (true){
                    try {
                        Thread.sleep(100);
                        b2.LerpXSize(200, x);
                        x +=.1;
                        if (x >= 1.1){
                            x = 0;
                        }
                    } catch (InterruptedException e) {
                        
                    }
                }
            }
        });

        thread.start();
        ui.add(fidk3,1);
        fidk3.add(b2);

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