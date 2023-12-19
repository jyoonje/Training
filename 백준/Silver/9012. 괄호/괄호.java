import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

	public static void main(String[] args) throws Exception {
		// TODO 괄호문자열의 길이는 50이하 이므로 O(n^2) 가능
		// 입력값으로 '(' 이 들어오면 스택에 push, ')'이 들어오면 스택에 있던 값 pop
		// 첫 입력이 ')'이 들어오면 no 출력
		// 한 줄 입력이 끝났을 때 스택이 비어있으면 yes

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		Stack<Character> inputStack = new Stack<>();
		StringBuilder answerStr = new StringBuilder();

		for (int i = 0; i < N; i++) {
			String inputStr = br.readLine(); // 문자열에서 '(' 와 ')'의 개수가 같으면 YES, 아니면 NO /스택이 비어있을 때 ')'가 들어오면 NO
			for (int j = 0; j < inputStr.length(); j++) {
				char str = inputStr.charAt(j);
				if (str == '(') {
					inputStack.push(str);
				}
				else if (str == ')') {
					if (inputStack.isEmpty()) {		// 문자열 시작이 ')' -> NO
						inputStack.push('(');
						break;
					}
					else {
						inputStack.pop();
					}
				}
			}
			if(inputStack.isEmpty())  answerStr.append("YES").append("\n");
			else answerStr.append("NO").append("\n");
			
			inputStack.clear();
		}

		br.close();
		System.out.println(answerStr);
	}
}
