	
import java.io.PrintWriter;
import java.io.*;

/**
 *
 * @author AV
 */
public class TestStaticMethods {

    /**
    * Tests for 4 stand-alone methods of Assignment 3
    * @return total score for AggregationClass  part of assignment  
    */
    public static boolean tests(PrintWriter out)
    { 

		out.println("\r\n----Rectangle Class TEST SETS -------------------------------------------------------\r\n");

        boolean t1 = testSet06Assignment03Methods(out);
        boolean t2 = testSet07Assignment03Methods(out);
        boolean t3 = testSet08Assignment03Methods(out);    
       
        return t1 && t2 && t3;   
    } 
    
    /**
  * Set of unit tests for isSorted() method
  * @param outputStream stream to direct output into
  * @return number of points earned for this unit. 0 is returned if even one of the tests failed
  */   
   public static boolean testSet06Assignment03Methods(PrintWriter outputStream)
    {
        int count = 0;
        int expectedCount = 3;
               

        try
        {
 // Test #1           
             LargeInteger[] objects = new LargeInteger[5];
            objects[0] = new LargeInteger("12345");
            objects[1] = new LargeInteger("12345");
            objects[2] = new LargeInteger("12347");
            objects[3] = new LargeInteger("12348");
            objects[4] = new LargeInteger("12344");
            if(Polymorphic.isSorted(objects)== false) 
            {
                outputStream.printf("%-80s%-10s\r\n", "Test Set 06: Test for Polymorphic.isSorted() - unsorted array",  "PASSED");
                count++;
            }
            else  outputStream.printf("%-80s%-10s\r\n", "Test Set 06: Test for Polymorphic.isSorted() - unsorted array",  "FAILED");
// Test #2            
           objects[4] = new LargeInteger("12354"); // change array to make it sorted;
           if(Polymorphic.isSorted(objects)) 
            {
                outputStream.printf("%-80s%-10s\r\n", "Test Set 06: Test for Polymorphic.isSorted() - sorted array",  "PASSED");
                count++;
            }
            else  outputStream.printf("%-80s%-10s\r\n", "Test Set 06: Test for Polymorphic.isSorted() - sorted array",  "FAILED");    
        }
        catch(LargeIntegerNumberFormatException e)
        {
            outputStream.println("LargeIntegerNumberFormatException! "+e.getMessage());
        }
// Test #3 - test if method parameters are of correct type       
        
        Rectangle [] rArray = new Rectangle[5];
        rArray[0] = new Rectangle(1, 1);
        rArray[1] = new Rectangle(2, 2);
        rArray[2] = new Rectangle(3, 3);
        rArray[3] = new Rectangle(4, 4);
        rArray[4] = new Rectangle(5, 5);
        if(Polymorphic.isSorted(rArray)) 
          {
              outputStream.printf("%-80s%-10s\r\n", "Test Set 06: Test for Polymorphic.isSorted() - array of Rectangles",  "PASSED");
              count++;
          }
          else  outputStream.printf("%-80s%-10s\r\n", "Test Set 06: Test for Polymorphic.isSorted() - array of Rectangles",  "FAILED"); 
        
        return count==expectedCount;
    } 
   
  
  /**
  * Set of unit tests for FileIOMethods.writeLargeIntegerArray() and FileIOMethods.readLargeIntegerArray() methods
  * @param outputStream stream to direct output into
  * @return number of points earned for this unit. 0 is returned if even one of the tests failed
  */   
   public static boolean testSet07Assignment03Methods(PrintWriter outputStream)
    {
        int count = 0;
        int expectedCount = 2;
               

        try
        {
 // Test #1           
            LargeInteger a1 = new LargeInteger("12345");
            LargeInteger a2 = new LargeInteger("12345");
            LargeInteger a3 = new LargeInteger("12347");
            LargeInteger a4 = new LargeInteger("12348");
            LargeInteger a5 = new LargeInteger("12344");
            LargeInteger[] objects = new LargeInteger[5];
            objects[0] = a1;
            objects[1] = a2;
            objects[2] = a3;
            objects[3] = a4;
            objects[4] = a5;
            LargeInteger[] array1 = null;
            try{          
                FileIOMethods.writeLargeIntegerArray(objects, "data.dat");
                array1 = FileIOMethods.readLargeIntegerArray("data.dat");  
            }
            catch(IOException e)
            {
                outputStream.println("IOException!! "+e.getMessage());
            }
            boolean equalArrays = false;
            if(array1.length==objects.length) 
            {
                equalArrays = true;
                for(int i = 0; i<array1.length; i++)
                {
                    if(!array1[i].equals(objects[i])) 
                    {
                        equalArrays = false;
                        break;
                    }
                }
            }
            if(equalArrays)
            {
                outputStream.printf("%-80s%-10s\r\n", "Test Set 07: Test for Read/Write LargeInteger methods",  "PASSED");
                count++;
            }
            else  outputStream.printf("%-80s%-10s\r\n", "Test Set 07: Test for Read/Write LargeInteger methods",  "FAILED");   
 
// Test #2 - IOException                
            try{          
                array1 = FileIOMethods.readLargeIntegerArray("data1.dat");  // exception must happen and thrown by method because "data1.dat" does not exist
                outputStream.printf("%-80s%-10s\r\n", "Test Set 07: Test for Read/Write LargeInteger methods - IOException",  "FAILED");   
            }
            catch(IOException e)
            {
                outputStream.printf("%-80s%-10s\r\n", "Test Set 07: Test for Read/Write LargeInteger methods - IOException",  "PASSED");
                count++;
            }            
              
        }
        catch(LargeIntegerNumberFormatException e)
        {
            outputStream.println("LargeIntegerNumberFormatException! "+e.getMessage());
        }
      
        return count==expectedCount;
    } 
   
