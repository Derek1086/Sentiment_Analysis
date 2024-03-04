/**
*  Program to classify a set of movie reviews as positive or negative based on their number of positive and negative words. 
* @author Derek Avila dka46, Jett Tipsword jbt71 as my partner
*
*/


import java.io.File;
import java.io.FileNotFoundException;

/**
* class SentimentAnalysisApp creates objects to be used in the Reviewhandler method
*/
public class SentimentAnalysisApp extends ReviewHandler {

/**
* class SentimentAnalysisApp creates objects to be used in the Reviewhandler method
*@exception FileNotFound if the positive and negative files created arent found
*/
public static void main(String[] args) throws FileNotFoundException  {

    try 
    {
      /** 
      *@param grab java SentimentAnalysisApp <path_to_pos_words>  
      * stores new file in argument 0 
      *@param grab java SentimentAnalysisApp <path_to_neg_words> 
        stores new file in argument 1
      */
      File positiveFile = new File(args[0]);
      File negativeFile = new File(args[1]);

    /** 
      * @param positvefolder grab java SentimentAnalysisApp <path_to pos_reviews_folder> 
      *  stores new file in argument 2 
      * @param negitvefolder grab java SentimentAnalysisApp <path_to neg_reviews_folder> 
      *  stores new file in argument 3
      */

      File positiveFolder = new File(args[2]);
      File negativeFolder = new File(args[3]);

      /**
      * creates review handler object
      * Use this object to populate hashsets
      */
      ReviewHandler rw = new ReviewHandler();

      rw.populateSet(positiveFile);
      rw.populateSet(negativeFile);

      rw.findRealClass(positiveFolder, positiveFolder.listFiles());
      rw.findRealClass(negativeFolder, negativeFolder.listFiles());

      rw.toString();

    }
    // catch any exceptions for files 
    catch (Exception e) 
    {
        e.printStackTrace();
    }

  }
}
