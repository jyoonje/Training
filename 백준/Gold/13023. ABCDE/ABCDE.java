import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
  static int depth = 0;
  static boolean found = false; // 존재 여부 플래그 추가

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    int N = 0;
    int M = 0;

    st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());

    ArrayList<Integer>[] A = new ArrayList[N];
    boolean[] visited = new boolean[N];
    for (int i = 0; i < N; i++) {
      A[i] = new ArrayList<>();
      visited[i] = false;
    }

    for (int i = 0; i < M; i++) {
      st = new StringTokenizer(br.readLine());
      int friendA = Integer.parseInt(st.nextToken());
      int friendB = Integer.parseInt(st.nextToken());

      A[friendA].add(friendB);
      A[friendB].add(friendA);
    }

    for (int i = 0; i < N && !found; i++) { // 찾으면 즉시 중단
      dfs(i, A, visited);
      // visited[i] = false; depth = 0;  // 백트래킹으로 처리하므로 불필요
    }

    System.out.println(found ? 1 : 0); // 존재 여부만 출력
  }

  public static void dfs(int friend, ArrayList<Integer>[] A, boolean[] visited) {
    if (found) return;           // 조기 종료
    if (visited[friend]) return;

    visited[friend] = true;
    depth++;

    // DFS 내부에서 길이 4(노드 5개) 도달 체크
    if (depth == 5) {
      found = true;
      // 되돌리고 종료 (다른 경로에 영향 없게)
      visited[friend] = false;
      depth--;
      return;
    }

    for (int i : A[friend]) {
      dfs(i, A, visited);
      if (found) break;          // 조기 종료
    }

    // 백트래킹
    visited[friend] = false;
    depth--;
  }
}