package PremadeElements; 
import java.awt.Color;
import java.awt.Font;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


import Classes.*;
import UiClasses.*;
import easingTypes.*;; 
public class StartScreen extends Frame{
    private ImageLabel i1;
    private ImageLabel i2;
    private ImageLabel i3;
    private TextLable Total;
    private TextLable LevelName;
    private TextLable Stage;
    private TextLable TotalStars;
    private TextLable Difficulty;
    private ImageLabel Title;
    private ImageLabel By;
    private ImageLabel Stars;
    private ImageLabel Choose;  
    private ImageLabel X; 

    private ImageLabel Star1;
    private ImageLabel Star2;
    private ImageLabel Star3;  
    private Game game;
    public static StartScreen ThisScreen;
    
    public static int CurrentStage =0;
    public StartScreen(Game g){
        super(); 
        ThisScreen = this;
        game = g;
        ScreenSize ScreenSize = new ScreenSize();
        Point Center = ScreenSize.GetCenter();

        setSize(ScreenSize.Get().x,ScreenSize.Get().y);
        setOpaque(false);
        
        Title = new ImageLabel("assets/Images/Menu/LoadingScreen/LargeTitle.png");
        Title.setSize(395*2+60, 39*2+10);
        Title.SetImageSize(395*2+50, 39*2);
        Title.SetCenter(new Point(Center.x, Center.y-400));
        add(Title);

        By = new ImageLabel("assets/Images/Menu/Title/By.png");
        By.setSize(1000/2, 200);
        By.SetImageSize(1000/2, 77/2);
        By.SetCenter(new Point(Center.x, Center.y-330));
        By.setVisible(true);
        
        Choose = new ImageLabel("assets/Images/Menu/Title/Choose.png");
        Choose.setSize(1209, 550);
        Choose.SetImageSize(1209, 550);
        Choose.SetCenter(new Point(Center.x, Center.y+100));

        Stars = new ImageLabel("assets/Images/Menu/Title/Stars.png");
        Stars.setSize(648, 62);
        Stars.SetImageSize(648, 62);
        Stars.SetCenter(new Point(new ScreenSize().GetCenter().x+5, 340));

        TotalStars = new TextLable("10000");
        TotalStars.setSize(400, 40);
        TotalStars.setLocation(835, 325);
        TotalStars.setFont(new Font("Comic Sans MS", 1, 20));
        TotalStars.setOpaque(false);
        TotalStars.RightAlignText();
        TotalStars.setForeground(Color.white);
        add(TotalStars);
        ImageLabel HTP = new ImageLabel("assets/Images/Menu/Title/HTP.png");
        HTP.setSize(30, 30);
        HTP.SetImageSize(30, 30);
        HTP.setLocation(10, new ScreenSize().Get().y-40);
       // add(HTP);

        Star1 = new ImageLabel("assets/Images/Winscreen/Star.png");
        Star1.setSize(50, 50);
        Star1.SetImageSize(50, 50);
        Star1.setLocation(1138, 838);
        add(Star1);

        Star2 = new ImageLabel("assets/Images/Winscreen/Star.png");
        Star2.setSize(50, 50);
        Star2.SetImageSize(50, 50);
        Star2.setLocation(1138+42, 838);
        add(Star2);

        Star3 = new ImageLabel("assets/Images/Winscreen/Star.png");
        Star3.setSize(50, 50);
        Star3.SetImageSize(50, 50);
        Star3.setLocation(1138+43+40, 838);
        add(Star3);

        i1 = new ImageLabel("assets/Images/Levels/Test.png");
        i1.setSize(260, 190);
        i1.SetImageSize(260, 190);
        i1.SetCenter(new Point(Center.x-469, +615));
        add(i1);

        i2 = new ImageLabel("assets/Images/Levels/Test.png");
        i2.setSize(551, 410);
        i2.SetImageSize(551, 410);
        i2.SetCenter(new Point(Center.x, +620));

        i3 = new ImageLabel("assets/Images/Levels/Test.png");
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

        Stage = new TextLable("Stage: 1");
        Stage.setSize(400, 40);
        Stage.setLocation(870, 380);
        Stage.setFont(new Font("Comic Sans MS", 1, 20));
        Stage.setOpaque(false);
        Stage.RightAlignText();
        Stage.setForeground(Color.white);

        
        LevelName = new TextLable("The Test Level");
        LevelName.setSize(400, 40);
        LevelName.SetCenter(new Point(new ScreenSize().GetCenter().x+5, 435));
        LevelName.setFont(new Font("Comic Sans MS", 1, 20));
        LevelName.setOpaque(false);
        LevelName.CenterText();
        LevelName.setForeground(Color.white);
        add(LevelName);
        add(i2);

        
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

        //buttons 
        Frame DifficultyButton = new Frame();
        DifficultyButton.setSize(110, 40);
        DifficultyButton.setSize(120, 50);
        DifficultyButton.SetCenter(new Point(DCent.x, DCent.y-5));
        DifficultyButton.setOpaque(false);
        DifficultyButton.addMouseListener(DifEvent);
        add(DifficultyButton);

        Frame PlayButton = new Frame();
        PlayButton.setSize(180, 70);
        PlayButton.SetCenter(new Point(DCent.x+257, DCent.y-5));
        PlayButton.setOpaque(false);
        PlayButton.addMouseListener(playEvent);
        add(PlayButton);

        X = new ImageLabel("assets/Images/Menu/Title/x.png");
        X.setSize(180, 70);
        X.SetCenter(new Point(DCent.x+257, DCent.y-5));
        X.setOpaque(false);
        X.addMouseListener(playEvent);
        X.setVisible(false);
        add(X);


        Frame LeftButton = new Frame();
        LeftButton.setSize(70, 70);
        LeftButton.SetCenter(new Point(DCent.x+257-130, DCent.y-5));
        LeftButton.setOpaque(false);
        LeftButton.addMouseListener(leftEvent);
        add(LeftButton);

        Frame RightButton = new Frame();
        RightButton.setSize(70, 70);
        RightButton.SetCenter(new Point(DCent.x+257+130, DCent.y-5));
        RightButton.setOpaque(false);
        RightButton.addMouseListener(rightEvent);
        add(RightButton);

        add(Difficulty);
        add(Stage);
        add(Total);
        add(Choose);
        add(Stars);
        add(By);
    }
    public void PlayAnimation(){
        this.setVisible(false);
        Update();
        UiTween ChooseTween = new UiTween(Choose,EaseFunc.Bounce, EaseType.easeOut);
        UiTween TitleTween = new UiTween(Title,EaseFunc.Bounce, EaseType.easeOut);
        UiTween ByTween = new UiTween(By,EaseFunc.Bounce, EaseType.easeOut);

        UiTween i1T = new UiTween(i1,EaseFunc.Bounce, EaseType.easeOut);
        UiTween i2T = new UiTween(i2,EaseFunc.Bounce, EaseType.easeOut);
        UiTween i3T = new UiTween(i3,EaseFunc.Bounce, EaseType.easeOut);

        UiTween Star1T = new UiTween(Star1,EaseFunc.Linear, EaseType.easeOut);
        UiTween Star2T = new UiTween(Star2,EaseFunc.Linear, EaseType.easeOut);
        UiTween Star3T = new UiTween(Star3,EaseFunc.Linear, EaseType.easeOut);

        UiTween TotalT = new UiTween(Total,EaseFunc.Bounce, EaseType.easeOut);
        UiTween LevelNameT = new UiTween(LevelName,EaseFunc.Bounce, EaseType.easeOut);
        UiTween StageT = new UiTween(Stage,EaseFunc.Bounce, EaseType.easeOut);
        UiTween DifficultyT = new UiTween(Difficulty,EaseFunc.Bounce, EaseType.easeOut);


        UiTween StarsT = new UiTween(Stars,EaseFunc.Bounce, EaseType.easeOut);
        UiTween TotalStarsT = new UiTween(TotalStars,EaseFunc.Bounce, EaseType.easeOut);
        
        ScreenSize ScreenSize = new ScreenSize();
        Point Center = ScreenSize.GetCenter();
        ByTween.Play(TweenProperty.TweenLocation, new Point(ScreenSize.Get().x+800, By.getLocation().y), By.getLocation(), 2);
        TitleTween.Play(TweenProperty.TweenLocation, new Point(Title.getLocation().x, Title.getLocation().y-800), Title.getLocation(), 2);

        ChooseTween.Play(TweenProperty.TweenLocation, new Point(Choose.getLocation().x, Center.y+800), Choose.getLocation(), 2);
        TotalT.Play(TweenProperty.TweenLocation, new Point(Total.getLocation().x, Total.getLocation().y+800), Total.getLocation(), 2);
        StageT.Play(TweenProperty.TweenLocation, new Point(Stage.getLocation().x, Stage.getLocation().y+800), Stage.getLocation(), 2);
        LevelNameT.Play(TweenProperty.TweenLocation, new Point(LevelName.getLocation().x, LevelName.getLocation().y+800), LevelName.getLocation(), 2);
        DifficultyT.Play(TweenProperty.TweenLocation, new Point(Difficulty.getLocation().x, Difficulty.getLocation().y+800), Difficulty.getLocation(), 2);
        LevelNameT.Play(TweenProperty.TweenLocation, new Point(LevelName.getLocation().x, LevelName.getLocation().y+800), LevelName.getLocation(), 2);

        i1T.Play(TweenProperty.TweenLocation, new Point(i1.getLocation().x, i1.getLocation().y+800), i1.getLocation(), 2);
        i2T.Play(TweenProperty.TweenLocation, new Point(i2.getLocation().x, i2.getLocation().y+800), i2.getLocation(), 2);
        i3T.Play(TweenProperty.TweenLocation, new Point(i3.getLocation().x, i3.getLocation().y+800), i3.getLocation(), 2);

        TotalStarsT.Play(TweenProperty.TweenLocation, new Point(TotalStars.getLocation().x, TotalStars.getLocation().y-800), TotalStars.getLocation(), 2);
        StarsT.Play(TweenProperty.TweenLocation, new Point(Stars.getLocation().x, Stars.getLocation().y-800), Stars.getLocation(), 2);

        Star1T.Play(TweenProperty.TweenLocation, new Point(Star1.getLocation().x, Star1.getLocation().y+800), Star1.getLocation(), 2);
        Star2T.Play(TweenProperty.TweenLocation, new Point(Star2.getLocation().x, Star2.getLocation().y+800), Star2.getLocation(), 2);
        Star3T.Play(TweenProperty.TweenLocation, new Point(Star3.getLocation().x, Star3.getLocation().y+800), Star3.getLocation(), 2);
        this.setVisible(true);
    }
    public void Update(){
        Player plr = Memory.player;
        Level lev = Player.GetLevelFromStage(CurrentStage);
        String levClassName = lev.getClass().getSimpleName();
        //handle Stars visible
        int Stars = plr.GetStars(levClassName);
        if (Stars >=1){
            Star1.setVisible(true);
        }else{
            Star1.setVisible(false);
        }
        if (Stars >=2){
            Star2.setVisible(true);
        }else{
            Star2.setVisible(false);
        }
        if (Stars >=3){
            Star3.setVisible(true);
        }else{
            Star3.setVisible(false);
        }
        //update display frames
        i2.SetImage(lev.GetImage());
        if (Player.GetLevelFromStage(CurrentStage-1)==null ){
            i1.SetImage(Player.GetLevelFromStage(Player.LevelOrder.length-1).GetImage());
        }else{
            i1.SetImage(Player.GetLevelFromStage(CurrentStage-1).GetImage());
        }
        if (Player.GetLevelFromStage(CurrentStage+1)==null ){
            i3.SetImage(Player.GetLevelFromStage(0).GetImage());
        }else{
            i3.SetImage(Player.GetLevelFromStage(CurrentStage+1).GetImage());
        }

        if (plr.getTotalStars() <Player.GetReqFromStage(CurrentStage)){
            X.setVisible(true); 
        }else{
            X.setVisible(false);
        }
        //textUpdate
        TotalStars.setText(""+plr.getTotalStars());
        Difficulty.setText("Difficulty: "+plr.getDifficultyAsString());
        Stage.setText("Stage: "+CurrentStage);
        LevelName.setText(""+lev.GetName());
        Total.setText("Requires: "+Player.GetReqFromStage(CurrentStage)+" Star(s)");

    }
    public MouseAdapter DifEvent = new MouseAdapter(){
        public void mouseClicked(MouseEvent e) {
            Player plr = game.plr;
                if (plr.getDifficulty() >= 2){
                    plr.setDifficulty(0);
                }else{
                    plr.setDifficulty(plr.getDifficulty()+1);
                }
                ThisScreen.Update();
            }
            
    };
    public MouseAdapter leftEvent = new MouseAdapter(){
        public void mouseClicked(MouseEvent e) {
            if (Player.GetLevelFromStage(CurrentStage-1) == null){
                CurrentStage = Player.LevelOrder.length-1;
            }else{
                CurrentStage --;
            }
            ThisScreen.Update();
        }
    };
    public MouseAdapter rightEvent = new MouseAdapter(){
        public void mouseClicked(MouseEvent e) {
            if (Player.GetLevelFromStage(CurrentStage+1) == null){
                CurrentStage = 0;
            }else{
                CurrentStage ++;
            }
            ThisScreen.Update();
        }
    };
    public static long time = System.currentTimeMillis();
    public MouseAdapter playEvent = new MouseAdapter(){
        public void mouseClicked(MouseEvent e) {
            Player plr = game.plr;
            if (plr.getTotalStars() >=Player.GetReqFromStage(CurrentStage) && System.currentTimeMillis() - time >= 1000){
                time = System.currentTimeMillis();
                game.StartLevel(plr.getDifficulty(), Player.GetLevelFromStage(CurrentStage).getClass().getSimpleName());
                
            }
        }
    };
} 