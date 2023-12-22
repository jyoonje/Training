import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
	
		StringTokenizer st = new StringTokenizer(str);
		String reverseNumStr1 = st.nextToken();
		String reverseNumStr2 = st.nextToken();
		
		String numStr1 = "";
		String numStr2 = "";
		for(int i=reverseNumStr1.length()-1; i>=0; i-- ) {
			numStr1 += reverseNumStr1.charAt(i);
			numStr2 += reverseNumStr2.charAt(i);
		}
		int num1 = Integer.parseInt(numStr1);
		int num2 = Integer.parseInt(numStr2);
	
		if(num1>num2) System.out.println(num1);
		else System.out.println(num2);
	}

}
