import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		PriorityQueue<Integer> inputQueue = new PriorityQueue<Integer>(new Comparator<Integer>() {
			//정렬 오버라이딩 -> compare()-> 리턴값 기준 양수: swap 음수: 유지
			@Override
			public int compare(Integer o1, Integer o2) {
				//o1의 절대값이 더 크다면 swap
				if(Math.abs(o1) > Math.abs(o2)) {
					return Math.abs(o1) - Math.abs(o2);
				//두 값의 절댓값이 같다면 값을 비교해서 swap/유지
				}else if(Math.abs(o1) == Math.abs(o2)) {
					return o1 - o2;
				}else {	//유지
					return -1;
				}
			}
		});
		StringBuilder sb = new StringBuilder();
		
		for(int i = 0; i < N; i++) {
			int x = Integer.parseInt(br.readLine());
			if(x == 0) {
				if(inputQueue.isEmpty()) sb.append("0").append("\n");
				else sb.append(inputQueue.poll()).append("\n");
			}else {
				inputQueue.offer(x);
			}
		}
		System.out.println(sb);
	}

}