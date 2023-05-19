package PremadeElements;

import UiClasses.*;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Image;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import javax.swing.SpringLayout.Constraints;

import Classes.*;
public class HoldableElement extends Frame{
   private ImageLable ImageFrame;
   private Holdable item;
   private CookedPercentage bar;
   private TileElement Parent;
    public HoldableElement(Holdable x){
        UpdateItem(x);
    }
    public HoldableElement(){
        super("HoldableItem");
        Dimension size = new Dimension(Kitchen.TileSize, Kitchen.TileSize);
        setSize(size);
        setOpaque(false);
        setBackground(Color.red);
        bar = new CookedPercentage();
        add(bar);
        ImageFrame = new ImageLable();
        ImageFrame.setSize(new Dimension(Kitchen.ItemSize, Kitchen.ItemSize));
        ImageFrame.SetImageSize(new Dimension(Kitchen.ItemSize, Kitchen.ItemSize));
        ImageFrame.SetCenter(GetCenterRelativeToFrame());
        add(ImageFrame);
        setVisible(false);
    }
    public void SetParent(TileElement x){
        Parent = x;
    }
    public void UpdateItem(Holdable x){
        item = x;
        UpdateIcons();
        TileElement p = Parent;
        Parent = null;
        Update();
        Parent = p;
    }
    public void Update(){
        if (item == null)return;
        double[] percent = item.GetPercentage();
        if (Parent == null){
            bar.UpdatePercentage(percent[0] > percent[1] ?percent[1] : percent[0], percent[1]);
            return;
        }
        bar.UpdatePercentage(percent[0], percent[1]);
    }
    public void UpdateIcons(){
        if (item == null){
            setVisible(false);
        }else{
            setVisible(true);
            //ImageFrame.SetImage("assets/Images/Menu/LoadingScreen/Plate.png");
            ImageFrame.SetImage(item.GetImage());
            ImageFrame.SetImageSize( new Dimension(Kitchen.ItemSize, Kitchen.ItemSize));
        }
    }
}
