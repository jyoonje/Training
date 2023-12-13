//쓸데없이 복잡하게 짜여진 코드이다. 자료구조/알고리즘 공부를 통해 더 나은 코드를 작성하기 위하여 연습이 필요하다.

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws Exception{
		// TODO 입력받은 문자열 str (str<=100)
		//if(str.lenghth() % 2 ) == 0 
		//{인덱스[0] ~ 인덱스[length/2 -1].equals(
		// 인덱스[length/2] ~ 인덱스[length-1] 의 뒤집은 문자열) }
		//
		//else {인덱스[0] ~ 인덱스[length/2 의 내림 -1].equals
		//      인덱스[length/2 올림] ~ 인덱스[length-1]}

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		String firstHalf = "";
		String halfLast = "";
		StringBuilder sb;
		if(str.length()%2 == 0) {
			firstHalf = str.substring(0, str.length()/2);
			halfLast = str.substring(str.length()/2, str.length());
		}else {
			firstHalf =  str.substring(0, str.length()/2);
			halfLast = str.substring(str.length()/2+1, str.length());
		}
		
		sb = new StringBuilder(halfLast);
		if(firstHalf.equals(sb.reverse().toString())) {
			System.out.println("1");
		}
		else {
			System.out.println("0");
			}
		
	}

}
