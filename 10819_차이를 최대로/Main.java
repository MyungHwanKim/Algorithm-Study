import java.io.*;
import java.util.*;

public class Main {
    static int[] arr;
    static boolean[] isCheck;
    static int[] out;
    static int max = Integer.MIN_VALUE;  // 식의 최댓값
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());  // 정수의 개수
        arr = new int[N];  // N개의 정수로 이루어진 배열
        isCheck = new boolean[N];  // 방문 확인
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        out = new int[N];  // 여러 순서의 배열
        calculation(N, 0);
        // 결과
        System.out.println(max);
    }

    public static void calculation(int N, int depth) {
        // 배열의 길이와 depth 가 일치할 경우
        if (N == depth) {
            int sum = 0;  // out 배열의 합
            for (int i = 1; i < out.length; i++) {
                sum += Math.abs(out[i] - out[i - 1]);
            }
            // out 배열의 합과 max 중 더 큰 값
            max = Math.max(max, sum);
            return;
        }

        for (int i = 0; i < N; i++) {
            // 아직 방문하지 않은 경우
            if (!isCheck[i]) {
                isCheck[i] = true;
                out[depth] = arr[i];
                calculation(N, depth + 1);
                isCheck[i] = false;
            }
        }
    }
}