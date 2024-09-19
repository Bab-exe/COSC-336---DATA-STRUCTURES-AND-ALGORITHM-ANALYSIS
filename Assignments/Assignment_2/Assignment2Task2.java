public class Assignment2Task2 {
    
    public static int MaxDecreasingSubsequence(int[] arr){

        int[] counts = new int[arr.length]; //keeps the counts of the corresponding arr
            counts[0] = 1; // The first element is always an increasing subsequence of length 1

        int max_count = 1;
        for (int i = 1; i < arr.length; i++) {
            counts[i] = 1;
            for (int j = 0; j < i; j++) {
                if (arr[i] < arr[j]){ 
                    if (counts[j] + 1 > counts[i]) 
                        counts[i] = counts[j] + 1;
                }
                
            }
        }

        return max_count;
    }
}
