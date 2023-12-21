import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception{
		//앞에서도 값을 제거하고 뒤에서도 값을 제거해야 하기 때문에 Deque을 사용하는게 성능적으로 좋음
		//덱의 poll(),peekFirst(), peekLast(0 -> 덱이 비어있으면 null 리턴
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st ;
        
        Deque<Integer> deque = new ArrayDeque<>();
        StringBuilder answer = new StringBuilder();
       
        for(int i=0; i<N; i++) {
        	st = new StringTokenizer(br.readLine());
        	String str = st.nextToken();
        	if(st.hasMoreTokens()) {
        		//push
        		int num = Integer.parseInt(st.nextToken());
        		deque.offer(num);
        	}
        	else {
        		if(str.equals("pop")) {
        			if(!deque.isEmpty()) answer.append(deque.poll()).append("\n");
        			else answer.append("-1").append("\n");
        		}
        		if(str.equals("size")) {
        			answer.append(deque.size()).append("\n");
        		}
        		if(str.equals("empty")) {
        			answer.append((deque.isEmpty()) ? "1" : "0" ).append("\n");
        		}
        		if(str.equals("front")) {
        			String a = deque.peek() + "";
//        			answer.append((a != null) ? a : "-1").append("\n");
        			if(!deque.isEmpty()) answer.append(a).append("\n");
        			else answer.append("-1").append("\n");
        		}
        		if(str.equals("back")) {
        			String a = deque.peekLast() + "";
//        			answer.append((a != null) ? a : "-1").append("\n");
        			if(!deque.isEmpty()) answer.append(a).append("\n");
        			else answer.append("-1").append("\n");
        			
        		}
        	}
        }
        System.out.println(answer);
	}

}
