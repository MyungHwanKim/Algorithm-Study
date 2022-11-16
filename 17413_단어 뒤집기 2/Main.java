import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] chars = br.readLine().toCharArray(); // 문자열을 문자로 나눈 배열

        StringBuilder sb = new StringBuilder();  // 결과를 담을 StringBuilder
        Stack<Character> stack = new Stack<>();  // 뒤집을 문자를 담을 Stack
        for (int i = 0; i < chars.length; i++) {
            // 문자가 '<'인 경우 
            // '<'의 쌍인 '>' 문자가 나올 때까지 
            // i를 늘려주면서 결과에 추가한다.
            if (chars[i] == '<') {
                while (chars[i] != '>') {
                    sb.append(chars[i]);
                    i++;
                }
                sb.append(chars[i]);
            } else {
                // i가 문자열의 길이를 벗어나지 않으면서 
                // 현재 문자가 ' ' 아니면서 다음 문자가 '<' 아닐 때까지 
                // stack 에 추가한다
                while (i < chars.length - 1 && chars[i] != ' ' && chars[i + 1] != '<') {
                    stack.push(chars[i]);
                    i++;
                }
                // 현재 문자가 ' '이 아니라면 
                // stack 에 넣어야할 마지막 문자이므로 추가한다.
                if (chars[i] != ' ') {
                    stack.push(chars[i]);
                }
                // stack 에서 하나씩 문자를 꺼내면서 결과에 추가한다.
                while (!stack.isEmpty()) {
                    sb.append(stack.pop());
                }
                // 혹시 현재 문자가 ' ' 이라면 결과에 추가한다.
                if (chars[i] == ' ') {
                    sb.append(chars[i]);
                }
            }
        }

        // 결과
        System.out.println(sb);
    }
}