    /**
  * Set of unit tests for FileIOMethods.writeLargeIntegerArray() and FileIOMethods.readLargeIntegerArray() methods
  * @param outputStream stream to direct output into
  * @return number of points earned for this unit. 0 is returned if even one of the tests failed
  */   
   public static boolean testSet08Assignment03Methods(PrintWriter outputStream)
    {
        int count = 0;
        int expectedCount = 3;
 
        try
        {
// Test #1  - test01.txt is a file with imperfect structure, but the sum can be calculated and returned    
           LargeInteger theSum = FileIOMethods.addLargeIntegersFromFile("test01.txt");
           if(theSum.toString().equals("11111111111111111111115") )
           {
               outputStream.printf("%-80s%-10s\r\n", "Test Set 08: Test for addLargeIntegersFromFile() - good file",  "PASSED");
               count++;
           }
           else  outputStream.printf("%-80s%-10s\r\n", "Test Set 08: Test for addLargeIntegersFromFile() - good file",  "FAILED");
// Test #2  - test01.txt is a file with imperfect structure, but the sum can be calculated and returned    
           theSum = FileIOMethods.addLargeIntegersFromFile("test02.txt");
           if(theSum==null )
           {
               outputStream.printf("%-80s%-10s\r\n", "Test Set 08: Test for addLargeIntegersFromFile() - file that causes overflow",  "PASSED");
               count++;
           }
           else  outputStream.printf("%-80s%-10s\r\n", "Test Set 08: Test for addLargeIntegersFromFile() - file that causes overflow",  "FAILED");
        }
        catch(IOException e)
        {
            outputStream.println("LargeIntegerNumberFormatException! "+e.getMessage());
        }
 // Test #3 - IOException                
        try{          
            LargeInteger theSum = FileIOMethods.addLargeIntegersFromFile("test03.txt");  // IOException must happen and thrown by method because "test03.txt" does not exist
            outputStream.printf("%-80s%-10s\r\n", "Test Set 08: Test for addLargeIntegersFromFile() - IOException",  "FAILED");   
        }
        catch(IOException e)
        {
            outputStream.printf("%-80s%-10s\r\n", "Test Set 08: Test for addLargeIntegersFromFile() - IOException",  "PASSED");
            count++;
        }         
        return count==expectedCount;
    } 
}

