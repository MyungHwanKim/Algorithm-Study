import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());  // 전체 사람 수
        int[][] info = new int[N][2];  // 사람들의 몸무게와 키를 담을 배열

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            info[i][0] = Integer.parseInt(st.nextToken());  // 몸무게
            info[i][1] = Integer.parseInt(st.nextToken());  // 키
        }

        StringBuilder sb = new StringBuilder();  // 결과를 담을 StringBuilder
        for (int[] info1 : info) {
            int count = 0;  // info1 보다 info2 덩치가 큰 사람의 수
            for (int[] info2 : info) {
                if (info1[0] < info2[0] && info1[1] < info2[1]) {
                    count++;
                }
            }
            // 등수는 1부터 시작하므로 + 1을 해준다.
            sb.append(count + 1).append(" ");
        }

        // 결과
        System.out.println(sb);
    }
}