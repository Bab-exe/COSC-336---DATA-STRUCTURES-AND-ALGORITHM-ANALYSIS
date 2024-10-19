import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class Assignment5Tests extends Assignment5 {
    @Test
    /**  For example, for sequence 1,14,5,6,2,3, the increasing subsequence 1,14 has the largest
 sum 1+14 = 15. (1,5,6 is another increasing subsequence but its sum, 1 + 5 + 6 = 12 is
 smaller.) */
    public void seq1(){
        int[] arr = {1,14,5,6,2,3};
            final int expected = 15;

        assertEquals(expected, sumIncreasingSubsequence(arr));

    }

    @Test
    /** custom tests to be sure */
    public void EzTests(){
        int[] seq1 = {1,2,3,4,5};
            final int expected1 = 1 + 2 + 3 + 4 + 5;
        assertEquals(expected1, sumIncreasingSubsequence(seq1));

        int[] seq2 = {5,6,4,3,2,1}; 
            final int expected2 = 5 + 6;
        assertEquals(expected2, sumIncreasingSubsequence(seq2));

        

    }

    @Test
    public void HardTests(){

    }

    @Test
    public void baseCase(){
        int[] seq1 = {1};
            final int expected1 = 1;
        assertEquals(expected1, sumIncreasingSubsequence(seq1));

        int[] seq2 = {1,2};
            final int expected2 = 1 + 2;
        assertEquals(expected2, sumIncreasingSubsequence(seq2));

        int[] seq3 = {2,1};
            final int expected3 = 2;
        assertEquals(expected3, sumIncreasingSubsequence(seq3));

        int[] seq4 = {};
            final int expected4 = 0;
        assertEquals(expected4, sumIncreasingSubsequence(seq4));
    }

    @Test
    /** tests if file reading is working correctly by 
     *  1. reading the file
     *  2. testing if the array length is correct
     *  3. testing if the first and last values are correct
     */
    public void FileReadingTest(){
        int[] input5_1 = inputFile("input-5.1.txt");
            assertEquals(6,input5_1.length);
            assertEquals(1, input5_1[0]);
            assertEquals(5,input5_1[input5_1.length-1]);   

        int[] input5_2 = inputFile("input-5.2.txt");
            assertEquals(12,input5_2.length);
            assertEquals(41, input5_2[0]);
            assertEquals(30000, input5_2[input5_2.length-1]);

        int[] input5_3 = inputFile("input-5.3.txt");
            assertEquals(12,input5_3.length);
            assertEquals(50000, input5_3[0]);
            assertEquals(50000, input5_3[input5_3.length-1]);

        int[] input5_4 = inputFile("input-5.4.txt");
            assertEquals(20,input5_4.length);
            assertEquals(25197, input5_4[0]);
            assertEquals(30953, input5_4[input5_4.length-1]);

    }

}
