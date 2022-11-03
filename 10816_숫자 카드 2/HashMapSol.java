import java.util.*;
import java.io.*;

public class HashMapSol {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());  // 상근이가 가지고 있는 숫자 카드의 개수
        Map<Integer, Integer> map = new HashMap<>();  // (숫자 카드, 개수)를 담을 hashmap

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(st.nextToken());
            // 이미 가지고 있는 숫자 카드일 경우 1씩 추가
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        int M = Integer.parseInt(br.readLine());  // 적혀 있는 숫자 카드의 개수
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            int num = Integer.parseInt(st.nextToken());
            // 개수를 파악해야할 숫자 카드가 map 의 key 로 존재한다면
            // sb 에 value 값 추가
            if (map.containsKey(num)) {
                sb.append(map.get(num)).append(" ");
            } else {
                sb.append(0).append(" ");
            }
        }

        // 결과
        System.out.println(sb);
    }
}