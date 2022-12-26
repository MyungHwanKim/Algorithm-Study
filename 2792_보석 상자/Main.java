import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());  // 아이들의 수
        int M = Integer.parseInt(st.nextToken());  // 색상의 수

        int min = 1;  // 최소 보석의 수
        int max = 1_000_000_000;  // 최대 보석의 수
        int[] nums = new int[M];  // 색상별 보석의 개수를 담을 배열
        for (int i = 0; i < M; i++) {
            nums[i] = Integer.parseInt(br.readLine());
        }

        // 최소 보석의 개수가 최대 보석의 개수보다 커질 경우 종료
        while (min <= max) {
            int mid = min + (max - min) / 2;

            int count = 0;  // 보석을 받은 아이들 수
            for (int num : nums) {
                // mid 로 색상별 나누어줄 수 있는 학생 수를 count 에 추가
                // 나머지가 존재한다면 1명 더 받을 수 있으니 + 1
                count += num % mid == 0 ? num / mid : num / mid + 1;
            }

            // 실제 받아야할 아이들 수가 보석을 받은 학생 수보다 같거나 클 경우
            // max 값 업데이트
            if (count <= N) {
                max = mid - 1;
            } else {
                min = mid + 1;
            }
        }

        // 결과(질투심의 최솟값)
        System.out.println(min);
    }
}