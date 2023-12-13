import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = 0;
		int M = 0;
		if(st.hasMoreTokens()) {
			N = Integer.parseInt(st.nextToken());
		}
		if(st.hasMoreTokens()) {
			M = Integer.parseInt(st.nextToken());
		}
		
		int leftIdx=0, rightIdx=0, sum=0, count=0;
		
		int[] numArr = new int[N+1];    //ArrayIndexOutOfBounds예외 예방
		
		for(int i=0; i<N; i++) {
			if(!st.hasMoreTokens()) {
		        st = new StringTokenizer(br.readLine());
		    }
		    numArr[i] = Integer.parseInt(st.nextToken());
		}
		
		while(leftIdx < N) {
			if(sum == M) {
				count++;
				sum = sum - numArr[leftIdx];
				leftIdx++;
			}else if(sum > M) {
				sum = sum - numArr[leftIdx];
				leftIdx++;
			}else {
				sum = sum + numArr[rightIdx];
				rightIdx++;
			}
			if(rightIdx > N) {
				break;
			}
		}
		
		br.close();
		System.out.println(count);
		
	}

}
