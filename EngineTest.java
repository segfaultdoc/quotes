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
  public void checkKeywordsTest1()
  {
    assertNull( engine.checkKeywords(null) );
  }
  
  /*
   * 2nd test case:
   * Added a parameter
   
  @Test
  public void checkKeywordsTest2()
  {
    assertEquals( "Oscar" , engine.checkKeywords("Oscar") );
  }
  
  /*
   * 3rd test case:
   * Check keyword size
   
  @Test
  public void checkKeywordSize()
  {
    assertEquals( "3" , engine.checkKeywords("bob,bill,will") );
  }
  

  // Check if word biggere than 25 was deleted
  @Test
  public void checkKeywordSize()
  {
    assertEquals( "2" , engine.checkKeywords("bo234234234234235457456242342353544563424b,bill,will") );
  }
 


  // check if words were trimmed
  @Test
  public void checkTrim()
  {
    assertEquals("bob" , engine.checkKeywords("  bob  ") );
  }


  // check if string is in xml form
  @Test
  public void checkXMLform()
  {
    assertEquals( "<keywords>bob,bill,boy</keywords>" , engine.checkKeywords("bob,bill,boy  ").trim() );
  }
 */

  // check if blanks are inserted
  @Test
  public void checkStringIsEmpty()
  {
    assertEquals("<keywords>bob</keywords>" , engine.checkKeywords("bob,     ").trim() );
  }

}