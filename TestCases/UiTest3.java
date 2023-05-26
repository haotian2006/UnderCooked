import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import Classes.Game;
import PremadeElements.*;
import UiClasses.*;
public class UiTest3 {
    public static void main(String[] args) {
        ScreenGui ui = new ScreenGui("UnderCooked");
        StartScreen x = new StartScreen(new Game(ui));
        ui.FullScreen();
        ui.setBackground(new Color(187, 255, 177));
        ui.add(x);

    }
}