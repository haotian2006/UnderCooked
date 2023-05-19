package Classes;

import java.io.Serializable;

public interface Holdable extends Serializable{
    public String GetType();
    public String GetImage();
    public double[] GetPercentage();
    public void UpdateProcessedTime(double x);
    public double GetProcessedTime();
}
