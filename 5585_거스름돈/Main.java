import java.io.*;

public class Main {
    static int[] coins = {500, 100, 50, 10 ,5 ,1};  // 잔돈 종류
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());  // 지불할 돈
        int money = 1000 - N;  // 거스름돈
        int count = 0;  // 거스름돈의 개수
        for (int coin : coins) {
            // 거스름돈을 잔돈 종류로 나눠줄 수 있을 경우
            if (money / coin > 0) {
                count += money / coin;
                money %= coin;
            }
        }
        System.out.println(count);
    }
}