package PremadeElements;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import Classes.Player;
//TAS = TIMER AND SCORE
import UiClasses.*;
import Classes.*;
public class TAS extends Frame {
    TextLable Timer;
    TextLable Score;
    public TAS(){
        super("Timer");
        double scale =1;
        Dimension size = new Dimension(((int)(367/scale)), ((int)(73/scale)));
        setSize(new ScreenSize().Get().x,new ScreenSize().Get().y);
        setOpaque(false);
        Frame Fbg = new Frame();
        Fbg.setSize(size);
        Fbg.setOpaque(false);
        Fbg.setLocation(new ScreenSize().Get().x-((int) (367/scale)), 0);
        add(Fbg);
        ImageLabel bg = new ImageLabel("assets/Images/Other/TimerAndScore.png");
        bg.setSize(size);
        bg.SetImageSize(size);

        Score = new TextLable("0");
        Score.setSize(150, 35);
        Score.setOpaque(false);
        Score.CenterText();
        Score.setLocation(0, 24);
        Score.setForeground(Color.white);
        Score.setFont(new Font("Comic Sans MS", 1, 20));

        Timer = new TextLable("00:00");
        Timer.setSize(150, 35);
        Timer.setOpaque(false);
        Timer.CenterText();
        Timer.setLocation(160, 24);
        Timer.setForeground(Color.white);
        Timer.setFont(new Font("Comic Sans MS", 1, 20));

        ImageLabel RTH = new ImageLabel("assets/Images/Other/RTH.png");
        RTH.setSize(232, 107);
        RTH.SetImageSize(232, 107);
        RTH.SetCenter(new ScreenSize().GetCenter());

        Frame RThB = new Frame();
        RThB.setSize(190, 70);
        RThB.SetCenter(new Point(new ScreenSize().GetCenter().x-10, new ScreenSize().GetCenter().y+10));
        RThB.setOpaque(false);

        Frame ExitA = new Frame();
        ExitA.setSize(30, 30);
        ExitA.SetCenter(new Point(new ScreenSize().GetCenter().x+100, new ScreenSize().GetCenter().y-40));
        ExitA.setOpaque(false);
        ExitA.setVisible(false);
        RThB.setVisible(false);
        RTH.setVisible(false);
        
        RThB.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                ExitA.setVisible(false);
                RThB.setVisible(false);
                RTH.setVisible(false);
                setVisible(false);
                new Thread(()->{
                    Memory.game.Hub();
                }).start();
            }
        }); 
        ExitA.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                ExitA.setVisible(false);
                RThB.setVisible(false);
                RTH.setVisible(false);
            }
        }); 
        add(ExitA);
        add(RThB);
        add(RTH);
        Frame Button = new Frame();
        Button.setSize(40, 40);
        Button.setLocation(367-40, 20);
        Button.setOpaque(false);
        Button.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                ExitA.setVisible(!ExitA.isVisible());
                RThB.setVisible(!RThB.isVisible());
                RTH.setVisible(!RTH.isVisible());
            }
        }); 

        Fbg .add(Button);
        Fbg. add(Score);
        Fbg. add(Timer);
        Fbg. add(bg);
    }   
    public void Update(Player plr){
        Score.setText(""+plr.getScore());
        int minutes = (int) (plr.GetTimer() / 60); 
        int seconds = (int) (plr.GetTimer() % 60);
        Timer.setText(String.format("%02d:%02d", minutes, seconds));
        if (plr.GetTimer() <=30){
            Timer.setForeground(Color.red);
        }else{
            Timer.setForeground(Color.white);
        }
    }
}
