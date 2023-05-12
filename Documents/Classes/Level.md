# Level Class 
> this is a template class for levels 
#### status: <span style="color:lightgreen;">Done</span>
### <span style="color:cyan;">Contributors:</span>
<!--put your names here between the ``` if you worked on it, and put what you did-->
```diff
haotian - finished class
```
### <span style="color:yellow;">Updates:</span>
```diff
5/10/2023 - created docs and class
```
### <span style="color:lightgreen;">Notes:</span>
```diff
```
### <span style="color:red;">Bugs:</span>
```diff
```
## <span style="color:green;">Attributes</span>

### **GridLayout** - private Grid
>The Level Layout

### **Orders** - private Recipe[]
>What orders are possible 

### **BackgroundImage** - private String
>What should the background Image be

### **StarRequirements** - private Int[][]
>how many points for each difficulty and star

### **MaxIngredients** - ArrayList<HashMap<String,Integer>>
>how many ingredients do they get per difficulty

## <span style="color:yellow;">Methods</span>

### **newLayout(String x)**-> Level
>creates a Subclass x object

### **GetGrid()**-> Grid
>returns the grid

### **GetOrders()**-> Recipe[]
>returns the possible recipes

### **GetImage()**-> String
>returns the background image path

### **GetRequirements(int difficulty)**-> int[]
>returns the array of point requirements for given difficulty

### **GetRequirements(int difficulty,int score)**-> int
>returns the amount of stars for the given difficulty and score

### **GetMaxIngredients(int difficulty)**-> HashMap<String,Integer>
>returns the amount of ingredients hashmap

### **GetMaxIngredients(int difficulty,String ingredient)**-> int
>returns the max amount for the given ingredient

## <span style="color:lightblue;">Subclasses</span>
> ## <span style="color:lightgreen;">Example</span>   
```java
public class Template extends Level {
    private String name = "Template";
    private Grid GridLayout = new Grid(800,800){//creates a grid with the size of 800x800
        {
            put("Counter", 0, 0); // creates a counter at 0,0
            put(Counter.newCounter("Counter",Item.newItem("Tomato") ), 0, 1);
             // creates a counter at 0,1 with a tomato on top
        }
    };
    private Recipe[] Orders = {
         Recipe.newRecipe("recipe1"),
         Recipe.newRecipe("recipe2")
    };
    
    private int[][] StarRequirements = {
        {60,100,120}, //easy 1 star 
        {80,120,140}, //normal
        {100,140,160} //hard
    };

    private ArrayList<HashMap<String,Integer>> MaxIngredients= new ArrayList<HashMap<String,Integer>>(){
        {
            add(new HashMap<String,Integer>(){{ //easy
                put("Item1", 100);
            }});
            add(new HashMap<String,Integer>(){{ // normal
                put("Item1", 50);
            }});
            add(new HashMap<String,Integer>(){{ // hard
                put("Item1", 20);
            }});
        }
    };
    
}


```




