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
   private ItemsElement elements; 
   private ImageLable Plate;
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
        Plate = new ImageLable();
        Plate.setSize(new Dimension(Kitchen.ItemSize, Kitchen.ItemSize));;
        Plate.SetImage("assets/Images/Other/Plate.png");
        Plate.SetImageSize(new Dimension(Kitchen.ItemSize, Kitchen.ItemSize));
        Plate.SetCenter(GetCenterRelativeToFrame());
        Plate.setVisible(false);
        ImageFrame = new ImageLable();
        ImageFrame.setSize(new Dimension(Kitchen.ItemSize, Kitchen.ItemSize));
        ImageFrame.SetImageSize(new Dimension(Kitchen.ItemSize, Kitchen.ItemSize));
        ImageFrame.SetCenter(GetCenterRelativeToFrame());
        elements = new ItemsElement(this);
        add(elements);
        add(ImageFrame);
        add(Plate);
        setVisible(false);
    }
    public void SetParent(TileElement x){
        Parent = x;
    }
    public Holdable GetItem(){return item;}
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
        elements.Reset();
        if (item == null){
            Plate.setVisible(false);
            setVisible(false);
        }else{
            if(item.GetType() == "Dish"){
                Plate.SetImage("assets/Images/Other/Plate.png");
                Plate.setVisible(true);
            }else if(item.GetType() == "Cookware" && ((Cookware)item).GetInventory().size() >= 1 ){
                Plate.SetImage(((Cookware)item).GetImage(true));
                Plate.setVisible(true);
            }else{
                Plate.setVisible(false);
            }
            
            setVisible(true);
            //ImageFrame.SetImage("assets/Images/Menu/LoadingScreen/Plate.png");
            ImageFrame.SetImage(item.GetImage());
            ImageFrame.SetImageSize( new Dimension(Kitchen.ItemSize, Kitchen.ItemSize));
            elements.UpdateFrame();
        }
    }
}
