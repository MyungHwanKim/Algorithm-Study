import java.io.*;
import java.util.*;

public class Main {
    static int[] num;
    static int[] operation = new int[4];  // {+, -, *, /} 연산자의 개수를 담을 배열
    static int min = Integer.MAX_VALUE;  // 최솟값을 구하기 위해 최댓값으로 설정
    static int max = Integer.MIN_VALUE;  // 최댓값을 구하기 위해 최솟값으로 설정
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());  // 수의 개수
        num = new int[N];  // 수를 담을 배열

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            num[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            operation[i] = Integer.parseInt(st.nextToken());
        }

        // 연산자의 개수는 수의 개수보다 1개 적고
        // 기본적으로 num 의 0번째 인덱스가 입력되어 시작하므로
        // depth 를 1부터 시작하여 N == depth 를 맞춘다.
        calculation(num[0], N , 1);
        sb.append(max).append("\n").append(min);
        // 결과
        System.out.println(sb.toString());
    }

    public static void calculation(int sum, int N, int depth) {
        // 기본 depth 를 1로 시작했기 때문에
        // N(수의 개수)와 depth(연산자의 개수 + 1)이 일치할 경우
        if (N == depth) {
            min = Math.min(min, sum);
            max = Math.max(max, sum);
            return;
        }

        for (int i = 0; i < 4; i++) {
            // 연산자 개수가 남아있을 경우
            if (operation[i] > 0) {
                operation[i]--;
                switch (i) {
                    // 연산자 + 일 경우
                    case 0:
                        calculation(sum + num[depth], N, depth + 1);
                        break;
                    // 연산자 - 일 경우
                    case 1:
                        calculation(sum - num[depth], N, depth + 1);
                        break;
                    // 연산자 * 일 경우
                    case 2:
                        calculation(sum * num[depth], N, depth + 1);
                        break;
                    // 연산자 / 일 경우
                    case 3:
                        calculation(sum / num[depth], N, depth + 1);
                        break;
                }
                operation[i]++;
            }
        }
    }
}