package UiClasses;
import java.awt.Color;
import java.awt.Font;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.*;
public class ScreenGui extends JFrame{
    private JComponent Topbar;
    public ScreenGui(String name){
        super(name);
        setUndecorated(true);
        setVisible(true);
        setLayout(null);
        setResizable(false);
        ExitButton();
    };
    public void setBackground(Color x){
        JPanel contentPane = (JPanel) getContentPane();
        contentPane.setBackground(x);
    }
    
    public void setTopBarColor(Color x){
        Topbar.setBackground(x);
    }
    public JComponent GetTopBar(){
        return Topbar;
    }
    public void SetTopBar(JComponent x){
        Topbar = x;
    }
    private void ExitButton(){//creates a red X on the top right corner 
        ImageLable name = new ImageLable("assets/Images/TopBar/SubTitle.png");
        ImageLable Close = new ImageLable("assets/Images/TopBar/Close.png");

        Frame ClickAble = new Frame();
        
        Frame z = new Frame();
        z.setBackground(Color.gray);
        Point s = new ScreenSize().Get(); 
        String osName = System.getProperty("os.name");
        if (osName.startsWith("Mac")) {
            z.setBounds(20, 0, s.x, 20);
        } else {
            z.setBounds(0, 0, s.x, 20);  
        }
        Topbar = z;
        Close.setBounds(s.x-20, 0, 20, 20);
        ClickAble.setBounds(s.x-20, 0, 20, 20);
        ClickAble.setBackground(Color.gray);
        ClickAble.setOpaque(false);
        MouseAdapter exit = new MouseAdapter() { // listens when a mouse clicked on the frame
            public void mousePressed(MouseEvent e) {
                System.exit(0);
            }
        };
        Close.SetImageSize(20, 20);
        name.setBounds(0, 0, s.x, 20);
        name.SetImageSize(140, 20);
        ClickAble.addMouseListener(exit);
        z.add(name);
        z.add(ClickAble, 0);
        z.add(Close,1);
        add(z);
    }
    public void FullScreen(){
        Point size = new ScreenSize().Get();
        //System.out.println("Mouse clicked at x=" + size[0] + ", y=" +  size[1]); // get size of screen
        setSize(size.x, size.y);
        setLocationRelativeTo(null);;
    }
}
