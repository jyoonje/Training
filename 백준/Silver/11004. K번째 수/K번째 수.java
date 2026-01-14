import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    st = new StringTokenizer(br.readLine());
    int N = 0;
    int index = 0;
    
    
    while(st.hasMoreTokens()) {
      N = Integer.parseInt(st.nextToken());
      index = Integer.parseInt(st.nextToken());
    }
    
    int[] arr = new int[N];
    
    
    st = new StringTokenizer(br.readLine());
        while(st.hasMoreTokens()) {
      for(int i = 0; i < N; i++) {
        arr[i] = Integer.parseInt(st.nextToken()); 
      }
    }
    
    Arrays.sort(arr);

    System.out.println(arr[index-1]);
  }
}
