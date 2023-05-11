package Classes;

import java.lang.reflect.InvocationTargetException;
 
public class Item implements Holdable{
    public boolean equals(Item other){
        
    }

    public static Item newItem(String name){
        try {
            Class<?> myClass = Class.forName(("Items."+name));//gets the class in assets/Items/name
            return (Item) myClass.getDeclaredConstructor().newInstance(); //creates a new class and convert it to an Item   
        } catch (ClassNotFoundException e) {
            e.printStackTrace(); 
            System.exit(1);
        }catch (NoSuchMethodException | InstantiationException | InvocationTargetException | IllegalAccessException e) {
            e.printStackTrace();
            System.exit(1);
        }
        return null;
    }
    public static Item newItem(String name,boolean Cooked,boolean Fried, boolean Chopped){
        Item x = newItem(name);
        if (x == null) return null;
        // add to this

        return x;
    }
    public String GetType() {return "Item";}
}
