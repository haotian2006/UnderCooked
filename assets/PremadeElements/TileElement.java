package PremadeElements;

import Classes.*;
import UiClasses.*;
import java.awt.Point;
import java.awt.Color;
import java.awt.Dimension;
public class TileElement extends Frame {
    private Counter counter;
    private ImageLable Counter;
    private HoldableElement Item;
    public TileElement(){
        super("TileElement");
        Dimension size = new Dimension(Kitchen.TileSize, Kitchen.TileSize);
        setOpaque(true);
        setSize(size);
        setBackground(new Color(255, 208, 137));     
    }
    public TileElement(Counter x){
        super("TileElement");
        counter = x;
        Dimension size = new Dimension(Kitchen.TileSize, Kitchen.TileSize);
        setOpaque(true);
        setSize(size);
        setBackground(new Color(255, 208, 137));

        Counter = new ImageLable();
        Counter.setSize(size);
        Counter.SetImage(x.GetImage());
        Counter.SetImageSize(size);
        Counter.setOpaque(false);
        Counter.setName("counter");
        add(Counter);

        UpdateIcons();

        
    }
    public Counter getCounter(){
        return counter;
    }
    public void AddItem(HoldableElement x){
        RemoveItem();
        x.SetParent(this);
        Item = x;
        add(Item,0);
    }
    public void RemoveItem(){
        if (Item != null){
            Item.SetParent(null);
            remove(Item);
            repaint();
        }
    }
    public HoldableElement GetItem(){
        return Item;
    }
    public void UpdateIcons(){
        Holdable x = counter.GetHolding();
        if (Item == null){
            Item = new HoldableElement();
            AddItem(Item);
        }
        Item.UpdateItem(x);
    }
    public void Update(){
        if (Item != null){
            Item.Update();
        }
    }
}
