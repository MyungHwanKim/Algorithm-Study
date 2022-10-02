import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());  // 서로 다은 양의 정수의 개수

        int[] nums = new int[n];  // 수열
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(nums);  // 투 포인터를 하기 전 정렬
        int x = Integer.parseInt(br.readLine());  // 두 수의 합의 일치 값

        int start = 0;  // 시작 인덳스
        int end = n - 1;  // 끝 인덱스
        int count = 0;  // 일치 개수
        while (start < end) {  // start 인덱스가 end 인덱스보다 클 경우 종료
            // 두 수의 합이 일치하는 경우
            if (nums[start] + nums[end] == x) {
                count++;
            }

            // 두 수의 합이 일치하거나 클 경우
            if (nums[start] + nums[end] <= x) {
                start++;
            } else {
                end--;
            }
        }
        System.out.println(count);
    }
}