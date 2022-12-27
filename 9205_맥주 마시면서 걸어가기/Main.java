import java.util.*;
import java.io.*;

// 좌표
class Point {
    int x;
    int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Main {
    static List<ArrayList<Integer>> board;
    static Point[] points;  // 상근이네 집, 편의점, 펜타포르 락 페스티벌 좌표를 담을 배열
    static boolean[] visit;  // 방문 확인
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());  // 테스트 케이스의 개수

        StringBuilder sb = new StringBuilder();  // 결과를 담을 StringBuilder
        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());  // 편의점의 개수

            points = new Point[n + 2];  // 편의점의 개수 + 상근이의 집 + 페스티벌
            visit = new boolean[n + 2];
            for (int j = 0; j < n + 2; j++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                points[j] = new Point(x, y);
            }

            board = new ArrayList<>();
            for (int j = 0; j < n + 2; j++) {
                board.add(new ArrayList<>());
            }

            for (int j = 0; j < n + 1; j++) {
                for (int k = j + 1; k < n + 2; k++) {
                    // 최대 1000미터 이동 가능하므로 맨해튼 거리 공식으로
                    // diff 를 구하여 1000미터 이내에 있는 정보에 대해서만
                    // board 에 양방향 연결
                    int diff = Math.abs(points[j].x - points[k].x) + Math.abs(points[j].y - points[k].y);
                    if (diff <= 1000) {
                        board.get(j).add(k);
                        board.get(k).add(j);
                    }
                }
            }
            // 상근이네 집 정보는 항상 0번 인덱스에 존재하므로
            // 시작은 항상 0
            sb.append(bfs(0)).append("\n");
        }

        // 결과
        System.out.println(sb);
    }

    public static String bfs(int start) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        visit[start] = true;

        while (!queue.isEmpty()) {
            int cur = queue.poll();

            // points 마지막 정보에 페스티벌 정보이므로
            // cur 이 마지막 위치 인덱스까지 올 수 있다면
            // 페스티벌에 도착할 수 있다는 의미로 "happy" 반환
            if (cur == points.length - 1) {
                return "happy";
            }

            for (int item : board.get(cur)) {
                // 아직 방문하지 않은 정보일 경우
                if (!visit[item]) {
                    visit[item] = true;
                    queue.offer(item);
                }
            }
        }

        // while 문이 종료되었다면
        // 페스티벌에 도착할 수 없다는 의미이므로
        // "sad" 반환
        return "sad";
    }
}