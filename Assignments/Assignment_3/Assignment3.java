import java.io.FileReader;
import java.util.Scanner;
/**  */
//L[I] < R[j]

public class Assignment3 {
    public static void main(String[] args){
        System.out.println("input-3.4.txt UP_Pairs: " + UP_Pairs(inputFile("input-3.4.txt")));
        System.out.println("input-3.5.txt UP_Pairs: " + UP_Pairs(inputFile("input-3.5.txt")));
    }

    public static int UP_Pairs(int[] arr){       
        if (arr == null || arr.length < 2) return 0;

        int[] L = new int[arr.length/2];
        int[] R = new int[arr.length - L.length];

        System.arraycopy(arr, 0, L, 0, L.length);
        System.arraycopy(arr, L.length, R, 0, R.length);
       
        return (
            UP_Pairs(L) +
            UP_Pairs(R) +
            merge(arr,0,arr.length/2,arr.length) 

        );
        
    }

    

    /** modified merge method from book to return UP pairs
     * @param arr the main array
     * @param  p left index
     * @param  q middle index
     * @param  r right index
     * @return UP pair count 
    */
    public static int merge(int[] arr, int p ,int q , int r){
        if (arr == null || arr.length <= 1 || p >= r) return 0; //if null or length less than 1 or left index bigger than right index,
        System.err.println();

        //removed + 1 for left index cus book was using 1 based indexing for some reason
        int n1 = q - p ; 
        int n2 = r - q; 

        int[] L = new int[n1];
        int[] R = new int[n2];

        //puts values in L and R from main array
        for (int i = 0; i < n1; i++)
            L[i] = arr[p + i];

        for (int j = 0; j < n2; j++)
            R[j] = arr[q + j];

        //sorts L and R 
        int pairs = merge(L,0,n1/2,n1) + merge(R,0,n2/2,n2) ;
        
        //i =left index, j = right index, k = main array index
        int i = 0;
        int j = 0;
        int k = p;
        while (i < n1 && j < n2) { 
            if (L[i] <= R[j]) {
                System.err.print( "(" + L[i] + " " + R[j] + ") ");
                arr[k] = L[i];
                i = i + 1;
            }    
            else {
                arr[k] = R[j];
                j = j + 1;
                
            }
            k = k + 1;
        }

        pairs += i;
        
        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }
       

        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }

        return pairs;
    }


    
   
    public static int[] inputFile(String filename) {
        try (Scanner reader = new Scanner(new FileReader(filename))) {
            // Read the number of elements
            int n = reader.nextInt();

            //reads ints
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = reader.nextInt();
            }


           
            return arr;

        }catch(java.io.FileNotFoundException e) {
            System.err.println("File not found: '" + filename + "'");
            return null;
        }
    } 
    
    
}
