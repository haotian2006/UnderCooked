package PremadeElements;

import UiClasses.*;

import java.awt.Color;

import javax.swing.BorderFactory;
import Classes.*;
import java.awt.Point;
import java.nio.channels.Pipe;

import easingTypes.*;
public class CookedPercentage extends Frame{
    private Frame SubBar;
    private ImageLabel Caution;
    private double time;
    private boolean CaVisible;
    public CookedPercentage(){
        super("PercentBar");
        setSize(Kitchen.TileSize, Kitchen.TileSize);
       // setBorder(BorderFactory.createMatteBorder(1,1,1,1,Color.black));
        setOpaque(false);
        setBackground(new Color(189, 189, 189));
        SubBar = new Frame("SubBar");
        SubBar.setBackground(Color.GREEN);
        SubBar.setLocation(0, Kitchen.TileSize/2+Kitchen.TileSize/3+2);
        Caution = new ImageLabel("assets/Images/Other/Caution.png");
        Caution.setSize(Kitchen.TileSize/2, Kitchen.TileSize/2);
        Caution.SetImageSize(Kitchen.TileSize/2, Kitchen.TileSize/2);
        Caution.setVisible(false);
        Caution.SetCenter(GetCenter());
        time = System.nanoTime();
        add(Caution,0);
        add(SubBar,1);        
    }
    public double GetFlashSpeed(double percent){
        return (2 - percent) * .5;
    }
    public void UpdateSize(double percent){
        SubBar.setSize((int) (Kitchen.TileSize*percent),Kitchen.TileSize/4);
        if(percent>1){
            UiTween colorTween = new UiTween(SubBar, EaseFunc.Linear, EaseType.easeNone);
            colorTween.TweenBackgroundColor(Color.green, Color.red, percent-1);
        }else{
            Caution.setVisible(false);
            CaVisible = false;
            SubBar.setBackground(Color.GREEN);
        }
    }
    public double UpdatePercentage(double current,double target){
        double maxOvercook = Memory.Kitchen.GetMaxBurnTime();
        double percent = current/target;
        if (percent>1.01){
            percent = 1+(current-target)/maxOvercook;
            double interval = GetFlashSpeed(percent);
           // System.out.println(percent);
            if ((System.nanoTime() - time)/ 1000000000.0 >= interval && percent < 1.99999){
                Caution.setVisible( CaVisible = !CaVisible);
                time = System.nanoTime();
            }else if(percent >= 1.99999){
                Caution.SetImage("assets/Images/Other/Fire.png");
                Caution.setVisible( CaVisible = true);
                Memory.player.SetInGame(2);
            }
        }

        UpdateSize(percent);
        return percent;
    }
}
