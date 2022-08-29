import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 전체 케이스 개수

        for (int i = 0; i < N; i++) {
            Stack<String> stack = new Stack<>();
            // 띄어쓰기 구분으로 문자열을 stack에 넣기
            stack.addAll(Arrays.asList(br.readLine().split(" ")));

            // 결과를 담을 StringBuilder
            StringBuilder sb = new StringBuilder();

            // case 번호에 맞는 기본 구조
            sb.append("Case #").append(i + 1).append(": ");
            while (!stack.isEmpty()) {
                sb.append(stack.pop());

                // stack이 비었을 경우
                if (stack.isEmpty()) {
                    break;
                }
                // 띄어쓰기로 구분하여 없앴던 부분을 다시 넣어주기
                sb.append(" ");
            }
            //결과 출력
            System.out.println(sb.toString());
        }
    }
}