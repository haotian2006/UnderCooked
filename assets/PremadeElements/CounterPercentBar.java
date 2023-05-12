package PremadeElements;

import UiClasses.*;

import java.awt.Color;

import javax.swing.BorderFactory;
import Classes.*;
import java.awt.Point;
public class CounterPercentBar extends Frame{
    private Frame SubBar;
    public CounterPercentBar(){
        super("PercentBar");
        setSize(Kitchen.TileSize, Kitchen.TileSize/4);
        setBorder(BorderFactory.createMatteBorder(1,1,1,1,Color.black));
        setOpaque(false);
        SubBar = new Frame("SubBar");
        add(SubBar);        
    }
    public void UpdateSize(double percent){
        SubBar.setSize((int) (Kitchen.TileSize*percent),Kitchen.TileSize/4);
    }
    public void setPosFromGrid(int x,int y){
        SetCenter(new Point(x* Kitchen.TileSize,y* Kitchen.TileSize));
    }

}
