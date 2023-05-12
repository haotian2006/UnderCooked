package UiClasses;

import java.awt.Point;
import java.io.Serializable;

interface UiElement extends Serializable {
    public Point GetCenter();
    public Point GetCenterRelativeToFrame();
    public void SetCenter(Point p);
    public void LerpPosition(int x,int y,double t);
    public void LerpXSize(int x,double t);
    public void LerpYSize(int y,double t);
}