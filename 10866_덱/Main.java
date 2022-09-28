import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Deque<Integer> deque = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder();  // 결과를 담을 StringBuilder

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");

            switch (st.nextToken()) {  // 들어오는 첫 단어
                // 정수 x를 앞쪽에 넣는 경우
                case "push_front":
                    int num = Integer.parseInt(st.nextToken());
                    deque.addFirst(num);
                    break;
                // 정수 x를 뒤쪽에 넣는 경우
                case "push_back":
                    num = Integer.parseInt(st.nextToken());
                    deque.addLast(num);
                    break;
                // 정수 x를 앞쪽에 수를 빼는 경우
                case "pop_front":
                    // deque 가 비었다면 -1
                    if (deque.isEmpty()) {
                        sb.append(-1).append("\n");
                    } else {
                        sb.append(deque.pollFirst()).append("\n");
                    }
                    break;
                // 정수 x를 뒤쪽에 수를 빼는 경우
                case "pop_back":
                    // deque 가 비었다면 -1
                    if (deque.isEmpty()) {
                        sb.append(-1).append("\n");
                    } else {
                        sb.append(deque.pollLast()).append("\n");
                    }
                    break;
                // deque 안에 정수의 개수
                case "size":
                    sb.append(deque.size()).append("\n");
                    break;
                case "empty":
                    // deque 가 비어있을 경우 1
                    if (deque.isEmpty()) {
                        sb.append(1).append("\n");
                    } else {
                        sb.append(0).append("\n");
                    }
                    break;
                // deque 의 가장 앞의 수를 출력
                case "front":
                    // deque 가 비어 있을 경우 -1
                    if (deque.isEmpty()) {
                        sb.append(-1).append("\n");
                    } else {
                        sb.append(deque.peekFirst()).append("\n");
                    }
                    break;
                // deque 의 가장 뒤의 수를 출력
                case "back":
                    // deque 가 비어 있을 경우 -1
                    if (deque.isEmpty()) {
                        sb.append(-1).append("\n");
                    } else {
                        sb.append(deque.peekLast()).append("\n");
                    }
                    break;
            }
        }
        System.out.println(sb);
    }
}