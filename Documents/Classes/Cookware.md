# Cookware Class 
> this will be a class of pots,pans,etc...
##  <span style="color:lightblue;">implements Holdable</span>
#### status: <span style="color:red;">Not started</span>
### <span style="color:cyan;">Contributors:</span>
<!--put your names here between the ``` if you worked on it, and put what you did-->
```diff 
haotian - created docs and class
```
### <span style="color:yellow;">Updates:</span>
```diff
5/9/2023 - created docs
5/10/2023 - added more methods to the docs
```
### <span style="color:lightgreen;">Notes:</span>
```diff

```
### <span style="color:red;">Bugs:</span>
```diff
```
## <span style="color:green;">Attributes</span>

### **Inventory** - private ArrayList<Item.>
> what is currently stored

### **Image** - private String
> the icon of the cookware

### **CurrentlyOn** - private Counter
> what counter is it on

### **name** - private String
> name of the Cookware


## <span style="color:yellow;">Methods</span>

### **GetPercentage()**-> double[]
>returns what percentage is the item being cooked,chopped,etc in this format: double[processedTime,needed] 

### **GetInventory()**-> ArrayList<Item.>
>returns Inventory 

### **Add(Item x)**-> boolean
>Adds x into the ArrayList returns false if x is not in possible

### **CanAdd(Item x)**-> boolean
>Can it be added. (sub class method) returns true by default

### **PlaceOn(Counter x)** -> boolean
>Sets CurrentlyOn to x if it can be placed on it. return false if it cannot

### **OnInteract(Player player)** -> void
>what to do when the player interacts with it

### **GetImage()** -> String
>Returns the image 

### **GetName()** -> String
>Returns the name 

### **Update()** -> void
>Updates the inventory value (sub class method)

### **static newCookware(string name)** -> cookware
>creates a new sub cookware object


## <span style="color:lightblue;">Subclasses</span>
> ## <span style="color:lightgreen;">Example</span>   
```java
```
