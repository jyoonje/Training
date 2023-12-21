import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());		//카드의 개수
        String cardStr = br.readLine();					// 카드 문자열
        int M = Integer.parseInt(br.readLine());	// 구해야 할 수의 갯수
        String mStr = br.readLine();						// 구해야 할 수 문자열
        
        String[] cardArr = new String[N];
        String[] mArr = new String[M];
        StringTokenizer st = new StringTokenizer(cardStr);		//cardStr 원소 배열에 저장
        for(int i=0; i<N; i++) {
        	if(st.hasMoreTokens()) cardArr[i] =st.nextToken();
        }
        st = new StringTokenizer(mStr);		//mStr 원소 배열에 저장
        for(int i=0; i<M; i++) {
        	if(st.hasMoreTokens()) mArr[i] =st.nextToken();
        }

        HashMap<String, Integer> map = new HashMap<>();		//해시맵에 카드번호, 갯수 삽입 
        for(String card : cardArr) {
        	Integer n = map.get(card);
        	int val = (n==null) ? 1 : n+1 ;
        	map.put(card, val);
        }
        
        StringBuilder answer = new StringBuilder();
        //mArr 배열을 순회하며 원소의 값으로 해시맵의 키에 접근해서 나온 밸류들을 answer에 append
        for(String item : mArr) {
        	Integer n = map.get(item);
        	int result = (n != null) ? n : 0;
        	answer.append(result).append(" ");
        }
        System.out.println(answer);
	}

}





