import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	// 시간제한 1초, 2 ≤ N ≤ 1,000
	static int testCast;
	static int N;
	static String numStr;
	static int[] A;
	static boolean[] visited;
	static int answer;

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		testCast = Integer.parseInt(br.readLine());
		
		//입력받기
		for(int i=0; i<testCast; i++) {
			N = Integer.parseInt(br.readLine());
			StringTokenizer st =  new StringTokenizer(br.readLine());
			A = new int[N+1];
			visited = new boolean[N+1];
			answer = 0;
			
			for(int j=1; j<N+1; j++) {	// 입력값 배열 A, 방문 확인 배열 visited 초기화 
				A[j] = Integer.parseInt(st.nextToken());
			}
			
			for(int j=1; j<N+1; j++) {
				if(!visited[j]) {
					DFS(j);
					answer++;
				}
			}
			System.out.println(answer);
		}
	}
	
	public static void DFS(int idx) {
		visited[idx] = true;
		
		//방문한 인덱스를 만날 때 까지 재귀호출
		int next = A[idx];
		if(!visited[next]) {
			DFS(next);
		}
		
		
	}

}


