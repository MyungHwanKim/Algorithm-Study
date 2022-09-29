import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());  // 카드의 개수
        int M = Integer.parseInt(st.nextToken());  // 3장의 합이 넘지 않는 최대한의 수

        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int max = 0;  // M을 넘지 않는 3장의 최대 값
        for (int i = 0; i < N - 2; i++) {
            for (int j = i + 1; j < N - 1; j++) {
                for (int k = j + 1; k < N; k++) {
                    int sum = arr[i] + arr[j] + arr[k];
                    // 3장이 합이 M보다 같거나 작고, max 보다 클 경우
                    if (sum <= M && sum > max) {
                        max = sum;
                    }
                }
            }
        }
        System.out.println(max);
    }
}