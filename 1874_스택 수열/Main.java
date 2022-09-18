import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine()); // 수의 개수
        Stack<Integer> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();

        int start = 0;  // 시작할 숫자
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(br.readLine());
            // 가져온 값이 현재 위치값보다 클 경우
            if (num > start) {
                // 현위치 값부터 가져온 값까지 push
                for (int j = start + 1; j <= num; j++) {
                    stack.push(j);
                    sb.append("+").append("\n");
                }
                // 시작 값을 가져온 값으로 초기화
                start = num;
            // stack 마지막 값이 가져온 값과 일치하지 않을 경우 종료
            } else if (stack.peek() != num) {
                System.out.println("NO");
                return;
            }
            stack.pop();
            sb.append("-").append("\n");
        }
        // 결과
        System.out.println(sb);
    }
}