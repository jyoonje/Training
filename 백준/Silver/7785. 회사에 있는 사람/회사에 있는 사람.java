import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int enterNo = Integer.parseInt(br.readLine());
		
		HashMap<String, String> nameMap = new HashMap<String, String>();	//기존에는 ArrayList로 코드를 작성했지만, 시간초과됨

		StringTokenizer st;
		for (int i = 0; i<enterNo; i++) {
			st = new StringTokenizer(br.readLine());
			String name = st.nextToken();			//공백의 앞 부분만 key에 저장하기 위한 로직
			String state = "";

			if (nameMap.containsKey(name)) {
				nameMap.remove(name);		//시간초과 된 부분. ArrayList는 0번 인덱스부터 순차적으로 탐색해야 하지만,
								//HashMap은 key값만 알고있다면 빠르게 접근 가능하다.
			} else {
				nameMap.put(name, state);
			}
		}

		ArrayList<String> nameList = new ArrayList<String>(nameMap.keySet());	
		Collections.sort(nameList, Collections.reverseOrder());		//Collections클래스의 reverseOrder(): 역순정렬(참조타입만 가능)
		
		for(String s : nameList) {
			System.out.println(s);
		}
	}
}
