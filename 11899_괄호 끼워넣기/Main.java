import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] brackets = br.readLine().toCharArray();  // 올바르지 않은 괄호열 배열

        int count = 0;  // 올바른 괄호열을 위한 최소 괄호의 개수
        Stack<Character> stack = new Stack<>();
        for (char bracket : brackets) {
            // '('일 경우 push
            if (bracket == '(') {
                stack.push('(');
            } else {
                // stack 이 비어있다면 올바르지 괄호열이기에
                // count 추가
                if (stack.isEmpty()) {
                    count++;
                    // 올바른 괄호 쌍일 경우
                    // stack 에서 하나 제거
                } else {
                    stack.pop();
                }
            }
        }
        // 올바른 괄호를 위한 개수인 count 와
        // stack 에 남아있는 괄호 개수의 합
        System.out.println(count + stack.size());
    }
}