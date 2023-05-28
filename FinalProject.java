
import Classes.*;
import UiClasses.*;

import java.awt.Color;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import PremadeElements.*;
import java.io.File; 

public class FinalProject {
    public static boolean TestMode = true;
    
    public static void main(String[] args) {
        RemoveAllDesktop.Destroy();
        Player player;
        if (TestMode){
          player = new Player("TEST_MODE");
        }else{
           player = new Player("Some guy");   
        }
        ScreenGui screen = new ScreenGui("Under Cooked");
        Kitchen kitchen = new Kitchen(screen);
        Memory.SetPlayer(player);
        Memory.SetKitchen(kitchen);
        Game game = new Game(screen);
        Memory.SetGame(game);
        screen.FullScreen();
        screen.setBackground(new Color(187, 255, 177));
        if (TestMode){
          game.StartLevel(2,"BurgerPlace");
        }else{
          game.Start();
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