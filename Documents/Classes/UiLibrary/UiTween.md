# UiTween Class 
>a class to handle Ui animations
#### status: <span style="color:lightGreen;">Done</span>
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

### **frame** - private JComponent
>The Frame Being Tweened

### **func** - private EaseFunc
>The lerping function to use

### **type** - private EaseType
>The type of EaseType to use

## <span style="color:yellow;">Methods</span>

### **UiTween(JComponent Frame,EaseFunc Func,EaseType Type)**-> Constructor
>Creates the tween

### **TweenSize(Dimension Start,Dimension goal,double duration)**-> Dimension
>Tweens the size

### **TweenSizeFromCenter(Dimension Start,Dimension goal,double duration)**-> Dimension
>Tweens the size while keeping the center the same

### **TweenBackgroundColor(Color Start,Color goal,double alpha)**-> Color
>Tweens the Background color

### **TweenLocation(Point Start,Point goal,double alpha)**-> Point
>Tweens the location

* all of these methods automatically update the frame so you don't need to update the frame with the returned values

### **SetDuration(double x)**-> void
>sets how long the tween should take

### **Play(TweenProperty x,Object Start, Object End,double duration)**-> void
>Tweens the given property in the given duration without needing another for loop




