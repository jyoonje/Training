import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    st = new StringTokenizer(br.readLine());
    int S = Integer.parseInt(st.nextToken()); // DNA 문자열 길이
    int P = Integer.parseInt(st.nextToken()); // 부분 문자열 길이

    st = new StringTokenizer(br.readLine());
    char[] dnaArr = st.nextToken().toCharArray(); // DNA 문자열

    int[] checkArr = new int[4];  // 비밀번호 조건 배열
    int[] myArr = new int[4];     // 비밀번호 조건 배열과 비교할 배열

    st = new StringTokenizer(br.readLine());
    for(int i = 0; i < 4; i++) {
      checkArr[i] = Integer.parseInt(st.nextToken());
    }

    Main q = new Main();
    int result = q.isValidPassword(P, dnaArr, checkArr, myArr);

    System.out.println(result);
  }

  public int isValidPassword(int P, char[] dnaArr, int[] checkArr, int[] myArr) {
    int count = 0;
    char[] passwordArr = new char[P];

    int start = 0;
    int end = P-1;

    for(int i = start; i <= end; i++) {
      passwordArr[i - start] = dnaArr[i];
    }

    for (char c : passwordArr) {
      addChar(c, myArr);
    }

    if (isSatisfied(checkArr, myArr)) count++;

    while (end < dnaArr.length -1) {
      removeChar(dnaArr[start], myArr);
      start++;

      end++;
      addChar(dnaArr[end], myArr);

      if (isSatisfied(checkArr, myArr)) count++;
    }

    return count;
  }

  private void addChar(char c, int[] myArr) {
    if (c == 'A') myArr[0]++;
    else if (c == 'C') myArr[1]++;
    else if (c == 'G') myArr[2]++;
    else if (c == 'T') myArr[3]++;
  }

  private void removeChar(char c, int[] myArr) {
    if (c == 'A') myArr[0]--;
    else if (c == 'C') myArr[1]--;
    else if (c == 'G') myArr[2]--;
    else if (c == 'T') myArr[3]--;
  }

  private boolean isSatisfied(int[] checkArr, int[] myArr) {
    for (int i = 0; i < 4; i++) {
      if (myArr[i] < checkArr[i]) return false;
    }
    return true;
  }
}
