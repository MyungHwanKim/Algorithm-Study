import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());  // 탑의 개수

        Stack<int[]> stack = new Stack<>();  // {탑의 위치, 탑의 높이}를 담을 배열
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();  // 결과를 담을 StringBuilder
        for (int i = 0; i < N; i++) {
            int top = Integer.parseInt(st.nextToken());  // 탑의 높이

            // stack 이 비어있을 때까지
            while (!stack.isEmpty()) {
                // stack 에서 꺼낸 탑의 높이 값과 
                // 현재 탑의 높이와 비교하여 stack 탑의 높이가 더 클 경우 
                // 탑의 위치를 결과에 추가한 후 종료
                if (stack.peek()[1] >= top) {
                    sb.append(stack.peek()[0]).append(" ");
                    break;
                }
                stack.pop();
            }

            // stack 이 비어있을 경우 어느 탑에서 수신 불가능하므로 
            // 결과에 0 추가
            if (stack.isEmpty()) {
                sb.append(0).append(" ");
            }

            // 현재 탑의 위치와 탑의 높이를 stack 에 추가
            stack.push(new int[]{i + 1, top});
        }

        // 결과
        System.out.println(sb);
    }
}