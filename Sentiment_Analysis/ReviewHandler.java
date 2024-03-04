import java.util.HashSet;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

/**
* class ReviewHandler inhereted the rw object, to use for populating hashsets
* Contains methods to find the number of positive and negative reviews
* Also compares these findings to the real number of positive and negative reviews
*/
public class ReviewHandler {

  
  /**
  *@param HashSet of strings to hold positive words in the reviews
  *@param HashSet of strings to hold negitive words in the reviews
  */
  private static HashSet<String> positiveWords = new HashSet<String>();
  private static HashSet<String> negativeWords = new HashSet<String>();

  
   /**
  *@param totalPosReviews the total number of positive reviews in all files
  *@param totalNegReviews the total number of negative reviews in all files
  *@param correctPosReviews the total correct positive reviews in all files
  *@param correctNegReviews the total correct negitive reviews in all files
  * These parameters keep track of accuracy 
  */
  private static double totalPosReviews = 0;
  private static double totalNegReviews = 0;
  private static double correctPosReviews = 0;
  private static double correctNegReviews = 0;

  /**
  * populates the set of positive words and negative words
  *@param dict the file that will be read from 
  *@exception throws file not found if the file to be popualted is not found
  */
  public void populateSet(File dict) throws FileNotFoundException
  {
    try {
        Scanner scnr = new Scanner(dict);
        while(scnr.hasNextLine())
        {
          String word = scnr.nextLine(); // grabbing word
          if(!word.startsWith(";") && dict.getName().equals("positive-words.txt")) // if not a comment in the file
          {
            positiveWords.add(word);
          }
          else if(!word.startsWith(";") && dict.getName().equals("negative-words.txt"))
          {
            negativeWords.add(word);
          }
        }
          scnr.close();
    }
    catch(Exception e)
      {
        
      }
  }
  
  /**
  * Finds the actual amount of positive and negative reviews by keeping 
    a count of respective review words
  *@param file the file that will be populated 
  *@param data the array of files to pull reviews from
  *@exception throws file not found if the file to be popualted is not found
  */
  public void findRealClass(File file, File[] data) throws FileNotFoundException
  {
    try 
    {
        for(File review : data)
        {
           if(review != null)
           {
             
               /**
               *@param negcount keeps track of the number of negitive reviews
               *@param poscount keeps track of the number of positive reviews
               * both of these help keep track of the review class
               */
              int negCount = 0; 
              int posCount = 0;

              Scanner scnr = new Scanner(review);
              String sentence = scnr.nextLine(); // grab the line from the review
              sentence = sentence.replaceAll("\\p{Punct}", ""); // remove punctuation
              sentence = sentence.toLowerCase(); // convert everything to lowercase
              String line[] = sentence.split("\\s+"); // put each word into an array

              for(int i = 0; i < line.length; i++)
              {
                if(positiveWords.contains(line[i])) // if the word is positive
                {
                    posCount++;
                }
                else if(negativeWords.contains(line[i])) // if word is negative
                {
                    negCount++;
                }

              }
              scnr.close();
              // see if review is negative or positive
              if(posCount > negCount)
              {
                  if(file.getName().equals("pos"))
                  {
                    correctPosReviews++; // predicted correctly
                    totalPosReviews++; // keep track of total txt files in folder
                    System.out.println(review.getName() + " Real Class: Positive \nPredicted Class: Positive");

                  }
                  else if(file.getName().equals("neg"))
                  {
                      totalNegReviews++; // keep track of total txt files in folder
                      System.out.println(review.getName() + " Real Class: Positive \nPredicted Class: Negative");
                  }
              }
              else
              {
                  if(file.getName().equals("pos"))
                  {
                    totalPosReviews++; // keep track of total txt files in folder
                    System.out.println(review.getName() + " Real Class: Negative \nPredicted Class: Positive");
                  }
                  else if(file.getName().equals("neg"))
                  {
                    totalNegReviews++; // keep track of total txt files in folder
                    correctNegReviews++; // predicted correctly
                    System.out.println(review.getName() + " Real Class: Negative \nPredicted Class: Negative");
                  }
               }
            }
         }
    }
    catch(Exception e)
      {

        
      }
}

  /**
  *@Override String method to output the results of review analysis
  */
  @Override
  public String toString() 
  {
    String sentence = "";
    String percent = "%";
    
    System.out.println("\nFinal result:\nNumber of positive reviews:  " + (int)(totalPosReviews));
    System.out.println("Correct classified: " + (int)(correctPosReviews) + "\nMisclassified: " + (int)(totalPosReviews - correctPosReviews));
    System.out.printf("Correct classification rate: %.1f%s \n",  ((correctPosReviews / totalPosReviews) * 100), percent);
    
    System.out.println("\nNumber of Negative Reviews: " + (int)(totalNegReviews));
    System.out.println("Correct Classified: " + (int) (correctNegReviews) + "\nMisclassified: " + (int)(totalNegReviews - correctNegReviews));
    System.out.printf("Correct classification rate: %.1f%s \n", ((correctNegReviews / totalNegReviews) * 100), percent);
    
    System.out.println("\nNumber of all reviews: " + (int)(totalNegReviews + totalPosReviews));
    System.out.println("Correct classified: " + (int)(correctPosReviews + correctNegReviews));
    System.out.println("Misclassified: " + (int)((totalPosReviews - correctPosReviews) + (totalNegReviews - correctNegReviews)));
    System.out.printf("Overall correct classification rate: %.1f%s \n\n", ((correctPosReviews + correctNegReviews ) / (totalPosReviews + totalNegReviews)) * 100, percent);
    
    return sentence;
  }
  
}
