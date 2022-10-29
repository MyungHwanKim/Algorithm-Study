import java.util.*;
import java.io.*;

class Node {
    int to;  // 도착 도시 번호
    int cost;  // 비용

    public Node(int to, int cost) {
        this.to = to;
        this.cost = cost;
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());  // 도시의 개수
        int M = Integer.parseInt(br.readLine());  // 버스의 개수

        int[][] data = new int[M][3];  // (출발 도시 번호, 도착 도시 번호, 버스 비용)을 담을 배열
        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                data[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());  // 출발 도시
        int end = Integer.parseInt(st.nextToken());  // 도착 도시
        System.out.println(dijkstra(N, data, start, end));
    }

    public static int dijkstra(int N, int[][] data, int start, int end) {
        List<ArrayList<Node>> graph = new ArrayList<>();
        for (int i = 0; i < N + 1; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] item : data) {
            graph.get(item[0]).add(new Node(item[1], item[2]));
        }

        int[] dist = new int[N + 1];  // 최단 거리를 담을 dp
        for (int i = 0; i < N + 1; i++) {
            dist[i] = Integer.MAX_VALUE;
        }
        dist[start] = 0;

        boolean[] visit = new boolean[N + 1];  // 방문 파악을 위한 배열

        for (int i = 0; i < N; i++) {
            int minDist = Integer.MAX_VALUE;
            int curIdx = 0;
            for (int j = 1; j < N + 1; j++) {
                // 방문한 적이 없는 노드 중에서 최소 거리인 노드를 선택
                if (!visit[j] && dist[j] < minDist) {
                    minDist = dist[j];
                    curIdx = j;
                }
            }

            visit[curIdx] = true;

            // 선택한 노드의 거리 갱신
            for (int j = 0; j < graph.get(curIdx).size(); j++) {
                Node adjNode = graph.get(curIdx).get(j);

                // 기존의 최소 거리보다 현재 노드에서 해당 노드까지 가는 거리가 더 작을 경우
                if (dist[adjNode.to] > dist[curIdx] + adjNode.cost) {
                    dist[adjNode.to] = dist[curIdx] + adjNode.cost;
                }
            }
        }

        // 결과
        return dist[end];
    }
}