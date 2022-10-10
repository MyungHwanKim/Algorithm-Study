import java.io.*;
import java.util.*;

public class Main {
    static int[] out;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());  // 1 ~ N까지 자연수
        int M = Integer.parseInt(st.nextToken());  // 수열의 길이

        out = new int[M];  // M 길이 만큼의 수열을 담을 배열
        permutation(N, M, 0);
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
            out[depth] = i + 1;
            permutation(N, M, depth + 1);
        }
    }
}