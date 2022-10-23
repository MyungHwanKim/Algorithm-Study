import java.io.*;
import java.util.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());  // 학생 수
        int[][] scores = new int[N][5];  // 학생 번호, 국어, 영어, 수학, 과학 점수 넣을 배열

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++) {
                scores[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        StringBuilder sb = new StringBuilder();
        boolean[] isCheck = new boolean[N + 1];  // 상을 받은지 체크할 배열
        for (int i = 1; i < 5; i++) {
            int max = Integer.MIN_VALUE;  // 과목별 최고점
            int idx = -1;  // 과목별 최고점 받은 학생 번호
            for (int[] score : scores) {
                // 현재 최고점보다 더 높고 상을 받지 않았을 경우
                if (max < score[i] && !isCheck[score[0]]) {
                    max = score[i];
                    idx = score[0];
                    // 현재 최고점과 같고 상을 받지 않았을 경우
                    // 학생 번호가 더 낮은 학생부터 상을 수여
                } else if (max == score[i] && !isCheck[score[0]]) {
                    idx = Math.min(idx, score[0]);
                }
            }
            isCheck[idx] = true;  // 상 받은 학생 체크
            sb.append(idx).append(" ");
        }

        // 결과
        System.out.println(sb);
    }
}