import java.io.*;
import java.util.*;

class Node {
    int to;  // 이동 통로
    int cowCount;  // 소의 수

    public Node(int to, int cowCount) {
        this.to = to;
        this.cowCount = cowCount;
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());  // 헛간의 개수
        int M = Integer.parseInt(st.nextToken());  // 소들의 길 수

        int[][] data = new int[M][3];  // 길에 대한 정보
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                data[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 현서는 헛간 1에 있으므로 start 는 1
        System.out.println(dijkstra(N, data, 1));
    }

    public static int dijkstra(int N, int[][] data, int start) {
        List<ArrayList<Node>> graph = new ArrayList<>();
        for (int i = 0; i < N + 1; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] item : data) {
            // 소들의 길이 양방향 길이 그려져 있으므로
            // from -> to, to -> from 둘 다 연결해준다.
            graph.get(item[0]).add(new Node(item[1], item[2]));
            graph.get(item[1]).add(new Node(item[0], item[2]));
        }

        int[] cost = new int[N + 1];  // 최소 여물 비용을 담을 dp
        for (int i = 0; i < N + 1; i++) {
            cost[i] = Integer.MAX_VALUE;
        }
        cost[start] = 0;  // 현서 헛간에 있을 때 비용은 0

        PriorityQueue<Node> pq = new PriorityQueue<>((x, y) -> x.cowCount - y.cowCount);
        pq.offer(new Node(start, 0));

        while (!pq.isEmpty()) {
            Node curNode = pq.poll();

            // 현재 이동한 헛간의 비용보다 현재 위치의 소의 수가 더 많은 경우 continue 처리
            if (cost[curNode.to] < curNode.cowCount) {
                continue;
            }

            for (int i = 0; i < graph.get(curNode.to).size(); i++) {
                Node adjNode = graph.get(curNode.to).get(i);
                // 기존 비용보다 현재 헛간에서 해당 헛간으로 가는 비용이 더 작으면 업데이트
                // 그리고 해당 헛간의 정보를 pq에 넣어준다.
                if (cost[adjNode.to] > curNode.cowCount + adjNode.cowCount) {
                    cost[adjNode.to] = curNode.cowCount + adjNode.cowCount;
                    pq.offer(new Node(adjNode.to, cost[adjNode.to]));
                }
            }
        }

        // 찬홍이(N)에게 도착할 때까지의 최소 여물
        return cost[N];
    }
}