package UiClasses;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.Toolkit;
// A ui class made by hao 
// It acts similar to how the GUI classes in roblox work

public class ScreenSize{
    public Point Get(){
        Dimension screenDimension = Toolkit.getDefaultToolkit().getScreenSize();
        int jFrameWidth = screenDimension.width;
        int jFrameHeight = screenDimension.height;
        return new Point(jFrameWidth,jFrameHeight);
    }
    public Point GetCenter(){
        Point size = Get();
        return new Point(size.x/2,size.y/2);
    }
}
