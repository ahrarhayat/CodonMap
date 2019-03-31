
/**
 * Write a description of codonMap here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.util.*;
import edu.duke.*;
public class codonMap {
private HashMap <String, Integer> CodonMap;
public codonMap()
{
    CodonMap=new HashMap<String, Integer>();
}
public void buildCodonMap(int start, String dna)
{
    CodonMap.clear();
    int length=dna.length();
    if(start==1)
    {
        length=length-1;
    }
    if(start==2)
    {
        length=length-2;
    }
    
    while(true){
    if(length<3)
    {
        break;
    }    
    String codon=dna.substring(start,start+3);
    if(CodonMap.containsKey(codon))
    {
     CodonMap.put(codon,CodonMap.get(codon)+1);
    }
    else
    {
        CodonMap.put(codon,1);
    }
    length=length-3;
    start=start+3;
    
    }
}
public String getMostCommonCodon()
{
    int max=0;
    int value=0;
    String key="";
    for (String s : CodonMap.keySet()) {
      value= CodonMap.get(s);
      if(value>max)
      {
          max=value;
          key=s;
      }
    } 
    return key;
}
public void printCodonCounts(int start, int end)
{
    for (String s : CodonMap.keySet()) {
        if(CodonMap.get(s)>=start && CodonMap.get(s)<=end)
        System.out.println(s+" "+ CodonMap.get(s));
        } 
   
}
public void testCodonMap()
{
    //FileResource fr = new FileResource();
    //String dna= fr.asString();
    String dnaUpper="CGTTCAAGTTCAA";
    int start1=0;
    int start2=1;
    int start3=2;
    buildCodonMap(start1,dnaUpper);
    System.out.println("Using frame "+start1);
    String mostCommon=getMostCommonCodon();
    printCodonCounts(1,5);
    
    System.out.println(" ");
    
    buildCodonMap(start2,dnaUpper);
    System.out.println("Using frame "+start2);
    mostCommon=getMostCommonCodon();
    printCodonCounts(1,5);
    
    System.out.println(" ");
    
    buildCodonMap(start3,dnaUpper);
    System.out.println("Using frame "+start3);
    mostCommon=getMostCommonCodon();
    printCodonCounts(1,5);
}
}
