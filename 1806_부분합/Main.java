import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());  // 수열의 길이
        int S = Integer.parseInt(st.nextToken());  // 최소 부분합
        int[] arr = new int[N];  // 수열

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int result = arr.length;  // 결과
        int sum = 0, cnt = 0;  // 부분합, 길이
        int p1 = 0, p2 = 0;
        while (true) {
            // 부분합이 S(최소 부분합)보다 클 경우
            if (sum >= S) {
                sum -= arr[p1++];
                result = Math.min(result, cnt);
                cnt--;
            } else if (p2 == N) {  // p2 index 값이 수열의 길이와 같을 때
                // 길이가 수열의 길이와 같을 경우
                if (cnt == arr.length) {
                    result = 0;
                    break;
                }
                break;
            } else {
                sum += arr[p2++];
                cnt++;
            }
        }
        System.out.println(result);
    }
}