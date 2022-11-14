import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());  // 로프의 개수

        int[] weights = new int[N];
        for (int i = 0; i < N; i++) {
            // 로프가 버틸 수 있는 최대 중량
            weights[i] = Integer.parseInt(br.readLine());
        }
        // 로프 무게를 오름차순 정렬
        Arrays.sort(weights);

        int maxWeight = 0;
        for (int i = 0; i < weights.length; i++) {
            // 현재 로프를 사용할 경우 현재 로프보다 큰 무게를 버틸 수 있는 로프를 모두 사용하는 것이 좋다.
            // 그러므로 현재 로프가 버틸 수 있는 최대 중량 * (로프의 개수 - 현재 위치 로프)
            maxWeight = Math.max(maxWeight, weights[i] * (weights.length - i));
        }

        // 결과
        System.out.println(maxWeight);
    }
}