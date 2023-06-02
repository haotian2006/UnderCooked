package PremadeElements;
import UiClasses.*;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Point;

import Classes.*;
public class LoseScreen extends WinScreen {
    public LoseScreen() {
        super();
        ImageLabel Fired = new ImageLabel("assets/Images/Winscreen/FiredStamp.png");
        Fired.setSize(449, 342);
        Fired.SetImageSize(449, 342);
        Fired.setLocation(75, 250);

        ImageLabel FiredTxt = new ImageLabel("assets/Images/Winscreen/txtN.png");
        Dimension size = new Dimension(((int) (422/1.5)), ((int) (58/1.5)));
        FiredTxt.setSize(size);
        FiredTxt.SetImageSize(size);
        FiredTxt.SetCenter(new Point(585/2, 90));

        Frame cross = new Frame();
        cross.setSize(500, 5);
        cross.setLocation(42, 150);
        cross.setBackground(Color.red);

        add(Fired,0);
        add(FiredTxt,0);
        add(cross,0);
        repaint();
    }
}
