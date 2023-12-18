import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

	public static void main(String[] args) throws Exception{
		// TODO FIFO의 문제이다.
		//		두 번 버리고, 나중에 버린 카드를 다시 삽입한다.

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		br.close();
		
		//1~N까지 큐에 삽입
		Queue<Integer> cardQueue = new LinkedList<>();
		for(int i=1; i<=N; i++) {
			cardQueue.offer(i);
		}
		
		//큐의 길이가 1일 때 까지 반복
		while(cardQueue.size() > 1) {
			cardQueue.poll();
			cardQueue.offer(cardQueue.poll());
		}
		
		//마지막에 남은 값 출력
		System.out.println(cardQueue.peek());
	}
}







