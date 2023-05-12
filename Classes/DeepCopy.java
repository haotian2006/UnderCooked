package Classes;
import java.io.*;
public class DeepCopy { 
    @SuppressWarnings("unchecked") // this is here to prevent line 18 from throwing an warning 
    public static <T> T copy(T object) {
        try{
            //I made this with some help from StackOverFlow | https://stackoverflow.com/posts/7596565/revisions
            //all I(hao) know is it does some converting into bytecode then back into an object 
            ByteArrayOutputStream Bytes = new ByteArrayOutputStream();
            ObjectOutputStream ObjectOutput = new ObjectOutputStream(Bytes);
            ObjectOutput.writeObject(object);
            ObjectOutput.flush(); 
            ObjectOutput.close(); 
            ByteArrayInputStream ByteArray = new ByteArrayInputStream(Bytes.toByteArray());
            ObjectInputStream ObjectInput = new ObjectInputStream(ByteArray);
            ObjectInput.close();
            ByteArray.close(); 
            return (T) ObjectInput.readObject();
        }catch (IOException | ClassNotFoundException e){
            e.printStackTrace(); 
            System.exit(1);
            return null;
        }
    }
}