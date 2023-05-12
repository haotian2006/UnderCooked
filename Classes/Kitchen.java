package Classes;
import java.io.Serializable;

import UiClasses.*;
public class Kitchen implements Serializable{
    public static int TileSize =4; // how many pixels per tile
    private Grid grid;
    private Frame[][] UiGrid;
    private Frame BackgroundFrame;
    private Frame HoldingFrame;
    private ScreenGui display;

    public Kitchen(ScreenGui x){
        display = x;
    }
    public void LoadLevel(Level x){
        if (BackgroundFrame != null) display.remove(BackgroundFrame);

        grid = DeepCopy.copy(x.getGrid());
        int xSize = x.getGrid().GetSize().width*TileSize;
        int ySize = x.getGrid().GetSize().height*TileSize;

        BackgroundFrame = new Frame("Kitchen");
        BackgroundFrame.setSize(xSize,ySize);
        display.add(BackgroundFrame, 0);

        ImageLable imageFrame = new ImageLable(x.GetImage());
        imageFrame.setName("BgImage");
        imageFrame.setSize(xSize,ySize);
        imageFrame.SetImageSize(xSize,ySize);
        imageFrame.SetCenter(BackgroundFrame.GetCenterRelativeToFrame());
        BackgroundFrame.add(imageFrame, 0);
        Draw();
        
    }
    public void Draw(){
        for (int x = 0;x<grid.GetSize().width;x++){
            for (int y = 0;x<grid.GetSize().height;y++){
                Counter counter = grid.GetAt(x, y);
                
            }
        }
    }

}
