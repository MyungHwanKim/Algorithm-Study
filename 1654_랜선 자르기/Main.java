import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int K = Integer.parseInt(st.nextToken());  // 가지고 있는 랜선의 개수
        int N = Integer.parseInt(st.nextToken());  // 필요한 랜선의 개수

        int[] lens = new int[K];  // 랜선의 길이를 담을 배열
        long max = 0;  // 가지고 있는 랜선의 길이 중 최대
        for (int i = 0; i < K; i++) {
            lens[i] = Integer.parseInt(br.readLine());
            max = Math.max(max, lens[i]);
        }

        // 결과
        // max + 1 인 경우는 N = 2 이고 가지고 있는 랜선의 길이도 [1, 1]이라면
        // min = 0, max = 1로 mid 값이 0을 가지게 된다.
        // 길이를 mid 로 나누기에 0으로 나눌 시 에러가 발생한다.
        // 그래서 max + 1로 이분 탐색을 실시한다.
        System.out.println(maxLen(N, max + 1, lens));
    }

    public static long maxLen(int N, long max, int[] lens) {
        long min = 0;  // 최소값

        // 최소값이 최대값과 같거나 클 경우 종료
        while (min < max) {
            long mid = min + (max - min) / 2;

            // 랜선의 개수
            long count = 0;
            for (int len : lens) {
                count += (len / mid);
            }

            // 랜선의 개수가 필요한 랜선의 개수보다 작을 경우
            // max 를 mid 로 변경한다.
            if (count < N) {
                max = mid;
            } else {
                min = mid + 1;
            }
        }
        // min 을 얻을 때 mid + 1로 설정했기에
        // 최종값은 mid - 1이 최대 길이가 된다.
        return min - 1;
    }
}