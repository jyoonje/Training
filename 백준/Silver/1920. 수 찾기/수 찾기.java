import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static int[] A;	// 기준 정수들을 저장할 배열
	static int[] B;	// 찾아야 할 정수들을 저장할 배열
	static StringTokenizer st;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		// 1 ≤ N ≤ 100,000 , 1 ≤ M ≤ 100,000 , 시간제한 1초
		// O(n^2)의 시간복잡도로 계산 불가능. -> 이진탐색 알고리즘 사용하여 풀이
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		
		A = new int[N];					// 입력값 배열에 저장
		for(int i=0; i<N; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}

		int M = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		
		B = new int[M];
		for(int i=0; i<M; i++) {
			B[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(A);					// 이진탐색을 위한 정렬
		
		for(int i=0; i<M; i++) {
			binarySearch(B[i], 0, A.length-1);
		}
	}
	
	
	static void binarySearch(int num, int start, int end) {
		int mid;
		
		while(start <= end) {
			mid = (start + end) / 2;
			
			if(num == A[mid]) {
				System.out.println("1");
				return;
			} 
			else if(num < A[mid]) end = mid-1 ;
			else if(num > A[mid]) start = mid+1 ;
		}
		System.out.println("0");
		return;
	}

}










