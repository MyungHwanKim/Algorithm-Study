import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());  // 재료의 개수
        int M = Integer.parseInt(br.readLine());  // 갑옷을 만드는데 필요한 수

        int[] nums = new int[N];  // 재료들의 고유한 번호를 넣을 배열
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(nums);  // 두 개의 재료로 갑옷을 만들기 위한 정렬

        int p1 = 0;  // 시작 인덱스
        int p2 = N - 1;  // 끝 인덱스

        int count = 0;  // 갑옷의 개수
        while (p1 < p2) {
            // 두 개의 재료의 합이 갑옷을 만드는데 필요한 수와 일치할 경우
            if (nums[p1] + nums[p2] == M) {
                count++;
                p1++;
                p2--;
                // 두 개의 재료 합이 갑옷을 만드는데 필요한 수보다 작을 경우
            } else if (nums[p1] + nums[p2] < M) {
                p1++;
            } else {
                p2--;
            }
        }
        // 결과
        System.out.println(count);
    }
}