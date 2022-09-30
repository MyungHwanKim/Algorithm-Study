import java.util.*;
import java.io.*;

public class BinarySearchSol {
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();  // 결과를 담을 StringBuilder
        int N = Integer.parseInt(br.readLine());  // 숫자 카드의 개수
        arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);  // 이분 탐색을 위한 정렬

        int M = Integer.parseInt(br.readLine());  // 비교해야할 숫자 카드의 개수

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            int num = Integer.parseInt(st.nextToken());
            // 이분 탐색 후 나온 결과값을 sb에 삽입
            sb.append(binarySearch(num)).append(" ");
        }
        System.out.println(sb);
    }

    public static int binarySearch(int num) {

        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            // arr 에 num 이 존재한다면 return 1
            if (arr[mid] == num) {
                return 1;
            } else if (arr[mid] < num) {
                left = mid + 1;
            } else if (arr[mid] > num){
                right = mid - 1;
            }
        }
        // while 문을 탐색했지만, arr 에 존재하지 않을 경우
        return 0;
    }
}