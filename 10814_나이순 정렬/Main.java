import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 회원 수
        int N = Integer.parseInt(br.readLine());
        // 나이를 인덱스로 하여 최대 200보다 작거나 같은 정수이므로 크기를 201로 설정
        StringBuilder[] info = new StringBuilder[201];

        for (int i = 0; i < 201; i++) {
            // 같은 나이일 경우 이어 붙이기 위해 StringBuilder() 추가
            info[i] = new StringBuilder();
        }

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int age = Integer.parseInt(st.nextToken());
            String name = st.nextToken();
            // age 인덱스에 age 와 name 추가
            info[age].append(age).append(" ").append(name).append("\n");
        }

        StringBuilder sb = new StringBuilder();  // 결과를 담을 StringBuilder
        for (StringBuilder value : info) {
            sb.append(value);
        }
        // 결과
        System.out.println(sb);
    }
}