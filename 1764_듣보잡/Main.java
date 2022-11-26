import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());  // 듣도 못한 사람의 수
        int M = Integer.parseInt(st.nextToken());  // 보도 못한 사람의 수

        Set<String> nameList = new HashSet<>();  // 듣도 못한 사람을 담을 Set
        for (int i = 0; i < N; i++) {
            nameList.add(br.readLine());
        }

        List<String> list = new ArrayList<>();  // 듣보잡의 사람을 담을 List
        for (int i = 0; i < M; i++) {
            String s = br.readLine();
            // 듣도 못한 사람 목록 중 보도 못한 사람이 존재할 경우
            if (nameList.contains(s)) {
                list.add(s);
            }
        }
        // 사전순으로 정렬
        Collections.sort(list);

        StringBuilder sb = new StringBuilder();  // 결과를 담을 StringBuilder
        sb.append(list.size()).append("\n");  // 듣보잡의 수 추가
        // 듣보잡 List 가 비어질 때까지
        // list 의 0번째 값 제거와 동시에 추가
        while (!list.isEmpty()) {
            sb.append(list.remove(0)).append("\n");
        }

        // 결과
        System.out.println(sb);
    }
}