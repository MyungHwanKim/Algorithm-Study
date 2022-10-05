import java.io.*;
import java.util.*;

public class Sort {
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

        int[][] grades = new int[M][2];  // 응시자의 성적표(수험 번호, 점수)
        for (int i = 0; i < M; i++) {
            String[] grade = br.readLine().split(" ");
            int sum = 0;  // 점수
            for (int j = 1; j < grade.length; j++) {
                // 맞췄을 경우
                if (grade[j].equals("O")) {
                    sum += scores[j - 1];
                }
            }
            grades[i][0] = Integer.parseInt(grade[0]);
            grades[i][1] = sum;
        }

        Arrays.sort(grades, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                // 점수가 같을 경우 수험 번호가 작은 순
                if (o1[1] == o2[1]) {
                    return o1[0] - o2[0];
                }
                // 점수가 높은 순
                return o2[1] - o1[1];
            }
        });
        // 결과
        System.out.println(grades[0][0] + " " + grades[0][1]);
    }
}