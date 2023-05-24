package Counters;
import java.util.ArrayList;

import Classes.*;
import PremadeElements.TileElement;
public class Server extends Counter{
    static String name = "Server";
    static String ImagePath = "assets/Images/Counters/ServingCounter.png";
    public void RightClick(Player player){

    }
    public void LeftClick(Player player){
        Holdable plrHolding = player.getHolding();
        Kitchen kit = Memory.Kitchen;
        if ((plrHolding != null && plrHolding.GetType().equals("Dish")) ){
            //do stuff
            Dish dish = (Dish) plrHolding;
            for (int n = 0;n<player.getOrders().size();n++){
                Recipe rp = player.getOrders().get(n);
                if (rp.DishMatchesRecipe(dish) && !rp.IsDone ){
                    int[] data = player.GetData();
                    rp.IsDone = true;
                    double pr = rp.GetTime()/Kitchen.GetMaxTime();
                    data[0] +=rp.GetScore();
                    data[1] ++;
                    data[2] += (int) (pr*10);
                    player.setScore((int) (player.getScore() + rp.GetScore() + pr*10));
                    break;
                }
            }
            player.setHolding(null);
            new Thread(() ->{
                try {
                    TileElement x = kit.GetTileFromName("Receive");
                    if (x == null){
                        System.err.println("RECEIVE COUNTER NOT FOUND");
                        System.exit(0);
                    }
                    Receive rec = (Receive) x.getCounter();
                    Thread.sleep(8000);
                    Item newPlate = Item.newItem("Plate");
                    newPlate.setDirty(true);
                    rec.getItems().add(newPlate);

                } catch (Exception e) {
                    
                }
            }).start();
        }
            
}
    public Server(){
        super(name, ImagePath);
    }
}
