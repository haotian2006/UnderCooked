import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import UiClasses.*;
import easingTypes.*;
public class UITest1 {
    public static void main(String[] args) {
        ScreenGui ui = new ScreenGui("UnderCooked");
        Frame bb = new Frame();
        bb.setOpaque(true);
        bb.setLocation(60, 60);
        bb.setSize(800, 820);
        Frame fidk = new Frame();
        fidk.setBounds(100, 100, 100, 100);
        fidk.setBackground(Color.green);
        ui.add(fidk,1);
        TextBox fidk2 = new TextBox("Test");
        fidk2.setOpaque(false);
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


        Frame fidk3 = new Frame();
        fidk3.setBounds(900, 900, 200, 40);
        fidk3.setBackground(Color.red);
        Frame b2 = new Frame();

        b2.setBackground(Color.green);
        b2.setSize(0, 40);
        UiTween abd = new UiTween(b2,EaseFunc.Linear , EaseType.easeOut);
        UiTween txt = new UiTween(fidk,EaseFunc.Linear , EaseType.easeOut);
        Thread thread = new Thread(new Runnable() {
            public void run() {
                double x = 0.1;
                while (true){
                    try {
                        Thread.sleep(100);
                        int lx = (int) Bounce.easeOut((float) x, 0f, 200f, 1f);
                        //b2.setSize(lx, b2.getSize().height);
                        txt.TweenBackgroundColor(Color.RED, Color.orange, x);
                        txt.TweenSizeFromCenter(new Dimension(100, 100), new Dimension(200, 200), x);
                        abd.TweenSize(new Dimension(0, 40), new Dimension(200, 40), x);
                        //b2.LerpXSize(200, x);
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



        ui.add(bb,0);
        ui.setBackground(Color.BLACK);
        ui.FullScreen();
        
    }
}