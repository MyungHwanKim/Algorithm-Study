import java.io.*;

public class Main {
    static boolean[] isVisited;
    static int[] out;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());  // 1 ~ N까지 자연수
        isVisited = new boolean[N];  // 방문 파악
        out = new int[N];  // N 길이 만큼의 수열을 담을 배열
        permutation(N, 0);
        System.out.println(sb.toString());
    }

    public static void permutation(int N, int depth) {
        if (N == depth) {
            for (int i = 0; i < N; i++) {
                sb.append(out[i]).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = 0; i < N; i++) {
            // 방문하지 않았을 경우
            if (!isVisited[i]) {
                // isVisited 를 true 로 만들면서 중복 제거
                isVisited[i] = true;
                out[depth] = i + 1;
                permutation(N, depth + 1);
                isVisited[i] = false;
            }
        }
    }
}