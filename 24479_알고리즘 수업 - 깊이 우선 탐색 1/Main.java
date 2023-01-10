import java.util.*;
import java.io.*;

public class Main {
    static ArrayList<Integer>[] edges;
    static int[] orders;
    static boolean[] visit;
    static int val = 1;  // 순서
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());  // 정점의 수
        int M = Integer.parseInt(st.nextToken());  // 간선의 수
        int R = Integer.parseInt(st.nextToken());  // 시작 정점

        edges = new ArrayList[N + 1];  // 그래프 구성
        for (int i = 1; i < N + 1; i++) {
            edges[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            // 양방향 간선이므로 양쪽으로 연결한다.
            edges[u].add(v);
            edges[v].add(u);
        }

        for (int i = 1; i < N + 1; i++) {
            // 인접 정점은 오름차순으로 방문하니 정렬한다.
            Collections.sort(edges[i]);
        }

        visit = new boolean[N + 1];  // 방문 확인
        orders = new int[N + 1];  // 순서 정보를 담을 배열
        dfs(R);

        // 결과를 담을 StringBuilder
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < N + 1; i++) {
            sb.append(orders[i]).append("\n");
        }

        // 결과
        System.out.println(sb);
    }

    public static void dfs(int start) {
        visit[start] = true;
        orders[start] = val++;  // 해당 정점의 순서값 추가

        for (int i = 0; i < edges[start].size(); i++) {
            int temp = edges[start].get(i);

            // 아직 방문하지 않은 정점일 경우
            if (!visit[temp]) {
                dfs(temp);
            }
        }
    }
}