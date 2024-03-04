# Programming project 1 (Sentiment Analysis)

## Objective
Java programming concepts:
1.	Input/Output to and from the terminal. 
2.	Storing data in a file and reading data from a file.
3.	Creating object-oriented classes and methods to handle data.
4.	Using data structures to store data in main memory (e.g., HashSet, ArrayList).
5.	Working with character strings.
6.	Using Javadoc comments and generating HTML documentation of the program.
7.	Using Java Exceptions to improve the error-handling capabilities of a program.

## Description
For this assignment, you will create a program to classify a set of movie reviews as positive or negative based on their sentiment. This process is known as [Sentiment Analysis](https://en.wikipedia.org/wiki/Sentiment_analysis). 

In this assignment, you are to write a Java package _project1_ that will classify a provided movie review as positive or negative by counting the number of positive and negative words in that review. Your class containing the _main()_ method should be named _SentimentAnalysisApp.java_. Design your main method to have multiple inputs as command line arguments: 
* Paths to two text files:  list of positive words (positive-words.txt) and list of negative words (negative-words.txt). 
* Paths to two folders:  the folder ‘pos’ contains the positive reviews and the folder ‘neg’ contains the negative reviews, both manually assigned by humans.  The reviews within each folder are given in separate .txt files, one review per file.  

_SentimentAnalysisApp_ should accept the following command line arguments. 
```java SentimentAnalysisApp <path_to_pos_words> <path_to_neg_words> <path_to pos_reviews_folder> <path_to_neg_reviews_folder>```

_SentimentAnalysisApp_ run example that assumes you have copied projecet1 directory as is, and made changes: 
```java SentimentAnalysisApp ./Data/positive-words.txt ./Data/negative-words.txt ./Data/Movie-reviews/pos ./Data/Movie-reviews/neg```

_SentimentAnalysisApp_ and the Java classes in the package _project1_ should automatically classify the .txt files in the folders and output the total count of how many were correctly classified, compared to the human ground truth. 

Steps needed: 
* The program loads the positive words and negative words and stores them in two separate lookup tables. The HashSet data structure can be used as a lookup table in Java as it provides a fast way to look if a word exists in it or not.
* The program iterates over the .txt files, and in each file, it counts the number of positive and negative words the review contains. If the review contains more positive than negative words, it is classified as positive and vice versa. If the same number of positive and negative words were found on the review, it counts as negative. 
* After each review has been classified, the program prints out in the command line the file name of the review, its real class, and its predicted class.
* The program should also print how many reviews were correctly classified and how many were misclassified – both total numbers or broken down per positive or negative review are accepted. 
* At the end, the program should print the accuracy per positive (i.e. Number of correctly classified positive reviews / Number of positive reviews ) and negative (i.e. Number of correctly classified negative reviews / Number of negative reviews ) classification and overall accuracy (Number of correctly classified reviews / Total number of reviews).
