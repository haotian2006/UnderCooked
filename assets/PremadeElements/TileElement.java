package PremadeElements;

import Classes.*;
import UiClasses.*;
import java.awt.Point;
import java.awt.Dimension;
public class TileElement extends Frame {
    private Counter counter;
    private ImageLable Counter;
    private ImageLable Cookware;
    public TileElement(Counter x){
        super("TileElement");
        counter = x;
        Dimension size = new Dimension(Kitchen.TileSize, Kitchen.TileSize);
        setOpaque(false);
        setSize(size);

        Counter = new ImageLable();
        Counter.setSize(size);
        //Counter.SetImage(x.GetImage());
        Counter.SetImageSize(size);
        Counter.setOpaque(false);
        Counter.setName("counter");
        add(Counter,0);

        Cookware = new ImageLable();
        Cookware.setSize(size);
        Cookware.setName("Cookware");
        Cookware.setOpaque(false);
        add(Cookware,1);


       
        
    }
    public void UpdateIcons(){
        Holdable x = counter.GetHolding();
        String image = x  == null? "" : x.GetImage();
        Cookware.SetImage(image);
    }
    public void Update(){

    }
}
