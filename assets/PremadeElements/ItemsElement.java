package PremadeElements;

import java.awt.Point;
import java.util.ArrayList;

import Classes.*;
import UiClasses.*;
public class ItemsElement extends Frame {
    public static int sizeOfIcon = 25;
    private ArrayList<Item> DisplayItems;
    private HoldableElement parent;
    public ItemsElement(HoldableElement Parent){
        super("ItemsElement");
        parent = Parent;
        setOpaque(false);
        DisplayItems = new ArrayList<Item>();
        setSize(Kitchen.TileSize, Kitchen.TileSize);
        UpdateFrame();
    }
    public void UpdatePosition(){
        setLocation(0, 0);
    }
    public ImageLable newIcon(Item it){
        ImageLable x = new ImageLable(it.GetImage(true));
        x.setSize(sizeOfIcon, sizeOfIcon);
        x.SetImageSize(sizeOfIcon,sizeOfIcon);
        return x;
    }
    public void AddIcon(Item x){
        ImageLable it = newIcon(x);
        add(it);
        int col = DisplayItems.size()/3;
        it.setLocation((DisplayItems.size()%3)*sizeOfIcon, col*sizeOfIcon);
        DisplayItems.add(x);
    }
    public void Reset(){
        DisplayItems = new ArrayList<Item>();
        removeAll();
        repaint();
    }
    public void UpdateFrame(){
        Holdable holding = parent.GetItem();
        if (holding == null) {return;}
        if (holding.GetType() == "Cookware"){
            if (((Cookware) holding).GetInventory().size() == 0){ Reset();}
            for (int x =0; x<((Cookware) holding).GetInventory().size();x++){
                Item it = ((Cookware) holding).GetInventory().get(x);
                if (DisplayItems.indexOf(it) == -1){
                    AddIcon(it);
                }
            }
        }else  if (holding.GetType() == "Dish"){
            if (((Dish) holding).getItems().size() == 0){ Reset();}
            for (int x =0; x<((Dish) holding).getItems().size();x++){
                Item it = ((Dish) holding).getItems().get(x);
                if (DisplayItems.indexOf(it) == -1){
                    AddIcon(it);
                }
            }
        }

    }
}
