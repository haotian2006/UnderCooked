package PremadeElements;

import UiClasses.*;
import java.awt.Dimension;
import Classes.*;
public class HoldableElement extends Frame{
    ImageLable ImageFrame;
    Holdable item;
    public HoldableElement(Holdable x){
        super("HoldableItem");
        item = x;
        Dimension size = new Dimension(Kitchen.TileSize, Kitchen.TileSize);
        setSize(size);
        setOpaque(false);

        ImageFrame = new ImageLable(item.GetImage());
        ImageFrame.setSize(size);
        ImageFrame.setOpaque(false);
        ImageFrame.SetImageSize(size);

        add(ImageFrame);
    }
}
