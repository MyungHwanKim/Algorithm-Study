import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());  // 나무 수
        int M = Integer.parseInt(st.nextToken());  // 원하는 나무의 길이
        int[] trees = new int[N];  // 나무의 높이를 담을 배열
        st = new StringTokenizer(br.readLine());
        int max = 0;  // 최대 나무 길이
        for (int i = 0; i < N; i++) {
            trees[i] = Integer.parseInt(st.nextToken());
            max = Math.max(max, trees[i]);
        }

        // 결과
        System.out.println(maxHeight(trees, M, max));
    }

    public static int maxHeight(int[] trees, int M, int max) {
        int min = 0;  // 절단해야할 나무 길이

        while (min < max) {
            // 절단할 나무 길이의 위치
            int mid = min + (max - min) / 2;

            long sum = 0;  // 절단한 나무 길이의 합
            for (int tree : trees) {
                // 나무 길이가 자르는 위치(mid)보다 클 때
                // sum 에 더해준다.
                if (tree > mid) {
                    sum += (tree - mid);
                }
            }

            // 절단한 나무 길이의 합이 우리가 필요로 하는 나무 길이보다 작다는 것은
            // 자르는 위치가 높다는 의미로 자를 높이를 나추어야한다.
            // 그래서 최대 높이를 mid 로 설정한다.
            if (sum < M) {
                max = mid;
            } else {
                min = mid + 1;
            }
        }
        // 절단기에 설정할 수 있는 높이의 최댓값
        return min - 1;
    }
}