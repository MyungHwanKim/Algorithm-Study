import java.util.*;
import java.io.*;

public class Main {
    static int N;
    static int K;
    static int[] increases;
    static boolean[] visit;
    static int count = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());  // 운동 키트의 개수
        K = Integer.parseInt(st.nextToken());  // 매일 감소하는 중량

        increases = new int[N];  // 중량 증가량을 담을 배열
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            increases[i] = Integer.parseInt(st.nextToken());
        }

        visit = new boolean[N];  // 방문 확인

        // 항상 중량이 500이상되는 경우의 수 파악
        weightCheck(0, 500);

        // 결과
        System.out.println(count);
    }

    public static void weightCheck(int depth, int weight) {
        // 운동 키트 사용 개수와 실제 운동 키트 개수가 일치할 경우
        if (N == depth) {
            count++;
            return;
        }

        for (int i = 0; i < N; i++) {
            // 이미 확인한 운동 키트이거나
            // 현재 운동 중량 + 운동한 중량 - 매일 감소 중량이 500보다 작을 경우
            // continue
            if (visit[i] || weight - K + increases[i] < 500) {
                continue;
            }
            visit[i] = true;
            weightCheck(depth + 1, weight - K + increases[i]);
            visit[i] = false;
        }
    }
}