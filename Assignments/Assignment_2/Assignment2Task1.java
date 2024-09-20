



/** You will write a program that computes the length of a longest increasing subsequence
 of a sequence of integers.
 +takes input */

public class Assignment2Task1 {


    /** a program that computes the length of a longest increasing subsequence
 of a sequence of integers. * */
    public static int MaxIncreasingSubsequence(int[] arr){
        //basecase
        if(arr == null || arr.length == 0)
            return 0;

        int[] counts = new int[arr.length]; //keeps the counts of the corresponding arr
            counts[0] = 1; //first element 

        
        int max_count = 1;
        for (int i = 1; i < arr.length; i++) {
            counts[i] = 1;
            for (int j = 0; j < i; j++) {
                if (arr[i] > arr[j]){ 
                    if (counts[j] + 1 > counts[i]) {
                        counts[i] = counts[j] + 1;
                    }
                        
                }
                
            }
            if (counts[i] > max_count){
                max_count = counts[i];
            }
               
            
                      
            
        }

        
        return max_count;


    }
       
      
        

       
        
    

    
}
