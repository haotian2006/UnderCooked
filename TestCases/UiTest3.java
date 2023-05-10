import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import PremadeElements.*;
import UiClasses.*;
public class UiTest3 {
    public static void main(String[] args) {
        StartScreen x = new StartScreen();
        ScreenGui ui = new ScreenGui("UnderCooked");
        ui.FullScreen();
        ui.setBackground(new Color(187, 255, 177));
        ui.add(x);

    }
}