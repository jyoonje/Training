

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class Main {

	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		List<String> listen = new ArrayList<>();
		Set<String> see = new HashSet<>();
		
		for(int i=0; i<N; i++) {
			String name = br.readLine();
			listen.add(name);
		}
		
		for(int i=0; i<M; i++) {
			String name = br.readLine();
			see.add(name);
		}
		
		List<String> duplicateList = listen.stream().filter(name -> see.contains(name)).collect(Collectors.toList());
		
		Collections.sort(duplicateList);
		
		System.out.println(duplicateList.size());
		for(String duplicateName : duplicateList) {
			System.out.println(duplicateName);
		}
	}

}





