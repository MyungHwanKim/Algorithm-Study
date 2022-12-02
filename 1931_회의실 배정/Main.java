import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());  // 회의의 수

        int[][] tables = new int[N][2];  // 회의 정보를 담을 배열
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());  // 시작 시간
            int end = Integer.parseInt(st.nextToken());  // 끝나는 시간
            tables[i][0] = start;
            tables[i][1] = end;
        }

        Arrays.sort(tables, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                // 끝나는 시간이 같을 경우
                // 시작 시간이 낮은 순으로 정렬
                if (o1[1] == o2[1]) {
                    return o1[0] - o2[0];
                }
                return o1[1] - o2[1];
            }
        });

        int curTime = 0;  // 현재 시간
        int count = 0;  // 회의실 개수
        for (int[] table : tables) {
            // 현재 시간보다 회의실 정보의 시작시간이 더 적은 경우
            if (curTime <= table[0]) {
                curTime = table[1];
                count++;
            }
        }

        // 결과
        System.out.println(count);
    }
}