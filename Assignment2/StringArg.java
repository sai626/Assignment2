package Assignment2;

/**
 * Created by zemoso on 28/6/17.
 */
public class StringArg {

    public StringArg(String a){
        System.out.println(a);
    }

    public static void main(String args[]){
        StringArg[] stringArgs = new StringArg[5];

        /* Initialization message from the constructor are not printed. This is because the object is not
        created here. Only array of object reference is created.
         */

        for (int i=0;i<5;i++){
            stringArgs[i]=new StringArg("a");
        }
    }
}
