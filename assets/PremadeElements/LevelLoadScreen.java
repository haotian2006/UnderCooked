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
import Classes.*;
public class LevelLoadScreen extends Frame{
    private boolean PressedPlay = false;
    private Thread thread;
    public LevelLoadScreen(Level lev){
        super();
        ScreenSize ScreenSize = new ScreenSize();
        Point Center = ScreenSize.GetCenter();

        setSize(ScreenSize.Get().x,ScreenSize.Get().y);
        setOpaque(false);
        
        ImageLabel image = new ImageLabel(lev.GetImage());
        image.setSize(700,500);
        image.SetImageSize(700,500);
        image.SetCenter(Center);
        add(image);

        ImageLabel ll = new ImageLabel("assets/Images/Other/LoadingLevel.png");
        Dimension size = new Dimension(((int) (718*1.3)), ((int) (527*1.3)));
        ll.setSize(size);
        ll.SetImageSize(size);
        ll.SetCenter(Center);
    

        Frame Bg = new Frame();
        Bg.setSize(ScreenSize.Get().x,ScreenSize.Get().y);
        Bg.setLocation(0, 020);
        Bg.setBackground(new Color(109, 226, 125));

        Frame LoadingBar = new Frame();
        LoadingBar.setLocation(Center.x-385, Center.y+300);
        LoadingBar.setSize(0, 20);
        add(LoadingBar);

        Frame LoadingBarBg = new Frame();
        LoadingBarBg.setLocation(Center.x-385, Center.y+300);
        LoadingBarBg.setSize(385*2, 20);
        LoadingBarBg.setBackground(new Color(164, 164, 164));
        add(LoadingBarBg);

        TextLable Loading = new TextLable("Generating Level...");
        Loading.setSize(385*2, 30);
        Loading.setOpaque(false);
        Loading.setFont(new Font("Arial Black",0, 20));
        Loading.SetCenter(new Point(Center.x-20, Center.y-28+300));
        Loading.RightAlignText();     
        
        TextLable Diff = new TextLable("Mode: "+Memory.player.getDifficultyAsString());
        Diff.setSize(200, 40);
        Diff.setLocation(1200, 210);
        Diff.setFont(new Font("Comic Sans MS", 1, 20));
        Diff.CenterText();
        Diff.setOpaque(false);
        Diff.setForeground(new Color(0,0,0));

        TextLable levT = new TextLable("Level: "+lev.GetName());
        levT.setSize(300, 40);
        levT.setLocation(520, 210);
        levT.setFont(new Font("Comic Sans MS", 1, 20));
        levT.setOpaque(false);
        levT.setForeground(new Color(0,0,0));


        add(Diff);
        add(levT);
        add(Loading);
        add(ll);
        add(Bg);
        
        UiTween LoadBar = new UiTween(LoadingBar,EaseFunc.Quint, EaseType.easeInOut);
        thread = new Thread(new Runnable() {
            public void run() {
                for (double i = 0;i <1; i +=.001){
                   // LoadingBar.LerpXSize(385*2, i);
                    LoadBar.TweenSize(new Dimension(0, 20), new Dimension(385*2, 20), i);
                    Loading.setForeground(LoadBar.TweenBackgroundColor(new Color(226, 255, 192), new Color(255,179,0), i));
                    try{
                        Thread.sleep(1);
                    }catch (InterruptedException e) {
                    }
                    
                }
                Loading.setText("Done!");
                
                try{
                    Thread.sleep(500);
                }catch (InterruptedException e) {
                }
                PressedPlay = true;
                
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