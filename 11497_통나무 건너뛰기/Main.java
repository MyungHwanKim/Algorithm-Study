import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());  // 테스트 케이스 수

        StringBuilder sb = new StringBuilder();  // 결과를 담을 StringBuilder
        for (int t = 0; t < T; t++) {
            int N = Integer.parseInt(br.readLine());  // 통나무의 개수
            int[] heights = new int[N];  // 통나무 높이를 담을 배열
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                heights[i] = Integer.parseInt(st.nextToken());
            }
            // 정렬
            Arrays.sort(heights);

            int p1 = 0;  // 시작 인덱스
            int p2 = N - 1;  // 끝 인덱스
            int[] result = new int[N];  // 결과 배열
            for (int i = 0; i < N; i++) {
                // 정렬한 후 작은 값부터 순서대로 첫번째, 끝 인덱스 값에 추가한다면
                // 최소 난이도를 만들 수 있다.
                if (i % 2 == 0) {
                    result[p1++] = heights[i];
                } else {
                    result[p2--] = heights[i];
                }
            }

            // 시작, 끝 인덱스도 연결되어 있으므로 현재 난이도로 설정
            int diff = result[N - 1] - result[0];
            for (int i = 1; i < result.length; i++) {
                // 이전의 난이도와 현재 구한 난이도 중 더 최대인 값으로 업데이트
                diff = Math.max(diff, Math.abs(result[i] - result[i - 1]));
            }

            sb.append(diff).append("\n");
        }

        // 결과
        System.out.println(sb);
    }
}