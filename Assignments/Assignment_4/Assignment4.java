/** Tamir Krief, Iaian Milton, Blessing Abumere  */
import java.io.FileReader;
import java.util.Scanner;

public class Assignment4{
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