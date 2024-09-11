/*Your program will calculate the length of a longest contiguous subsequence of equal
values in a given sequence of integer values. 
For example if the input sequence is 1,0,0,0,1,1 your program will return 3. 
Another example: 2,5,5,1,11,11,11,3,5,5,5,5,4,7. Now your
program should return 4, because there are 4 consecutive values (namely four 5’s) and
there is no longer subsequence of equal values.*/

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import org.junit.Test;

import junit.framework.Assert;

public class Assignment1UnitTests {
    
    /**if the input sequence is 1,0,0,0,1,1 your program will return 3. */
    @Test public void sequence1() {
        int[] arr = { 1, 0, 0, 0, 1, 1 };
        final long ANSWER = 3; 

        
        assertEquals(
            ANSWER,
            Assignment1.MaxContinuousSubsequence(arr)
        );
    }

    
    /** 2,5,5,1,11,11,11,3,5,5,5,5,4,7. Now your program should return 4, because there are 4 consecutive values (namely four 5’s) and there is no longer subsequence of equal values.*/
    @Test public void sequence2(){
        int[] arr = {2,5,5,1,11,11,11,3,5,5,5,5,4,7};
        final int ANSWER = 4;

        assertEquals(
            ANSWER,
            Assignment1.MaxContinuousSubsequence(arr) 
        );
    }

    @Test
    public void BaseCases(){
        assertEquals(
            0,
            Assignment1.MaxContinuousSubsequence(new int[0])
        );

        assertEquals(
            1,
            Assignment1.MaxContinuousSubsequence(new int[]{0})
        );

        assertEquals(
            1,
            Assignment1.MaxContinuousSubsequence(new int[1000])
        );

    }

    @Test public void CUSTOM(){
       
        
        assertEquals(1,Assignment1.MaxContinuousSubsequence(new int[100]));
        
        
    }

    //tests if the random function is always different
    @Test public void RandomPart(){
        int[] arr1 = Assignment1.GenerateBits(1000);
        int[] arr2 = Assignment1.GenerateBits(1000);
        int[] arr3 = Assignment1.GenerateBits(1000);


        assertEquals(
            java.util.Arrays.equals(arr1, arr2),
            false 
        );

        assertEquals(java.util.Arrays.equals(arr1, arr2) ,false);
        
        
    }


}
