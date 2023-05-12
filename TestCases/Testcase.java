import Classes.*;
public class Testcase {
    public static void main(String[] args) {
        Grid x = new Grid(800,800){
            {
                put((new Counter()), 0, 1);
                 // creates a counter at 0,1 with a tomato on top
            }
        };
        Grid x2 = DeepCopy.copy(x);
        System.out.println(x2);
        System.out.println(x.GetAt(0, 1));
    }
    
}
