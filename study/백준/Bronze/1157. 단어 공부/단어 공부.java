import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Main {

	public static void main(String[] args) throws Exception{
		
		   BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	        String input = br.readLine();
		
	        input = input.toLowerCase();	 // 대소문자를 구분하지 않기 위해 소문자로 통일
	        int[] frequencyArray = new int[26];	// 알파벳 빈도를 저장하는 배열 (a~z: 26개)

	        for (char c : input.toCharArray()) {	// 각 알파벳의 빈도 계산
	            if (Character.isLetter(c)) {
	                int index = c - 'a';	// a의 ASCII값: 97 b의 ASCII값 : 98, c: 99 ... z: 122	
	                frequencyArray[index]++;
	            }
	        }
		
	        int maxFrequency = 0;	// 빈도가 가장 높은 값 찾기
	        for (int frequency : frequencyArray) {
	            maxFrequency = Math.max(maxFrequency, frequency);	// 두 값 중 더 큰 값으로 maxFrequency 업데이트	
	        }

	        StringBuilder mostFrequentCharacters = new StringBuilder(); // 가장 높은 빈도를 가지는 알파벳들을 저장하는 문자열 생성

	        for (char c = 'a'; c <= 'z'; c++) {
	            int index = c - 'a';
	            if (frequencyArray[index] == maxFrequency) {
	                mostFrequentCharacters.append(c);
	            }
	        }

	        if (mostFrequentCharacters.length() == 1) {	// 결과 출력.
	            System.out.println(Character.toUpperCase(mostFrequentCharacters.charAt(0)));
	        } else {
	            System.out.println("?");
	        }
		
	}

}







