import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception{
		//  1: 스택에 정수 x 삽입
		//	 2: isEmpty(): pop()값 출력 / !isEmpty(): -1 출력
		//	 3: size() 출력
		//	 4: isEmpty(): 1 출력/ !isEmpty(): 0 출력
		//	 5: isEmpty(): -1 출력/ !isEmpty(): peek() 값 출력
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		Stack<Integer> inputStack = new Stack<>();
		StringBuilder answer = new StringBuilder();
		
		for(int i=0; i<N; i++) {
			String inputStr = br.readLine();
			if(inputStr.startsWith("1")) {
				String[] str = inputStr.split(" ");			//초기 코드는 int x = Integer.parseInt(inputStr.subString(3)); 이었지만 numberFormatException 발생
				String xStr = str[1];
				int x =Integer.parseInt(xStr);
				inputStack.push(x);
			}else {
				if(inputStr.equals("2")) {
					int num = (inputStack.isEmpty() ? -1 : inputStack.pop());
					answer.append(num + "\n");
				}
				if(inputStr.equals("3")) {
					answer.append(inputStack.size() + "\n");
				}
				if(inputStr.equals("4")) {
					int num = (inputStack.isEmpty() ? 1 : 0);
					answer.append(num + "\n");
				}
				if(inputStr.equals("5")) {
					int num = (inputStack.isEmpty() ? -1 : inputStack.peek());
					answer.append(num + "\n");
				}
				
			}
		}
		System.out.println(answer);
	}

}






