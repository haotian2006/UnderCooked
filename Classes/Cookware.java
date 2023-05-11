package Classes;

import java.lang.reflect.InvocationTargetException;

public class Cookware extends Holdable{
    public static Cookware newCookware(String name){
        try {
            Class<?> myClass = Class.forName(("Cookware."+name));//gets the class in assets/Cookware/name
            return (Cookware) myClass.getDeclaredConstructor().newInstance();//creates a new class and convert it to an Cookware   
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
 