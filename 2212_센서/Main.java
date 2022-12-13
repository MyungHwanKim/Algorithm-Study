import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());  // 센서의 개수
        int K = Integer.parseInt(br.readLine());  // 집중국의 개수

        // 집중국의 개수가 센서의 개수보다 같거나 클 경우
        // 수신 가능한 영역의 거리 합은 무조건 0이 된다.
        if (K >= N) {
            System.out.println(0);
            return;
        }

        int[] sensors = new int[N];  // 센서의 위치를 담을 배열
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            sensors[i] = Integer.parseInt(st.nextToken());
        }
        // 센서의 위치 순으로 정렬
        Arrays.sort(sensors);

        int[] diff = new int[N - 1];  // 센서 사이의 거리를 담을 배열
        for (int i = 0; i < N - 1; i++) {
            diff[i] = sensors[i + 1] - sensors[i];
        }
        Arrays.sort(diff);

        int minLen = 0;  // 수신 가능영역의 거리의 합의 최솟값
        for (int i = 0; i < N - K; i++) {
            minLen += diff[i];
        }

        // 결과
        System.out.println(minLen);
    }
}