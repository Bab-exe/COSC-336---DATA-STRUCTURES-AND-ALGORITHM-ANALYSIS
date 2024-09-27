import static org.junit.Assert.assertArrayEquals;
import org.junit.Test;
import junit.framework.Assert;

@SuppressWarnings("deprecation")
public class Assignment3UnitTests extends Assignment3{
    @Test 
    public void Merge_Sort(){
        int[] arr1 = {3,2,1, 6, 5 ,4 };
        int[] expected = { 1, 2, 3, 4, 5 , 6 };
            merge(arr1,0,arr1.length);
            assertArrayEquals(expected, arr1);

        int[] arr2 = {6,5,4,68,3,2,1,0};
        int[] expected2 = {0, 1, 2, 3, 4, 5 , 6 ,68};
            merge(arr2,0,arr2.length);
            assertArrayEquals(expected2, arr2);
    }

    
    @Test 
    /**  for example input sequence 7,3,8,1,5, we have the following UP-pairs: (7, 8), (3,8),(3,5),(1,5). */
    public void UP_Pairs(){
        int[] arr1 = {7,3,8,1,5}; //pairs; (7,8), (3,8),(3,5),(1,5)
            Assert.assertEquals(4, UP_Pairs(arr1));
        
        int[] arr2 = {1,2,3,4}; //pairs; (1,2) (1,3) (1,4) , (2,3) (2,4), (3,4) 
            Assert.assertEquals(6, UP_Pairs(arr2));

        int[] arr3 = {7,3,8,1} ; //pairs; (7,8), (3,8)
            Assert.assertEquals(2, UP_Pairs(arr3));
 
        int[] arr4 = {3,2,1,0}; //pairs; 0
            Assert.assertEquals(0, UP_Pairs(arr4));

        
        int[] arr5 = {1,2,3,4,5,6,7,8,9,10};
            Assert.assertEquals(45, UP_Pairs(arr5));        

        int[] arr6 = {9,10,7,8,6,5,3,4,1,2};
            Assert.assertEquals(4, UP_Pairs(arr6));

        System.out.println("Simple Tests Passed");
        int[] input1 = inputFile("input-3.4.txt");
            System.out.println("input-3.4.txt UP_Pairs: " + UP_Pairs(input1));

        int[] input2 = inputFile("input-3.5.txt");
            System.out.println("input-3.5.txt UP_Pairs: " + UP_Pairs(input2));
    }

    @Test
    public void UP_PairsBase(){
        int[] arr1 = {1,2}; //pairs; (1,2)
            Assert.assertEquals(1, UP_Pairs(arr1));

        int[] arr2 = new int[0];
            Assert.assertEquals(0, UP_Pairs(arr2));

        int[] arr3 = {2,1};
            Assert.assertEquals(0, UP_Pairs(arr3));
        
        int[] arr4 = {1};
            Assert.assertEquals(0, UP_Pairs(arr4));

        int[] arr5 = {1,2,3}; // (1,2) (1,3) (2,3)
            Assert.assertEquals(3, UP_Pairs(arr5));
        

    }
    
    @Test 
    /** tests that input files UP pairs are correct */
    public void TheTestTest(){
        int[] input1 = inputFile("input-3.4.txt");
        int[] input2 = inputFile("input-3.5.txt");
        
        Assert.assertEquals(
            Brute_UP_Pairs(input1),
            UP_Pairs(input1)
        );

        Assert.assertEquals(
            Brute_UP_Pairs(input2),
            UP_Pairs(input2)
        );


    }
    @Test 
    /** Tests if input file is read correctly */
    public void InputFileTest(){
        int[] arr1 = inputFile("input-3.4.txt");
            Assert.assertEquals(1000, arr1.length);
            Assert.assertEquals(arr1[0],448);
            Assert.assertEquals(arr1[arr1.length-1],321);

        int[] arr2 = inputFile("input-3.5.txt");
            Assert.assertEquals(10000, arr2.length);
            Assert.assertEquals(arr2[0],745);
            Assert.assertEquals(arr2[arr2.length-1], 1057);
        
    }



    /** O(n^2) Up pair brute force*/
    public int Brute_UP_Pairs(int[] arr){
        /** For example, for n = 5 and input sequence 7,3,8,1,5, we have the following UP-pairs:
 (7, 8), (3,8),(3,5),(1,5). So, there are 4 UP-pairs. Design an O(nlogn) algorithm which
 computes the number of UP-pairs  */

        int pairs = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i+1; j < arr.length; j++) {
                if (arr[i] < arr[j]) {
                    //System.err.print( "(" + arr[i] + " " + arr[j] + ") ");
                    pairs++;
                }
            }
        }

        return pairs;
    }

  
}