import Classes.*;
public class Testcase {
    public static void main(String[] args) {
        //clones both arrays
        int[] y = {1,2};
        int[] z = {2,1};
        if (y.length != z.length){ return;}
        boolean found = true;
        for (int yy =0;yy<y.length;yy++){
            found = false;
            for (int zz =0;zz<z.length;zz++){
                if (y[yy] == z[zz] && y[yy] != 0){ // if it equals but not equal to null then
                    z[zz] = 0; // set them to null
                    found = true; break;
                }
            }
        }
      System.out.println(found);
    }
    
}
