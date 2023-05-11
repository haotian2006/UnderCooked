package Classes;

import java.lang.reflect.InvocationTargetException;

public class Counter {
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
}

 