import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    if(N <= 2 ) {
      System.out.println(0);
      return;
    }

    int[] arr = new int[N];
    StringTokenizer st = new StringTokenizer(br.readLine());
    for(int i = 0; i < N; i++) {
      arr[i] = Integer.parseInt(st.nextToken());
    }
    Arrays.sort(arr);

    int count = getCount(N, arr);

    System.out.println(count);
  }

  private static int getCount(int N, int[] arr) {
    int count = 0;
    for(int i = 0; i < N; i++) {
      int start = 0, end = N -1;

      while(start < end) {
        if(start == i) {
          start ++;
          continue;
        }
        if(end == i) {
          end --;
          continue;
        }

        // 찾으면
        if(arr[start] + arr[end] == arr[i]) {
          count++;
          break;
        }
        // 못 찾았으면
        if(arr[start] + arr[end] > arr[i]) {
          end--;
        }
        else if(arr[start] + arr[end] < arr[i]) {
          start++;
        }
      }
    }
    return count;
  }
}
