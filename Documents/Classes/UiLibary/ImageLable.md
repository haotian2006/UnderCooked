# ImageLable Class 
> a class where you can create a frame with a image
##  <span style="color:lightblue;">extends from JLabel</span>
#### status: <span style="color:lightgreen;">Done</span>
### <span style="color:cyan;">Contributors:</span>
<!--put your names here between the ``` if you worked on it, and put what you did-->
```diff
Haotian - created docs and class
```

### <span style="color:red;">Bugs:</span>
```diff
```
## <span style="color:green;">Attributes</span>
### **image** - private ImageIcon
>the image currently loaded

### **sizex** - private Int
>x size of the image

### **sizey** - private Int
>y size of the image

## <span style="color:yellow;">Methods</span>

### **ImageLable(String imagePath)**-> Constructor
>creates an image with the given path

### **ImageLable()**-> Constructor
>creates an empty ImageLable 

### **SetImage(String imagePath)**-> void
>Sets Image

### **SetImageSize(int x,int y)**-> void
>Sets Image Size

### **LerpImageXSize(int x,double t)** ->void
>lerps the image X size

### **LerpImageYSize(int y,double t)** ->void
>lerps the image Y size



