import java.io.*;

public class DpSol {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());  // 거스름돈 액수
        int[] dp = new int[n + 1];  // 거스름돈 동전의 개수를 담을 dp 배열

        for (int i = 1; i < dp.length; i++) {
            // 거스름돈이 5원으로 나눠줄 수 있는 경우
            if (i % 5 == 0) {
                dp[i] = i / 5;
            // 거스름돈이 1원과 3원일 경우
            } else if (i == 1 || i == 3){
                dp[i] = -1;
            } else {
                dp[i] = dp[i - 2] + 1;
            }
        }
        // 거스름돈 액수 인덱스에 있는 값 반환
        System.out.println(dp[n]);
    }
}