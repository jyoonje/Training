import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception{
		// Stack의 pop(), peek() 메소드는 비어있으면 예외발생
		//				empty()메소드는 true/false 반환
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();
        
        StringBuilder answer = new StringBuilder();
        for(int i=0; i<N; i++) {
        	StringTokenizer st = new StringTokenizer(br.readLine());
        	String str = st.nextToken();
        	if(st.hasMoreTokens()) { 
        		int num = Integer.parseInt(st.nextToken());
        		stack.push(num);
        	}
        	else {
        		if(str.equals("pop")) {
        			if(!stack.isEmpty()) answer.append(stack.pop()).append("\n");
        			else answer.append("-1").append("\n");
        		}
        		if(str.equals("size")) {
        			answer.append(stack.size()).append("\n");
        		}
        		if(str.equals("empty")) {
        			if(!stack.isEmpty()) answer.append("0").append("\n");
        			else answer.append("1").append("\n");
        		}
        		if(str.equals("top")) {
        			if(!stack.isEmpty()) answer.append(stack.peek()).append("\n");
        			else answer.append("-1").append("\n");
        		}
        	}
        }
        System.out.println(answer);
	}

}
