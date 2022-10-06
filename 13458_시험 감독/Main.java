import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());  // 시험장 개수
        int[] candidates = new int[N];  // 시험장마다 응시자 수

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            candidates[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine(), " ");
        int B = Integer.parseInt(st.nextToken());  // 총감독관
        int C = Integer.parseInt(st.nextToken());  // 부감독관

        long count = 0;  // 필요한 감독관 수
        for (int candidate : candidates) {
            candidate -= B;  // 응시자 중 총감독관이 감시할 수 있는 응시자 수 제외
            count++;

            // 총 감독관으로 모든 응시자를 감시할 수 있는 경우
            if (candidate <= 0) {
                continue;
            }

            // 남은 응시자를 감시할 수 있는 부감독관의 수
            count += candidate / C;
            // 응시자가 남아있다면 부감독관 수 추가
            if (candidate % C != 0) {
                count++;
            }
        }
        // 결과
        System.out.println(count);
    }
}