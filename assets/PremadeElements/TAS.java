package PremadeElements;
//TAS = TIMER AND SCORE
import UiClasses.Frame;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import Classes.Player;
import UiClasses.*;

public class TAS extends Frame {
    TextLable Timer;
    TextLable Score;
    public TAS(){
        super("Timer");
        double scale =1;
        Dimension size = new Dimension(((int)(367/scale)), ((int)(73/scale)));
        setLocation(new ScreenSize().Get().x-((int) (367/scale)), 0);
        setSize(size);
        setOpaque(false);
        
        ImageLable bg = new ImageLable("assets/Images/Other/TimerAndScore.png");
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

        Frame Button = new Frame();
        Button.setSize(40, 40);
        Button.setLocation(367-40, 20);
        Button.setOpaque(false);

        add(Button);
        add(Score);
        add(Timer);
        add(bg);
    }   
    public void Update(Player plr){
        Score.setText(""+plr.getScore());
        int minutes = (int) (plr.GetTimer() / 60); 
        int seconds = (int) (plr.GetTimer() % 60);
        Timer.setText(String.format("%02d:%02d", minutes, seconds));
        if (plr.GetTimer() <=30){
            Timer.setForeground(Color.red);
        }
    }
}
