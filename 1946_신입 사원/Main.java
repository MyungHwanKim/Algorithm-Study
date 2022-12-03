import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());  // 테스트 케이스 개수

        StringBuilder sb = new StringBuilder();  // 결과를 담을 StringBuilder
        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine());  // 지원자의 숫자
            int[] grades = new int[N + 1];  // 서류 등수를 인덱스로 한 면접 등수를 담을 배열
            for (int j = 0; j < N; j++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int docRank = Integer.parseInt(st.nextToken());  // 서류 등수
                grades[docRank] = Integer.parseInt(st.nextToken());  // 면접 등수
            }

            int count = 1;  // 서류 등수 1등은 무조건 선발
            int interviewRank = grades[1];  // 서류 등수 1등의 면접 등수
            for (int j = 1; j < N + 1; j++) {
                // 이전의 최소 면접 등수가 현재 비교할 사원의 면접 등수보다 클 경우
                // 현재 비교 대상 사원은 선발되며
                // 이전의 최소 면접 등수를 현재 비교 대상 사원의 면접 등수로 업데이트
                if (interviewRank > grades[j]) {
                    count++;
                    interviewRank = grades[j];
                }
            }

            sb.append(count).append("\n");
        }

        // 결과
        System.out.println(sb);
    }
}