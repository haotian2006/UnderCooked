# Recipe Class 
> a class to define what a dish is made out of 
##  <span style="color:lightblue;">extends from Yes</span>
#### status: <span style="color:red;">not started</span>
### <span style="color:cyan;">Contributors:</span>
<!--put your names here between the ``` if you worked on it, and put what you did-->
```diff
haotian - made document

```
### <span style="color:yellow;">Updates:</span>
```diff
5/7/2023 - created docs
```
### <span style="color:lightgreen;">Notes:</span>
```diff

```
### <span style="color:red;">Bugs:</span>
```diff
```
## <span style="color:green;">Attributes</span>
### **Time** - private double
>This is how long the order has to be made before the time runs out

### **Ingredients** - private Item[]
>an Item Array defining the ingredients needed to make

### **name** - private String
>name of the recipe

### **Image** - private String
>Image path for recipe 

## <span style="color:yellow;">Methods</span>

### **newRecipe(String name)**-> Recipe
>creates a Recipe object from a sub class with the name

### **DishMatchesRecipe(Dish x)** -> boolean
> if the given Dish matches the recipe 

### **GetIngredients()** ->Item[]
>returns the Ingredients List

### **GetTime()** ->double
>returns the time

### **SetTime(double x)** ->
>sets the time 
## <span style="color:lightblue;">Subclasses</span>
> ## <span style="color:lightgreen;">Example</span>   
```java
class TomatoSoup extends Recipe{
    private Item[] Ingredients = new Item[]{
        new Item("Tomato"),
        new Item("Plate")
    };
}
class FriedTomato extends Recipe{
    private Item[] Ingredients = new Item[]{
        new Item("Tomato",false,true,true),//creates a Tomato that is not cooked, that is chopped and is fried
         new Item("Plate")
    };
}
```




