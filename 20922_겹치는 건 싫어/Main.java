import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());  // 수열의 길이
        int K = Integer.parseInt(st.nextToken());  // 같은 정수의 최대 개수

        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int len = 0;  // 최장 연속 부분 수열의 길이
        int p1 = 0, p2 = 0;  // 인덱스
        // 인덱스에 맞는 숫자들의 개수를 담을 배열 (최대 100000까지 이므로 100001로 설정)
        int[] visit = new int[100001];
        // p2 인덱스가 배열의 길이 이상일 경우 종료
        while (p2 < N) {
            // p2 인덱스가 배열의 길이보다 작고
            // 배열에서 p2 인덱스에 있는 값의 visit 배열에서의 개수 + 1이
            // 같은 정수의 최대 개수보다 같거나 작을 경우
            // visit 의 p2 인덱스에 맞는 값을 추가한 후
            // p2 인덱스 값도 늘려준다.
            while (p2 < N && visit[arr[p2]] + 1 <= K) {
                visit[arr[p2++]]++;
            }

            // 이전 최장 연속 길이와 현재 최자아 연속 길이 중
            // 더 긴 값으로 업데이트
            len = Math.max(len, p2 - p1);
            // p1 인덱스 값도 늘려주면서
            // visit 배열의 값은 줄여준다.
            visit[arr[p1++]]--;
        }

        // 결과
        System.out.println(len);
    }
}