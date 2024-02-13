import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		String bomb = br.readLine();

		char[] inputArr = input.toCharArray();
		char[] bombArr = bomb.toCharArray();

		Stack<Character> stack = new Stack<>();

		for (int i = 0; i < inputArr.length; i++) {
			stack.push(inputArr[i]);

			if (stack.size() >= bombArr.length) {
				boolean match = true;
				for (int j = 0; j < bombArr.length; j++) {
					if (stack.get(stack.size() - bombArr.length + j) != bombArr[j]) {
						match = false;
						break;
					}
				}
				if (match) {
					for (int j = 0; j < bombArr.length; j++) stack.pop();
				}
			}
		}

		StringBuilder sb = new StringBuilder();
		for (char c : stack) {
			sb.append(c);
		}
		System.out.println(sb.length() > 0 ? sb.toString() : "FRULA");

	}

}
