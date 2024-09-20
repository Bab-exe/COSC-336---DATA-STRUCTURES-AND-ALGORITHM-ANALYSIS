/**Tamir Krief, Iaian Milton, Blessing Abumere */



/** You will write a program that computes the length of a longest increasing subsequence
 of a sequence of integers.
 +takes input */

public class Assignment2Task1 {

    public static void main(String[] args) {
        java.util.Scanner input = new java.util.Scanner(System.in);

        int[] user_sequence = Prompt_Sequence(input);

        System.out.print("\nMax Increasing Subsequence: " + MaxIncreasingSubsequence(user_sequence));
    }
    /** a program that computes the length of a longest increasing subsequence
 of a sequence of integers. * */
    public static int MaxIncreasingSubsequence(int[] arr){
        //basecase
        if(arr == null || arr.length == 0)
            return 0;

        //not sure if the grader prefers d like the assignment pdf variable name or an actual variable name like {counts} ; variable name is just ,like the assignment pdf, d to be safe
        //d[i] corresponds with arr[i]
        int[] d = new int[arr.length]; //keeps track of the COUNTS of the max increasing subsequence 
            d[0] = 1; // d[0] will always be initialized to 1 as will any d[i] as that is the basecase

        int max_count = 1; //intitialization step is  1

        for (int i = 1; i < arr.length;i++){ //i is always bigger than j
            d[i] = 1;   //intitialized to 1 for the base case of no increasing subsequences 
            for (int j = 0; j < i; j++){ 
                //if current element is greater than a previous element in the array and
                //if d[i] is greater than d[j] + 1 then d[i] count will go up
                if (arr[i] > arr[j]){
                    if (d[i] < d[j] + 1)
                        d[i] = d[j] + 1;
                }
            }
            //update max_count if d[i] is bigger
            if (d[i] > max_count)
                max_count = d[i];
        }


        return max_count;
    }
        
      /**reads the initial sequence which is entered by the user*/
    public static int[] Prompt_Sequence(java.util.Scanner input){ 
        int[] sequence;
        try {
            System.out.println("\nEnter the length of the sequence");
                sequence = new int[input.nextInt()];

            System.out.println("\nEnter the values of the sequence[]");
                
            for (int i = 0; i < sequence.length; i++){
                sequence[i] = input.nextInt();
            }
            System.out.println("sequence[] = " + java.util.Arrays.toString(sequence));
            return sequence; 
        }catch(java.util.InputMismatchException e){
            input.nextLine();
            System.err.print("Integer Values only. Please Try again\n");
            Prompt_Sequence(input);
        }
       
        return null;
    }


    
}
