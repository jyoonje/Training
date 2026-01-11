import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int N = Integer.parseInt(st.nextToken());

    int[] sumArr = new int[N+1];
    sumArr[0] = 0;
    for(int i = 1; i <= N; i++) {
      sumArr[i] = sumArr[i - 1] + i;
    }

    int count = 0;

    for(int i = N; i > 0; i--) {
      int bigPointer = i;
      int smallPointer = i-1;
      boolean found = false;
      while(!found) {
         int result = sumArr[bigPointer] - sumArr[smallPointer];
         if(result == N) {
           count++;
           found = true;
         } else if(result > N) {
           break;
         } else {
           if(smallPointer > 0) smallPointer--;
           else break;
         }
      }
    }

    System.out.println(count);
  }


}
