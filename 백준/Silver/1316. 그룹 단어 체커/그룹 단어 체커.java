import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int cnt = N;
		
		for(int i=0; i<N; i++) {
			String str = br.readLine();
			char[] arr = str.toCharArray();
			HashMap<Character, Integer> map = new HashMap<>();
			
			for(int j=0; j<arr.length; j++) {
				char key = arr[j];
				if(!map.containsKey(key)) map.put(key, 0);
				else { 
					if(key != arr[j-1]) {
						cnt--;
						break;
					}
				}
			}
		}
		System.out.println(cnt);
	}
	
}
