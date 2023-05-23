package Classes;
import java.awt.Color;
import java.awt.Dimension;
import java.io.Serializable;
import java.nio.channels.Pipe;

import Counters.counter;

import java.awt.Point;
import UiClasses.*;
import PremadeElements.*;
public class Kitchen implements Serializable{
    public static int TileSize =70; // how many pixels per tile
    public static int ItemSize = 55; // how many pixels are the items.
    public static int MaxOrders =8; //how many orders should be on screen
    public static int[] Rate = {

    };
    public static int[] OrderLasts = {

    };//how many seconds do orders last

    public double[] maxBurnTime = {

    };
    public static int GetRate(){
        return 750;
    }
    public static int GetMaxTime(){
        return 60;
    }
    private Grid grid;
    private TileElement[][] UiGrid;
    private Frame BackgroundFrame;
    private Frame HoldingFrame;
    private ScreenGui display;
    private Frame Clickable;
    private Level level;
    public HoldableElement Holding;
    private OrdersBar OrdersBar;


    public Kitchen(ScreenGui x){
        display = x;
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
        UiGrid = new TileElement[xSize][ySize];
        BackgroundFrame = new Frame("Kitchen");
        BackgroundFrame.setSize(xSize,ySize);
        BackgroundFrame.SetCenter(new ScreenSize().GetCenter());
        BackgroundFrame.setBackground(Color.DARK_GRAY);
        Holding = new HoldableElement();
        display.add(BackgroundFrame, 1);
        Clickable = new Frame("Clickable");
        Clickable.setSize((x.getGrid().GetSize().width)*TileSize,(x.getGrid().GetSize().height)*TileSize);
        Clickable.setLocation(TileSize, TileSize);
        Clickable.setBackground(Color.LIGHT_GRAY);
        Clickable.setOpaque(false);
        BackgroundFrame.add(Clickable, 0);
        BackgroundFrame.add(Holding,1);
        OrdersBar = new OrdersBar();
        Draw();
        display.add(OrdersBar,1);
        display.repaint();
        
    }
    public OrdersBar getOrdersBar(){
        return OrdersBar;
    }
    public Frame getClickFrame(){
        return Clickable;
    }
    public double GetMaxBurnTime(int diff){
        return 1;
    }
    public double GetMaxBurnTime(){
        return 15;
    }
    public TileElement GetTileAt(Point loc){
        return UiGrid[loc.x+1][loc.y+1];
    }
    public TileElement GetTileFromName(String x){
        for (int xx = 0;xx<UiGrid.length;xx++){
            for (TileElement TE: UiGrid[xx]){
                if (TE!= null && TE.getCounter() != null && TE.getCounter().GetName().equals(x)){
                    return TE;
                }
            }
        }
        return null;
    }
    public void Draw(){
        //this defines the colors
        Color Bg = level.GetColor(0);   Bg = Bg != null ?Bg : new Color(0, 153, 0);
        Color wall = level.GetColor(1); wall = wall != null ?wall : new Color(182, 91, 0);
        Color White = level.GetColor(2);White = White != null ?White : Color.WHITE;
        Color Black = level.GetColor(3);Black = Black != null ?Black : Color.black;

        display.setBackground(Bg);
        for (int x = 0;x<grid.GetSize().width+2;x++){
            for (int y = 0;y<grid.GetSize().height+2;y++){
                Counter counter = grid.GetAt(x, y);
                {
                    TileElement tile = new TileElement();
                    if (x ==0 || y==0 ||x == grid.GetSize().width+1 || y == grid.GetSize().height+1){
                        //if its the outline then create a wall with the color
                        tile.setBackground(wall);
                    }else{
                        //if x coords + y coords is even then load a black tile else load white
                        tile.setBackground((x + y) % 2 == 0 ? Black : White);
                    }
                    BackgroundFrame.add(tile);
                    tile.setLocation((x)*TileSize, (y)*TileSize);
                }

                if (counter != null){
                    //if there is a counter on the tile then load the counter 
                    TileElement tile = new TileElement(counter);
                    BackgroundFrame.add(tile,2);
                    tile.setLocation((x)*TileSize, (y)*TileSize);
                    counter.SetFrame(tile);
                    UiGrid[x][y] = tile;
                }   
            }
        }
    }
    public Level GetLevel(){
        return level;
    }
    public HoldableElement GetFrame(){
        return Holding;
    }
    public void UpdateFrame(HoldableElement x){
        Holding = x;
    }
    public Frame GetBackgroundFrame(){
        return BackgroundFrame;
    }
    public void UpdateHolding(Player x){
        if (Holding != null){
            Holding.UpdateItem(x.getHolding()); 
        }
    }
    public void Update(Point loc){
        if (Holding != null){
            Holding.SetCenter(new Point(loc.x + TileSize, loc.y +TileSize));
        }
    }
    public void UpdateAll(){
        Counter[][] gridA = grid.GetGrid();
        for (int x = 0;x< gridA.length;x++ ){
            for (Counter c:gridA[x]){
                if (c == null) continue;
                c.Update();
            }
        }
    }

}
