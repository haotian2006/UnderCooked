package Classes;

import java.awt.Dimension;
import java.io.Serializable;

public class Grid implements Serializable{
    private Counter[][] grid;
    public Grid(int x,int y){
        grid = new Counter[x][y];
    }
    public boolean put(Counter c, int x,int y){
        x -=1;
        y-=1;
        if (!InBounds(x,y)) return false;
        grid[x][y] = c;
        return true;
    }
    public boolean put(String c, int x,int y){
        x -=1;
        y-=1;
        if (!InBounds(x,y)) return false;
        grid[x][y] = Counter.newCounter(c);
        return true;
    }
    public boolean put(String c, int x,int y,Holdable cookware){
        // subtracting here because the input its from [1,x] but for the table to set we need [0,x-1]
        x -=1;
        y-=1;
        if (!InBounds(x,y)) return false;
        Counter count = Counter.newCounter(c);
        count.SetHolding(cookware);
        grid[x][y] = count;
        return true;
    }
    public Dimension GetSize(){
        return new Dimension(grid.length,grid[0].length);
    }
    public Counter[][] GetGrid(){
        return grid;
    }
    public boolean InBounds(int x,int y){// if the given values are in the bounds of the array
        return !(x >= GetSize().width || y >= GetSize().height || y <= -1 || x <= -1);
    }
    public Counter GetAt(int x,int y){
        if (!InBounds(x-1,y-1)) return null;
       // System.out.println(x+"|"+y);
        return grid[x-1][y-1];
    }
} 
