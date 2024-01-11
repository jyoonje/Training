import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class Main {
    // N개의 수 입력받음 -> 배열에 저장 -> 스트림 변환 -> 중간처리(중복 제거, 길이 순 정렬, 길이가 같다면 사전 순 정렬) -> 출력.

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        String[] arr = new String[N];
        for(int i=0; i<N; i++){
            arr[i] = br.readLine();
        }

        Arrays.stream(arr)
                .distinct()
                .sorted(Comparator.comparingInt(String::length).thenComparing(Comparator.naturalOrder()))
                .forEach(s -> System.out.println(s));
    }
}
