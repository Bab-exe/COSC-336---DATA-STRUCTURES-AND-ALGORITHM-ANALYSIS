import static org.junit.Assert.assertArrayEquals;
import org.junit.Test;
import junit.framework.Assert;

public class Assignment3UnitTests extends Assignment3{
    @Test 
    public void Merge_Sort(){
        int[] arr = {3,2,1, 6, 5 ,4 };
        int[] expected = { 1, 2, 3, 4, 5 , 6 };
           
        merge(arr,0,arr.length/2,arr.length);
        assertArrayEquals(expected, arr);

        int[] arr2 = {6,5,4,68,3,2,1,0};
        int[] expected2 = {0, 1, 2, 3, 4, 5 , 6 ,68};
           
        merge(arr2,0,arr2.length/2,arr2.length);
        assertArrayEquals(expected2, arr2);
    }

    @Test 
    /**  for example input sequence 7,3,8,1,5, we have the following UP-pairs: (7, 8), (3,8),(3,5),(1,5). */
    public void UP_Pairs(){
        int[] arr = {7,3,8,1,5};
            Assert.assertEquals(4, merge(arr, 0, arr.length/2, arr.length));

        int[] arr2 = {1,2};
            Assert.assertEquals(1, UP_Pairs(arr2));


        int[] arr3 = {3,2,1,0};
            Assert.assertEquals(0, UP_Pairs(arr3));


    }
}