package Classes;

import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.awt.event.MouseEvent;
import Counters.*;
import PremadeElements.*;
public class Counter implements Serializable {
    private String name;
    private String ImagePath;
    private Holdable Holding;
    private TileElement CounterFrame;
    public static Counter newCounter(String name){
        try {
            Class<?> myClass = Class.forName(("Counters."+name));//gets the class in assets/Counters/name
            return (Counter) myClass.getDeclaredConstructor().newInstance();//creates a new class and convert it to an Counter   
        } catch (ClassNotFoundException e) {
            e.printStackTrace(); 
            System.exit(1);
        }catch (NoSuchMethodException | InstantiationException | InvocationTargetException | IllegalAccessException e) {
            e.printStackTrace();
            System.exit(1);
        }
        return null;
    }
    public void SetFrame(TileElement x){
        CounterFrame = x;
    }
    public TileElement GetFrame(){
        return CounterFrame;
    }
    public static Counter newCounter(String name,Holdable holding){
        Counter x = newCounter(name);
        if (x == null) return null;
        x.SetHolding(holding);
        return x;
    }
    public Counter(String name,String ImagePath){
        this.name = name; this.ImagePath = ImagePath;
    }
    public String GetName(){
        return name;
    }
    public Holdable GetHolding(){
        return Holding;
    }
    public void SetHolding(Holdable obj) {
        Holding = obj;

    }
    public String GetImage() {
        return ImagePath;
    }

    public double[] GetPercentage() {
        if (Holding.GetType() == "Cookware"){
            return  ((Cookware) Holding).GetPercentage();
        }
        return new double[]{};
    }

    public void Update() {

    }
    
    public boolean CanPlace(Holdable obj) {
        return true;
    }
    public void LeftClick(Player player){
        Holdable plrHolding = player.getHolding();
        Kitchen kit = Memory.Kitchen;
        if (plrHolding != null && GetHolding() == null){
            if (!CanPlace(plrHolding)) return;
            SetHolding(plrHolding);
            player.setHolding(null);
            CounterFrame.UpdateIcons();
        } else if(plrHolding == null && GetHolding() != null){
            player.setHolding(GetHolding());
            SetHolding(null);
            CounterFrame.UpdateIcons();
        }else if(plrHolding != null && GetHolding() != null && GetHolding().GetType() == "Cookware"){
            Cookware cookware = (Cookware) GetHolding();
            if (cookware.Add(plrHolding)){
                player.setHolding(null);
                CounterFrame.UpdateIcons();
            }
        }
    }
    public void RightClick(Player player){

    }
    public void OnInteract(Player player,String Key) {
        if (Key == "Left"){
            LeftClick(player);
        }else{
            RightClick(player);
        }
    }

}