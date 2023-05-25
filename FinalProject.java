
import Classes.*;
import UiClasses.*;

import java.awt.Color;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import PremadeElements.*;
import java.io.File; 

public class FinalProject {
    public static boolean TestMode = false;
    public static ScheduledExecutorService MainLoop;
    public static ScreenGui screen;
    public static WinScreen ws;
    public static void StartMainLoop(double seconds){
      Player plr = Memory.player;
      Memory.player.first = false;
      // this creates a loop that will update every counter every .01 seconds 
      // using this type of loop because sleep has some yielding issue and weird delay
        Thread thread = new Thread(() -> {
          MainLoop = Executors.newScheduledThreadPool(1);
          long interval = 10;
          double[] timeLeft ={seconds};//just doing seconds-=0.01 causes a scope error so we have to make it into a array
          boolean[] Lost = new boolean[1];//we have to use a array here because you can't get outside vars from inside of a new thread
          MainLoop.scheduleAtFixedRate(() -> {
              if (!Memory.player.GetInGame() || false){//if the game ended then stop the loop
                Lost[0] = true;
                MainLoop.shutdown();
              }
              Memory.Kitchen.Update(Memory.player.GetMouse());
              Memory.player.SetTimer(timeLeft[0]);
              timeLeft[0] -= .01;
              Memory.Kitchen.UpdateAll();
              Memory.player.Update();


          }, 0, interval, TimeUnit.MILLISECONDS);
          try {
            MainLoop.awaitTermination((long)(seconds*1000), TimeUnit.MILLISECONDS);
          } catch (InterruptedException e) {
          }
          MainLoop.shutdown();
          Memory.player.SetInGame(false);
          if (Lost[0]){
            ws = new LoseScreen();
            screen.add(ws,0);
            screen.repaint();
          }else{
            ws = new WinScreen();
            screen.add(ws,0);
            screen.repaint();

            //increase stars 
           plr.SetLevelData(Memory.Kitchen.GetLevel().GetRequirements(plr.getDifficulty(), plr.getScore()));
           while (plr.Command == 0) {try {Thread.sleep(500);} catch (Exception e) {} } // until the player inputs an command after game has ended 
           switch(plr.Command){
              case 1:
               // retry 
                StartLevel(plr.getDifficulty(), Memory.Kitchen.GetLevel().GetName());
                break;
              default:
                break;
           }
          }
          //System.out.println("Ended");
         //end game
      });
      thread.start();


    }
    public static void StartLevel(int difficulty, String Level_){
        if (ws != null) {screen.remove(ws); ws = null;}
        Memory.Kitchen.Reset();
        Player plr = Memory.player;
        screen.repaint();
        plr.Command = 0;
        plr.setDifficulty(difficulty);
        Level level = Level.newLevel(Level_);
        LevelLoadScreen LL = new LevelLoadScreen(level);
        screen.add(LL,0);
        screen.repaint();
        plr.Clear();//this would reset the players temporary data 
        Memory.Kitchen.LoadLevel(level);
        LL.WaitTillLoaded();
        screen.remove(LL);
        Memory.Kitchen.GetBackgroundFrame().setVisible(true);
        Frame Clickable = Memory.Kitchen.getClickFrame();
        screen.repaint();
        plr.SetInGame(true);
        StartMainLoop(level.GetTimeLimit());
    }
    
    public static void main(String[] args) {
        RemoveAllDesktop.Destroy();

        Player player = new Player("bob");   
        screen = new ScreenGui("Under Cooked");
        Kitchen kitchen = new Kitchen(screen);
        Memory.SetPlayer(player);
        Memory.SetKitchen(kitchen);
        screen.FullScreen();
        screen.setBackground(new Color(187, 255, 177));
        if (TestMode){
          StartLevel(0,"Test");
        }else{
          LoadingScreen x = new LoadingScreen();
          screen.setBackground(new Color(187, 255, 177));
          screen.add(x);
          screen.repaint();
          x.WaitTillLoaded();
          x.CloseAnimation();
          StartScreen sS = new StartScreen();
          screen.remove(x);
          screen.add(sS);
          screen.repaint();
        }
    }
}



//this function is to destroy  desktop.ini files created by google drive so it doesn't break some scripts 
class RemoveAllDesktop {
    public static void Destroy() {
        String currentDir = System.getProperty("user.dir");
        String parentDir = new File(currentDir).getParent();
        deleteDesktopIniFiles(parentDir);
    }

    private static void deleteDesktopIniFiles(String directory) {
        File dir = new File(directory);
        File[] files = dir.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isDirectory()) {
                    deleteDesktopIniFiles(file.getAbsolutePath());
                } else if (file.getName().equals("desktop.ini")) {
                    file.delete();
                }
            }
        }
    }
} 