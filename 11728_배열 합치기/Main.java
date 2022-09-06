import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());  // 배열 A의 크기
        int M = Integer.parseInt(st.nextToken());  // 배열 B의 크기
        int[] A = new int[N];
        int[] B = new int[M];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            B[i] = Integer.parseInt(st.nextToken());
        }

        StringBuilder sb = new StringBuilder();
        int p1 = 0;  // A 배열의 인덱스
        int p2 = 0;  // B 배열의 인덱스
        while (true) {
            // B배열 값들은 모두 추가 후 A배열의 남은 값들을 추가
            while (p1 != A.length && p2 == B.length) {
                sb.append(A[p1++]).append(" ");
            }

            // A배열 값들은 모두 추가 후 B배열의 남은 값들을 추가
            while (p1 == A.length && p2 != B.length) {
                sb.append(B[p2++]).append(" ");
            }

            // A 배열과 B 배열 값들을 모두 추가했을 경우
            if (p1 == A.length && p2 == B.length) {
                break;
            }

            // A[p1]보다 B[p2] 더 큰 경우
            if (A[p1] < B[p2]) {
                sb.append(A[p1++]).append(" ");
            } else {
                sb.append(B[p2++]).append(" ");
            }
        }
        System.out.println(sb);
    }
}