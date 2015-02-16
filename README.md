# Information-Retrieval-Tokenizer
Program to tokenize the Cranfield database collection using the Porters Stemming algorithm

Part of **CS 6322 Information Retrieval** coursework.

##Homework1.java 
Includes code to process the Cranfield documents into tokens. The location of the documents is 
to be passed to the program. 

##Stemmer.java
Implementation of Porters Stemming algorithm to obtain the root of a given word. 

The tokens are *"StringTokenized"* and passed into **TreeMap**. A [TreeMap](http://docs.oracle.com/javase/7/docs/api/java/util/TreeMap.html) 
is a red-black tree based data structure, that orders the keys in log(n) time. TreeMap accepts <key, value> pair 
of data.

###Program Description:
###Problem 1: 
* Initially, the program accepts the directory path of the Cranfield Collection as a command line argument.

* The program at this point, stores the current time in milliseconds in a **long** variable. 

* We now call the `scanFiles` method, which accepts the Cranfield Collection location as as argument. `scanFiles` method 
traverses through all the files in the target location. Here we count the number of files in the *`countOfFiles`* variable. 

* `scanFiles` method calls the `fetchWords` method that takes a **File** as an argument. This method scans through each
line of the file, and tokenizes it. **StringTokenizer** is used to split every word in the line currently being scanned.
Every word is normalized by converting it to lower case, and replacing all characters that are non-alphanumeric to `""`.
This check is performed by matching the string with regular expressions. Non-alphanumeric characters are matched against 
`[^a-zA-Z0-9]`.

* We count the number of tokens in `fetchWords` method in the *`numberOfTokens`* variable. Furthermore, the tokens are 
added into a TreeMap called *`tokens`*. If the token does not exist in the TreeMap, it is added into it and its count is 
initialized to 1. Otherwise, its current count is incremented by 1. This operation is performed using the put() and get()
methods of TreeMap. 

* An Iterator is used to iterate through all the tokens present in the TreeMap. 

* To count the number of tokens that appear only once in the Cranfield Collection, `countOnes` method is called. The 
TreeMap is iterated and tokens whose count value is 1, is counted in a variable, *`countOfOnes`*. 

* To obtain the 30 most common frequent tokens, the `sortDecreasing` method is called. This method will compare each token
with other tokens in the map. Using a Comparator and order specified, it will return the tokens in a decreasing order.
 
* The program returns information regarding the count of tokens, unique tokens, tokens that occur only once, average 
number of tokens per document and 30 most frequent tokens. 

* Time taken to acquire the overall text characteristics is approximately 6720ms. 

* The program handles upper and lower case words in the same fashion. They both are converted to lower case. So, "Apple"
and "apple" are converted to "apple" and are considered as the same token.

* Words with dashes are handled by replacing the hyphen with a space. Eventually, the hyphenated words are treated as 
separate words. "boundary-layer-control" is treated as "boundary", "layer" and "control".
 
* Possessives are considered as one whole word without the apostrophe, as the program removes all special 
characters. "sherrif's" is converted as "sherrifs".

* Similarly, acronyms are treated as possessives are. "U.S." is converted to "us" as the program converts all tokens to 
  lower case and removes the periods. 

* Data structure used to store the token is `TreeMap`. 

###Problem 2: 
* For Stemming, the `Stemmer.java` program is used. 
This open source implementation was developed by Martin Porter. The implementation is available at 
[http://tartarus.org/martin/PorterStemmer/java.txt](http://tartarus.org/martin/PorterStemmer/java.txt)

* By iterating through the tokens present in the `*tokens*` TreeMap, each token is converted to a character array and 
 passed to the `add()` method of `Stemmer.java`.

* Similar to Problem 1, we count the number of stems, stems that occur only once, number of average stems per document, 30 most 
 frequent stems. 

##Output: 
**Problem 1 results:**<br>
Number of tokens: 235890 <br>
Number of unique tokens: 11502<br>
Number of tokens that occur only once: 5468<br>
Number of average tokens per document: 168<br>
30 most frequent tokens: <br>

1. the	19448
2. of	12714
3. and	6669
4. a	5922
5. in	4644
6. to	4560
7. is	4113
8. for	3491
9. are	2428
10. with	2263
11. on	1943
12. flow	1848
13. at	1834
14. by	1755
15. that	1570
16. an	1388
17. be	1271
18. pressure	1207
19. boundary	1156
20. from	1116
21. as	1114
22. this	1081
23. layer	1002
24. which	975
25. number	973
26. results	885
27. it	854
28. mach	823
29. theory	788
30. shock	712
<br>Time taken to acquire characteristics: 6721ms<br>

**Problem 2 results:**
Number of distinct stems: 8718<br>
Number of stems occurring only once: 4336<br>
Number of average tokens per document: 168<br>
30 most frequent stems: <br>

1. the	19448
2. of	12714
3. and	6669
4. a	5922
5. in	4644
6. to	4560
7. is	4113
8. for	3491
9. with	2263
10. at	1834
11. by	1755
12. that	1570
13. an	1388
14. boundari	1157
15. from	1116
16. as	1114
17. thi	1081
18. which	975
19. result	886
20. theori	789
21. wa	699
22. two	618
23. been	590
24. were	583
25. bodi	546
26. given	520
27. effect	512
28. veloc	502
29. these	500
30. or	482