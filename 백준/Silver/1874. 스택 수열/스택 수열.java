import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

	public static void main(String[] args) throws Exception{
		//push: 주어진 요소를 스택의 맨 위에 추가
		//pop: 스택 맨 위의 요소를 삭제하고 삭제한 요소를 반환
		
		// TODO 1<= N <= 100,000 / 2초 -> n 또는 nlogn 가능
		//		첫 줄에 N 입력받고, 2번째 줄 부터 N개의 수를 입력받는다. (수열의 요소)
		//		push연산 : + , pop연산: -, 불가능한 경우: "NO"
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] A = new int[N]; // 입력받은 수를 저장할 배열
		for(int i=0; i<N; i++) {
			int n = Integer.parseInt(br.readLine());
			A[i] = n;
		}
		br.close();
		
		Stack<Integer> stack = new Stack<>();
		int num=1;
		StringBuffer bf = new StringBuffer();
		for(int i=0; i<N; i++) {
			int su = A[i];
			if(su >= num) {
				while(su >= num) {
					stack.push(num++);
					bf.append("+\n");
				}
				stack.pop();
				bf.append("-\n");
			}
			else {
				int n = stack.pop();
				if(n > su) {
					System.out.println("NO");
					return;
				}
				else {
					bf.append("-\n");
				}
			}
		}
		System.out.println(bf.toString());
	}
}
