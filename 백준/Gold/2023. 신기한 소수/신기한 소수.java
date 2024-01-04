import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	//일의자리 수 중 2, 3, 5, 7이 소수이므로, 시간복잡도를 줄이기 위해 불필요한 1, 4, 6, 8, 9는 함수 호출하지 않음
	
	static int N;

	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		DFS(2, 1);
		DFS(3, 1);
		DFS(5, 1);
		DFS(7, 1);
	}
	
	static void DFS(int number, int jarisu) {
		if(jarisu == N) {
			if(isPrime(number)) {
				System.out.println(number);
			}
			return;
		}
		
		for(int i=1; i<10; i=i+2) {
			if(isPrime(number*10 + i)) {
				DFS(number*10 + i, jarisu+1);
			}
		}
	}
	
	static boolean isPrime(int num) {	//  소수 구하는 메소드
		for(int i=2; i<=num/2; i++) { 	//	num/2 이상부터는 확인할 필요 없음
			if(num % i == 0) {
				return false;	
			}
		}
		return true;
	}

}








