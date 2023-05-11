package Classes;

import java.awt.Dimension;

public class Grid {
    private Counter[][] grid;
    public Grid(int x,int y){
        grid = new Counter[x][y];
    }
    public boolean put(Counter c, int x,int y){
        if (!InBounds(x,y)) return false;
        grid[x][y] = c;
        return true;
    }
    public boolean put(String c, int x,int y){
        if (!InBounds(x,y)) return false;
        grid[x][y] = Counter.newCounter(c);
        return true;
    }
    public Dimension GetSize(){
        return new Dimension(grid.length,grid[0].length);
    }
    public Counter[][] GetGrid(){
        return grid;
    }
    public boolean InBounds(int x,int y){
        return (x >= GetSize().width || y >= GetSize().height);
    }
    public Counter GetAt(int x,int y){
        if (!InBounds(x,y)) return null;
        return grid[x][y];
    }
} 
