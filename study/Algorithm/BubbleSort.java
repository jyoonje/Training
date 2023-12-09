package Algorithm;

import java.io.BufferedReader;
import java.io.InputStreamReader;

// 데이터의 수가 N개일 때, 버블소트는 N*(N+1)/2 만큼의 시간복잡도를 가진다.
// +,/ 와 같은 연산은 N이 매우 큰 값이라면 큰 의미가 없음. 
// => 버블소트의 시간 복잡도:  O(N^2) 
// 버블소트의 한계점:
// 	- 버블소트는 자리를 스왑하는 과정에서 세 개의 명령어를 수행해야 하기 때문에(밑의 예제에선 temp,arr[i], arr[j]) 성능이 떨어짐.

public class BubbleSort {
	
	public static void main(String[] args) throws Exception {
		//사용자에게 10개의 배열을 입력받아 버블소트 구현
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] arr = new int[10];

		for(int i=0; i<arr.length; i++) {
			System.out.println(i+"번째 정수: ");
			arr[i] = br.read();
		}
		
		for(int i=0; i<arr.length-1; i++){		// 배열의 길이-1 만큼의 라운드를 가짐
			for(int j=0; j<arr.length-1-i; j++) {	//실제 정렬이 일어나는 구간으로, 가장 큰 수가 마지막으로 가기 때문에 비교하는 수가 하나씩 줄어듦
				if(arr[j] > arr[j+1]) {		//왼쪽 인덱스의 값이 오른쪽 인덱스의 값보다 크다면 스왑
					int temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;
				}
			}
		}
		
		for(int i=0; i<arr.length; i++) {
			System.out.println(arr[i] + " ");
		}
	}

}
