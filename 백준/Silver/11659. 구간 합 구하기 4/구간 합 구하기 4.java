import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());	
		int arrLength = Integer.parseInt(st.nextToken());
		int quizNo = Integer.parseInt(st.nextToken());
		
		int[] A = new int[arrLength];
		StringTokenizer st2 = new StringTokenizer(br.readLine());
		for(int k=0; k<A.length; k++) {
			A[k] = Integer.parseInt(st2.nextToken());
		}
		
		int[] S = new int[arrLength];	
		S[0] = A[0];
		for(int k=1; k<arrLength; k++) {
			S[k] = S[k-1] + A[k];
		}
		
		int[] resultArr = new int[quizNo]; 
		
		for(int k=0; k<quizNo; k++) {
			StringTokenizer st3 = new StringTokenizer(br.readLine());
			int i = Integer.parseInt(st3.nextToken());	
			int j = Integer.parseInt(st3.nextToken());	
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
