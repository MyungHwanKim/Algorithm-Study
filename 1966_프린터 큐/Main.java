import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());  // 테스트케이스의 수

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());  // 문서의 개수
            // 몇 번째로 인쇄되었는지 궁금한 문서의 인덱스 나타내는 정수
            int M = Integer.parseInt(st.nextToken());
            int[] documents = new int[N];  // 문서를 담을 배열

            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                documents[j] = Integer.parseInt(st.nextToken());
            }
            sb.append(print(N, documents, M)).append("\n");
        }
        // 결과
        System.out.println(sb);
    }

    public static int print(int N, int[] documents, int M) {
        Queue<int[]> queue = new LinkedList<>();
        // [대기번호, 중요도]의 배열로 queue 에 담는다.
        for (int j = 0; j < N; j++) {
            queue.offer(new int[]{j, documents[j]});
        }
        Arrays.sort(documents);  // 우선순위가 큰 순서로 파악하기 위한 정렬

        int idx = N - 1;  // 오름차순으로 정렬했기에 맨 뒤부터 프린트되어야 한다.
        int num = 0;  // 인쇄 처리 개수
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();  // 현재 문서

            // 현재 문서의 우선순위가 처리해야할 문서의 우선순위보다 작을 경우
            // 다시 queue 에 담아준다.
            if (cur[1] < documents[idx]) {
                queue.offer(cur);
                // 현재 문서의 우선순위와 처리해야할 문서의 우선순위와 같을 경우
                // 인쇄 처리 개수 증가, 처리해야할 인덱스를 하나 줄여준다.
            } else if (cur[1] == documents[idx]){
                num++;
                idx--;

                // 현재 문서 번호와 궁금했던 문서의 번호와 일치할 경우
                // break 걸어준다.
                if (cur[0] == M) {
                    break;
                }
            }
        }

        // 궁금했던 문서의 처리 순서 결과
        return num;
    }
}