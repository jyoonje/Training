import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {
		// TODO 에라토스테네스의 체 알고리즘으로 풀이
		// 정렬된 수가 들어있는 배열의 값을 0으로 바꿈

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		int[] A = new int[N + 1];
		A[0] = A[1] = 0;

		for (int i = 2; i <= N; i++) {    // 배열 A 초기화
			A[i] = i;
		}

		calc(A, N, K);
	}

	static void calc(int[] A, int N, int K) {   
		int cnt = 0;        

		for (int i = 2; i <= N; i++) {
			if (A[i] != 0) {
				for (int j = i; j <= N; j += i) {    //A[i]와 그 배수들을 지움
					if (A[j] != 0) {
						cnt++;                        //지울 때 마다 cnt++; 
						if (cnt == K) {
							System.out.println(A[j]);
							return;
						}
						A[j] = 0;                    //조건문에 부합하지 않다면 값을 지우는 로직
					}
				}
			}
		}
	}

}
