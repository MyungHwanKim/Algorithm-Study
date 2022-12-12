import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());  // 자르는 횟수가 담긴 목록의 길이
        int M = Integer.parseInt(st.nextToken());  // 자를 수 있는 지점의 개수
        int L = Integer.parseInt(st.nextToken());  // 롤 케이크의 길이

        int[] lens = new int[M + 1];  // 자를 수 있는 지점을 나타내는 정수
        lens[M] = L;  // 최대 길이를 마지막 배열 값에 추가
        for (int i = 0; i < M; i++) {
            lens[i] = Integer.parseInt(br.readLine());
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            int Q = Integer.parseInt(br.readLine());  // 자르는 횟수

            int start = 0;  // 시작
            int end = L;  // 끝(전체 길이)
            int maxLen = 0;  // 가장 작은 조각의 길이의 최댓값
            while (start <= end) {
                int mid = start + (end - start) / 2;

                int count = 0;  // 자른 후 개수
                int prev = 0;  // 이전 위치 값
                for (int j = 0; j < M + 1; j++) {
                    // 이전 위치값에서 현재 자른 길이 값을 추가한 값이
                    // 실제 자를 수 있는 길이 값의 위치보다 같거나 같거나 작으면
                    // 자른 후 개수를 추가하면서 이전 값 업데이트
                    if (prev + mid <= lens[j]) {
                        count++;
                        prev = lens[j];
                    }
                }

                // 자른 후의 개수가 자르는 횟수보다 클 경우
                // 시작값을 업데이트하고 가장 작은 조각의 길이 최댓값을 업데이트
                if (count > Q) {
                    start = mid + 1;
                    maxLen = Math.max(maxLen, mid);
                } else {
                    end = mid - 1;
                }
            }

            sb.append(maxLen).append("\n");
        }

        // 결과
        System.out.println(sb);
    }
}