import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		StringBuilder str1 = new StringBuilder();	//reverse() 메소드를 사용하기 위해 sb 생성
		StringBuilder str2 = new StringBuilder();
		
		while(st.hasMoreTokens()) {
			str1.append(st.nextToken());
			str2.append(st.nextToken());
		}

		int num1 =  Integer.parseInt(str1.reverse().toString());
		int num2 =  Integer.parseInt(str2.reverse().toString());
		
		System.out.println(num1 > num2 ? num1 : num2 );
		
	}

}
