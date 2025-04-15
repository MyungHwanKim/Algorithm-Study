import java.util.*;
import java.io.*;

public class DFS {
    static List<List<Integer>> graph = new ArrayList<>();
    static boolean[] visited;
    static int[] result;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        result = new int[N + 1];

        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());  // 컴퓨터 번호
            int b = Integer.parseInt(st.nextToken());  // 컴퓨터 번호
            // b 를 해킹하면 a도 해킹 가능하므로 a 가 b를 신뢰하는 방향으로 처리
            graph.get(a).add(b);
        }

        for (int i = 1; i <= N; i++) {
            visited = new boolean[N + 1];
            dfs(i);
        }

        // 가장 많이 해킹한 값
        int max = Arrays.stream(result).max().getAsInt();
        for (int i = 1; i <= N; i++) {
            // 가장 많이 해킹한 값일 경우 출력
            if (result[i] == max) {
                System.out.print(i + " ");
            }
        }
    }

    public static void dfs(int start) {
        visited[start] = true;

        for (int next : graph.get(start)) {
            if (!visited[next]) {
                result[next]++;
                dfs(next);
            }
        }
    }
}