import java.util.*;
import java.io.*;

public class LinkedListSol {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());  // 인원 수
        int K = Integer.parseInt(st.nextToken());  // 제거할 순서의 번호

        LinkedList<Integer> list = new LinkedList<>();
        for (int i = 1; i <= N; i++) {
            list.add(i);
        }

        // 결과를 담은 StringBuilder
        StringBuilder sb = new StringBuilder();
        sb.append("<");
        int idx = 0;  // 제거할 위치를 담을 변수
        // list 의 개수가 1개 남을 때까지 진행
        while (N > 1) {
            // 인덱스는 K인 위치보다 하나 작게 입력
            // 그리고 인덱스는 N보다 클 수 없으므로 N으로 나눈 나머지로 진행
            // list 의 size 도 하나씩 작아지고 있으므로, N 도 하나씩 줄여준다.
            idx = (idx + K - 1) % N;
            sb.append(list.remove(idx)).append(", ");
            N--;
        }
        // 마지막 하나 남은 list 의 value 도 sb 에 넣어준다.
        sb.append(list.remove()).append(">");
        System.out.println(sb);
    }
}