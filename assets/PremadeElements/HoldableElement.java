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

        
        Thread thread = new Thread(() -> {
            long start = System.nanoTime();
            ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);
            final double[] i = {0};
            long interval = 10;
            executor.scheduleAtFixedRate(() -> {
                i[0] += 0.01;
                bar.UpdatePercentage(i[0],2);
            }, 0, interval, TimeUnit.MILLISECONDS);
            try {
            executor.awaitTermination((long)(2*1000+Memory.Kitchen.GetMaxBurnTime()*1000), TimeUnit.MILLISECONDS);
            } catch (InterruptedException e) {
            }
            executor.shutdown();
            System.out.println("Took " + (System.nanoTime() - start) / 1_000_000_000.0 + " seconds.");
        });
        thread.start();
        ImageFrame = new ImageLable();
        ImageFrame.setSize(size);
        ImageFrame.SetImageSize(size);
        add(ImageFrame);
    }
    public void SetParent(TileElement x){
        Parent = x;
    }
    public void UpdateItem(Holdable x){
        item = x;
        UpdateIcons();
        Update();
    }
    public void Update(){

    }
    public void UpdateIcons(){
        if (item == null){
            setVisible(false);
        }else{
            setVisible(true);
            ImageFrame.SetImage("assets/Images/Menu/LoadingScreen/Plate.png");
            //ImageFrame.SetImage(item.GetImage());
            ImageFrame.SetImageSize( new Dimension(Kitchen.TileSize, Kitchen.TileSize));
        }
    }
}
