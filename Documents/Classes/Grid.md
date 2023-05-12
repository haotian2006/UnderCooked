# Grid Class 
> a class to store the tiles
#### status: <span style="color:lightgreen;">done</span>
### <span style="color:cyan;">Contributors:</span>
<!--put your names here between the ``` if you worked on it, and put what you did-->
```diff
haotian - created docs and class
```
### <span style="color:lightgreen;">Notes:</span>
```diff
!this will be added to as we make progress (done)
```
### <span style="color:yellow;">Updates:</span>
```diff
5/10/2023 - made changes to the class | class is done
```
### <span style="color:red;">Bugs:</span>
```diff
```
## <span style="color:green;">Attributes</span>
### **Grid** - private Counter[][]
>where the Tiles are stored 
## <span style="color:yellow;">Methods</span>

### **Grid(int x,int y)**-> Constructor
> Creates an 2D array with the size of x and y
### **put(Counter c, int x,int y)**-> Void
> puts a Counter at  x,y returns false if out of bounds

### **put(String c, int x,int y)**-> Void
> creates a Counter object and puts at x,y. returns false if out of bounds

### **put(String c, int x,int y,Holdable Item)**-> Void
> creates a Counter object with an Item and puts at x,y. returns false if out of bounds


### **GetSize()** -> Dimension
> return the grid size Dimension
### **GetGrid()**-> Counter[][]
> returns the grid array

### **GetAt(int x,int y)**-> Counter
> returns the counter at x,y