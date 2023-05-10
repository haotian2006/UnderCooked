# Tween Class 
#### status: <span style="color:lightgreen;">Done</span>
### <span style="color:cyan;">Contributors:</span>
<!--put your names here between the ``` if you worked on it, and put what you did-->
```diff
haotian - created docs and class
```
### <span style="color:yellow;">Updates:</span>
```diff
5/9/2023 - created docs
```
### <span style="color:lightgreen;">Notes:</span>
```diff
```
### <span style="color:red;">Bugs:</span>
```diff
```
## <span style="color:green;">Attributes</span>

### **f** - private EaseFunc
>type of easing function

### **t** - private EaseType
>type of easing type

### **s** - private float
>Starting value
### **e** - private float
>ending value
### **dur** - private float
>duration

## <span style="color:yellow;">Methods</span>

### **Tween()**-> Constructor
>creates an empty tween

### **Tween(EaseFunc func,EaseType type,double start,double end)**-> Constructor
>creates an tween with duration at 1

### **Tween(EaseFunc func,EaseType type,double start,double end, double duration)**-> Constructor
>creates an tween

### **Reset(float start,float end)**-> void
>re-sets the start and end value 

### **GetValue(double alpha)**-> double
>returns the tweened/lerped value 






