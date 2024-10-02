import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class CuttingRod {
//note: if u use the github pdf book the cutting rod stuff is on pdf page 385

    public static int[] extendedBottomUpCutRod(int[] price, int length) {
        int[] revenue = new int[length + 1];
        int[] optCut = new int[length + 1];

        revenue[0] = 0; // Base case

        for (int j = 1; j <= length; j++) {
            int maxRevenueForLength = Integer.MIN_VALUE; // Initialize for each length j
            for (int i = 1; i <= j; i++) {
                if (maxRevenueForLength < price[i - 1] + revenue[j - i]) {
                    maxRevenueForLength = price[i - 1] + revenue[j - i];
                    optCut[j] = i; // Record the optimal cut
                }
            }
            revenue[j] = maxRevenueForLength; // Store the maximum revenue for length j
        }

        return optCut; // Return the optimal cuts array
    }

    public static void printCutRodSolution(int[] price, int length) {
        int[] optCut = extendedBottomUpCutRod(price, length);
        int maxRevenue = optCut[length]; // Revenue is calculated in the cut rod function

        System.out.println("Maximum Revenue: " + maxRevenue);
        System.out.print("Cut lengths: ");
        while (length > 0) {
            System.out.print(optCut[length] + " ");
            length = length - optCut[length];
        }
        System.out.println(); // New line after cuts
    }

    public static void main(String[] args) {
        // Test Case 1: Manual prices for a rod of length 10
        int[] price1 = {1, 5, 8, 9, 10, 17, 17, 20, 24, 30}; // Prices for lengths 1 to 10
        int length1 = 10;

        System.out.println("Test Case 1:");
        printCutRodSolution(price1, length1);

        int[] input4_2 = inputFile("input-4.2.txt");

        System.out.print("\ninput-4.2.txt: ") ;
            printCutRodSolution(input4_2,input4_2.length);

        // Test Case 2: Input prices from a file
        int[] input4_3 = inputFile("input-4.3.txt");
        System.out.println("\ninput-4.3.txt: ") ;
            printCutRodSolution(input4_3,input4_3.length);

        
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
        }catch(FileNotFoundException e) {
            System.err.println("File not found: '" + filename + "'");
        }

        return null;
    } 
}
