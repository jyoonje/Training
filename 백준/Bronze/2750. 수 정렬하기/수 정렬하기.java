//시간제한 1초
// 1<= N <= 1000 -> N^2 가능

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	// 입력값을 배열에 넣은 후, 버블정렬로 정렬

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		int[] arr = new int[N];
		for (int i = 0; i < N; i++) {
			int num = Integer.parseInt(br.readLine());

			arr[i] = num;
		}

		int tmp = 0;
		for (int i = 0; i < arr.length - 1; i++) {
			for (int j = 0; j < arr.length - 1 - i; j++) {
				if (arr[j] > arr[j + 1]) {
					tmp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = tmp;
				}
			}
		}
		for(int item : arr) {
			System.out.println(item);
		}
	}

}
