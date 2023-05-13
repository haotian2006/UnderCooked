# Kitchen Class 
#### status: <span style="color:Red;">Not Started</span>
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

### **grid** - private Grid
>The Grid

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

### **UpdateAt(int x,int y)** -> void
> updates the counter/icon at given position

### **UpdateHolding()** -> void
> updates what there player is holding

### **GetGrid()**-> Grid
> returns the grid




