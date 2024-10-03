import org.junit.Assert;
import org.junit.Test;


public class Assignment4Tests extends CuttingRod{
    @Test 
    public void baseCase(){
        int[] empty = new int[0];
            int[] optCut = extendedBottomUpCutRod(empty, empty.length);
            int maxRevenue = optCut[empty.length];
        Assert.assertEquals(0,maxRevenue);

        int[] price1 = {1};
            optCut = extendedBottomUpCutRod(price1, price1.length);
            maxRevenue = optCut[price1.length];
        Assert.assertEquals(1,maxRevenue);
    }


    @Test 
    /** Data set 1: 1,5,8,9,10,17,17,20,24,30. (This is the example on page 364) */
    public void DataSet1(){
        int[] price1 = {1, 5, 8, 9, 10, 17, 17, 20, 24, 30};
        int length1 = price1.length; //10

        int[] optCut = extendedBottomUpCutRod(price1, length1);
        
        int maxRevenue = optCut[length1];

        Assert.assertEquals(10,maxRevenue);
        

     
    }


    @Test 
    public void FileReading(){
        int[] arr4_2 = CuttingRod.inputFile("input-4.2.txt");

        //size is the first number 
            Assert.assertEquals(15,arr4_2.length);

            //first and last val test
            Assert.assertEquals(1,arr4_2[0]);
            Assert.assertEquals(11,arr4_2[arr4_2.length-1]);

        int[] arr4_3 = CuttingRod.inputFile("input-4.3.txt");

        //size is the first number
            Assert.assertEquals(15,arr4_3.length);

            //first and last val test
            Assert.assertEquals(3,arr4_3[0]);
            Assert.assertEquals(4,arr4_3[arr4_3.length-1]);
    }
}
