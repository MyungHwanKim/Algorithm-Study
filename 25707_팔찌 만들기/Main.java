import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());  // 구슬의 개수
        int[] marble = new int[N];  // 구슬을 담을 배열

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            marble[i] = Integer.parseInt(st.nextToken());
        }
        // 구슬의 적힌 수들의 차를 최소화하기 위한 정렬
        Arrays.sort(marble);

        int minLen = 0;  // 최소 길이
        for (int i = marble.length - 1; i > 0; i--) {
            minLen += marble[i] - marble[i - 1];
        }
        minLen += marble[marble.length - 1] - marble[0];
        // 결과
        System.out.println(minLen);
    }
}