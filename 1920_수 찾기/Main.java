import java.util.*;
import java.io.*;

public class Main {
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());  // 정수의 개수
        arr = new int[N];
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        // 이분 탐색을 위한 정렬
        Arrays.sort(arr);

        int M = Integer.parseInt(br.readLine());  // 존재 여부를 파악할 정수의 개수
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < M; i++) {
            // 이분 탐색을 통해 존재하면 True, 아니면 False
            if (binarySearch(Integer.parseInt(st.nextToken()))) {
                sb.append(1).append("\n");
            } else {
                sb.append(0).append("\n");
            }
        }
        System.out.println(sb);
    }

    public static boolean binarySearch(int num) {
        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {
            // 큰 수 대비를 위한 방법
            int mid = left + (right - left) / 2;

            // arr 에 존재할 경우
            if (arr[mid] == num) {
                return true;
            }

            if (num > arr[mid]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        // while 문을 left > right 로 빠져나온 경우
        return false;
    }
}