

/**
 * Quote data object.
 * @author Mongkoldech Rajapakdee & Jeff offutt
 *         Date: Nov 2009
 * A quote has two parts, an author and a quoteText.
 * This bean class provides getters and setters for both, plus a toString()
 */
public class Quote
{
   private String author;
   private String quoteText;
   private String [] keywords;
   private String id;
   // Default constructor does nothing
   public Quote ()
   {
   }

   // Constructor that assigns both strings
   public Quote (String author, String quoteText, String [] keywords, String id)
   {
      this.author = author;
      this.quoteText = quoteText;
      this.keywords = keywords;
      this.id = id;
   }

   public String getId(){
      return this.id;
   }

   public void setId(String id){
      this.id = id;
   }
   // Getter and setter for author
   public String getAuthor ()
   {
      return author;
   }
   public void setAuthor (String author)
   {
      this.author = author;
   }

   // Getter and setter for quoteText
   public String getQuoteText ()
   {
      return quoteText;
   }
   public void setQuoteText (String quoteText)
   {
      this.quoteText = quoteText;
   }
  
   public void setKeywords(String [] keys){
      this.keywords = keys;
   }
   public String [] getKeywords(){
      return this.keywords;
   }
   @Override
   public String toString ()
   {
      return "Quote {" + "author='" + author + '\'' + ", ID='"+ this.id + '\'' + ", quoteText='" + quoteText + '\'' + '}';
   }
}
