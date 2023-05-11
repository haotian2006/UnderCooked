package PremadeElements; 
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import easingTypes.*;
//this creates the loading screen
import UiClasses.*; 
public class LoadingScreen extends Frame{
    private boolean PressedPlay = false;
    private Thread thread;
    public LoadingScreen(){
        super(null);
        ScreenSize ScreenSize = new ScreenSize();
        Point Center = ScreenSize.GetCenter();

        setSize(ScreenSize.Get().x,ScreenSize.Get().y);
        setOpaque(false);
        
        ImageLable Title = new ImageLable("assets/Images/Menu/LoadingScreen/LargeTitlev1.png");
        Title.setSize(385*2, 39*2);
        Title.SetImageSize(385*2, 39*2);

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

        ImageLable Plate = new ImageLable("assets/Images/Menu/LoadingScreen/Plate.png");
        Plate.setSize(1000, 1000);
        Plate.SetImageSize(1000, 1000);
        Plate.SetCenter(new Point(Center.x, Center.y-20));
        add(Plate);
        UiTween LoadBar = new UiTween(LoadingBar,EaseFunc.Quint, EaseType.easeInOut);
        thread = new Thread(new Runnable() {
            public void run() {
                for (double i = 0;i <1; i +=.001){
                   // LoadingBar.LerpXSize(385*2, i);
                    LoadBar.TweenSize(new Dimension(0, 20), new Dimension(385*2, 20), i);
                    Loading.setForeground(LoadBar.TweenBackgroundColor(Color.cyan, new Color(255,179,0), i));
                    try{
                        Thread.sleep(2);
                    }catch (InterruptedException e) {
                    }
                    
                }
                Loading.setText("Done!");
                EventFrame.addMouseListener(new MouseAdapter() {
                    public void mousePressed(MouseEvent e) {
                        if (e.getButton() == MouseEvent.BUTTON1) {
                            PressedPlay = true;
                        }
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
    public void CloseAnimation(){
        UiTween Close = new UiTween(this,EaseFunc.Linear, EaseType.easeInOut,.4);
        Point pos = getLocation();
        for (double i = 0;i <.4; i +=.002){
            // LoadingBar.LerpXSize(385*2, i);
             Close.TweenLocation(pos, new Point(-getSize().width, pos.y), i);
             try{
                 Thread.sleep(1);
             }catch (InterruptedException e) {
             }
             
         }
    }
} 