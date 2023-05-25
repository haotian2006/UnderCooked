package PremadeElements; 
import java.awt.Color;
import java.awt.Font;
import java.awt.Point;

import UiClasses.*;
import easingTypes.*;; 
public class StartScreen extends Frame{
    private ImageLable i1;
    private ImageLable i2;
    private ImageLable i3;
    private TextLable Total;
    private TextLable LevelName;
    private TextLable Difficulty;
    public static int CurrentFrame =0;
    public StartScreen(){
        super(); 
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

        ImageLable Choose = new ImageLable("assets/Images/Menu/Title/Choose.png");
        Choose.setSize(1209, 550);
        Choose.SetImageSize(1209, 550);
        Choose.SetCenter(new Point(Center.x, Center.y+100));

        ImageLable Stars = new ImageLable("assets/Images/Menu/Title/Stars.png");
        Stars.setSize(162, 70);
        Stars.SetImageSize(162, 70);
        Stars.setLocation(new ScreenSize().Get().x-162, 10);

        ImageLable HTP = new ImageLable("assets/Images/Menu/Title/HTP.png");
        HTP.setSize(30, 30);
        HTP.SetImageSize(30, 30);
        HTP.setLocation(10, new ScreenSize().Get().y-40);
        add(HTP);
        UiTween ChooseTween = new UiTween(Choose,EaseFunc.Bounce, EaseType.easeOut);

        i1 = new ImageLable("assets/Images/Levels/Test.png");
        i1.setSize(260, 190);
        i1.SetImageSize(260, 190);
        i1.SetCenter(new Point(Center.x-469, +615));

        add(i1);

        i2 = new ImageLable("assets/Images/Levels/Test.png");
        i2.setSize(551, 410);
        i2.SetImageSize(551, 410);
        i2.SetCenter(new Point(Center.x, +620));
        add(i2);

        i3 = new ImageLable("assets/Images/Levels/Test.png");
        i3.setSize(260, 190);
        i3.SetImageSize(260, 190);
        i3.SetCenter(new Point(Center.x+469, +615));
        add(i3);

        Total = new TextLable("Requires: 0 Star(s)");
        Total.setSize(400, 40);
        Total.setLocation(650, 380);
        Total.setFont(new Font("Comic Sans MS", 1, 20));
        Total.setOpaque(false);
        Total.setForeground(Color.white);

        LevelName = new TextLable("Level: 1");
        LevelName.setSize(400, 40);
        LevelName.setLocation(870, 380);
        LevelName.setFont(new Font("Comic Sans MS", 1, 20));
        LevelName.setOpaque(false);
        LevelName.RightAlignText();
        LevelName.setForeground(Color.white);

        
        Difficulty = new TextLable("Difficulty: Normal");
        Difficulty.setSize(110, 40);
        Difficulty.setLocation(647, 870);
        Point DCent = Difficulty.GetCenter();
        Difficulty.setSize(200, 40);
        Difficulty.SetCenter(DCent);
        Difficulty.setFont(new Font("Comic Sans MS", 1, 12));
        Difficulty.setOpaque(false);
        Difficulty.CenterText();
        Difficulty.setForeground(Color.white);

        add(Difficulty);
        add(LevelName);
        add(LevelName);
        add(Total);
        add(Stars);
        add(Choose);
        add(By);
        ByTween.Play(TweenProperty.TweenLocation, new Point(ScreenSize.Get().x+800, CenterOfBy.y), CenterOfBy, 2);
        TitleTween.Play(TweenProperty.TweenLocation, new Point(CenterOfTitle.x, CenterOfTitle.y-800), CenterOfTitle, 2);
        ChooseTween.Play(TweenProperty.TweenLocation, new Point(Choose.getLocation().x, Center.y+800), Choose.getLocation(), 2);
    }
    public void UpdateFrame(int x){

    }
} 