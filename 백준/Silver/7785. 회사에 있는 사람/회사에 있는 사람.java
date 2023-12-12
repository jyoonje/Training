import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int enterNo = Integer.parseInt(br.readLine());
		
		HashMap<String, String> nameMap = new HashMap<String, String>();

		StringTokenizer st;
		for (int i = 0; i<enterNo; i++) {
			st = new StringTokenizer(br.readLine());
			String name = st.nextToken();
			String state = "";

			if (nameMap.containsKey(name)) {
				nameMap.remove(name);
			} else {
				nameMap.put(name, state);
			}
		}

		ArrayList<String> nameList = new ArrayList<String>(nameMap.keySet());
		Collections.sort(nameList, Collections.reverseOrder());
		
		for(String s : nameList) {
			System.out.println(s);
		}
	}
}