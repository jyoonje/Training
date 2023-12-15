import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO 1. 단어는 공백 한 개로 구분.
		// 		2. 문자열은 공백으로 시작하거나 끝날 수 있음.
		//  	3. 문자열을 공백을 기준으로 단어로 나눠서 리스트에 저장.
		//		4. 리스트의 길이 출력
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		ArrayList<String> wordList = new ArrayList<>();
		
		StringTokenizer st = new StringTokenizer(str);
		while(st.hasMoreTokens()) {
			wordList.add(st.nextToken());
		}
		System.out.println(wordList.size());

	}
}