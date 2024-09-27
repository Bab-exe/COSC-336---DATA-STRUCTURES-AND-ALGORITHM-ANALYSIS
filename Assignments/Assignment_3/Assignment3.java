import java.io.FileReader;
import java.util.Scanner;
/**  */
//L[I] < R[j]

public class Assignment3 {
    public static void main(String[] args){
        System.err.println(UP_Pairs(new int[]{7,3,8,1,5}));
        //248339 System.out.println("input-3.4.txt UP_Pairs: " + UP_Pairs(inputFile("input-3.4.txt")));
        //24787869 System.out.println("input-3.5.txt UP_Pairs: " + UP_Pairs(inputFile("input-3.5.txt")));
    }

    public static int UP_Pairs(int[] arr){
        return merge(arr,0,arr.length);
    }

    

    /** modified merge method from book to return UP pairs
     * @param A the main array
     * @param  p left index
     * @param  r right index
     * @return UP pair count 
    */
    public static int merge(int[] A, int p , int r){
        if (A == null || A.length <= 1 || p >= r) return 0; //if null or length less than 1 or left index bigger than right index,
        //removed + 1 for left index cus book was using 1 based indexing for some reason

        final int MID = A.length/2;
        final int n1 = MID - p  ; 
        final int n2 = r - MID; 

        int[] L = new int[n1];
        int[] R = new int[n2];

        //puts values in L and R from main Aay
        for (int i = 0; i < n1; i++)
            L[i] = A[p + i];

        for (int j = 0; j < n2; j++)
            R[j] = A[MID + j];

        //sorts L and R
        int pairs =merge(L,0,L.length) +merge(R,0,R.length);

        //i =left index, j = right index, k = main array index
        int i = 0;
        int j = 0;
        int k = p;
        

        while (i < n1 && j < n2) { 
            if (L[i] <= R[j]) {
                System.err.print( "(" + L[i] + " " + R[j] + ") ");
                A[k++] = L[i++];       
                pairs += n2 - j;
            }    
            else {
                A[k++] = R[j++];
            }
               
                
        }
        
        while (i < n1) {
            A[k++] = L[i++];
        }
       
        while (j < n2) {
            A[k++] = R[j++];
        }

        return pairs;
    }
   
    /** reads the file and converts it to an int array */
    public static int[] inputFile(String filename) {
        
        try (Scanner input = new Scanner(new FileReader(filename))) {

            //size is the first number
            final int n = input.nextInt();

            //reads ints in the file
            int[] A = new int[n];
            for (int i = 0; i < n; i++) 
                A[i] = input.nextInt();
            
            return A;
        }catch(java.io.FileNotFoundException e) {
            System.err.println("File not found: '" + filename + "'");
        }

        return null;
    } 
    
    
}
