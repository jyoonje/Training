//2초, N<=50, str<=50
// str의 길이는 모두 같음
//입력 문자열이 하나만 들어오면 그대로 출력

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) throws Exception{
		//문자열 하나만 들어오면 그대로 출력, 
		// 2개 이상일 때 문자열 비교해서 틀리면 해당 인덱스 ? 로 replace()
		// 2차원 배열의  j는 문자열을 문자로 쪼갠 값
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		String str = br.readLine();
		if(N==1) { System.out.println(str); return;}
		
		char[] S = new char[str.length()];
		S = str.toCharArray();
		
		char[][] A = new char[N-1][str.length()];
		
		for(int i=0; i<N-1; i++) {				//입력받은 문자열 문자로 쪼개서 배열에 저장
			String s = br.readLine();
			for(int j=0; j<str.length(); j++) {
				A[i][j] = s.toCharArray()[j];
			}
		}
		
		//str 과 다른 문자열들을 비교하여 틀린 인덱스에 ? 삽입 
		for(int i=0; i<A.length; i++) {
			for(int j=0; j<A[i].length; j++) {
				if( S[j] != A[i][j] ) {
					S[j] = '?';
				}
			}
		}
		StringBuilder sb = new StringBuilder();
		for(char item : S) {
			sb.append(item);
		}
		System.out.println(sb);
	}
}


