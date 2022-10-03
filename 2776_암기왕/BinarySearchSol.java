import java.util.*;
import java.io.*;

public class BinarySearchSol {
    static int N;
    static int[] note1;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());  // 테스트케이스의 개수

        StringBuilder sb = new StringBuilder();  // 결과를 담을 StringBuilder
        for (int i = 0; i < T; i++) {
            N = Integer.parseInt(br.readLine());  // 수첩 1에 적어놓은 정수의 개수
            note1 = new int[N];  // 수첩 1에 정수를 담을 배열

            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                note1[j] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(note1);  // 이분 탐색을 위한 정렬

            int M = Integer.parseInt(br.readLine());  // 수첩 2에 적어놓은 정수의 개수

            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                // binarySearch 를 통한 결과를 sb에 추가(1 or 0)
                sb.append(binarySearch(Integer.parseInt(st.nextToken()))).append("\n");
            }
        }
        System.out.println(sb);
    }

    public static int binarySearch(int num) {
        int left = 0;
        int right = N - 1;

        // left 가 right 보다 클 경우 종료
        while (left <= right) {
            int mid = left + (right - left) / 2;  // 정수의 개수가 클 경우를 대비

            if (note1[mid] == num) {
                return 1;
            } else if (note1[mid] > num) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        // while 문을 탈출할 경우
        return 0;
    }
}