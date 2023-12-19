import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

	public static void main(String[] args) throws Exception{
		// TODO k번의 입력값을 스택에 저장하되, 입력값으로 0이 들어오면 pop();
		//				스택의 정수 값들을 더한 후 출력
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int K = Integer.parseInt(br.readLine());
		
		Stack<Integer> inputStack = new Stack<>();
		for(int i=0; i<K; i++) {
			int inputNum = Integer.parseInt(br.readLine());
			if(inputNum == 0) {
				//스택의 최상단 값 제거
				inputStack.pop();
			}else {
				//스택에 입력값 저장
				inputStack.push(inputNum);
			}
		}
		
		int sum = 0;
		while(!inputStack.isEmpty()) {
			sum += inputStack.pop();
		}
		br.close();
		System.out.println(sum);
	}

}
