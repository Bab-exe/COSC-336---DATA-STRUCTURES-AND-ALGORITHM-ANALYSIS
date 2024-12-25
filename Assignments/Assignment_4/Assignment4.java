/** Tamir Krief, Iaian Milton, Blessing Abumere  */
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.FileNotFoundException;

public class Assignment4{
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
    
    //Extended-Bottom-Up-Cut-Rod(p,n) method to compute max revenue and cuts
    public static int[] extBottomUpCutRod(int[] p, int n) {
        int[] r = new int[n + 1];
        int[] s = new int[n + 1]; 
        
        r[0] = 0; //base case
        
        for (int j = 1; j <= n; j++) {
            int q = Integer.MIN_VALUE;
            for (int i = 1; i <= j; i++) {
                if (q < p[i - 1] + r[j - 1]) {
                    q = p[i - 1] + r[j - 1];
                    s[j] = i;
                }
            }
            r[j] = q;
        } 
        
        return new int[]{r[n], s[n]};
    }
    
    //Print-Cut-Rod-Solution(p,n) method to print the solution
    public static void printCutRodSolution(int[] p, int n) {
        int[] r = new int[n + 1];
        int[] s = new int[n + 1];
        ArrayList<Integer> cuts = new ArrayList<>();
        
        r[0] = 0;
        
        for (int j = 1; j <= n; j++) {
            int q = Integer.MIN_VALUE;
            for (int i = 1; i <= j; i++) {
                if (q < p[i - 1] + r[j - 1]) {
                    q = p[i - 1] + r[j - 1];
                    s[j] = i;
                }
            }
            r[j] = q;
        }
        
        while (n > 0) {
            cuts.add(s[n]);
            n = n - s[n];
        }
        
        System.out.println("Maximum Revenue: " + r[r.length - 1]);
        System.out.println("Cuts yielding this revenue: " + cuts);
    }
    
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        
        System.out.print("Enter the filename: "); //input-4.2.txt or input-4.3.txt
            String filename = console.nextLine();        
        int[] prices = inputFile(filename);
        
        console.close();
        if (prices == null) {
            System.out.println("Error reading the input file.");
            return;
        }
        
        int rodLength = prices.length;
        
        printCutRodSolution(prices, rodLength);
    }
}