
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
     FileResource fr = new FileResource(f);
     String fileName= f.getName();
     for (String word : fr.words()) {
     if(map.containsKey(word))
     {
       ArrayList<String> value = new ArrayList<String>();
       value=map.get(word);
       value.add(fileName);
       map.put(word, value);
     }
     else
     {
        ArrayList<String> FileNameForWord = new ArrayList<String>(); 
        FileNameForWord.add(fileName);
        map.put(word, FileNameForWord);
     }
 }
}
public void buildWordFileMap()
{
     map.clear();
     DirectoryResource dr = new DirectoryResource();
     for (File f : dr.selectedFiles()) {
     addWordsFromFile(f);
     }
    
}
public int maxNumber()
{
    ArrayList<String> value=new ArrayList<String>();
    int valueI=0;
    int max=0;
    String wordMax="";
    for (String s : map.keySet()) {
     value=map.get(s);
     valueI=value.size();
     if(valueI>max)
     {
        max=valueI;
        wordMax=s;
     }
    } 
    //System.out.println("Word that appears most is " +wordMax);
    return max;
}
public ArrayList<String> wordsInNumFiles(int number)
{
    ArrayList<String> value=new ArrayList<String>();
    ArrayList<String> result=new ArrayList<String>();
    int valueI=0;
    for (String s : map.keySet()) {
     value=map.get(s);
     valueI=value.size();
     if(valueI==number)
     {
       result.add(s);
     }
    } 
    return result;
}
public void printFilesIn(String word)
{
 ArrayList<String> fileNames = new ArrayList<String>();
 fileNames=map.get(word);
 for(int k =0;k<fileNames.size();k++)
 {
    System.out.println(fileNames.get(k)); 
 }
}
public void tester()
{
   buildWordFileMap();
   ArrayList<String> wordsInNum = new ArrayList<String>();
   wordsInNum=wordsInNumFiles(3);
   System.out.println("Showing results for wordsInNumFiles: ");
   for(int k =0;k<wordsInNum.size();k++)
   {
       System.out.println(wordsInNum.get(k));
   }
   
   System.out.println(" ");
   System.out.println("Showing results for maxNumber()");
   int max= maxNumber();
   System.out.println("The maximum number of times a word appears in the files is: "+max);
   System.out.println(" ");
   System.out.println("The total map is below: ");
   
    for (String s : map.keySet()) {
   System.out.println("Word: "+s);
    ArrayList<String> list = new ArrayList<String>();
    list = map.get(s);
    for(int k =0;k<list.size();k++)
        {
        System.out.println("ArrayList: "+list.get(k)); 
       }
           } 
}

}
