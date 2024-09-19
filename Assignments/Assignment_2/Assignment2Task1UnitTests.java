import org.junit.Assert;
import org.junit.Test;


public class Assignment2Task1UnitTests{

    
    
    @Test
    /**  10,9,2,5,3,101,7,18. Output: 4, or for the bonus solution 4,(2,5,7,18) */
    public void test1(){
        final int GIVEN = 4;
        int[] arr = {10,9,2,5,3,101,7,18};
        Assert.assertEquals(
            GIVEN,
            Assignment2Task1.MaxIncreasingSubsequence(arr)
        );
    }

    @Test 
    public void test2(){
        int[] arr = { 7,7,7,7,7,7,7 };
        final int GIVEN = 1;
        Assert.assertEquals(GIVEN, Assignment2Task1.MaxIncreasingSubsequence(arr));
    }


    @Test
    public void test3(){
        int[] arr = {0,1,0,3,2,3};
        final int GIVEN = 4;

        Assert.assertEquals(GIVEN, Assignment2Task1.MaxIncreasingSubsequence(arr));
    }
}