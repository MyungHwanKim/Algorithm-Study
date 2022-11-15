import java.io.*;
import java.util.*;

public class Main {
    static int[] num = {1, 5, 10, 50};  // I, V, X, L
    static boolean[] visit;
    static boolean[] sums = new boolean[1001];  // 수의 합이 중복인 파악할 배열
    static int count = 0;  // 서로 다른 수의 개수
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());  // 합할 수의 문자 개수
        visit = new boolean[4];  // 방문 확인

        // 서로 다른 수의 개수 파악
        differentNumCount(N, 0, 0);

        // 결과
        System.out.println(count);
    }

    public static void differentNumCount(int N, int depth, int sum) {
        // depth 가 수의 문자를 담을 배열의 길이와 일치할 경우
        if (N == depth) {
            // sums 배열에 sum 번째 인덱스가 false 인 경우
            // 중복이 아니므로 서로 다른 수의 개수를 추가하고
            // sum 번째 인덱스를 true 로 만든다.
            if (!sums[sum]) {
                count++;
                sums[sum] = true;
            }
            return;
        }

        for (int i = 0; i < num.length; i++) {
            // 방문한 로마 숫자가 아닌 경우
            if (!visit[i]) {
                // 현재 위치 이전의 visit 을 true 로 만들어 중복 제거
                for (int j = 0; j < i; j++) {
                    visit[j] = true;
                }

                differentNumCount(N, depth + 1, sum + num[i]);

                for (int j = 0; j < i; j++) {
                    visit[j] = false;
                }
            }
        }
    }
}