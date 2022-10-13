import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int K = Integer.parseInt(br.readLine());  // 정수의 개수

        Stack<Integer> stack = new Stack<>();  // 장부에 적을 수를 담을 stack
        for (int i = 0; i < K; i++) {
            int num = Integer.parseInt(br.readLine());
            // num 이 0이라면 가장 최근 숫자 제거
            if (num == 0) {
                stack.pop();
            } else {
                stack.push(num);
            }
        }

        int sum = 0;
        // stack 에 남은 수를 합하여 결과 도출
        while (!stack.isEmpty()) {
            int cur = stack.pop();
            sum += cur;
        }
        System.out.println(sum);
    }
}