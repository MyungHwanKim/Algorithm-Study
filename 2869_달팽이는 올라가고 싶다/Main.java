import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long A = Long.parseLong(st.nextToken());  // 올라가는 높이
        long B = Long.parseLong(st.nextToken());  // 미끄러지는 높이
        long V = Long.parseLong(st.nextToken());  // 높이

        // 마지막으로 미끄러지기 전까지 일수
        long day = (V - B) / (A - B);

        // day 를 구하고도 V까지 도달하지 못했을 경우
        if ((V - B) % (A - B) != 0) {
            day++;
        }
        System.out.println(day);
    }
}