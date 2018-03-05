/* 
 * @author - Zanyar Sherwani
 * @author - Omar Zairi
 *
 * This is the driver class that displays
 * menu prompts to the user and calls other
 * classes as helpers.
 *
 *
 */

import java.util.Scanner; 
import java.io.IOException;
import java.util.ArrayList;
import java.io.*;

public class Engine
{
   // initializes the quotelist and stores all the quotes from xml file into quoteList variable
   static QuoteList quoteList = new QuoteList();
   static String quoteFileName = "quotes.xml";
   
   // blacklist of profane words
   static Blacklist blkList = new Blacklist(); 
   
   // the current quote
   static Quote quote = new Quote();
   
   
   public static void main(String[] args){
      // keeps track of user input, if user enters 'exit' the while loop below will stop
      String tracker = "a";
       
      // parses the xml file into the quotelist
      Scanner in = new Scanner(System.in);
      Scanner searcher = new Scanner(System.in);
      QuoteSaxParser qParser = new QuoteSaxParser (quoteFileName);
      quoteList = qParser.getQuoteList();
      
      // loop runs until user enters 'exit'
      while( !tracker.equalsIgnoreCase("exit") ){
         
         printRandomQuote();
         
          // user menu
         System.out.println("\nPress 1 to get another random quote.");
         System.out.println("Press 2 to search by a keyword in a quote.");
         System.out.println("Press 3 to search by an author.");
         System.out.println("Press 4 to search by both.");
         System.out.println("Press 5 to search by keywords.");
         System.out.println("Press 6 to add a quote.");
         System.out.println("Enter 'exit' to quit the program.");
         
         String inn = in.nextLine();
         tracker = inn;
         
         // user input from possible menu options
         String key;
         
         // runs desired use case based on user input
         switch(tracker) {
            
            case "2":
               System.out.println("Enter search query.");
               key = searcher.nextLine();
               searchQuote( key );
               break;
            
            case "3":
               System.out.println("Enter search query.");
               key = searcher.nextLine();
               searchAuthor( key );
               break;
            
            case "4":
               System.out.println("Enter search query.");
               key = searcher.nextLine();
               searchBoth( key );
               break;
            
            case "5":
              // Search by keywords
              break;
            
            case "6":
               System.out.println("Enter the quote.");
               key = searcher.nextLine();
               String newQuote = key;
               
               if(blkList.containsBadWord(newQuote))
                  System.out.println("Sorry, innappropriate language will not be added to our database!");
               
               else{
                  
                    System.out.println("Enter the author.");
                    key = searcher.nextLine();
                    String newAuthor = key;
                    
                    if(blkList.containsBadWord(newAuthor))
                        System.out.println("Sorry, innappropriate language will not be added to our database!");
                     else
                     {
                      
                        String keywordString = null;
                        int stopper = 1;
                        
                        // if user doesnt enter word correctly
                        // allow them to try 3 times
                        // If they run out of tries then no keywords will be added
                        while( stopper < 4 )
                        {
                          // Get keywords
                          System.out.println("Enter keywords.");
                          System.out.println("* Seperate keyword or phrases with a comma *");
                          System.out.println("* Limit of 5 keywords and 25 characters per each keyword *");
                          System.out.println("* Example: eating, motivate me, fitness, study guide *");
                          
                          key = searcher.nextLine();
                        
                          keywordString = checkKeywords(key);
                          
                          if(keywordString != null)
                            break;
                          
                          stopper++;
                        }
                        
                        addQuote( newQuote , newAuthor , keywordString );
                     }
               }
               break;
         }
      }
   }

   /*
    * @author - Zanyar Sherwani
    *
    * This function uses a non-optimal
    * way to check for profanity within 
    * any string passed in
    *
    */
   public static boolean checkForProfanity(String str){
      return true;
   }
   
