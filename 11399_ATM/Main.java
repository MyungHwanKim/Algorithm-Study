import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());  // 사람의 수

        int[] minutes = new int[N];  // 인출하는데 걸리는 시간을 담을 배열
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            minutes[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(minutes);  // 필요한 시간의 최소합을 위한 정렬

        int minTime = 0;  // 최소 시간
        int prev = 0;  // 이전 시간
        for (int i = 0; i < N; i++) {
            // 이전 시간과 현재 시간의 합을 추가해준다.
            minTime += prev + minutes[i];
            // 다음 사람이 기다려야 하는 시간을 위해
            // 이전 시간을 기록해둔다.
            prev += minutes[i];
        }
        // 결과
        System.out.println(minTime);
    }
}