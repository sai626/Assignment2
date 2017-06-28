package Assignment2;

/**
 * Created by zemoso on 28/6/17.
 */
public class Constructor {
    public Constructor(){
        this(0);
        System.out.println("Constructor with no argument");
    }

    public Constructor(int a){
        System.out.println("Constructor with 1 argument");
    }
}
