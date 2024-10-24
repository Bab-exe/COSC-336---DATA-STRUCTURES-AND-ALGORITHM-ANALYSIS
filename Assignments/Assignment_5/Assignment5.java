import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class Assignment5 {

    public static void main(String[] args) {
        System.out.println("Max Increasing Subsequences:");
            System.out.println("[1,14,5,6,2,3]: " + sumIncreasingSubsequence(new int[]{1,14,5,6,2,3}));

            System.out.println("input-5.1.txt: " + sumIncreasingSubsequence(inputFile("input-5.1.txt")));

            System.out.println("input-5.2.txt: " + sumIncreasingSubsequence(inputFile("input-5.2.txt")));

            System.out.println("input-5.3.txt: " + sumIncreasingSubsequence(inputFile("input-5.3.txt")));

            System.out.println("input-5.4.txt: " + sumIncreasingSubsequence(inputFile("input-5.4.txt")));
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
    
    //the first version that was made from not reading all the directions delete when finished 
    /** calculates the sum of the increasing subsequence ; doesnt have to be continuous 
     * @param A the array of numbers
     * @return the max sum
     * TODO: make function pass input5_1 test; right now it just going in order. Does not work correctly for the case of when i < i+2 < i+1 
     
    static public int _sumIncreasingSubsequence(int[] A){
        final int N = A.length;
        int maxSum = 0;
        int sum, value;
        int[] sumArray = new int[1];
        int[] tempSumArray;

        for (int i = 0; i < N; i++) {
            value = A[i];
            sum = value;
            tempSumArray = new int[N - i];
                tempSumArray[0] = value;

            for (int s = 1,j = i+1; j < N; j++,s++) { //s is the index of the tempSumArray and j is the index of the number after value
                //if the next number is greater than the or equal current number then the number is added and value is changed to the next number                    
                if (value <= A[j]){
                    value = A[j];
                    sum += value;
                    
                    tempSumArray[s] = value;  
                }
                
                
            }
            if (sum > maxSum){
                sumArray = new int[tempSumArray.length];
                System.arraycopy(tempSumArray,0,sumArray,0,tempSumArray.length);
                maxSum = sum;
            }
                
        }

        System.err.println(maxSum + " = Summation Array: " + Arrays.toString(sumArray));
        return maxSum;


    }
    */
    

    //the second version that works and was made from following the directions
    /** calculates the sum of the increasing subsequence
     * @param A the array of numbers
     * @return the max sum
     * 
     */
    static public int sumIncreasingSubsequence(int[] A){
        final int N = A.length;
        int[] s = new int[N]; // max sum of an increasing subsequence with last element
        
        //didnt need to use p
        //int[] p = new int[N]; // index of the element preceding a[i]
           
        int maxSum = 0;
        for (int i = 0; i < N; i++) {
            //You start with s[i] = a[i] and p[i] = ? where {?} is a number that represents the index of the element before a[i] ; the number chosen doesnt matter .
            s[i] = A[i]; //the starting sum of A[i] which is whatever the first number from i is
           
            for (int j = 0; j < i; j++) { //from left to whatever index i is ; j is an index to the left of i
                if (A[j] <= A[i] && s[j] + A[i] >= s[i])  // if A[j] is less than or equal to A[i] and the sum of the subsequence ending at j plus A[i] is greater than the sum of the subsequence ending at i
                    s[i] = s[j] + A[i] ; //sum is recalculated and left index of i is added to A[i]   
            }
            if (s[i] > maxSum)
                maxSum = s[i];
           
        }
        return maxSum;
    }
}