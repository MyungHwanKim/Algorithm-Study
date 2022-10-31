import java.io.*;
import java.util.*;

class Traffic {
    int to; // 지름길 도착 위치
    int minDist;  // 지름길의 길이

    public Traffic(int to, int minDist) {
        this.to = to;
        this.minDist = minDist;
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());  // 지름길 개수
        int D = Integer.parseInt(st.nextToken());  // 고속도로의 길이

        int[][] data = new int[N][3];  // (시작 위치, 도착 위치, 길이) 정보를 담을 배열
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                data[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        System.out.println(dijkstra(D, data, 0));
    }

    public static int dijkstra(int D, int[][] data, int start) {
        List<ArrayList<Traffic>> graph = new ArrayList<>();
        // 도착 위치의 정보가 실제 도착해야하는 위치보다 클 수 있으므로
        // 최대 범위 내인 10000보다 작거나 음이 아닌 정수로 표현
        for (int i = 0; i < 10001; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] item : data) {
            graph.get(item[0]).add(new Traffic(item[1], item[2]));
        }

        int[] dist = new int[10001];
        for (int i = 0; i < 10001; i++) {
            dist[i] = Integer.MAX_VALUE;
        }
        dist[start] = 0;

        for (int i = 0; i < D; i++) {
            // 일반통행이므로 적어도 직전 위치보다 거리 1씩 증가한다.
            if (dist[i + 1] > dist[i] + 1) {
                dist[i + 1] = dist[i] + 1;
            }

            for (int j = 0; j < graph.get(i).size(); j++) {
                Traffic adjTraffic = graph.get(i).get(j);

                // 지름길을 통한 도착 위치가 최종 도착 위치보다 크면 continue
                if (adjTraffic.to > D) {
                    continue;
                }

                // 기존 거리보다 지름길을 통한 현재 위치까지의 거리가 더 작으면 업데이트
                if (dist[adjTraffic.to] > dist[i] + adjTraffic.minDist) {
                    dist[adjTraffic.to] = dist[i] + adjTraffic.minDist;
                }
            }
        }

        // 최종 도착 지점까지의 최소 거리
        return dist[D];
    }
}