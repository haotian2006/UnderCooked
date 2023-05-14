import java.awt.Color;

import Classes.*;
import UiClasses.*;
import UiClasses.ScreenGui;
import Levels.*;
public class KitchenTestCase {
    public static void main(String[] args) {
        ScreenGui ui = new ScreenGui("UnderCooked");
        ui.FullScreen();
        ui.setBackground(new Color(187, 255, 177));
        Kitchen y = new Kitchen(ui);
        y.LoadLevel(new Template());
    }
}
