import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

  public static void main(String[] args) throws IOException {
    // 입력 및 출력
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int subNum = Integer.parseInt(br.readLine());
    String scores = br.readLine();

    // 배열 저장
    int[] scoreArray = new int[subNum];
    String[] strScoreArray = scores.split(" ");

    if (scoreArray.length != strScoreArray.length){
      return;
    }

    for(int i = 0; i < scoreArray.length; i++){
      scoreArray[i] = Integer.parseInt(strScoreArray[i]);
    }

    Main main = new Main();
    int maxScore = main.getMaxScore(scoreArray);
    double avgScore = main.getAvgScore(scoreArray, maxScore);

    System.out.println(avgScore);
  }

  // 최댓값 계산
  private int getMaxScore(int[] scoreArray) {
    int maxScore = 0;
    for (int data : scoreArray) {
      if (data > maxScore) { maxScore = data; }
    }

    return maxScore;
  }

  // 모든 성적 수정 및 평균 계산
  private double getAvgScore(int[] scoreArray, int maxScore) {
    double totalNum = 0;
    double avgScore = 0;

    for (int j : scoreArray) {
      totalNum += (double) j / maxScore * 100;
    }

    avgScore = totalNum / scoreArray.length;
    return avgScore;
  }

}
