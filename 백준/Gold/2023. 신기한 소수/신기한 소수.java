import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
  static int N;
  static int[] B = {1, 3, 5, 7, 9};

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    N = Integer.parseInt(br.readLine());
    int[] A = {2, 3, 5, 7};

    for(int i : A) {
      dfs(i);
    }
  }

  public static void dfs(int num){
    int length = String.valueOf(num).length();
    if(length == N){
      System.out.println(num);
      return;
    }

    // 뒷자릿수 더해서 추가된 자릿수의 수 생성
    // isPrime() 함수로 소수 판별 -> 맞다면 N 자릿수까지 진행
    // 마지막 N 자릿수 까지 왔을때, 소수라면 sout
    for(int i : B) {
      int newNum = 10 * num + i;
      if(isPrime(newNum)) dfs(newNum);
      else continue;
    }

  }

  public static boolean isPrime(int n) {
    if (n <= 1) return false;       // 1 이하의 수는 소수가 아님
    if (n == 2) return true;        // 2는 소수
    if (n % 2 == 0) return false;   // 2의 배수는 소수가 아님

    // √n 까지만 검사하면 충분
    for (int i = 3; i <= Math.sqrt(n); i += 2) {
      if (n % i == 0) return false;
    }
    return true;

  }
}