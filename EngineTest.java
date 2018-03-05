import static org.junit.Assert.*;				
import org.junit.Test;
import org.junit.runner.JUnitCore;		
import org.junit.runner.Result;		
import org.junit.runner.notification.Failure;
import java.util.*;

public class EngineTest {
  
  private Engine engine;
  
 
  /*
   * 1st test case:
   * Function is meant to add the list of keywords.
   * The function has not been implemented in engine.java
   * yet.
   
  @Test
  public void keywordsTest1()
  {
    assertNull( engine.checkKeywords(null) );
  }
  
  /*
   * 2nd test case:
   * Added a parameter
   
  @Test
  public void keywordsTest2()
  {
    assertEquals( "Oscar" , engine.checkKeywords("Oscar") );
  }
  
  /*
   * 3rd test case:
   * Check keyword size
   
  @Test
  public void keywordSizeTest1()
  {
    assertEquals( "3" , engine.checkKeywords("bob,bill,will") );
  }
  

  // Check if word biggere than 25 was deleted
  @Test
  public void keywordSizeTest2()
  {
    assertEquals( "2" , engine.checkKeywords("bo234234234234235457456242342353544563424b,bill,will") );
  }
 


  // check if words were trimmed
  @Test
  public void trimTest()
  {
    assertEquals("bob" , engine.checkKeywords("  bob  ") );
  }


  // check if string is in xml form
  @Test
  public void XMLformTest()
  {
    assertEquals( "<keywords>bob,bill,boy</keywords>" , engine.checkKeywords("bob,bill,boy  ").trim() );
  }


  // check if blanks are inserted
  @Test
  public void checkStringIsEmptyTest()
  {
    assertEquals("<keywords>bob</keywords>" , engine.checkKeywords("bob,     ").trim() );
  }

  */

  // check if max limit of 5 keywords are saved
  @Test
  public void maxLimitTest()
  {
    assertEquals("<keywords>1,2,3,4,5</keywords>" , engine.checkKeywords("1,2,3,4,5,6,7") );
  }

  // Test for max limit and extra spaces
  @Test
  public void limitAndSpacingTest()
  {
    assertEquals("<keywords>one,two,three,four,five</keywords>" , engine.checkKeywords("one , two   , three ,four,five, six, seven,   eightee"));
  }


}
