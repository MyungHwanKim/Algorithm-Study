import java.util.*;
import java.io.*;

public class HashSetSol {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());  // 테스트케이스의 개수

        StringBuilder sb = new StringBuilder();  // 결과를 담을 StringBuilder
        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine());  // 수첩 1에 적어놓은 정수의 개수
            Set<Integer> note1 = new HashSet<>();  // 수첩 1에 정수를 담을 set

            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                note1.add(Integer.parseInt(st.nextToken()));
            }

            int M = Integer.parseInt(br.readLine());  // 수첩 2에 적어놓은 정수의 개수

            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                // 수첩 2에 적혀있는 정수가 수첩 1에 포함된 경우 sb에 1, 아니면 0
                sb.append(note1.contains(Integer.parseInt(st.nextToken())) ? 1 : 0).append("\n");
            }
        }
        System.out.println(sb);
    }
}