// Given a String s in input, pass in output a String digest containing the following:
// 1. The number of words in the String, excluding white spaces
// 2. The total number of characters in the String, excluding white spaces
// 3. A dictionary with the count of the number of appearances of each character in the String, in the same order as they appear in the String


import java.io.*;
import java.util.LinkedHashMap;
import java.util.Map;

class myCode
{
    public static void main (String[] args) throws java.lang.Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        String digest = buildDigest(input);
        System.out.println(digest);
    }
    
    private static String buildDigest(String str) {
      
      if (str == null || str.isEmpty()) {
          return "";
      }
      
      // words count
      final String[] words = str.split("\\s+");
      int countWords = words.length;
      
      // chars count
      int countChars = 0;
      for (String word : words) {  
        countChars += word.length();
      }
      
      // chars count in a map in order of insertion
      final Map<Character, Integer> map = new LinkedHashMap<Character, Integer>();
      for (int i = 0; i < str.length(); i++) {
        char c = str.charAt(i);
        Integer val = map.get(c);
        if (val != null) {
          map.put(c, Integer.valueOf(val + 1));
        }
        else {
          map.put(c, 1);
        }
      }
      
      // generate digest
      final StringBuilder sb = new StringBuilder();
      sb.append("Word count = ");
      sb.append(countWords);
      sb.append("\n");
      sb.append("Non-whitespace character count = ");
      sb.append(countChars);
      sb.append("\n");
      sb.append("Unique breakdown of all characters in order they appeared...");
      sb.append("\n");
      for (Map.Entry<Character, Integer> entry : map.entrySet()) {
          sb.append(entry.getKey() + ": " + entry.getValue());
          sb.append("\n"); 
      }
      
      return sb.toString(); 
      
    }
}