import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int S = Integer.parseInt(st.nextToken());  // 파의 수
        int C = Integer.parseInt(st.nextToken());  // 파닭의 수
        int[] greenOnions = new int[S];  // 파를 담을 배열

        int start = 1;  // 파의 길이는 1부터 시작
        int end = 0;
        long sum = 0;  // 전체 파의 길이 합
        for (int i = 0; i < S; i++) {
            greenOnions[i] = Integer.parseInt(br.readLine());
            // 이전의 최대 파의 길이와 현재 파의 길이 중 더 긴 값으로 업데이트
            end = Math.max(end, greenOnions[i]);
            sum += greenOnions[i];
        }

        while (start <= end) {
            int mid = start + (end - start) / 2;

            int count = 0;// 현재 파의 길이로 만들 수 있는 파닭의 수
            for (int greenOnion : greenOnions) {
                count += greenOnion / mid;
            }

            // 현재 파의 길이로 만들 수 있는 파닭의 수가
            // 주문받은 파닭 수와 같거나 클 경우 시작 파의 길이를 업데이트
            if (count >= C) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        // 결과
        // 전체 파의 길이에서
        // 구한 파의 길이와 주문받은 파닭의 수를 곱한 값을
        // 뺀 값이 라면에 넣을 파의 양이다.
        System.out.println(sum - (long) end * C);
    }
}