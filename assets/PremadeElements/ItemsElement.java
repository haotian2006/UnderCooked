package PremadeElements;

import java.util.ArrayList;

import Classes.*;
import UiClasses.*;

public class ItemsElement extends Frame {
    public static int sizeOfIcon = 2;
    private ArrayList<Item> items;
    public ItemsElement(ArrayList<Item> item){
        super("ItemsElement");
        setOpaque(false);
        items = item;
        UpdateFrame();
    }
    public void addItem(Item Item){
        items.add(Item);
        UpdateFrame();
    }
    public void UpdateFrame(){
        int size = items.size();

    }
}
