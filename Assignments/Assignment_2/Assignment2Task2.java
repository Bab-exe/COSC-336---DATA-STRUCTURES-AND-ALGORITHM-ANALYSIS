public class Assignment2Task2 {
    



   
    /** a program that computes the length of a longest decreasing subsequence of a sequence of integers. */
    public static int MaxDecreasingSubsequence(int[] arr){
        //basecase
        if(arr == null || arr.length == 0)
            return 0;

        int[] d = new int[arr.length]; //keeps track of the max decreasing subsequence
            d[0] = 1; // d[0] will always be initialized to 1 as will any d[i] 

        int max_count = 1;

       for (int i = 1; i < arr.length;i++){
           d[i] = 1;    
           for (int j = 0; j < i; j++){
               if (arr[i] < arr[j]){
                   if (d[j] + 1 > d[i]){
                       d[i] = d[j] + 1;
                   }
               }
           }
           if (d[i] > max_count){
               max_count = d[i];
           }
       }
                /* Formally, an increasing subsequence of the sequence a1,a2,...,an of length k is given
        by k indices 1 ≤ i1 < i2 < ... < ik ≤ n such that ai1 
        > ai2 
        > ... > aik
        . So the goal is to
        f
        ind the largest k for which there exists an decreasing subsequence of the input sequence of
        length k. */
        return max_count;
        
    }
}
