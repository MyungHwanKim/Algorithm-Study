import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());  // 캐릭터의 개수
        int K = Integer.parseInt(st.nextToken());  // 올릴 수 있는 레벨 총합

        int[] levels = new int[N];  // 레벨들을 담을 배열
        long start = Integer.MAX_VALUE;  // levels 중 가장 작은 level
        long end = Integer.MAX_VALUE;
        for (int i = 0; i < N; i++) {
            levels[i] = Integer.parseInt(br.readLine());
            start = Math.min(start, levels[i]);
        }

        long answer = 0;  // 결과
        while (start <= end) {
            long mid = start + (end - start) / 2;

            long level = 0;  // 현재 올려야하는 레벨 합
            for (int l : levels) {
                // 목표 레벨과 현재 레벨보다 클 경우
                // 그 차만큼 올려야 하는 레벨 합에 추가
                if (mid > l) {
                    level += (mid - l);
                }
            }

            // 올려야하는 레벨 합이 올릴 수 있는 레벨 총합보다 클 경우
            if (level > K) {
                end = mid - 1;
            } else {
                // 올려야하는 레벨 합이 올릴 수 있는 레벨 총합보다 같거나 작을 경우
                // 최대 팀 목표레벨 업데이트
                start = mid + 1;
                answer = Math.max(answer, mid);
            }
        }

        // 결과
        System.out.println(answer);
    }
}