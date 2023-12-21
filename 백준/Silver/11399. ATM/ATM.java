import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception{
		// 1. 입력받은 배열를 오름차순으로 정렬
		//	2. 정렬된 배열A의 합 배열 S 생성
		//	3. S의 총합 출력
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String str = br.readLine();
        
        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(str);
        for(int i=0; i<arr.length; i++) {
        	arr[i] = Integer.parseInt(st.nextToken());
        }
        mergeSort(arr);	//오름차순 정렬
        
        int[] A = new int[arr.length];		// arr의 합배열 A 생성
        A[0] = arr[0];
        for(int i=1; i<A.length; i++) {
        	A[i] = A[i-1] + arr[i];
        }
        
        int sum = 0;			//A의 합 출력
        for(int item : A) {
        	sum += item;
        }
        System.out.println(sum);
	}
	
	public static void mergeSort(int[] arr) {
		int[] tmp = new int[arr.length];
		mergeSort(arr, tmp, 0, arr.length-1);
	}

	private static void mergeSort(int[] arr, int[] tmp, int start, int end) {
		if(start<end) {
			int mid = (start+end)/2;
			mergeSort(arr, tmp, start, mid);
			mergeSort(arr, tmp, mid+1, end);	//분할정복
			merge(arr, tmp, start, mid, end);	//병합
		}
	}
	private static void merge(int[] arr, int[] tmp, int start, int mid, int end) {
		for(int i=start; i<=end; i++) {
			tmp[i] = arr[i];
		}
		int part1 = start;
		int part2 = mid+1;
		int index = start;
		while(part1<=mid && part2<=end) {
			if(tmp[part1] <= tmp[part2]) {
				arr[index] = tmp[part1];
				part1++;
			} else {
				arr[index] = tmp[part2];
				part2++;
			}
			index++;
		}
		for(int i=0; i<=mid-part1; i++) {		//part2의 포인터가 먼저 끝났을 때.  그리고 기존 arr의 mid 뒤의 인덱스에는 part2의 값이 들어있기 때문에 part1의 포인터가 먼저 끝났을 때의 처리는 필요없음
			arr[index+i] = tmp[part1+i];
		}
	}
}







