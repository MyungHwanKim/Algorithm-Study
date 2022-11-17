import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());  // 스태프의 수
        int M = Integer.parseInt(st.nextToken());  // 풍선의 개수

        long min = Integer.MAX_VALUE;  // 걸리는 시간 중 최소 시간
        int[] times = new int[N];  // 풍선 만드는 데 걸리는 시간을 담을 배열
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            times[i] = Integer.parseInt(st.nextToken());
            min = Math.min(min, times[i]);  // 풍선을 만드는 데 걸리는 시간 중 최소
        }

        // 최소 시간으로 만들어야 하는 풍선의 개수를 최대 시간으로 잡는다.
        System.out.println(minTime(times, min * M, M));
    }

    public static long minTime(int[] times, long end, int M) {
        long start = 0;  // 시간 시작

        // 시작 시간이 끝 시간보다 클 경우 종료
        while (start <= end) {
            long mid = start + (end - start) / 2;

            long count = 0;  // 현재 만들 수 있는 풍선의 개수
            for (int time : times) {
                count += mid / time;
            }

            // 풍선의 개수가 필요한 풍선의 개수보다 작을 경우
            if (count < M) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }

        }
        // 결과
        return start;
    }
}