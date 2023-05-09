package PremadeElements; 
import java.awt.Color;
import java.awt.Font;

import UiClasses.*; 
public class StartScreen extends Frame{
    public StartScreen(){
        super(null);
        setSize(1200, 800);
        SetCenter(new ScreenSize().GetCenter());
        setBackground(new Color(139, 170, 255));
        
        TextLable Title = new TextLable("UnderCooked");
        Title.setSize(1200, 100);
        Title.setLocation(0, 0);
        Title.CenterText();
        Title.SetFont(new Font("Monospaced", 0, 60));
        Title.setOpaque(false);
        add(Title);
    }
} 