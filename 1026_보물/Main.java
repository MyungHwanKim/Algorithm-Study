import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());  // 배열의 길이

        int[] A = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(A);  // 함수 S 를 위한 정렬
        int[] B = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            B[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(B);  // 함수 S 를 위한 정렬

        int S = 0;  // 함수 S의 최솟값
        for (int i = A.length - 1; i >= 0; i--) {
            // A 와 B 배열의 길이가 같으므로
            // A[배열의 시작 인덱스]과 B[배열의 마지막 인덱스]부터
            // A의 인덱스는 늘리고 B의 인덱스는 줄인다.
            S += (A[i] * B[A.length - 1 - i]);
        }
        // 결과
        System.out.println(S);
    }
}