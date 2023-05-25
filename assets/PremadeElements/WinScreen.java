package PremadeElements;
import UiClasses.*;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import Classes.*;
public class WinScreen extends Frame {
    public WinScreen() {
        super("WinScreen");
        double scale =1;
        setOpaque(false);
        Dimension size = new Dimension(((int)(585/scale)), ((int)(737/scale)));
        ImageLable bg = new ImageLable("assets/Images/Winscreen/Screen.png");
        setSize(size);
        bg.setSize(size);
        bg.SetImageSize(size);
        SetCenter((new ScreenSize()).GetCenter());
        Player plr = Memory.player;
        Kitchen kit =  Memory.Kitchen;
        Level level = Memory.Kitchen.GetLevel();
        int[] starReq = level.GetRequirements(plr.getDifficulty());
        int[] data = plr.GetData();
        int stars = level.GetRequirements(plr.getDifficulty(),plr.getScore());
       // stars = 3;
        TextLable Diff = new TextLable("Mode: "+plr.getDifficultyAsString());
        Diff.setSize(200, 40);
        Diff.setLocation(410, 30);
        Diff.setFont(new Font("Comic Sans MS", 1, 20));
        Diff.CenterText();
        Diff.setOpaque(false);
        Diff.setForeground(new Color(0,0,0));

        TextLable lev = new TextLable("Level: "+level.GetName());
        lev.setSize(160, 40);
        lev.setLocation(0, 30);
        lev.setFont(new Font("Comic Sans MS", 1, 20));
        lev.CenterText();
        lev.setOpaque(false);
        lev.setForeground(new Color(0,0,0));

        TextLable s1 = new TextLable("" + starReq[0]);
        s1.setSize(100, 40);
        s1.setLocation(100, 220);
        s1.setFont(new Font("Comic Sans MS", 1, 20));
        s1.CenterText();
        s1.setOpaque(false);
        s1.setForeground(new Color(255, 204, 0));

        TextLable s2 = new TextLable("" + starReq[1]);
        s2.setSize(100, 40);
        s2.setLocation(240, 220);
        s2.setFont(new Font("Comic Sans MS", 1, 20));
        s2.CenterText();
        s2.setOpaque(false);
        s2.setForeground(new Color(255, 204, 0));

        TextLable s3 = new TextLable("" + starReq[2]);
        s3.setSize(100, 40);
        s3.setLocation(380, 220);
        s3.setFont(new Font("Comic Sans MS", 1, 20));
        s3.CenterText();
        s3.setOpaque(false);
        s3.setForeground(new Color(255, 204, 0));

        if (1 <= stars){
            ImageLable star = new ImageLable("assets/Images/Winscreen/Star.png");
            star.setSize(128, 128);
            star.SetImageSize(128, 128);
            star.setLocation(90, 85);
            add(star);
        }
        if (2 <= stars){
            ImageLable star = new ImageLable("assets/Images/Winscreen/Star.png");
            star.setSize(128, 128);
            star.SetImageSize(128, 128);
            star.setLocation(90+140, 85);
            add(star);
        }
        if (3 <= stars){
            ImageLable star = new ImageLable("assets/Images/Winscreen/Star.png");
            star.setSize(128, 128);
            star.SetImageSize(128, 128);
            star.setLocation(90+140*2, 85);
            add(star);
        }

        TextLable Orders = new TextLable("Orders Delivered x "+data[1]);
        Orders.setSize(400, 40);
        Orders.setLocation(30, 300+10);
        Orders.setFont(new Font("Comic Sans MS", 1, 20));
        Orders.setOpaque(false);
        Orders.setForeground(new Color(0,0,0));

        TextLable OrdersINFO = new TextLable(""+data[0]);
        OrdersINFO.setSize(100, 40);
        OrdersINFO.setLocation(450, 300+10);
        OrdersINFO.setFont(new Font("Comic Sans MS", 1, 20));
        OrdersINFO.setOpaque(false);
        OrdersINFO.RightAlignText();
        OrdersINFO.setForeground(new Color(0,0,0));

        TextLable Tips = new TextLable("Tips");
        Tips.setSize(400, 40);
        Tips.setLocation(30, 340+10);
        Tips.setFont(new Font("Comic Sans MS", 1, 20));
        Tips.setOpaque(false);
        Tips.setForeground(new Color(99,220,75));

        TextLable TipsINFO = new TextLable(""+data[2]);
        TipsINFO.setSize(100, 40);
        TipsINFO.setLocation(450, 340+10);
        TipsINFO.setFont(new Font("Comic Sans MS", 1, 20));
        TipsINFO.setOpaque(false);
        TipsINFO.RightAlignText();
        TipsINFO.setForeground(new Color(99,220,75));

        TextLable Failed = new TextLable("Orders Failed x "+data[4]);
        Failed.setSize(400, 40);
        Failed.setLocation(30, 380+10);
        Failed.setFont(new Font("Comic Sans MS", 1, 20));
        Failed.setOpaque(false);
        Failed.setForeground(new Color(230,8,8));

        TextLable FailedInfo = new TextLable(""+data[3]);
        FailedInfo.setSize(100, 40);
        FailedInfo.setLocation(450, 380+10);
        FailedInfo.setFont(new Font("Comic Sans MS", 1, 20));
        FailedInfo.setOpaque(false);
        FailedInfo.RightAlignText();
        FailedInfo.setForeground(new Color(230,8,8));

        TextLable Total = new TextLable("TOTAL:");
        Total.setSize(400, 40);
        Total.setLocation(30, 480);
        Total.setFont(new Font("Comic Sans MS", 1, 30));
        Total.setOpaque(false);
        Total.setForeground(new Color(0,0,0));

        TextLable TotalInfo = new TextLable(""+plr.getScore());
        TotalInfo.setSize(200, 80);
        TotalInfo.setLocation(340, 470);
        TotalInfo.setFont(new Font("Comic Sans MS", 1, 40));
        TotalInfo.setOpaque(false);
        TotalInfo.RightAlignText();
        
        TotalInfo.setForeground(new Color(0,0,0));

        Frame retryFrame = new Frame();
        retryFrame.setSize(180, 100);
        retryFrame.setLocation(40, 580);
        retryFrame.setOpaque(false);

        Frame HomeFrame = new Frame();
        HomeFrame.setSize(180, 100);
        HomeFrame.setLocation(345, 580);
        HomeFrame.setOpaque(false);

        retryFrame.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e) {
                System.out.println("clicked");
                Memory.player.Command = 1;
                retryFrame.removeMouseListener(this);

            }
        });
        add(HomeFrame);
        add(retryFrame);
        add(Total);
        add(TotalInfo);
        add(Failed);
        add(FailedInfo);
        add(Tips);
        add(TipsINFO);
        add(OrdersINFO);
        add(Orders);
        add(lev);
        add(Diff);
        add(s3);
        add(s2);
        add(s1);
        add(bg);
        repaint();
    }
}
