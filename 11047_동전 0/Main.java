import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());  // 동전의 종류
        int K = Integer.parseInt(st.nextToken());  // 동전 가치의 합
        int[] coins = new int[N];  // 동전의 종류를 담을 배열
        for (int i = 0; i < N; i++) {
            coins[i] = Integer.parseInt(br.readLine());
        }

        int count = 0;  // 필요한 동전 개수의 최솟값
        for (int i = coins.length - 1; i >= 0; i--) {
            // 현재 동전 가치의 합에서 가진 동전으로 나눌 수 있는 경우
            // count 에 나눌 수 있는 만큼 추가
            // 그리고 나눈 나머지로 업데이트
            if (K / coins[i] > 0) {
                count += K / coins[i];
                K %= coins[i];
            }
        }

        // 결과
        System.out.println(count);
    }
}