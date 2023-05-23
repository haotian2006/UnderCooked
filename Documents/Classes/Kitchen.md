# Kitchen Class 
#### status: <span style="color:lightgreen;">done</span>
### <span style="color:cyan;">Contributors:</span>
<!--put your names here between the ``` if you worked on it, and put what you did-->
```diff
haotian - created docs and class
```
### <span style="color:lightgreen;">Notes:</span>
```diff
-still a work in progress not sure how to implement it at the moment might be removed because Grid class is very similar

!this will be added to as we make progress
```
### <span style="color:yellow;">Updates:</span>
```diff
5/7/2023 - created docs
5/11/2023 - renamed from display to Kitchen
``` 
### <span style="color:red;">Bugs:</span>
```diff

```
## <span style="color:green;">Attributes</span>

### **TileSize** - public static int
>how many pixels per tile
### **ItemSize** - public static int
>how many pixels per Item
### **MaxOrders** - public static int
>how many Orders can be on screen
### **TileSize** - public static int
>how many pixels per tile
### **Rate** - public static int[]
>Chance of order per .01 second 
### **OrderLasts** - public static int[]
>How long you have until an order expires

### **grid** - private Grid
>The Grid

### **maxBurnTime** - private double[]
>max burn time for each difficulty

### **UiGrid** - private Frame[][]
>grid location for the ui 

### **BackgroundFrame** - private Frame
> the background frame

### **HoldingFrame** - private Frame
> the holding frame

### **display** - private ScreenGui
>The ScreenGui used

## <span style="color:yellow;">Methods</span>

### **Kitchen(ScreenGui x)**-> Constructor
> Creates the Display object and should init the ScreenGui

### **LoadLevel(Level x)**-> void
>loads the given level

### **Draw()** -> void
> draws the counters

### **GetTileFromName(String x)** -> TileElement
> returns a tile on screen, returns null if not found
### **UpdateAt(int x,int y)** -> void
> updates the counter/icon at given position

### **UpdateHolding()** -> void
> updates what there player is holding

### **GetMaxBurnTime(int difficulty)** -> double
> returns how long should something burn before losing from given difficulty

### **GetMaxBurnTime()** -> double
> returns how long should something burn before losing 

### **GetGrid()**-> Grid
> returns the grid

### **UpdateAll()** -> void
> updates all tile elements 




