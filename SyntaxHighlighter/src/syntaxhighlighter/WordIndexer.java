package syntaxhighlighter;

import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

public class WordIndexer {

    public static List<Integer> findWord(String textString, String word) {
        
        // Defining the arraylist for the idex's to be stored. (The index is the position of a string, within a string.)
        List<Integer> indexes = new ArrayList<Integer>();       
        
        // Defining the new string that will be made as blank
        String lineWithEnd = "";

        // Adds a new line char at the end of each line as the highlighter doesn't work properly unless there are clearly defined lines.
        Scanner scanner = new Scanner(textString);
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            lineWithEnd += line + "\n";
        }
        scanner.close();

        // Makes the strings lower case
        String lowerCaseTextString = lineWithEnd.toLowerCase();
        String lowerCaseWord = word.toLowerCase();

        // Loop through and store all instances of the string in an array
        int wordLength = 0;
        int index = 0;
        while (index != -1) {
            index = lowerCaseTextString.indexOf(lowerCaseWord, index + wordLength); 
            if (index != -1) {
                indexes.add(index);
            }
            wordLength = word.length();
        }
        return indexes;
    }
}
