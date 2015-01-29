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
     */
    static TreeMap<String, Integer> tokens = new TreeMap<String, Integer>();
    static int numberOfTokens=0;

    public static void main(String args[]){
        String filePath = "E:\\Sem 5\\Information Retrieval\\Homework\\Test1\\Cranfield_Collection";
        try {
            scanFiles(filePath);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

/*
        TODO: Update TreeMap traversal to eliminate using two collections
         */
        Collection collection = tokens.keySet();
        Collection collectionValues = tokens.values();
        Iterator<String> iterator = collection.iterator();
        Iterator<Integer> valueIterator = collectionValues.iterator();

        while(iterator.hasNext()){
            System.out.println(iterator.next() + " " + valueIterator.next());
        }

        System.out.println("number of files: " + countOfFiles);
    }
    private static void scanFiles(String filePath) throws FileNotFoundException {
        File file = new File(filePath);

        File listOfFiles[] = file.listFiles();

        for(int i=0; i<listOfFiles.length; i++){
            if(listOfFiles[i].isFile()){
                countOfFiles++;
    //            if(i<5)
                    fetchWords(listOfFiles[i]);
            }

        }
    }
    static void fetchWords(File file) throws FileNotFoundException {
        Scanner inputFile = new Scanner(file);

        while(inputFile.hasNextLine()){

            String currentLine = inputFile.nextLine();
            if(currentLine!=null && !(currentLine.contains("<") && currentLine.contains(">"))){
                StringTokenizer stringTokenizer = new StringTokenizer(currentLine);
                while(stringTokenizer.hasMoreTokens()){
                    String currentToken = stringTokenizer.nextToken().toString().toLowerCase();
   //                 System.out.println(currentToken);

                    numberOfTokens++;
                    if(tokens.get(currentToken) == null)
                        tokens.put(currentToken, 1);
                    else
                        tokens.put(currentToken, tokens.get(currentToken) + 1);

                }
            }
        }
/*
TODO: will the file close or will it generate error?
 */
    }
}
