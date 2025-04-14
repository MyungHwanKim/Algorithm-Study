import java.util.*;
import java.io.*;
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    static List<List<Integer>> graph = new ArrayList<>();
    static boolean[] visited;  // 방문 여부

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());  // 동기 수
        int m = Integer.parseInt(br.readLine());  // 리스트의 길이

        visited = new boolean[n + 1];

        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        // 친구 관계 등록
        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        System.out.println(bfs(1));
    }

    public static int bfs(int start) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{start, 0});
        visited[start] = true;
        int count = 0; // 동기 수

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int person = cur[0]; // 사람 번호
            int depth = cur[1];  // 친구 관계

            // 친구거나 친구의 친구
            if (depth >= 1 && depth <= 2) {
                count++;
            }

            // 친구의 친구에서 멈추기
            if (depth == 2) {
                continue;
            }

            for (int nextPerson : graph.get(person)) {
                // 아직 확인하지 않은 친구일 경우
                if (!visited[nextPerson]) {
                    queue.offer(new int[]{nextPerson, depth + 1});
                    visited[nextPerson] = true;
                }
            }
        }
        return count;
    }
}