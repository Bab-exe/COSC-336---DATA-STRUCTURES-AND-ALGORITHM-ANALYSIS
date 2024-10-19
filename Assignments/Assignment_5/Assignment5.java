import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;


/** The input consists of a sequence of numbers a[1],a[2,]...,a[n]. Your task is to design
 an O(n^2) algorithm that finds an increasing subsequence with the maximum possible sum.
 An increasing subsequence is given by a sequence of indices 1 ≤ i1 < i2 < ... < ik ≤ n
 such that a[i1] ≤ a[i2] ≤ ... ≤ a[ik]. Note the the indices defining the subsequence are not
 necessarily consecutive numbers. The program will output the max sum and the increasing
 subsequence with that sum.
 Your algorithm should work in time O(n2).
 For example, for sequence 1,14,5,6,2,3, the increasing subsequence 1,14 has the largest
 sum 1+14 = 15. (1,5,6 is another increasing subsequence but its sum, 1 + 5 + 6 = 12 is
 smaller.)
 Input specification: the first line contains n and the second line contains a1,...,an.
 Numbers on the same line are separated by spaces. You may assume that n is not bigger
 than 10,000 and all the numbers fit in int. */


public class Assignment5 {

    public static void main(String[] args) {
        int[] seq1 = {1,14,5,6,2,3};

        System.out.println(sumIncreasingSubsequence(seq1));
    }


     /** reads the file and converts it to an int array */
    public static int[] inputFile(String filename) {
        try (Scanner console = new Scanner(new FileReader(filename))) {
            //size is the first number
            final int n = console.nextInt();

            //reads ints in the file
            int[] A = new int[n];
            for (int i = 0; i < n; i++) 
                A[i] = console.nextInt();
            
            return A;
        }catch(FileNotFoundException e) {
            System.err.println("File not found: '" + filename + "'");
        }

        return null;
    } 

    static public int sumIncreasingSubsequence(int[] A){
        int maxSum = 0;
        int sum = 0;
        int value;
        for (int i = 0; i < A.length; i++) {
            value = A[i];
            sum = value;
            for (int j = i+1; j < A.length; j++) {
                if (A[j] > value) //if the next number is greater than the current number then the number is  added and value is changed to the next number                    
                    sum += value = A[j];            
            }
            if (sum > maxSum) 
                maxSum = sum;
        }
        return maxSum;


    }
}