import Classes.*;
import UiClasses.*;
import Levels.*;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.awt.Point;
import PremadeElements.*;
public class FinalProject {
    public static Point GetGrid(Point loc){
        return new Point(loc.x/Kitchen.TileSize, loc.y/Kitchen.TileSize);
    }
    public static ScheduledExecutorService MainLoop;
    public static void StartMainLoop(double seconds){
      // this creates a loop that will update every counter every .01 seconds 
      // using this type of loop because sleep has some yielding issue and weird delay
        Thread thread = new Thread(() -> {
          MainLoop = Executors.newScheduledThreadPool(1);
          long interval = 10;
          double[] timeLeft ={seconds};//just doing seconds-=0.01 causes a scope error so we have to make it into a array
          MainLoop.scheduleAtFixedRate(() -> {
              if (!Memory.player.GetInGame()){//if the game ended then stop the loop
                MainLoop.shutdown();
                System.out.println("End");System.out.println("End");
              }

              Memory.player.SetTimer(timeLeft[0]);
              timeLeft[0] -= .01;

              Memory.Kitchen.UpdateAll();

          }, 0, interval, TimeUnit.MILLISECONDS);
          try {
            MainLoop.awaitTermination((long)(seconds*1000), TimeUnit.MILLISECONDS);
          } catch (InterruptedException e) {
          }
          MainLoop.shutdown();
          Memory.player.SetInGame(false);
          System.out.println("End");
         //end game
      });
      thread.start();
    }
    public static void StartGame(int difficulty, int levelNum){
        Level level = new Template();
        Memory.Kitchen.LoadLevel(level);
        Frame Clickable = Memory.Kitchen.getClickFrame();
        Player plr = Memory.player;
        Clickable.addMouseListener(new MouseAdapter() {
          // on input 
          public void mousePressed(MouseEvent me) { 
            Point loc = GetGrid(me.getPoint());
            TileElement counterEle = Memory.Kitchen.GetTileAt(loc);
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
            if (me.getButton() == MouseEvent.BUTTON1){
            
            }
            else if(me.getButton() == MouseEvent.BUTTON3){
              plr.SetCounter(null);
            }
        } 

        }); 
        Clickable.addMouseMotionListener(new MouseMotionListener() {
          public void mouseDragged(MouseEvent e) {
            Memory.Kitchen.Update(e.getPoint());
          }
          public void mouseMoved(MouseEvent e) {
           Memory.Kitchen.Update(e.getPoint());
          }
        });
        plr.SetInGame(true);
        StartMainLoop(level.GetTimeLimit());

    }

    
    public static void main(String[] args) {
        Player player = new Player("bob");   
        ScreenGui screen = new ScreenGui("Under Cooked");
        Kitchen kitchen = new Kitchen(screen);
        Memory.SetPlayer(player);
        Memory.SetKitchen(kitchen);
        screen.FullScreen();
        screen.setBackground(new Color(187, 255, 177));
        StartGame(1,1);
    }
}
