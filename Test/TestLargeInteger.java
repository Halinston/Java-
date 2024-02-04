import java.io.PrintWriter;
/**
 *
 * @author AV
 */
public class TestLargeInteger {

    /**
    * All tests for LargeInteger class
    * @return total score for AggregationClass  part of assignment
    */
    public static boolean tests(PrintWriter out)
    { 

		out.println("\r\n----LargeInteger Class TEST SETS -------------------------------------------------------\r\n");
        boolean t1 = testSet01TestsLargeIntegerClass(out);
        boolean t2 = testSet02TestsLargeIntegerClass(out);
        boolean t3 = testSet03TestsLargeIntegerClass(out);
        boolean t4 = testSet04TestsLargeIntegerClass(out);
        boolean t5 = testSet05TestsLargeIntegerClass(out);
        
        return t1 && t2 && t3 && t4 && t5;   
    } 
  /**
  * Set of unit tests for no-argument constructor, toString(), accessor
  * @param outputStream stream to direct output into
  * @return number of points earned for this unit. 0 is returned if even one of the tests failed
  */   
    public static boolean testSet01TestsLargeIntegerClass(PrintWriter outputStream)
    {
        int count = 0;
        int expectedCount = 2;

        LargeInteger num01 = new LargeInteger();
               
// Test #1
        if(num01.toString().equals("0")) 
        {
            outputStream.printf("%-80s%-10s\r\n", "Test Set 01: Test for no-argument constructor, and toString()",  "PASSED");
            count++;
        }
        else  outputStream.printf("%-80s%-10s\r\n", "Test Set 01: Test for no-argument constructor, and toString()",  "FAILED");
// Test #2
        if(num01.getDigitCount() == 1) 
        {
            outputStream.printf("%-80s%-10s\r\n", "Test Set 01: Test #1 for getDigitCount()",  "PASSED");
            count++;
        }
        else  outputStream.printf("%-80s%-10s\r\n", "Test Set 01: Test #1 for getDigitCount()",  "FAILED");

       
        return count==expectedCount;
       
    }
  /**
  * Set of unit tests for LargeInteger(String) constructor, toString(), getDigitCount(), and LargeIntegerNumberFormatException
  * @param outputStream stream to direct output into
  * @return number of points earned for this unit. 0 is returned if even one of the tests failed
  */   
    public static boolean  testSet02TestsLargeIntegerClass(PrintWriter outputStream)
    {
        int count = 0;
        int expectedCount = 5;
               
        try
        {
 // Test #1           
            LargeInteger num01 = new LargeInteger("123");
           
            if(num01.toString().equals("123")&& num01.getDigitCount()==3) 
            {
                outputStream.printf("%-80s%-10s\r\n", "Test Set 02: Test for LargeInteger(String) - short number & empty string",  "PASSED");
                count++;
            }
            else  outputStream.printf("%-80s%-10s\r\n", "Test Set 02: Test for LargeInteger(String) - short number & empty string",  "FAILED");
        }
        catch(LargeIntegerNumberFormatException e)
        {
        	outputStream.printf("%-80s%-10s\r\n", "Test Set 02: Test for LargeInteger(String) - short number & empty string",  "FAILED -- unexpected LargeIntegerNumberFormatException");
        }
 
// Test #2  
        try 
        {
            LargeInteger num02 = new LargeInteger("12345678901234567890123");
            
            if(num02.toString().equals("12345678901234567890123") && num02.getDigitCount()== 23) 
            {
                outputStream.printf("%-80s%-10s\r\n", "Test Set 02: Test for LargeInteger(String) - longest 23-digit number",  "PASSED");
                count++;
            }
            else  outputStream.printf("%-80s%-10s\r\n", "Test Set 02: Test for LargeInteger(String) - longest 23-digit number",  "FAILED");        
        }
        catch(LargeIntegerNumberFormatException e)
        {
        	outputStream.printf("%-80s%-10s\r\n", "Test Set 02: Test for LargeInteger(String) - longest 23-digit number",  "FAILED -- unexpected LargeIntegerNumberFormatException");
        }
 //Test #3 LargeIntegerNumberFormatException 
        try{
            LargeInteger num03 = new LargeInteger("123456789012345678901234"); // too long! 24 digts!
            outputStream.printf("%-80s%-10s\r\n", "Test Set 02: LargeIntegerNumberFormatException - number too long ",  "FAILED");          
        }
        catch (LargeIntegerNumberFormatException e)
        { 
            outputStream.printf("%-80s%-10s\r\n", "Test Set 02: LargeIntegerNumberFormatException - number too long ",  "PASSED");
            count++;
        }  
 //Test #4 LargeIntegerNumberFormatException 
        try{
            LargeInteger num03 = new LargeInteger("-123a345z"); // malformed number
            outputStream.printf("%-80s%-10s\r\n", "Test Set 02: LargeIntegerNumberFormatException - malformed number ",  "FAILED");          
        }
        catch (LargeIntegerNumberFormatException e)
        { 
            outputStream.printf("%-80s%-10s\r\n", "Test Set 02: LargeIntegerNumberFormatException - malformed number ",  "PASSED");
            count++;
        }  
 //Test #5 LargeIntegerNumberFormatException 
        try{
            LargeInteger num03 = new LargeInteger(""); // empty string
            outputStream.printf("%-80s%-10s\r\n", "Test Set 02: LargeIntegerNumberFormatException - empty string ",  "FAILED");          
        }
        catch (LargeIntegerNumberFormatException e)
        { 
            outputStream.printf("%-80s%-10s\r\n", "Test Set 02: LargeIntegerNumberFormatException - empty string ",  "PASSED");
            count++;
        }  
        return count==expectedCount;

    } 

