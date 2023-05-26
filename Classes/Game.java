package Classes;
import Classes.*;
import UiClasses.*;

import java.awt.Color;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import PremadeElements.*;
import java.io.File; 
//This used to be in Final Project 
public class Game {
    private ScheduledExecutorService MainLoop;
    private ScreenGui screen;
    private WinScreen ws;
    private StartScreen Hub;
    public Player plr;
    public Kitchen kit;
    public void StartMainLoop(double seconds){
        kit.StartTimer();
        Memory.player.first = false;
        // this creates a loop that will update every counter every .01 seconds 
        // using this type of loop because sleep has some yielding issue and weird delay
        Thread thread = new Thread(() -> {
            MainLoop = Executors.newScheduledThreadPool(1);
            long interval = 10;
            double[] timeLeft ={seconds};//just doing seconds-=0.01 causes a scope error so we have to make it into a array
            boolean[] Lost = new boolean[1];//we have to use a array here because you can't get outside vars from inside of a new thread
            MainLoop.scheduleAtFixedRate(() -> {
                if (plr.GetInGame() != 1 || false){//if the game ended then stop the loop
                    Lost[0] = true;
                    MainLoop.shutdown();
                }
                kit.Update(plr.GetMouse());
                plr.SetTimer(timeLeft[0]);
                timeLeft[0] -= .01;
                kit.UpdateAll();
                plr.Update();


            }, 0, interval, TimeUnit.MILLISECONDS);
            try { MainLoop.awaitTermination((long)(seconds*1000), TimeUnit.MILLISECONDS);} catch (InterruptedException e) {}
            MainLoop.shutdown();
            if (plr.GetInGame() == 3) { plr.SetInGame(0); return;}
            plr.SetInGame(0);
            if (Lost[0]){
                ws = new LoseScreen();
                screen.add(ws,0);
                screen.repaint();
            }else{
                ws = new WinScreen();
                screen.add(ws,0);
                screen.repaint();
                //increase stars 
            plr.SetLevelData(kit.GetLevel().GetRequirements(plr.getDifficulty(), plr.getScore()));
            }
            while (plr.Command == 0) {try {Thread.sleep(500);} catch (Exception e) {} } // until the player inputs an command after game has ended 
                new Thread(() -> {
                    switch(plr.Command){
                        case 1:
                        // retry 
                        StartLevel(plr.getDifficulty(), kit.GetLevel().GetName());
                        break;
                    case 2:
                    // home 
                        Hub();
                        break;
                        default:
                        break;
                    }
                }).start();

            //System.out.println("Ended");
            //end game
        });
        thread.start();


    }
    public void Hub(){
        if (ws != null) {screen.remove(ws); ws = null;}
        plr.SetInGame(3);
        kit.Reset();
        screen.repaint();
        screen.add(Hub,0);
        Hub.PlayAnimation();
        screen.repaint();
    }
    public void StartLevel(int difficulty, String Level_){
        new Thread(() -> {
            if (ws != null) {screen.remove(ws); ws = null;}
            screen.remove(Hub);
            kit.Reset();
            screen.repaint();
            plr.Command = 0;
            plr.setDifficulty(difficulty);
            Level level = Level.newLevel(Level_);
            LevelLoadScreen LL = new LevelLoadScreen(level);
            screen.add(LL,0);
            screen.repaint();
            plr.Clear();//this would reset the players temporary data 
            kit.LoadLevel(level);
            LL.WaitTillLoaded();
            screen.remove(LL);
            kit.GetBackgroundFrame().setVisible(true);
            screen.repaint();
            plr.SetInGame(1);
            StartMainLoop(level.GetTimeLimit());
        }).start();
    }
    public void Start(){
        LoadingScreen x = new LoadingScreen();
        screen.setBackground(new Color(187, 255, 177));
        screen.add(x);
        screen.repaint();
        x.WaitTillLoaded();
        x.CloseAnimation();

        screen.remove(x);
        Hub();
    }
    public Game(ScreenGui x){
        screen = x;
        Hub = new StartScreen(this);
        plr = Memory.player;
        kit = Memory.Kitchen;
    }   
}
