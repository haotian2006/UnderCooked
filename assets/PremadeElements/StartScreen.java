package PremadeElements; 
import java.awt.Color;
import java.awt.Font;
import java.awt.Point;

import UiClasses.*;
import easingTypes.*;; 
public class StartScreen extends Frame{
    public StartScreen(){
        super(null); 
        ScreenSize ScreenSize = new ScreenSize();
        Point Center = ScreenSize.GetCenter();

        setSize(ScreenSize.Get().x,ScreenSize.Get().y);
        setOpaque(false);
        
        ImageLable Title = new ImageLable("assets/Images/Menu/LoadingScreen/LargeTitle.png");
        Title.setSize(395*2+60, 39*2+10);
        Title.SetImageSize(395*2+50, 39*2);
        Title.SetCenter(new Point(Center.x, Center.y-400));
        Point CenterOfTitle = Title.getLocation();
        add(Title);
        UiTween TitleTween = new UiTween(Title,EaseFunc.Bounce, EaseType.easeOut);

        ImageLable By = new ImageLable("assets/Images/Menu/Title/By.png");
        By.setSize(1000/2, 200);
        By.SetImageSize(1000/2, 77/2);
        By.SetCenter(new Point(Center.x, Center.y-330));
        Point CenterOfBy = By.getLocation();
        UiTween ByTween = new UiTween(By,EaseFunc.Bounce, EaseType.easeOut);

        add(By);
        ByTween.Play(TweenProperty.TweenLocation, new Point(ScreenSize.Get().x+800, CenterOfBy.y), CenterOfBy, 2);
        TitleTween.Play(TweenProperty.TweenLocation, new Point(CenterOfTitle.x, CenterOfTitle.y-800), CenterOfTitle, 2);
    }
} 