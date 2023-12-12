//합 배열 공식: S[i] = S[i-1] + A[i]
//구간 i~j가 주어졌을 때 구간 합 공식: S[j] - S[i-1]
//	ex)(1, 3) -> S[3] - S[0]

//Split(); / StringTokeninzer 차이: Split(): 구분자를 정규식으로 받음, StringTokenizer: 문자열으로 받음(디폴트: 공백)

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
//TODO 수 N개가 주어졌을 때, i번째 수부터 j번째 수까지 합을 구하는 프로그램을 작성하시오.
		//	   입력: 첫째 줄에 수의 개수 N과 합을 구해야 하는 횟수 M이 주어진다. 둘째 줄에는 N개의 수가 주어진다. 
		//			수는 1,000보다 작거나 같은 자연수이다. 셋째 줄부터 M개의 줄에는 합을 구해야 하는 구간 i와 j가 주어진다.
		//	   출력: 총 M개의 줄에 입력으로 주어진 i번째 수부터 j번째 수까지 합을 출력한다.

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());	
		int arrLength = Integer.parseInt(st.nextToken());
		int quizNo = Integer.parseInt(st.nextToken());
		
		//st로 문자열 입력 받은 후, 배열 A에 저장 
		int[] A = new int[arrLength];
		StringTokenizer st2 = new StringTokenizer(br.readLine());
		for(int k=0; k<A.length; k++) {
			A[k] = Integer.parseInt(st2.nextToken());
		}
		
		int[] S = new int[arrLength];	//구간 합을 계산할 배열 생성
		S[0] = A[0];
		for(int k=1; k<arrLength; k++) {
			S[k] = S[k-1] + A[k];
		}
		
		int[] resultArr = new int[quizNo]; //정답 저장할 배열 생성
		
		//구간 i, j를 quizNo 만큼 입력받고, 구간 합 계산
		for(int k=0; k<quizNo; k++) {
			StringTokenizer st3 = new StringTokenizer(br.readLine());
			int i = Integer.parseInt(st3.nextToken());	//i번째 수 부터 == S[i-1]
			int j = Integer.parseInt(st3.nextToken());	//j번쨰 수 까지 == S[j-1]
			int result = 0;
			if(i==1) {
				result = S[j-1];
			}else {
				result = S[j-1] - S[i-2];
			}
			resultArr[k] = result;
		}
		for(int k=0; k<resultArr.length; k++) {
			System.out.println(resultArr[k]);
		}
	}

}
