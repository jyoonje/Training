import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
  static int N;
  static int M;
  static int cnt;
  static ArrayList<Integer>[] arr;
  static boolean[] visited;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
    arr = new ArrayList[N+1];
    visited = new boolean[N+1];
    for(int i = 1; i < N+1; i++) {
      arr[i] = new ArrayList<Integer>();
      visited[i] = false;
    }
    cnt = 0;

    for(int i = 0; i < M; i++) {
      st = new StringTokenizer(br.readLine());
      int node1 = Integer.parseInt(st.nextToken());
      int node2 = Integer.parseInt(st.nextToken());

      arr[node1].add(node2);
      arr[node2].add(node1);
    }
    for(int i = 1; i < N+1; i++) {
      if (!visited[i]) {
        cnt++;
        dfs(i);
      }
    }
    System.out.println(cnt);
  }

  public static void dfs(int idx) {
    if (visited[idx]) return;

    visited[idx] = true;
    for(int i : arr[idx]) {
      if (!visited[i]) dfs(i);
    }
  }
}
