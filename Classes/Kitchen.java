package Classes;
import java.awt.Color;
import java.awt.Dimension;
import java.io.Serializable;
import java.nio.channels.Pipe;

import Counters.counter;

import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

import UiClasses.*;
import PremadeElements.*;
public class Kitchen implements Serializable{
    public static int TileSize =70; // how many pixels per tile
    public static int ItemSize = 55; // how many pixels are the items.
    public static int MaxOrders =8; //how many orders should be on screen

    //1/x chance of order every .01 seconds  
    public static int[] Rate = {
        750,600,500
    };
    public static int[] OrderLasts = {
        60,50,40
    };//how many seconds do orders last

    //how long can something over cook
    public static int[] maxBurnTime = {
        15,10,7
    };
    
    //how much you should loose
    public static int[] loseAmt ={
        10,15,20
    };
    public static int GetLoseAmt(){
        int i = Memory.player.getDifficulty();
        return loseAmt[i];
    }
    public static int GetRate(){
        int i = Memory.player.getDifficulty();
        return Rate[i];
    }
    public static int GetMaxTime(){
        int i = Memory.player.getDifficulty();
        return OrderLasts[i];
    }
    public static int  GetMaxBurnTime(){
        int i = Memory.player.getDifficulty();
        return maxBurnTime[i];
    }
    private TAS Timer;
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
        Clickable = new Frame("Clickable");
        display = x;
        Memory.SetKitchen(this);
    } 
    public ScreenGui GetDisplay(){
        return display;
    }
    public void LoadLevel(Level x){
        if (BackgroundFrame != null) display.remove(BackgroundFrame);
        if (Timer != null) display.remove(Timer);
        Timer = new TAS();

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
        BackgroundFrame.setVisible(false);
        Holding = new HoldableElement();
        display.add(BackgroundFrame, 1);
        Clickable.setSize((x.getGrid().GetSize().width)*TileSize,(x.getGrid().GetSize().height)*TileSize);
        Clickable.setLocation(TileSize, TileSize);
        Clickable.setBackground(Color.LIGHT_GRAY);
        Clickable.setOpaque(false);
        Clickable.addMouseListener(MouseButton); 
        Clickable.addMouseMotionListener(MouseMove);
        BackgroundFrame.add(Clickable, 0);
        BackgroundFrame.add(Holding,1);
        OrdersBar = new OrdersBar();
        Draw();
        display.add(Timer,0);
        display.add(OrdersBar,1);
        
    }
    public OrdersBar getOrdersBar(){
        return OrdersBar;
    }
    public Frame getClickFrame(){
        return Clickable;
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
        Color Bg = level.GetColor(0);   Bg = Bg != null ?Bg : new Color(109, 226, 125);
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
        Timer.Update(Memory.player);
    }
    public void Reset(){
        if (BackgroundFrame != null) {BackgroundFrame.removeAll(); display.remove(BackgroundFrame);}
        if (Timer != null) display.remove(Timer);
        if (OrdersBar != null) display.remove(OrdersBar);
        UiGrid = null;
        if (Clickable != null){
            Clickable.removeMouseListener(MouseButton); 
            Clickable.removeMouseMotionListener(MouseMove);
        }
    }

    public static MouseAdapter MouseButton = new MouseAdapter() {
        // on input 
        public static Point GetGrid(Point loc){
            return new Point(loc.x/Kitchen.TileSize, loc.y/Kitchen.TileSize);
        }
        public void mousePressed(MouseEvent me) { 
            Player plr = Memory.player;
          if (!plr.GetInGame())return;
          Point loc = GetGrid(me.getPoint());
          TileElement counterEle = Memory.Kitchen.GetTileAt(loc);
          if (counterEle == null){ return;}
          Counter counter = counterEle.getCounter();
          if (counter == null) {return;}
          if (me.getButton() == MouseEvent.BUTTON1){
              counter.OnInteract(plr,"Left");
              Memory.Kitchen.UpdateHolding(plr);
          }else if(me.getButton() == MouseEvent.BUTTON3){
            plr.SetCounter(counter);
            counter.OnInteract(plr,"Right");
            Memory.Kitchen.UpdateHolding(plr);
          }
        }
        // on input ended
        public void mouseReleased(MouseEvent me) { 
            Player plr = Memory.player;
          if (!plr.GetInGame())return;
          if (me.getButton() == MouseEvent.BUTTON1){
          
          }
          else if(me.getButton() == MouseEvent.BUTTON3){
            plr.SetCounter(null);
          }
      } 

      };
    public static MouseMotionListener MouseMove = new MouseMotionListener() {
        public void mouseDragged(MouseEvent e) {
            Player plr = Memory.player;
          if (!plr.GetInGame())return;
          plr.SetMouse(e.getPoint());
          //Memory.Kitchen.Update(e.getPoint());
        }
        public void mouseMoved(MouseEvent e) {
            Player plr = Memory.player;
          if (!plr.GetInGame())return;
          plr.SetMouse(e.getPoint());
         //Memory.Kitchen.Update(e.getPoint());
        }
      };
  
}
