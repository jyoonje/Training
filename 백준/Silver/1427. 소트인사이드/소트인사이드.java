import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String line = br.readLine();
    int[] arr = new int[line.length()];

    for (int i = 0; i < line.length(); i++) {
      arr[i] = line.charAt(i) - '0';
    }

    for(int i = 0; i < arr.length-1; i++){
      int tmp;
      for(int j = i+1; j < arr.length; j++){
        if(arr[j] > arr[i]){
          tmp = arr[i];
          arr[i] = arr[j];
          arr[j] = tmp;
        }
      }
    }
    for (int n : arr) {
      System.out.print(n);
    }
  }
}
