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
   */
  @Test
  public void checkKeywordsTest1()
  {
    assertNull( engine.checkKeywords(null) );
  }
  
  /*
   * 2nd test case:
   * Added a parameter
   */
  @Test
  public void checkKeywordsTest2()
  {
    assertEquals( "Oscar" , engine.checkKeywords("Oscar") );
  }
  
  
}