package easingTypes;
public class Tween{
    private EaseFunc f;
    private EaseType t;
    private int s;
    private int e;
    public Tween(EaseFunc func,EaseType type,int start,int end){
        f = func; t = type; s = start;e = end;
    }
    public double GetValue(double time){
        return 1;
    }
}