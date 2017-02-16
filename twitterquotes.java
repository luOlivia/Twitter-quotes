//OLIVIA LU
//version 12.8.2015

import twitter4j.*;       //set the classpath to lib\twitter4j-core-4.0.2.jar
import java.util.List;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Date;

public class Twitter_Driver
{
   private static PrintStream consolePrint;
   
   public static void main (String []args) throws TwitterException, IOException
   {
      consolePrint = System.out;
      
      // PART 1
      // set up classpath and properties file
             
      TJTwitter bigBird = new TJTwitter(consolePrint);
      String message = "@bastilledan I'm tweeting u from my JAVA program";
     // bigBird.tweetOut(message);
   
      // PART 3
      bigBird.investigate();
       
         
   }//end main         
         
}//end driver        
         
class TJTwitter 
{
   private Twitter twitter;
   private PrintStream consolePrint;
   private List<Status> statuses;
   private List<String> sortedTerms;
   private int tweetcount;
   private int ofmax;
   
   public TJTwitter(PrintStream console)
   {
      // Makes an instance of Twitter - this is re-useable and thread safe.
      twitter = TwitterFactory.getSingleton(); //connects to Twitter and performs authorizations
      consolePrint = console;
      statuses = new ArrayList<Status>();
      sortedTerms = new ArrayList<String>();   
   }
   public int gettweetcount()
   {
      return tweetcount;
   }
   public int getofmax()
   {
      return ofmax;
   }


   /******************  Part 3 *******************/
   
   public void investigate ()
   {
      try {
         Scanner rem = new Scanner(new File("quotes.txt"));
         String[] common = new String[365];
         for(int x =0; x<common.length; x++)//fills array with quotes
         {
            common[x] = rem.nextLine();
         }      
         for(int x =0; x<365; x++)
         {
            Twitter twitter = TwitterFactory.getSingleton();
            twitter.updateStatus(common[x]);
            //tweetout(common[x]);
            Thread.sleep(24*60*60*1000);
         }
      }
      catch(FileNotFoundException e)
      {
         System.out.println("File not Found");
         System.exit(0);
      }
      catch (TwitterException e) {
         e.printStackTrace();
      }
      catch (InterruptedException e) {
        System.out.println("Interrupted");
        System.exit(0);
      }
   
   
   }
