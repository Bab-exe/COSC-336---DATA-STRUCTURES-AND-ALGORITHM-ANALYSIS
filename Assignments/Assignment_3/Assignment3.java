
/**  */
//L[I] < R[j]

public class Assignment3 {

    //TODO: pairs method
    public static int UP_Pairs(int[] arr){
        if (arr.length <= 1) return 0;
        if (arr.length == 2){
            if (arr[0] < arr[1]) return 1;

            return 0;
        }

        final int MID = (arr.length / 2)  ;

        int[] L = new int[MID]; //could be n1
        int[] R = new int[arr.length - MID]; //could be n2

        //array copying step using System.arraycopy instead of for loop manual copy
        System.arraycopy(arr, 0, L, 0, MID);
        System.arraycopy(arr, MID, R, 0, arr.length - MID);

        return merge(arr,L,R) + UP_Pairs(L) + UP_Pairs(R);
       

        
    }

    //working merge sort for testing
    public static void mergeSort(int[] arr) {
        if (arr.length <= 1) 
            return;
        
        final int MID = arr.length / 2;

        int[] L = new int[MID]; //could be n1
        int[] R = new int[arr.length - MID]; //could be n2

        //array copying step using System.arraycopy instead of for loop manual copy
        System.arraycopy(arr, 0, L, 0, MID);
        System.arraycopy(arr, MID, R, 0, arr.length - MID);


        //recursively sorts the halves; does the above process until the basecase of 1 and then sorts them and merges them into the main array
        mergeSort(L);
        mergeSort(R);

        // Merge the sorted halves
        merge(arr, L, R);
    }


    //working merge method for testing
    public static int merge(int[] arr, int[] L, int[] R) {
 
        /** i is index of left , j is index of right, k is absolute index of main array just like the mergesort in lect4*/
        int i = 0, j = 0, k = 0;
   
        //k always increases while i or j will eventually stop ;same as the textbooks way of sorting it 
        while (i < L.length && j < R.length) {
            if (L[i] <= R[j]) 
                arr[k++] = L[i++];
             else 
                arr[k++] = R[j++];
        }

        
        // Copies whatever is left into the main array; whatever space is leftabsolute position k is calculated by (array.length-k)
        if (i < L.length)
            System.arraycopy(L,i,arr,k,arr.length-k);

        if (j < R.length)
            System.arraycopy(R,j,arr,k,arr.length-k);

        return i;
    }

    

    //the books merge method //TODO: fix the books version
    public static void merge(int[] arr, int p ,int q , int r){
        if (arr.length <= 1 || p > r) return;
        
        int n1 = q - p + 1;
        int n2 = r - q;

        int[] L = new int[n1];
        int[] R = new int[n2];

        for (int i = 0; i < n1; i++)
            L[i] = arr[p + i];

        for (int j = 0; j < n2; j++)
            R[j] = arr[q + j + 1];

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


        
        

        //copies the remainder
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

    }


    
   


    
    
}
