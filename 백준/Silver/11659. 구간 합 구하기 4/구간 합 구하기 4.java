import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws IOException {
    // 입력받음
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int N = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(st.nextToken());
    String str = br.readLine();


    // 입력받은 값 배열 생성
    String[] strArr = str.split(" ");
    int[] arr = new int[N];
    for(int i = 0; i < arr.length; i++){
      arr[i] = Integer.parseInt(strArr[i]);
    }

    Main q = new Main();
    // 구간 합 배열 생성
    int[] sumArr = q.getSumArr(arr);

    // 구간 계산
    for (int i = 0; i < M; i++){
      st = new StringTokenizer(br.readLine());
      int start = Integer.parseInt(st.nextToken());
      int end = Integer.parseInt(st.nextToken());

      System.out.println(sumArr[end] - sumArr[start - 1]);

    }
  }

  private int[] getSumArr(int[] arr){
    int[] sumArr = new int[arr.length + 1];

    for(int i = 1; i <= arr.length; i++){
      sumArr[i] = sumArr[i-1] + arr[i-1];
    }
    return sumArr;
  }
}
