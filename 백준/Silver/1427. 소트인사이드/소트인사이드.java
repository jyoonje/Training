import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws Exception {
		// 선택정렬 알고리즘 연습
		// 1<= N <=1,000,000,000
		// N을 입력받고, 배열로 변환 -> 내림차순으로 정렬
		// ㄴ 최댓값을 기준으로 정렬

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String N = br.readLine();
		int[] numArr = new int[N.length()];

		for (int i = 0; i < numArr.length; i++) {
			numArr[i] = N.charAt(i) - '0';
		}

		for (int i = 0; i < numArr.length; i++) {
			int maxIdx = i;
			for (int j = i + 1; j < numArr.length; j++) {    //최댓값 찾기
				if (numArr[j] > numArr[maxIdx]) {
					maxIdx = j;
				}
			}
			int tmp = numArr[i];        //swap
			numArr[i] = numArr[maxIdx];
			numArr[maxIdx] = tmp;
		}
		for (int item : numArr) {
			System.out.print(item);
		}
	}

}
