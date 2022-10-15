import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());  // 명령의 수
        Queue<String> queue = new LinkedList<>();
        String last = "";  // 가장 뒤의 있는 정수

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            String[] command = br.readLine().split(" ");  // 명령
            switch (command[0]) {
                // 명령의 push 인 경우
                case "push":
                    // queue 는 FIFO (First In First Out)으로
                    // 먼저 들어온 값이 먼저 나가므로 queue 에 들어오는 값이
                    // 마지막 값이 된다.
                    last = command[1];
                    queue.offer(command[1]);
                    break;
                // 명령이 pop 인 경우
                case "pop":
                    // queue 에서 꺼낼 값이 없을 경우
                    if (queue.isEmpty()) {
                        sb.append("-1").append("\n");
                    } else {
                        sb.append(queue.poll()).append("\n");
                    }
                    break;
                // 명령이 size 인 경우
                case "size":
                    sb.append(queue.size()).append("\n");
                    break;
                // 명령이 empty 인 경우
                case "empty":
                    // queue 가 비어 있을 경우
                    if (queue.isEmpty()) {
                        sb.append("1").append("\n");
                    } else {
                        sb.append("0").append("\n");
                    }
                    break;
                // 명령이 front 인 경우
                case "front":
                    // queue 에서 꺼낼 값이 없을 경우
                    if (queue.isEmpty()) {
                        sb.append("-1").append("\n");
                    } else {
                        sb.append(queue.peek()).append("\n");
                    }
                    break;
                // 명령이 back 인 경우
                case "back":
                    // queue 에서 꺼낼 값이 없을 경우
                    if (queue.isEmpty()) {
                        sb.append("-1").append("\n");
                    } else {
                        sb.append(last).append("\n");
                    }
                    break;
            }
        }
        // 결과
        System.out.println(sb);
    }
}