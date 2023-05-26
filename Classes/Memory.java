package Classes;

public class Memory {
    public static Player player;
    public static Kitchen Kitchen;
    public static Game game;
    public static void SetGame(Game x){
        game = x;
    }
    public static void SetKitchen(Kitchen x){
        Kitchen = x;
    }
    public static void SetPlayer(Player x){
        player = x;
    }
}