  /**
  * Set of unit tests for LargeInteger(Long) constructor and LargeIntegerNumberFormatException
  * @param outputStream stream to direct output into
  * @return number of points earned for this unit. 0 is returned if even one of the tests failed
  */   
    public static boolean testSet03TestsLargeIntegerClass(PrintWriter outputStream)
    {
        int count = 0;
        int expectedCount = 3;
          
// Test #1
        try
        {
            LargeInteger num01 = new LargeInteger(123L);
            if(num01.toString().equals("123")&& num01.getDigitCount()==3) 
            {
                outputStream.printf("%-80s%-10s\r\n", "Test Set 03: Test for LargeInteger(long) - short number",  "PASSED");
                count++;
            }
            else  outputStream.printf("%-80s%-10s\r\n", "Test Set 03: Test for LargeInteger(long) - short number",  "FAILED");
// Test #2            
            LargeInteger num02 = new LargeInteger(Long.MAX_VALUE);

            if(num02.toString().equals("9223372036854775807") && num02.getDigitCount()== 19) 
            {
                outputStream.printf("%-80s%-10s\r\n", "Test Set 03: Test for LargeInteger(long) - longest 19-digit long number",  "PASSED");
                count++;
            }
            else  outputStream.printf("%-80s%-10s\r\n", "Test Set 03: Test for LargeInteger(long) - longest 19-digit long number",  "FAILED");        
        }
        catch(LargeIntegerNumberFormatException e)
        {
        	outputStream.printf("%-80s%-10s\r\n", "Test Set 03: Test for LargeInteger(long)",  "FAILED - unexpected LargeIntegerNumberFormatException"); 
        }
 //Test #3 LargeIntegerNumberFormatException 
        try{
            LargeInteger num03 = new LargeInteger(-123L); // negative, cannot be used 
            outputStream.printf("%-80s%-10s\r\n", "Test Set 03: LargeIntegerNumberFormatException - negative long number ",  "FAILED");          
        }
        catch (LargeIntegerNumberFormatException e)
        { 
            outputStream.printf("%-80s%-10s\r\n", "Test Set 03: LargeIntegerNumberFormatException - negative long number ",  "PASSED");
            count++;
        }  
 
        return count==expectedCount;

    } 
  /**
  * Set of unit tests for add() and LargeIntegerOverflowException 
  * @param outputStream stream to direct output into
  * @return number of points earned for this unit. 0 is returned if even one of the tests failed
  */   
    public static boolean testSet04TestsLargeIntegerClass(PrintWriter outputStream)
    {
        int count = 0;
        int expectedCount = 4;
            
// Test #1
        try
        {
            LargeInteger b1 = new LargeInteger(12945);
            LargeInteger b2 = new LargeInteger(999);
            LargeInteger b3 = b1.add(b2);
            if(b3.toString().equals("13944")&& b3.getDigitCount()==5) 
            {
                outputStream.printf("%-80s%-10s\r\n", "Test Set 04: Test for add())- short number",  "PASSED");
                count++;
            }
            else  outputStream.printf("%-80s%-10s\r\n", "Test Set 04: Test for add())- short number",  "FAILED");
// Test #2            

             b1 = new LargeInteger("11111111111111111111111");
             b2 = new LargeInteger("11111111111111111111111");
             b3 = b1.add(b2);
            if(b3.toString().equals("22222222222222222222222") && b3.getDigitCount()== 23) 
            {
                outputStream.printf("%-80s%-10s\r\n", "Test Set 04: Test for add() -  no carry over",  "PASSED");
                count++;
            }
            else  outputStream.printf("%-80s%-10s\r\n", "Test Set 04: Test for add() -  no carry over",  "FAILED");  
// Test #3                 
             b1 = new LargeInteger("12345678901234567890123");
             b2 = new LargeInteger("12345678901234567890123");
             b3 = b1.add(b2);
             LargeInteger b11 = new LargeInteger("999");
             LargeInteger b12 = new LargeInteger("1");
             LargeInteger b13 = b11.add(b12);
             LargeInteger b21 = new LargeInteger("191");
             LargeInteger b22 = new LargeInteger("11");
             LargeInteger b23 = b21.add(b22);            

            if(b3.toString().equals("24691357802469135780246") && b3.getDigitCount()== 23 &&
               b13.toString().equals("1000")&& b13.getDigitCount()== 4 &&
               b23.toString().equals("202")&& b23.getDigitCount()== 3) 
            	
            {
                outputStream.printf("%-80s%-10s\r\n", "Test Set 04: Test for add() -  carry over",  "PASSED");
                count++;
            }
            else  outputStream.printf("%-80s%-10s\r\n", "Test Set 04: Test for add() -  carry over",  "FAILED");        
        }
        catch(LargeIntegerOverflowException  e)
        {
        	outputStream.printf("%-80s%-10s\r\n", "Test Set 04: Test for add()",  "FAILED -- unexpected LargeIntegerOverflowException");
        }
        catch(LargeIntegerNumberFormatException  e)
        {
        	outputStream.printf("%-80s%-10s\r\n", "Test Set 04: Test for add()",  "FAILED -- unexpected LargeIntegerNumberFormatException");
        }
 //Test #4 LargeIntegerOverflowException 
        try{
             LargeInteger b1 = new LargeInteger("12345678901234567890123");
             LargeInteger b2 = new LargeInteger("99999999999999999999999");
             try {           
                LargeInteger b3 = b1.add(b2);
               outputStream.printf("%-80s%-10s\r\n", "Test Set 04: LargeIntegerOverflowException, number too large to fit",  "FAILED");          
            }
            catch (LargeIntegerOverflowException e )
            { 
                outputStream.printf("%-80s%-10s\r\n", "Test Set 04: LargeIntegerOverflowException, number too large to fit",  "PASSED");
                count++;
            }  
        }
        catch (LargeIntegerNumberFormatException e )
        {
        	outputStream.printf("%-80s%-10s\r\n", "Test Set 04: Test for add()",  "FAILED -- unexpected LargeIntegerNumberFormatException"); 
        }
 
 
        return count==expectedCount;

    }  
/**
  * Set of unit tests for clone(), equals(), isLess(), isGreater()
  * @param outputStream stream to direct output into
  * @return number of points earned for this unit. 0 is returned if even one of the tests failed
  */   
    public static boolean testSet05TestsLargeIntegerClass(PrintWriter outputStream)
    {
        int count = 0;
        int expectedCount = 4;
             
// Test #1 - clone()
        try
        {
            LargeInteger b1 = new LargeInteger(12945);
            LargeInteger copy = b1.clone();
                 if(copy.toString().equals("12945")&& copy.getDigitCount()==5 && copy.getState() == b1.getState()) 
            {
                outputStream.printf("%-80s%-10s\r\n", "Test Set 05: Test for clone()",  "PASSED");
                count++;
            }
            else  outputStream.printf("%-80s%-10s\r\n", "Test Set 05: Test for clone()",  "FAILED");
// Test #2  - isGreater()          
            
            b1 = new LargeInteger("12345678901234567890123"); // 12345670901234567890123
            LargeInteger b2 = new LargeInteger("1234567890123456789012"); // less digits
            LargeInteger b3 = new LargeInteger("12345670901234567890123"); // smaller number, same number of digits   
            LargeInteger b4 = new LargeInteger("3333"); // equal but not greater or smaller
            LargeInteger b5 = new LargeInteger("3333");
            LargeInteger b6 = new LargeInteger("2177");

            if(b1.isGreater(b2)&&b1.isGreater(b3)&&!b4.isGreater(b5)
            		&& b5.isGreater(b6)) 
            		//&& !b6.isGreater(b5))
            {
                outputStream.printf("%-80s%-10s\r\n", "Test Set 05: Test for isGreater()",  "PASSED");
                count++;
            }
            else  outputStream.printf("%-80s%-10s\r\n", "Test Set 05: Test for isGreater()",  "FAILED");
// Test #3   - isLess()             
            
            if(b2.isLess(b1)&&b3.isLess(b1)&& !b4.isLess(b5) && b6.isLess(b5) && !b5.isLess(b6) )
            {
                outputStream.printf("%-80s%-10s\r\n", "Test Set 05: Test for isLess()",  "PASSED");
                count++;
            }
            else  outputStream.printf("%-80s%-10s\r\n", "Test Set 05: Test for isLess()",  "FAILED");           

// Test #4 - equals()
            b1 = new LargeInteger(12945);
            b2 = new LargeInteger("12945");
            b3 = new LargeInteger("129456");
            b6 = new LargeInteger("12345");
            
            String s = "Test";
            HasState obj = new HasState();
            
            if(b1.equals(b2)&& !b1.equals(b3)&&!b1.equals(b6) && !b1.equals(s) && !b1.equals(obj)) 
            {
                outputStream.printf("%-80s%-10s\r\n", "Test Set 05: Test for equals()",  "PASSED");
                count++;
            }
            else  outputStream.printf("%-80s%-10s\r\n", "Test Set 05: Test for equals()",  "FAILED"); 
        }
        catch(LargeIntegerNumberFormatException e)
        {
        	outputStream.printf("%-80s%-10s\r\n", "Test Set 05",  "FAILED -- unexpected LargeIntegerNumberFormatException"); 
        }
 
        return count==expectedCount;

    } 
}
