import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());  // 정수의 개수
        int M = Integer.parseInt(st.nextToken());  // 두 정수의 최소 차이 이상의 값

        int[] nums = new int[N];  // 수를 넣을 배열
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(br.readLine());
        }
        // 오름차순 정렬
        Arrays.sort(nums);

        int p1 = 0;
        int p2 = 0;

        int min = Integer.MAX_VALUE;  // 차이의 최소값
        // 첫번째 인덱스값이 정수의 개수보다 적을 경우
        while (p1 < N) {
            // 두 수의 차이가 M보다 작을 경우
            // p1 인덱스 값을 늘려준다.
            if (nums[p1] - nums[p2] < M) {
                p1++;
                continue;
            }

            // 두 수의 차이가 M과 일치할 경우
            // 구할 수 있는 최적의 최소값이므로
            // 업데이트 후 종료
            if (nums[p1] - nums[p2] == M) {
                min = M;
                break;
            }

            // M과 일치하지 않을 경우
            // 현재 최소값과 현재 두 수의 차 중 더 최소로 업데이트
            min = Math.min(min, nums[p1] - nums[p2]);
            p2++;
        }

        // 결과
        System.out.println(min);
    }
}