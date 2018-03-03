import static org.junit.Assert.*;				
import org.junit.Test;
import org.junit.runner.JUnitCore;		
import org.junit.runner.Result;		
import org.junit.runner.notification.Failure;
import java.util.*;

public class EngineTest {
  
  Engine engine;
  
  @Before
  public void before()
  {
    engine = new Engine();
  }
  
  /*
   * 1st test case:
   * Function is meant to add the list of keywords.
   * The function has not been implemented in engine.java
   * yet.
   */
  @Test
  public void addKeywordsTest()
  {
    assertNull( engine.addKeywords() );
  }
  
  
  
}