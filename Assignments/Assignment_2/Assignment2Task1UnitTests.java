import org.junit.Assert;
import org.junit.Test;

/** theres a leetcode problem for this 
 * @see https://leetcode.com/problems/longest-increasing-subsequence/
 */
public class Assignment2Task1UnitTests extends Assignment2Task1{

    
    
    @Test
    /**  10,9,2,5,3,101,7,18. Output: 4, or for the bonus solution 4,(2,5,7,18) */
    public void test1(){
        final int GIVEN = 4;
        int[] arr = {10,9,2,5,3,101,7,18};
        Assert.assertEquals(
            GIVEN,
            MaxIncreasingSubsequence(arr)
        );
    }

    @Test 
    public void test2(){
        int[] arr = { 7,7,7,7,7,7,7 };
        final int GIVEN = 1;
        Assert.assertEquals(GIVEN, MaxIncreasingSubsequence(arr));
    }

    @Test
    public void test3(){
        int[] arr = {0,1,0,3,2,3};
        final int GIVEN = 4;

        Assert.assertEquals(GIVEN, MaxIncreasingSubsequence(arr));
    }

    @Test 
    public void Assignment2Examples(){

        int[] seq1 = {186, 359, 274, 927, 890, 520, 571, 310, 916, 798, 732, 23, 196, 579, 426,188, 524, 991, 91, 150, 117, 565, 993, 615, 48, 811, 594, 303, 191, 505, 724, 818, 536, 416, 179, 485 , 334 , 74, 998, 100, 197, 768, 421, 114, 739, 636, 356, 908 , 477, 656};
        Assert.assertEquals(
            10,
            MaxIncreasingSubsequence(seq1)
        );
        
    }
}