import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());  // 정수의 개수
        // 1000보다 작거나 작은 정수이기에 1000 + 1001만큼의 boolean 배열
        boolean[] arr = new boolean[2001];
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            // 받은 숫자를 인덱스를하여 false 부분을 true로 변경
            arr[Integer.parseInt(st.nextToken()) + 1000] = true;
        }

        for (int i = 0; i < 2001; i++) {
            // 배열 중 true인 부분만 sb에 추가
            if (arr[i]) {
                sb.append(i - 1000).append(" ");
            }
        }
        System.out.println(sb);
    }
}