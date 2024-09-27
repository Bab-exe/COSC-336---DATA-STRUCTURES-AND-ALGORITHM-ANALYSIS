
/**  */
//L[I] < R[j]

public class Assignment3 {

    //TODO: pairs method
    public static int UP_Pairs(int[] arr){
        return merge(arr, 0, arr.length / 2, arr.length) + 1;
        
    }

    

    /** modified merge method to return UP pairs
     * @param arr the main array
     * @param  p left index
     * @param  q middle index
     * @param  r right index
     * @return UP pair count 
    */
    public static int merge(int[] arr, int p ,int q , int r){
        if (arr == null || arr.length <= 1 || p > r) return 0; //if null or length less than 1 or left index bigger than right index,
       

        //removed + 1 for left index cus book was using 1 based indexing for some reason
        int n1 = q - p ; 
        int n2 = r - q; 

        int up_pairs = 0;

        int[] L = new int[n1];
        int[] R = new int[n2];

        //puts values in L and R from main array
        for (int i = 0; i < n1; i++)
            L[i] = arr[p + i];

        for (int j = 0; j < n2; j++)
            R[j] = arr[q + j];

        //sorts L and R 
        up_pairs += merge(L,0,n1/2,n1) ;
        up_pairs += merge(R,0,n2/2,n2);
        
        //i is left index, j is right index, k is main array index
        int i = 0;
        int j = 0;
        int k = 0;

        while (i < n1 && j < n2) { 
            if (L[i] <= R[j]) {
                arr[k] = L[i];
                i = i + 1;
            }
            else {
                arr[k] = R[j];
                j = j + 1;
            }
            k = k + 1;
        }

        //since i is also how many in L are smaller than R everything in it is a guaranteed pair
        up_pairs += i;

        
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

        return up_pairs;
    }


    
   


    
    
}
