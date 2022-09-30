import java.util.*;
import java.io.*;

public class BooleanSol {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();  // 결과를 담을 StringBuilder
        int N = Integer.parseInt(br.readLine());  // 숫자 카드의 개수
        boolean[] nums = new boolean[20000000];  // 범위가 -10000000 ~ 10000000 이므로
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            // 들어온 숫자에 + 10000000 대한 인덱스를 true 로 변경
            nums[Integer.parseInt(st.nextToken()) + 10000000] = true;
        }

        int M = Integer.parseInt(br.readLine());  // 비교해야할 숫자 카드의 개수

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            int num = Integer.parseInt(st.nextToken());
            // 비교해야할 숫자에 + 10000000 의 인텍스가 true 일 경우
            if (nums[num + 10000000]) {
                sb.append(1).append(" ");
            } else {
                sb.append(0).append(" ");
            }
        }
        System.out.println(sb);
    }
}