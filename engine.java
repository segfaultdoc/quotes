import java.util.Scanner; 
import java.io.IOException;
import java.util.ArrayList;



public class engine
{
   // initializes the quotelist and stores all the quotes from xml file into quoteList variable
   static QuoteList quoteList = new QuoteList();
   static String quoteFileName = "quotes.xml";
   

   // the current quote
   static Quote quote = new Quote();
   
   
   public static void main(String[] args){
      
      
      // keeps track of user input, if user enters 'exit' the while loop below will stop
      String tracker = "a";
      Scanner in = new Scanner(System.in);
      Scanner searcher = new Scanner(System.in);
      QuoteSaxParser qParser = new QuoteSaxParser (quoteFileName);
      quoteList = qParser.getQuoteList();
      
      // loop runs until user enters 'exit'
      while( !tracker.equalsIgnoreCase("exit") ){
         
         
         switch(tracker) {
            
            case "a":
               printRandomQuote();
               break;
            case "1":
               printRandomQuote();
               break;
            case "2":
               System.out.println("Enter keyword.");
               String key = searcher.nextLine();
               search( key , 1 );
               break;
            
            case "3":
               
               break;
            
            case "4":
               
               break;
            
         }
         
         
         
         
         System.out.println("\nPress 1 to get another random quote.");
         System.out.println("Press 2 to search by a keyword in a quote.");
         System.out.println("Press 3 to search by an author.");
         System.out.println("Press 4 to search by both.");
         System.out.println("Enter 'exit' to quit the program.");
         String inn = in.nextLine();
         tracker = inn;
         
         
         
      }
      
     
   }
   
   public static void search( String keyword , int mode)
   {
      QuoteList results = quoteList.search( keyword , 1 );
      System.out.println(results.quoteArray.size());
   }
   
   public static void printRandomQuote()
   {
      quote = quoteList.getRandomQuote();
      System.out.println("\nRandom quote of the day:");
      System.out.println( "  "+quote.getQuoteText() );
      System.out.println( "  -"+quote.getAuthor() );
   }
} 
