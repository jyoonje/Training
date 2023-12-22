import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		String str = br.readLine();
		
		int[] A = new int[N];
		
		StringTokenizer st = new StringTokenizer(str);
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<A.length; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}
		int min=A[0];
		int max=A[0];
		for(int i=0; i<A.length; i++) {
			if(min>A[i]) { min=A[i]; }
			if(max<A[i]) { max=A[i]; }
		}
		
		sb.append(min).append(" ").append(max);
		System.out.println(sb);
		
		
	}

}
