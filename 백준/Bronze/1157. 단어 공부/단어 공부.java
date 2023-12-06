import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Main {

	public static void main(String[] args) throws Exception{
		
		   BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	        String input = br.readLine();

	        input = input.toLowerCase();

	        int[] frequencyArray = new int[26]; 

	        for (char c : input.toCharArray()) {
	            if (Character.isLetter(c)) {
	                int index = c - 'a';		
	                frequencyArray[index]++;
	            }
	        }

	        int maxFrequency = 0;
	        for (int frequency : frequencyArray) {
	            maxFrequency = Math.max(maxFrequency, frequency);	
	        }

	        StringBuilder mostFrequentCharacters = new StringBuilder();

	        for (char c = 'a'; c <= 'z'; c++) {
	            int index = c - 'a';
	            if (frequencyArray[index] == maxFrequency) {
	                mostFrequentCharacters.append(c);
	                
	            }
	        }

	        if (mostFrequentCharacters.length() == 1) {
	            System.out.println(Character.toUpperCase(mostFrequentCharacters.charAt(0)));
	        } else {
	            System.out.println("?");
	        }
		
	}

}







