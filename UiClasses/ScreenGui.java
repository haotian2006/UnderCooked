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
        Frame x = new Frame();//the x frame is just a red frame 
        TextLable y = new TextLable("X");// the y frame is a red background and has "X" written on it and is 5 pixels above the x so that the "X" is centered 
        //x and y frames might be replaced by a image instead 
        TextLable name = new TextLable("UnderCooked");
        Frame z = new Frame(null);
        Point s = new ScreenSize().Get(); 
        name.SetEditable();
        z.setBounds(0, 0, s.x, 20);
        Topbar = z;
        y.SetEditable();
        y.setBounds(s.x-17, -5, 20, 25);
        y.SetFont(new Font("Impact", Font.PLAIN, 20));
        y.SetEditable();
        y.setBackground(Color.red);
        x.setBackground(Color.red);
        x.setBounds(s.x-20, 0, 20, 20);
        MouseAdapter exit = new MouseAdapter() { // listens when a mouse clicked on the frame
            public void mousePressed(MouseEvent e) {
                System.exit(0);
            }
        };
        name.setBounds(0, 0, s.x, 20);
        name.setOpaque(false);
        x.addMouseListener(exit);
        y.addMouseListener(exit);
        z.add(name);
        z.add(y,null,0);
        z.add(x,null,-1);
        add(z);
    }
    public void FullScreen(){
        Point size = new ScreenSize().Get();
        //System.out.println("Mouse clicked at x=" + size[0] + ", y=" +  size[1]); // get size of screen
        setSize(size.x, size.y);
        setLocationRelativeTo(null);;
    }
}
