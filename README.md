# Information-Retrieval-Tokenizer
Program to tokenize the Cranfield database collection using the Porters Stemming algorithm

Part of **CS 6322 Information Retrieval** coursework.

###Homework1.java 
Includes code to process the Cranfield documents into tokens. The location of the documents is 
to be passed to the program. 
Note: Document destination has been hard-coded for testing purposes.

The tokens are "*StringTokenized*" and passed into **TreeMap**. A [TreeMap](http://docs.oracle.com/javase/7/docs/api/java/util/TreeMap.html) is a red-black tree 
based data structure, that orders the keys in log(n) time. TreeMap accepts <key, value> pair 
of data.

###Stemmer.java
Implementation of Porters Stemming algorithm to obtain the root of a given word. This open
source implementation was developed by Martin Porter. The implementation is available [here](http://tartarus.org/martin/PorterStemmer/java.txt)
