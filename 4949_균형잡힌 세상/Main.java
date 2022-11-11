import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();  // 결과를 담은 StringBuilder

        while (true) {
            String str = br.readLine();  // 문자열
            // 문자열이 "." 이라면 입력의 종료 조건
            if (str.equals(".")) {
                break;
            }

            // solve 메서드를 통해 확인 후 StringBuilder 에 추가
            sb.append(solve(str)).append("\n");
        }
        // 결과
        System.out.println(sb);
    }

    public static String solve(String str) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);

            // 왼쪽 소괄호, 왼쪽 대괄호 일 경우 stack 에 추가
            if (c == '(' || c == '[') {
                stack.push(c);
                // 오른쪽 소괄호일 경우
            } else if (c == ')') {
                // stack 이 비어있고 stack 에 마지막에 왼쪽 소괄호가 아닌 경우 
                // 괄호들의 균형이 맞지 않으므로 no를 리턴한다.
                if (stack.isEmpty() || stack.peek() != '(') {
                    return "no";
                } else {
                    stack.pop();
                }
                // 오른쪽 대괄호일 경우
            } else if (c == ']') {
                // stack 이 비어있고 stack 에 마지막에 왼쪽 대괄호가 아닌 경우 
                // 괄호들의 균형이 맞지 않으므로 no를 리턴한다.
                if (stack.isEmpty() || stack.peek() != '[') {
                    return "no";
                } else {
                    stack.pop();
                }
            }
        }

        // while 문 종료 후 stack 이 비어있다면 괄호들의 균형이 맞음
        return stack.isEmpty() ? "yes" : "no";
    }
}