import java.io.*;
import java.util.*;

public class DFS {
    static List<ArrayList<Integer>> graph;  // 양방향 그래프
    static boolean[] isVisited;  // 방문 여부 확인
    static int cnt = -1;  // 촌수 결과
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());  // 사람의 수
        graph = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());  // 출발 사람의 번호
        int end = Integer.parseInt(st.nextToken());  // 도착 사람의 번호

        int m = Integer.parseInt(br.readLine());  // 부모 자식 관계의 개수
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());  // 부모 번호
            int y = Integer.parseInt(st.nextToken());  // 자식 번호
            // 양방향으로 추가
            graph.get(x).add(y);
            graph.get(y).add(x);
        }

        isVisited = new boolean[N + 1];
        // dfs 방문 확인
        dfs(start, end, 0);
        System.out.println(cnt);
    }

    public static void dfs(int start, int end, int count) {
        isVisited[start] = true;

        for (int idx : graph.get(start)) {
            // 방문하지 않았을 경우
            if (!isVisited[idx]) {
                // 도착지점 번호의 사람과 같을 경우
                if (idx == end) {
                    cnt = count + 1;
                    return;
                }
                // 다음 촌수
                dfs(idx, end, count + 1);
            }
        }
    }
}