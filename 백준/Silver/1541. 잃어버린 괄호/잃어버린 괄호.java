import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

	static String str;
	static StringTokenizer st;
	static ArrayList<String> list;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		str = br.readLine();

		st = new StringTokenizer(str, "-");			// 입력 문자열을 "-" 를 기준으로 자른다.
		list = new ArrayList<>();
		while (st.hasMoreTokens()) {					// 자른 문자열을 list에 넣는다.
			list.add(st.nextToken());
		}

		int sum = 0;
		for (int i = 1; i < list.size(); i++) {			// list의 요소들의 덧셈 계산을 수행하는 calculator() 메소드 실행
			sum += calculator(list.get(i));
		}

		if (!str.startsWith("-")) {													// 입력 문자열이 "+"로 시작하면 첫번째 인덱스 - 나머지
			System.out.println(calculator(list.get(0)) - sum);	// 입력문자열이 "-"로 시작하면 0-모든 인덱스
		} else {
			System.out.println(0 - calculator(list.get(0)) - sum);
		}
	}

	static int calculator(String element) {						//리스트의 요소를 "+" 기준으로 나눠서 요소의 덧셈을 수행한 후 반환
		ArrayList<Integer> list = new ArrayList<>();
		int sum = 0;
		
		st = new StringTokenizer(element, "+");
		while (st.hasMoreTokens()) {
			list.add(Integer.parseInt(st.nextToken()));
		}
		for(Integer item : list) {
			sum += item;
		}
		return sum;
	}

}
