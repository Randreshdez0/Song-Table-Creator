import java.util.*;
import java.io.*;
import java.security.PublicKey;


/**
 * @author Andres
 *
 */
public class MusicWordCount {
	List<String> uniqueUserWords = new ArrayList<String>();	
	List<String> totalUserWords = new ArrayList<String>();	
	int totalWordCount = 0;
	int uniqueWordCount = 0;
	/**
	 * 
	 * @param word
	 * @throws FileNotFoundException 
	 */
	public void addMultipleWords(String[] words) throws FileNotFoundException {
		File file = new File("C:\\Users\\randr\\Desktop\\Song.txt");
		Scanner scanner = new Scanner(file);
		
		
		while(scanner.hasNext()) {
			addWord(scanner.next());
//			System.out.println(scanner.next());
		}
	}
	public void addWord(String word) {
		totalWordCount++;
		
		for (int i = 0; i < uniqueUserWords.size(); i++) {
			if(uniqueUserWords.contains(word.toLowerCase()))return;
		}
		
		uniqueUserWords.add(word.toLowerCase());
		uniqueWordCount++;
	}
	public String toString(){
		String result = "[" + uniqueUserWords.get(0);
		for(int i = 1; i < uniqueUserWords.size(); i++){
			result += ", " + uniqueUserWords.get(i);
		}
		return result + "]";
	}
	public void getTopWords() {
		for (String uniqueWordString : uniqueUserWords) {
			for (int i = 0; i < uniqueUserWords.size(); i++) {
				
			}
		}
	}
  // Function to calculate the most frequent word in the array.
	public void FrequentWord() 
	{ 
		// Insert all unique strings and update count if a string is not unique.
		Map<String,Integer> hshmap = new HashMap<String, Integer>(); 

		for (int i = 0; i < totalUserWords.size(); i++) { 
			
			String str =  totalUserWords.get(i);
			
			if (hshmap.keySet().contains(str)) // if already exists then update count. 
				hshmap.put(str, hshmap.get(str) + 1); 
			else
				hshmap.put(str, 1); // else insert it in the map.
		} 
    	// Traverse the map for the maximum value.
		String maxStr = ""; 
    	int maxVal = 0; 
		for (Map.Entry<String,Integer> entry : hshmap.entrySet()) 
		{ 
			String key = entry.getKey(); 
			Integer count = entry.getValue(); 
			if (count > maxVal) 
			{ 
				maxVal = count; 
				maxStr = key; 
			} 
      		// Condition for the tie.
			else if (count == maxVal){ 
				if (key.length() < maxStr.length())
					maxStr = key; 
			}
		} 
		System.out.println("Most frequent word: "+ maxStr);
		System.out.println("Count: "+ maxVal); 
	} 
}