   /*
    * @author : Omar Zairi
    * @param text of the quote
    * @param author of the quote
    *
    * Gets a quote text and author name from the user
    * Adds the quote to the current quote list array
    * and adds it to the xml file
    * 
    */
   public static void addQuote( String quote , String author , String keywords )
   {
      // create new quote
      Quote newQuote = new Quote(author,quote);
      // put new quote in current quote list
      quoteList.setQuote( newQuote );
      
      // print the old list into a .tmp file and add the new quote to the file
      try (BufferedReader br = new BufferedReader(new FileReader("quotes.xml"))) {
         
         PrintWriter pw = new PrintWriter("quotes.tmp", "UTF-8");
         String line;
         
         // add old quotes to new file
         while ((line = br.readLine()) != null) {
            if( !line.equals("</quote-list>") )
               pw.println(line);
         }
         
         
         
         // write new quote to file
         pw.println("   <quote>");
         pw.println("      <quote-text>"+quote+"</quote-text>");
         pw.println("      <author>"+author+"</author>");
         pw.println(keywords);
         pw.println("   </quote>");
         
         // close out the list
         pw.println("</quote-list>");
         
         // rename the file 
         File renamer = new File("quotes.tmp");
         renamer.renameTo(new File("quotes.xml"));
         
         br.close();
         pw.close();
      }
      catch(Exception e){
         System.out.println("Error with file.");
      }
   }
   
   // Searches quote list by quote text
   public static void searchQuote( String keyword )
   {
      
      // retrieve list of results based on search
      QuoteList results = quoteList.search( keyword , 1 );
      
      // output the results
      System.out.println("Results ("+results.getSize()+"):");
      
      for ( int i = 0 ; i < results.getSize() ; i++ )
      {
         Quote quote1 = results.getQuote(i);
         System.out.println( "  "+quote1.getQuoteText() );
         System.out.println( "  -"+quote1.getAuthor() + "\n" );
      }
   }
   
   // Searches quote list by author name
   public static void searchAuthor( String keyword )
   {
      QuoteList results = quoteList.search( keyword , 0 );
      System.out.println("Results ("+results.getSize()+"):");
      
      for ( int i = 0 ; i < results.getSize() ; i++ )
      {
         Quote quote1 = results.getQuote(i);
         System.out.println( "  "+quote1.getQuoteText() );
         System.out.println( "  -"+quote1.getAuthor() + "\n" );
      }
   }
   
   // Searchs quote list by author name and quote text
   public static void searchBoth( String keyword )
   {
      QuoteList results = quoteList.search( keyword , 2 );
      System.out.println("Results ("+results.getSize()+"):");
      
      for ( int i = 0 ; i < results.getSize() ; i++ )
      {
         Quote quote1 = results.getQuote(i);
         System.out.println( "  "+quote1.getQuoteText() );
         System.out.println( "  -"+quote1.getAuthor() + "\n" );
      }
   }
   
   // Gets a random quote from quote list   
   public static void printRandomQuote()
   {
      quote = quoteList.getRandomQuote();
      
      System.out.println("\nRandom quote of the day:");
      System.out.println( "  "+quote.getQuoteText() );
      System.out.println( "  -"+quote.getAuthor() );
   }
   
   // Adds keywords
   public static String checkKeywords(String keywords)
   {
      String[] wordsWithComma = keywords.split(",");
      
      ArrayList<String> keywordList = new ArrayList<String>();

      int listSize = wordsWithComma.length;

      for(int i = 0; i < listSize && i < 5 ; i++)
      {
        String trimmedWord = wordsWithComma[i];
        trimmedWord = trimmedWord.trim();
     
        if( trimmedWord.length() <= 25 && !trimmedWord.equals("") )
        {
          keywordList.add(trimmedWord);
        }

      }

      String xmlString = "<keywords>";
      
      for(int i = 0; i < keywordList.size() ; i++)
      {
        if( i == keywordList.size()-1 )
          xmlString += keywordList.get(i);
        else
          xmlString += keywordList.get(i)+",";
      }
      
      xmlString += "</keywords>";

      return xmlString;
   }
} 

