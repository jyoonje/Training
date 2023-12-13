import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception{
		// 숫자형 배열에 값을 담은 후 정렬한다.
		// 투 포인터를 각각 시작, 마지막 인덱스에서 위치시킨다.
		// 재료는 한 번 쓰면 소진되므로 sum==M이면 포인터를 한 칸씩 좁힌다.
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		
		int[] arr = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			if(!st.hasMoreTokens()) {
				st = new StringTokenizer(br.readLine());
			}
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);
		
		int i=0, j=N-1, count=0;
		
		while(i<j) {
			if(arr[i]+arr[j] == M) {
				count++;
				i++;
				j--;
			}else if(arr[i]+arr[j]>M) {
				j--;
			}else if(arr[i]+arr[j]<M) {
				i++;
			}
		}
		
		System.out.println(count);
	}

}





