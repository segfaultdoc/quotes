import static org.junit.Assert.*;				
import org.junit.Test;
import org.junit.runner.JUnitCore;		
import org.junit.runner.Result;		
import org.junit.runner.notification.Failure;
import java.util.*;
import java.io.*;

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

*/
  QuoteList ql = new QuoteList();
  Scanner in;
  Scanner searcher;
  QuoteSaxParser qParser;

  
  public EngineTest(){
    
    in = new Scanner(System.in);
    qParser = new QuoteSaxParser("quotes.xml");
    ql = qParser.getQuoteList(); 
  }
  @Test
  public void getIdOfLastQuoteTest(){
    Engine en;// =// new Engine();
    //assertEquals(10, Engine.getIdOfLastQuote());
    assertEquals("13",ql.getLastId());
  }
  @Test
  public void searchKeywordsTest(){
    // this test only checks to see if at least the first
    // occurence of the keyword is returned with id 10
    QuoteList results = ql.search("health", 3);
    assertEquals("10", results.getQuote(0).getId());
  }

  @Test
  public void searchKeywordsMultipleQuotesTest(){
    // this test only checks to see if all quotes with
    // the health keyword are returned
    QuoteList results = ql.search("health", 3);
    assertEquals("10", results.getQuote(0).getId());
    assertEquals("12", results.getQuote(1).getId());
  }

   @Test
  public void searchDifferentKeywordsMultipleQuotesTest(){
    // this test checks to see if all quotes with
    // the "health" or "im fat" keywords are returned
    QuoteList results = ql.search("health, im fat", 3);
    assertEquals("10", results.getQuote(0).getId());
    assertEquals("11", results.getQuote(1).getId());
     assertEquals("12", results.getQuote(2).getId()); 
  }

  @Test
  public void rightNumberOfQuotesTest(){
    // this test only checks to see that only
    // 2 quotes were returned, since there are
    // only 2 quotes with this keyword
    QuoteList results = ql.search("health", 3);
    assertEquals(2, results.getSize());
  }


  @Test
  public void rightNumberOfQuotesTest2(){
    // this test only checks to see that only 
    // 3 quotes were returned since only 
    // 3 quotes have either of these keywords
    QuoteList results = ql.search("health, im fat", 3);
    assertEquals(3, results.getSize());
  }







}
