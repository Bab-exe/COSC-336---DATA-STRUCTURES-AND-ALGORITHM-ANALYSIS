import java.util.Random;

public class Assignment1 {

    public static void main(String[] args){
        int[] arr = GenerateBits(4000);
        System.out.println(java.util.Arrays.toString(arr));
        System.out.println("Max Subsequence: " + MaxContinuousSubsequence(arr));
    }

    /** generates an array of bits using COUNT */
    public static int[] GenerateBits(final int COUNT){
        return GenerateBits(COUNT,new Random());
    }
    //exists for better looping
    public static int[] GenerateBits(final int COUNT,Random random){
        if (COUNT < 0) throw new IllegalArgumentException("Positive numbers only");
        
        int[] bits = new int[COUNT]; //array of bits
    
        //generates either a 1 or 0 using random.nextBoolean() and puts in array
        for (int i=0; i<COUNT; i++)
            bits[i] = random.nextBoolean() ? 0 : 1;
        
        return bits;
    }
    /** returns the number of max continuous subsequence */
    public static long MaxContinuousSubsequence(int[] bits){
        if (bits.length == 0) return 0; //base case

        int max = 1; //must start at 1 for the base case of 1 element
        int count = 0;
        
        int last_bit = 0;

        for (int b : bits){
            if (b == last_bit) //if current bit is same as the last one then count goes up by 1
                count++;
            else{
                //if count bigger than max then max = count and count gets reset
                if (count > max)
                    max = count;

                last_bit = b; //set last bit to current value
                count = 1; //reset count to 1
            }
        }

        
        
        return max;
    }
}
