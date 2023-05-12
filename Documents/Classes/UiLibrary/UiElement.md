# UiElement Interface
>Methods/attributes that the Frame,TextLable,ImageLable,etc.. all have
##  <span style="color:lightblue;">extends from Serializable</span>
### <span style="color:cyan;">Contributors:</span>
<!--put your names here between the ``` if you worked on it, and put what you did-->
```diff
haotian - created docs and class
```
### <span style="color:lightgreen;">Updates:</span>
```diff
5/9/2023 - Renamed from Shared -> UiElement | Deprecated lerp methods
```
## <span style="color:green;">Attributes</span>

## <span style="color:yellow;">Methods</span>

### **SetCenter(Point p)**-> void
>sets the center of the Object to p
### **GetCenter()**-> Point
>Gets the center of the Object
### **GetPositionRelativeToFrame(Point p)**-> Point
>Returns a point that is Relative to it's position

### **Clone()** -> Object
>Clones a Object with similar attributes 

### **LerpXSize(int x,double t)** -> void **<span style="color:Red;">Deprecated</span>**
> Lerps the X size to the Target | Replaced by UiTween Class

### **LerpYSize(int y,double t)** -> void **<span style="color:Red;">Deprecated</span>**
> Lerps the Y size to the Target | Replaced by UiTween Class

### **LerpPosition(int x,int y,double t)** -> void **<span style="color:Red;">Deprecated</span>**
> Lerp the Position to the Targeted | Replaced by UiTween Class




