import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		for(int i=0; i<N; i++) {
			String str = br.readLine();
			StringTokenizer st = new StringTokenizer(str);
			int num = Integer.parseInt(st.nextToken());
			String a = st.nextToken();
			
			char[] arr = a.toCharArray();
			ArrayList<Character> charList = new ArrayList<>();
			
			for(int j=0; j<arr.length; j++) {
				for(int k=0; k<num; k++) {
					charList.add(arr[j]);
				}
			}
			for(char item : charList) {
				sb.append(item);
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}

}
