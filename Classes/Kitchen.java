package Classes;
import java.awt.Color;
import java.io.Serializable;
import java.nio.channels.Pipe;

import UiClasses.*;
import PremadeElements.*;
public class Kitchen implements Serializable{
    public static int TileSize =70; // how many pixels per tile
    private Grid grid;
    private Frame[][] UiGrid;
    private Frame BackgroundFrame;
    private Frame HoldingFrame;
    private ScreenGui display;
    private Frame Clickable;
    private Level level;
    private double[] maxBurnTime = {

    };

    public Kitchen(ScreenGui x){
        display = x;
        Memory.SetKitchen(this);
    } 
    public Kitchen(){
        Memory.SetKitchen(this);
    }
    public ScreenGui GetDisplay(){
        return display;
    }
    public void LoadLevel(Level x){
        if (BackgroundFrame != null) display.remove(BackgroundFrame);
        level = x;
        display.setBackground(new Color(0, 153, 0));
        grid = DeepCopy.copy(x.getGrid());
        int xSize = (x.getGrid().GetSize().width+2)*TileSize;
        int ySize = (x.getGrid().GetSize().height+2)*TileSize;

        BackgroundFrame = new Frame("Kitchen");
        BackgroundFrame.setSize(xSize,ySize);
        BackgroundFrame.SetCenter(new ScreenSize().GetCenter());
        BackgroundFrame.setBackground(Color.DARK_GRAY);
        display.add(BackgroundFrame, 0);

        Clickable = new Frame("Clickable");
        Clickable.setSize(xSize,ySize);
        Clickable.setBackground(Color.LIGHT_GRAY);
        Clickable.setOpaque(false);
        BackgroundFrame.add(Clickable, 0);
        Draw();
        
    }
    public double GetMaxBurnTime(int diff){
        return 1;
    }
    public double GetMaxBurnTime(){
        return 5;
    }
    public void Draw(){
        Color Bg = level.GetColor(0);   Bg = Bg != null ?Bg : new Color(0, 153, 0);
        Color wall = level.GetColor(1); wall = wall != null ?wall : new Color(182, 91, 0);
        Color White = level.GetColor(2);White = White != null ?White : Color.WHITE;
        Color Black = level.GetColor(3);Black = Black != null ?Black : Color.black;
        display.setBackground(Bg);
        for (int x = 0;x<grid.GetSize().width+2;x++){
            for (int y = 0;y<grid.GetSize().height+2;y++){
                Counter counter = grid.GetAt(x, y);
                if (counter == null) {
                    TileElement tile = new TileElement();
                    if (x ==0 || y==0 ||x == grid.GetSize().width+1 || y == grid.GetSize().height+1){
                        tile.setBackground(wall);
                    }else{
                        tile.setBackground((x + y) % 2 == 0 ? Black : White);
                    }
                    BackgroundFrame.add(tile);
                    tile.setLocation((x)*TileSize, (y)*TileSize);
                }else{
                    TileElement tile = new TileElement(counter);
                    BackgroundFrame.add(tile,1);
                    tile.setLocation((x)*TileSize, (y)*TileSize);
                }   
            }
        }
        display.repaint();
    }

}
