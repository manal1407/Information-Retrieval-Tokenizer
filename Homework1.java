import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

/**
 * Created by miren_t on 1/29/2015.
 */
public class Homework1 {


    static int countOfFiles=0;
    /*
    TODO: Sort according to key, then value or only value?
            Include DocID information?
            how to deal with numbers?
            how to deal with acronyms?
            how to deal with hyphens?
     */
    static TreeMap<String, Integer> tokens = new TreeMap<String, Integer>();
    static int numberOfTokens=0;

    public static void main(String args[]){
        String filePath = "E:\\Sem 5\\Information Retrieval\\Homework\\Homework1\\Cranfield_Collection";
//        String filePath = args[0].toString();

        try {
            scanFiles(filePath);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

/*
        TODO: Update TreeMap traversal to eliminate using two collections
         */
        Iterator<Map.Entry<String, Integer>> entryIterator = tokens.entrySet().iterator();

     /*   while(entryIterator.hasNext()){
            Map.Entry<String, Integer> entry = entryIterator.next();
               System.out.println(entry.getKey() + " " + entry.getValue());
        }
*/
/*
        Collection collection = tokens.keySet();
        Collection collectionValues = tokens.values();
        Iterator<String> iterator = collection.iterator();
        Iterator<Integer> valueIterator = collectionValues.iterator();

        while(iterator.hasNext()){
            System.out.println(iterator.next() + " " + valueIterator.next());
        }
*/
        System.out.println("Number of tokens: " + numberOfTokens);
        System.out.println("Number of unique tokens: " + tokens.size());
        System.out.println("Number of tokens that occur only once: " + countOnes(tokens));
        System.out.println("Number of files: " + countOfFiles);
    }
    private static void scanFiles(String filePath) throws FileNotFoundException {
        File file = new File(filePath);

        File listOfFiles[] = file.listFiles();

        for(int i=0; i<listOfFiles.length; i++){
            if(listOfFiles[i].isFile()){
                countOfFiles++;
   //             if(i<5)
                    fetchWords(listOfFiles[i]);
            }

        }
    }

    static int countOnes(TreeMap<String, Integer> tokens){
        int countOfOnes=0;
        Iterator<Map.Entry<String, Integer>> countIterator = tokens.entrySet().iterator();
        while(countIterator.hasNext()){
            Map.Entry<String, Integer> entry = countIterator.next();
            if(entry.getValue()==1)
                countOfOnes++;
        }

        return countOfOnes;
    }

    /*
    TODO: Do we eliminate numbers as tokens?
     */
    static void fetchWords(File file) throws FileNotFoundException {
        Scanner inputFile = new Scanner(file);

        while(inputFile.hasNextLine()){

            String currentLine = inputFile.nextLine();
            if(currentLine!=null && !(currentLine.contains("<") && currentLine.contains(">"))){
                StringTokenizer stringTokenizer = new StringTokenizer(currentLine);
                while(stringTokenizer.hasMoreTokens()){
                    String currentToken = stringTokenizer.nextToken().toString().toLowerCase();

                    String currentTokenModified = currentToken.replaceAll("[^a-zA-Z0-9]", "");

                    if(currentTokenModified.equals(""))
                        continue;
                    else{
                        numberOfTokens++;
                        if(tokens.get(currentTokenModified) == null)
                            tokens.put(currentTokenModified, 1);
                        else
                            tokens.put(currentTokenModified, tokens.get(currentTokenModified) + 1);
                    }
                }
            }
        }
/*
TODO: will the file close or will it generate error?
 */
    }
}
