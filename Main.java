
import Classes.*;
import UiClasses.*;

import java.awt.Color;


public class Main {
    public static boolean TestMode = true;
    
    public static void main(String[] args) {
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
            game.Start();
        }else{
          game.Start();
        }
    }
}


