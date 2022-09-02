import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());  // 수의 개수
        int K = Integer.parseInt(st.nextToken());  // 뽑을 번째의 수
        int[] arr = new int[N];  // 수의 배열

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // 정렬
        Arrays.sort(arr);
        // 배열은 인덱스가 0부터 시작하여 K번째는 K-1번째 인덱스로 적용
        System.out.println(arr[K - 1]);
    }
}