package Assignment2;

/**
 * Created by zemoso on 28/6/17.
 */
public class Vampire_Number {

    /**
     * The main method to find and print the vampire numbers. It starts searching for vampire numbers from 10
     * till it has found 100 vampire numbers.
     */
    public void printVampireNumbers(){

        // 'count' stores the number of vampire numbers found so far and 'number' is the current number being
        // tested for vampire number
        int count=0,number=9;
        // f1 f2 are the factors of the vampire number
        int f1,f2;

        outer:
        while(count<100){
            number++;
            if(length(number)%2!=0){ // length of a probable vampire should be even
                continue outer;
            }

            f1=(int)Math.sqrt(number); // approximate factor of the probable vampire number and half its length
            for (;2*length(f1)==length(number);f1++){
                if(number%f1==0){  // f1 is a factor
                    f2=number/f1;

                    if(digitsCheck(number,f1,f2)){ // 'number' is a vampire number with f1 f2 as factors
                        System.out.println(number);
                        count++;
                        continue outer;
                    }
                }
            }
        }
    }

    /**
     * Returns the length of a number.
     * @param a a number
     * @return length of the number
     */

    public int length(int a){
        int l=0;
        while(a>0){
            a=a/10;
            l++;
        }
        return l;
    }

    /**
     * It returns whether the number passed with the factors is a vampire number or not.
     * @param n     The probable vampire number
     * @param f1    First factor of the vampire number
     * @param f2    Second factor of the vampire number
     * @return      returns whether n is a vampire number with factors f1 f2 or not
     */

    public boolean digitsCheck(int n, int f1, int f2){
        if(f1%10==0 && f2%10==0){ // both f1 and f2 should not have trailing zeros
            return false;
        }else{
            int[] count_n=new int[10];
            int[] count_f1f2=new int[10];

            digitsCount(n,count_n);  // populate the digits count of n
            digitsCount(f1,count_f1f2);  // populate the digits count of f1
            digitsCount(f2,count_f1f2);  // add the digits count of f1 with f2

            for (int i=0;i<10;i++){
                if(count_n[i]!=count_f1f2[i]){  // check if both the digits count are equal
                    return false;
                }
            }
        }
        return true;
    }


    /**
     * The function counts the number of 0s, 1s, 2s ..... 9s in the number a and stores it in array.
     * As the array is passed as reference, the input array is directly modified to reflect the changes.
     * Thus calling this function with twice with same array will reflect the total number of digits
     * in both numbers combined.
     * @param a     The number whose digits count is neeed
     * @param array The array where the digits count of the number is stored
     */
    public void digitsCount(int a, int[] array){
        char[] temp=Integer.toString(a).toCharArray();

        for (char ch:temp){  // populate digits count of a
            switch (ch){
                case '0': array[0]++;
                    break;
                case '1': array[1]++;
                    break;
                case '2': array[2]++;
                    break;
                case '3': array[3]++;
                    break;
                case '4': array[4]++;
                    break;
                case '5': array[5]++;
                    break;
                case '6': array[6]++;
                    break;
                case '7': array[7]++;
                    break;
                case '8': array[8]++;
                    break;
                case '9': array[9]++;
                    break;
            }
        }
    }

    public static void main(String args[]){
        Vampire_Number v=new Vampire_Number();
        v.printVampireNumbers();
    }
}
