import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int[] A;
	static StringTokenizer st;
	
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());	// 동전 종류의 수
		int K = Integer.parseInt(st.nextToken());	// 목표 금액
		
		A= new int[N];
		
		for(int i=0; i<N; i++) {
			A[i] = Integer.parseInt(br.readLine());
		}
		
		greedy(A, K);
		
	}

	
	static void greedy(int[] A, int K) {
		int answer = 0;	// 정답 출력할 변수
		int targetAmount = K;	// 목표금액(반복문을 돌면서 값이 바뀜)
		
		for(int i=A.length-1;  i>=0;  i--) {
			
			if(targetAmount  == 0) break;
			else if(targetAmount >= A[i]) {		//	배열을 반대로 순회하면서 목표금액보다 작은 단위의 동전이 나오면 나눈 몫을 answer에 할당하고 목표 금액에 나머지를 대입
				answer += targetAmount / A[i];
				targetAmount = targetAmount % A[i];
			}
			
		}
	
		System.out.println(answer);
		
	}
	
	
	
	
}



	

