# Cookware Class 
> this will be a class of pots,pans,etc...
##  <span style="color:lightblue;">implements Holdable</span>
#### status: <span style="color:red;">Not started</span>
### <span style="color:cyan;">Contributors:</span>
<!--put your names here between the ``` if you worked on it, and put what you did-->
```diff 
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

### **CurrentlyOn** - private Counter
> what counter is it on

### **CannotPlaceOn** -private Counter[]
> what types of counter can it not be placed on

### **name** - private String
> name of the Cookware

### **PossibleItems** - private Item[]
> what items can the cookware store

## <span style="color:yellow;">Methods</span>

### **GetInventory()**-> ArrayList<Item.>
>returns Inventory 

### **Add(Item x)**-> boolean
>Adds x into the ArrayList returns false if x is not in PossibleItems

### **PlaceOn(Counter x)** -> boolean
>Sets CurrentlyOn to x if it can be placed on it. return false if it cannot

### **OnInteract(Player player)** -> void
>what to do when the player interacts with it

### **static newCookware(string name)** -> cookware
>creates a new sub cookware object

## <span style="color:lightblue;">Subclasses</span>
> ## <span style="color:lightgreen;">Example</span>   
```java
```
