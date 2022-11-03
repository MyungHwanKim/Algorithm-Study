import java.util.*;
import java.io.*;

public class CountingSol {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());  // 상근이가 가지고 있는 숫자 카드의 개수

        int[] nums = new int[20000001];  // (숫자 카드 인덱스, 개수)를 담을 배열 (최소 -10000000 ~ 10000000 이므로 20000001)
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            // 상근이가 가지고 있는 번호와 인덱스가 일치하는 값에 value 를 1씩 증가
            nums[Integer.parseInt(st.nextToken()) + 10000000]++;
        }

        int M = Integer.parseInt(br.readLine());  // 찾으려고 하는 숫자 카드의 개수
        st = new StringTokenizer(br.readLine());

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            // 찾으려고 하는 숫자 카드 번호 인덱스의 value 값을 sb 에 추가
            sb.append(nums[Integer.parseInt(st.nextToken()) + 10000000]).append(" ");
        }

        // 결과
        System.out.println(sb);
    }
}