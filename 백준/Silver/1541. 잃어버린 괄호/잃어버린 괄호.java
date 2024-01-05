import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class Main {

	static String str;
	static StringTokenizer st;
	static ArrayList<String> list;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		str = br.readLine();

		st = new StringTokenizer(str, "-");
		list = new ArrayList<>();
		while (st.hasMoreTokens()) {
			list.add(st.nextToken());
		}

		int sum = 0;

		for (int i = 1; i < list.size(); i++) {
			sum += calculator(list.get(i));
		}

		if (!str.startsWith("-")) {
			System.out.println(calculator(list.get(0)) - sum);
		} else {
			System.out.println(0 - calculator(list.get(0)) - sum);
		}
	}

	static int calculator(String element) {
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
