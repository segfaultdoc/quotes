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
        
        assertFalse( "Failed." , "Bob the Builder" == quoteList.search("George",0).getQuote(0).getAuthor() );
        assertEquals( "George Bernard Shaw" , quoteList.search("George",0).getQuote(0).getAuthor() );
        
        assertEquals( "Eschew obfuscation!" , quoteList.search("Eschew",1).getQuote(0).getQuoteText() );
        
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
        
        assertNotNull(random);
        
    }
    
    
    @Test
    public void testFlaw(){
        
        ArrayList<String> words = new ArrayList<String>();
        
        words.add ("cookie");
        words.add ("cake");
        words.add ("cake");
        words.add ("pie");
        words.removeDuplicates();
        assertTrue ("removeDuplicates method", words.getFirst().equals ("cookie"));
    }



}
