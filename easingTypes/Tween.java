package easingTypes;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Tween{
    private EaseFunc f;
    private EaseType t;
    private float s;
    private float e;
    private float dur = 1;

    public Tween(){
        
    }
    public Tween(EaseFunc func,EaseType type,double start,double end){
        if (func != EaseFunc.Linear &&  type == EaseType.easeNone)System.err.println("CANNOT USE 'EaseType.easeNone' ON A NONE LINEAR FUNCTION");
        f = func; t = type; s = (float) start;e = (float) end;
    }
    public Tween(EaseFunc func,EaseType type,double start,double end, double duration){
        if (func != EaseFunc.Linear &&  type == EaseType.easeNone)System.err.println("CANNOT USE 'EaseType.easeNone' ON A NONE LINEAR FUNCTION");
        f = func; t = type; s = (float) start;e = (float) end; dur = (float) duration;
    }
    public void Reset(float start,float end){
        s = start; e = end;
    }

    public double GetValue(double time){
        float time2 = (float) time;
        try {
            //all this just to create a class 
            Class<?> myClass = Class.forName(("easingTypes."+f.name()));
            Object obj = myClass.getDeclaredConstructor().newInstance();
            Method method = myClass.getMethod(t.name(), float.class, float.class,float.class,float.class);
            //Float value = (float) method.invoke(obj,time2,s,e,dur);(old script) -- this one line caused me 30 minuets of pain
            //and the fix was 2 characters
            Float value = (float) method.invoke(obj,time2,s,e-s,dur);
            return (double) value.doubleValue();
        } catch (ClassNotFoundException e) {
            e.printStackTrace(); 
            System.exit(1);
        }catch (NoSuchMethodException e) {
            e.printStackTrace();
            System.exit(1);
        }catch (InstantiationException e) {
            e.printStackTrace();
            System.exit(1);
        }catch (IllegalAccessException e) {
            e.printStackTrace();
            System.exit(1);
        }catch (InvocationTargetException   e) {
            e.printStackTrace();
            System.exit(1);
        }
        
        return e;
    }
}