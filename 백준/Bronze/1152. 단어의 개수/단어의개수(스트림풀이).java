package 백준.Bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.stream.Stream;

public class prob1142New {

	public static void main(String[] args) throws IOException {
		// TODO 스트림을 사용해서 풀이
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int cnt = (int)Stream.of(br.readLine()).flatMap(s -> Arrays.stream(s.split(" "))).count();
		System.out.println(cnt);
	}
}
