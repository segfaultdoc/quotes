import static org.junit.Assert.*;				
import org.junit.Test;
import org.junit.runner.JUnitCore;		
import org.junit.runner.Result;		
import org.junit.runner.notification.Failure;
import java.util.*;

public class QuoteListTest {
    
    QuoteList quoteList;
    
    // Put quotes into the QuoteList
    public void initializeList(){
        QuoteSaxParser qParser = new QuoteSaxParser ("quotes.xml");
        quoteList = qParser.getQuoteList();
    }
    
    
    // Tests
    
    @Test
    public void testSize(){
        initializeList();
        
        assertFalse( "Failed." , quoteList.getSize() == 2 );
        assertEquals( 10 , quoteList.getSize() );
    }

    @Test
    public void testSearch(){
        initializeList();
        
        // test search by author
        assertFalse( "Failed." , "Bob the Builder" == quoteList.search("George",0).getQuote(0).getAuthor() );
        assertEquals( "George Bernard Shaw" , quoteList.search("George",0).getQuote(0).getAuthor() );
        
        // test search by quote
        assertFalse("Failed." , "I am your father." == quoteList.search("Eschew",1).getQuote(0).getQuoteText() );
        assertEquals( "Eschew obfuscation!" , quoteList.search("Eschew",1).getQuote(0).getQuoteText() );
        
        // test search by both
        String testQuote = "We often do not know how to make those decisions [about a system design] until we can play with the system.";
        assertEquals( testQuote , quoteList.search("Software Aspects of SDI",2).getQuote(0).getQuoteText() );
    }

    @Test
    public void testGetQuote(){
        initializeList();
        
        assertEquals( "Richard Nixon" , quoteList.getQuote(0).getAuthor() );
    }
    
    @Test
    public void testGetRandomQuote(){
        initializeList();
        
        Quote random = quoteList.getRandomQuote();
        
        // check if a quote was returned
        assertNotNull(random);
    }
}
