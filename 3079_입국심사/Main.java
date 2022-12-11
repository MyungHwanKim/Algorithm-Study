import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());  // 입국심사대의 수
        long M = Integer.parseInt(st.nextToken());  // 상근이와 친구들의 수

        int[] times = new int[N];
        long max = 0;  // 심사하는데 드는 최대 시간
        for (int i = 0; i < N; i++) {
            // 심사관이 한 명을 심사하는데 드는 시간
            times[i] = Integer.parseInt(br.readLine());
            max = Math.max(max, times[i]);
        }

        long start = 1;  // 최소 시간
        long end = M * max;  // 전체 인원을 심사할 최대 시간
        while (start <= end) {
            long mid = start + (end - start) / 2;

            long count = 0;  // 인원 수
            for (int time : times) {
                count += (mid / time);
            }

            // 인원 수가 상근이와 친구들의 수보다 같거나 클 경우
            // 시간을 더 줄일 수 있으므로 최대 시간을 줄여준다.
            if (count >= M) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        // 결과
        System.out.println(start);
    }
}