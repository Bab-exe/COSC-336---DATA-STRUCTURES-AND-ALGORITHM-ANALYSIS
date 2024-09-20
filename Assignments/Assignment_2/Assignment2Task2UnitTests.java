import org.junit.Assert;
import org.junit.Test;

public class Assignment2Task2UnitTests extends Assignment2Task2 {
    /** , if the input sequence is 4,9,2,5,3,101,7,18,2,1 then a longest decreasing
 subsequence is 9,5,3,2,1, which has length 5. Therefore your program should return 5
 because there is no decreasing subsequence of length 6 or larger. */
    @Test
    public void test1() {
        final int GIVEN = 5;
        int[] arr = {4, 9, 2, 5, 3, 101, 7, 18, 2, 1};
        Assert.assertEquals(GIVEN, MaxDecreasingSubsequence(arr));
    }

    @Test 
    public void test2(){
        int[] arr = {10, 9, 8, 7, 6, 5, 4, 3, 2, 1};

        Assert.assertEquals(arr.length,MaxDecreasingSubsequence(arr));
    }
}
