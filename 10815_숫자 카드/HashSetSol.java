import java.util.*;
import java.io.*;

public class HashSetSol {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();  // 결과를 담을 StringBuilder
        int N = Integer.parseInt(br.readLine());  // 숫자 카드의 개수
        Set<Integer> set = new HashSet<>();  // 숫자들을 담을 HashSet

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            set.add(Integer.parseInt(st.nextToken()));
        }

        int M = Integer.parseInt(br.readLine());  // 비교해야할 숫자 카드의 개수

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            int num = Integer.parseInt(st.nextToken());
            // set 에 num이 존재할 경우
            if (set.contains(num)) {
                sb.append(1).append(" ");
            } else {
                sb.append(0).append(" ");
            }
        }
        System.out.println(sb);
    }
}