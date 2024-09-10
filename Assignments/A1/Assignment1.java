import java.util.Random;

public class Assignment1 {

    public static void main(String[] args){
        System.out.println(java.util.Arrays.toString(GenerateBits(4000)));
        System.out.println(MaxContinuousSubsequence(GenerateBits(4000)));
    }

    /** generates an array of bits using COUNT */
    public static int[] GenerateBits(final int COUNT){
        if (COUNT < 0) throw new IllegalArgumentException("Positive numbers only");

        Random random = new Random(); //random object
        int[] bits = new int[COUNT]; //array of bits
    
        //generates either a 1 or 0 using random.nextBoolean() and puts in array
        for (int i=0; i<COUNT; i++)
            bits[i] = random.nextBoolean() ? 0 : 1;
        
        return bits;
    }

    public static long MaxContinuousSubsequence(int[] bits){
        if (bits.length == 0) return 0; //base case

        int max = 1; //must start at 1 for the base case of 1 element
        int count = 0;
        
        int last_bit = 0;

        for (int b : bits){
            if (b == last_bit)
                count++;
            else{
                //if count bigger than max then max = count
                if (count > max)
                    max = count;

                last_bit = b; //set last bit to current value
                count = 1; //reset count to 1
            }
        }

        
        
        return max;
    }
}
