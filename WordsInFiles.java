
/**
 * Write a description of WordsInFiles here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.util.*;
import edu.duke.*;
import java.io.*;
public class WordsInFiles {
 private HashMap<String, ArrayList<String>> map;
 public WordsInFiles()
 {
     map= new HashMap<String, ArrayList<String>>();
 }
 private void addWordsFromFile(File f)
 {
     
     map.clear();
     FileResource fr = new FileResource(f);
     String fileName= f.getName();
     for (String word : fr.words()) {
     if(map.containsKey(word))
     {
       
     }
     else
     {
        ArrayList<String> list = new ArrayList<String>(); 
        map.put(fileName, list);
     }
 }
}
}
