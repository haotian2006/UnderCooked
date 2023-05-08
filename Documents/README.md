to preview a .md you first make sure a .md file is opened then you do:

WINDOWS:
press ctrl-shift-v 

MAC:

press cmd-k-v

### or click on

![PlaceHolder](/Documents/Images/Here.png)

to view it side by side
# <span style="color:yellow;">Guide on writing docs:</span>
for Contributors put it in a format like this
### <span style="color:cyan;">Contributors:</span>
```diff
name - did what 
```

for Updates put it in a format like this

### <span style="color:yellow;">Updates:</span>
```diff
5/7/2023 - created docs
5/8/2023 - added Hello() method
```
for bugs put it in a format like this
### <span style="color:red;">Bugs:</span>
```diff
!bug is fixed
-bug is not fixed
```
for notes put it in a format like this
### <span style="color:lightgreen;">Notes:</span>
```diff
!hello - hao
-you can chose to use ! or - doesn't matter 
>or use a different symbol 
```
# <span style="color:lightgreen;">Formatting stuff:</span>
Titles:
# Title
## Subtitle
### Subtitle
#### SubSubtitle 

# <span style="color:lightblue;">Modifying Text:</span>

**Bold**

__Bold__

*Italic*

_italic_

_**Bold and italic**_
<!--comments these would not show up in the preview-->
# <span style="color:lightblue;">Images:</span>

![green](/Documents/Images/green.jpg)
![red](/Documents/Images/red.jpg)

# <span style="color:lightblue;">Lists:</span>
* Hi
* hello
* Bye
* Hey
    * Sublist
* hi 
 
1. apple
2. orange
3. pineapple

# <span style="color:lightblue;">Colored Text:</span>

<span style="color:Green;">Green</span>

<span style="color:Blue;">Blue</span>

<span style="color:Yellow;">Yellow</span>

etc...


# <span style="color:lightblue;">diffs:</span>
```diff
- text in red
+ text in green
```
# <span style="color:lightblue;">Code Blocks:</span>
```java
class ScreenSize{
    public Point Get(){
        Dimension screenDimension = Toolkit.getDefaultToolkit().getScreenSize();
        int jFrameWidth = screenDimension.width;
        int jFrameHeight = screenDimension.height;
        return new Point(jFrameWidth,jFrameHeight);
    }
    public Point GetCenter(){
        Point size = Get();
        return new Point(size.x/2,size.y/2);
    }
}
```
