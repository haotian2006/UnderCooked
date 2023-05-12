package Classes;

import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;

public class Counter implements Serializable {
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
    public static Counter newCounter(String name,Holdable holding){
        Counter x = newCounter(name);
        if (x == null) return null;
        x.SetHolding(holding);
        return x;
    }
}

 