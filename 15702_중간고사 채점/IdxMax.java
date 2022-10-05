import java.io.*;
import java.util.*;

public class IdxMax {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());  // 문제의 개수
        int M = Integer.parseInt(st.nextToken());  // 응시자의 수

        int[] scores = new int[N];  // 문제의 배점을 담을 배열
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            scores[i] = Integer.parseInt(st.nextToken());
        }

        int idx = 0;  // 학생의 수험 번호(가장 높은 점수)
        int max = -1;  // 가장 높은 점수
        for (int i = 0; i < M; i++) {
            String[] grade = br.readLine().split(" ");
            int sum = 0;  // 점수
            for (int j = 1; j < grade.length; j++) {
                // 맞췄을 경우
                if (grade[j].equals("O")) {
                    sum += scores[j - 1];
                }
            }
            // 점수가 이전 최고점보다 클 경우
            if (max < sum) {
                max = sum;
                idx = Integer.parseInt(grade[0]);
            } else if (max == sum) {  // 최고점과 같을 경우
                idx = Math.min(idx, Integer.parseInt(grade[0]));
            }
        }
        // 결과
        System.out.println(idx + " " + max);
    }
}