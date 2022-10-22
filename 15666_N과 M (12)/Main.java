import java.io.*;
import java.util.*;

public class Main {
    static int[] arr;
    static boolean[] isCheck;
    static int[] out;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());  // 자연수 개수
        int M = Integer.parseInt(st.nextToken());  // 수열의 길이

        arr = new int[N];  // N 개의 자연수 배열
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        isCheck = new boolean[N];  // 방문 파악
        out = new int[M];  // M 길이 배열
        // 사전 순으로 증가해야하므로 정렬
        Arrays.sort(arr);
        permutation(N, M, 0);
        // 결과
        System.out.println(sb.toString());
    }

    public static void permutation(int N, int M, int depth) {
        // 수열의 길이와 depth 가 일치할 경우
        if (M == depth) {
            for (int o : out) {
                sb.append(o).append(" ");
            }
            sb.append("\n");
            return;
        }

        int before = 0;  // 이전에 뽑은 값
        for (int i = 0; i < N; i++) {
            // 아직 방문하지 않은 값이면서 이전에 뽑은 값과 현재 값이 같지 않을 경우
            if (!isCheck[i] && before != arr[i]) {
                // isVisited 를 true 로 만들면서 중복 수열 제거
                for (int j = 0; j < i; j++) {
                    isCheck[j] = true;
                }
                before = arr[i];  // 이전 값 저장
                out[depth] = arr[i];  // 출력 값 저장
                permutation(N, M, depth + 1);
                for (int j = 0; j < i; j++) {
                    isCheck[j] = false;
                }
            }
        }
    }
}