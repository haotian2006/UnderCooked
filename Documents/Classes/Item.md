# Item Class 
> A class to define items like tomatoes,plates 
##  <span style="color:lightblue;">extends from Holdable</span>
#### status: <span style="color:Red;">Not Started</span>
### <span style="color:cyan;">Contributors:</span>
<!--put your names here between the ``` if you worked on it, and put what you did-->
```diff
haotian - created docs
```
### <span style="color:lightgreen;">Notes:</span>
```diff
!don't worry about the subclasses for now - hao
```
### <span style="color:yellow;">Updates:</span>
```diff

```
### <span style="color:red;">Bugs:</span>
```diff

```
## <span style="color:green;">Attributes</span>

### **Plate** - private boolean
> is it a plate

### **Images** - private Hashmap <String[],String>
> what image should be displayed 
 ### **maxProcessTime** - private Hashmap <String,double>
>how long should each process take (in seconds)

### **ProcessedTime** - private double
>How long has its been Processed 

>ex: if its been into a pot for 4 seconds ProcessedTime would be 4

### **Cooked** - private boolean
> has it been cooked?

### **Chopped** - private boolean
> has it been Chopped?

### **Fried** - private boolean
> has it been Fried?

### **Dirty** - private boolean
> is it Dirty (plates)

### **name** - private String
>name of item 

## <span style="color:yellow;">Methods</span>

### **GetName()**-> String
>returns the name 

### **GetImage(String[] items)**-> String
>returns a Image that matches the string array
### **GetMaxProcessTime(String x)** -> double
>returns the process time for the type

### **IsPlate()** -> boolean
> is the item a plate
### **IsCooked()**-> boolean
>is it cooked
### **IsFried()**-> boolean
>is it Fried
### **IsDirty()**-> boolean
>is it Dirty
### **IsChopped()**-> boolean
>is it Chopped

### **CanBeChopped()**-> boolean
>Can it? (subclasses) *return false by default
### **CanBeCooked()**-> boolean
>Can it? (subclasses)*return false by default
### **CanBeFried()**-> boolean
>Can it? (subclasses)*return false by default
### **CanHold()**-> boolean
>Can a player hold it or does it have to be in a plate (subclasses)*return true by default

### **newItem(String name)** -> Item 
> creates a Item with the template of a subclass with the same name

### **newItem(String name,boolean Cooked,boolean Fried, boolean Chopped)** -> Item 
> creates a Item with the template of a subclass with the same name and given attributes

## <span style="color:lightblue;">Subclasses</span>
> ## <span style="color:lightgreen;">Example</span>   
```java
class Tomato extends Item{
    private HashMap<String[], String> Images = new HashMap<String[], String>(){{
        put(new String[]{}, "/assets/tomato.png");//empty Array so a normal tomato 
        put(new String[]{"Chopped"}, "/assets/ChoppedTomato.png");//Array  with a Chopped string so a Chopped tomato 
    }}
    private HashMap<String, double> maxProcessTime = new HashMap<String, double>(){{
        put("Chopping", 3);//should take 3 seconds to chop
        put("Frying", 4);//should take 4 second to fry
    }}
    public boolean CanBeFried(){ // if its chopped then it can be fried 
        if (IsChopped()){
            return true
        }
        return false
    }
    public boolean CanHold(){//  if its been cooked(soup form) then you can't hold it without a plate
        if (IsCooked()){
            return false
        }
        return true
    }
}

```

