package PremadeElements; 
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Point;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.AffineTransform;
//this creates the loading screen
import UiClasses.*; 
public class LoadingScreen extends Frame{
    private boolean PressedPlay = false;
    private Thread thread;
    public LoadingScreen(){
        super(null);
        ScreenSize ScreenSize = new ScreenSize();
        setSize(ScreenSize.Get().x,ScreenSize.Get().y);
        setOpaque(false);
        
        ImageLable Title = new ImageLable("assets/Images/LargeTitle.png");
        Title.setSize(385*2, 39*2);
        Title.SetImageSize(385*2, 39*2);

        Point Center = ScreenSize.GetCenter();
        Title.SetCenter(new Point(Center.x, Center.y-50));
        add(Title);

        Frame EventFrame = new Frame();
        EventFrame.setSize(ScreenSize.Get().x,ScreenSize.Get().y);
        EventFrame.setOpaque(false);
        add(EventFrame, 0);

        Frame LoadingBar = new Frame();
        LoadingBar.setLocation(Center.x-385, Center.y);
        LoadingBar.setSize(0, 20);
        add(LoadingBar);


        TextLable Loading = new TextLable("Loading");
        Loading.setSize(800, 30);
        Loading.setOpaque(false);
        Loading.setFont(new Font("Arial Black",0, 20));
        Loading.SetCenter(new Point(Center.x-20, Center.y+30));
        Loading.CenterText();        
        add(Loading);

        ImageLable Plate = new ImageLable("assets/Images/Plate.png");
        Plate.setSize(1000, 1000);
        Plate.SetImageSize(1000, 1000);
        Plate.SetCenter(new Point(Center.x, Center.y-20));
        add(Plate);

        thread = new Thread(new Runnable() {
            public Color lerpRGB(Color color1, Color color2, double t) {
                double r = color1.getRed() + ((color2.getRed() - color1.getRed()) * t);
                double g = color1.getGreen() + ((color2.getGreen() - color1.getGreen()) * t);
                double b = color1.getBlue() + ((color2.getBlue() - color1.getBlue()) * t);
                return new Color((int) r, (int)g, (int)b);
            }
            public void run() {
                for (double i = 0;i <1; i +=.001){
                    LoadingBar.LerpXSize(385*2, i);
                    Loading.setForeground(lerpRGB(Color.cyan,new Color(255,179,0),i));
                    LoadingBar.setBackground(lerpRGB(Color.cyan,new Color(255,179,0),i));
                    try{
                        Thread.sleep(2);
                    }catch (InterruptedException e) {
                    }
                    
                }
                Loading.setText("Done!");
                EventFrame.addMouseListener(new MouseAdapter() {
                    public void mousePressed(MouseEvent e) {
                        PressedPlay = true;
                    }
                });
                try{
                    Thread.sleep(750);
                }catch (InterruptedException e) {
                }
                Loading.setText("Click Anywhere To start");
            }
        });
        thread.start();
    }
    public boolean Ready(){
        return PressedPlay;
    }
    public void WaitTillLoaded(){//yields the code until PressedPlay turns into true
        while (!PressedPlay){
            try{
                Thread.sleep(100);
            }catch (InterruptedException e) {
            }
        }
        thread.interrupt();//disconnect the thread
    }
} 