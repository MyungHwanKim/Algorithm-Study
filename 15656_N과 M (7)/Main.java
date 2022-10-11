import java.io.*;
import java.util.*;

public class Main {
    static int[] arr;
    static int[] out;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());  // 자연수의 개수
        int M = Integer.parseInt(st.nextToken());  // 수열의 길이
        arr = new int[N];  // N 개의 자연수

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        // 사전 순으로 증가해야 하므로 정렬
        Arrays.sort(arr);
        out = new int[M];  // M 길이 만큼의 수열을 담을 배열
        permutation(N, M, 0);
        // 결과
        System.out.println(sb.toString());
    }

    public static void permutation(int N, int M, int depth) {
        // depth 가 수열의 길이와 일치할 경우
        if (M == depth) {
            for (int i = 0; i < M; i++) {
                sb.append(out[i]).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = 0; i < N; i++) {
            out[depth] = arr[i];
            permutation(N, M, depth + 1);
        }
    }
}