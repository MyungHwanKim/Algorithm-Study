import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());  // 우유 가게의 수
        int[] store = new int[N];  // 우유 가게 정보

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            store[i] = Integer.parseInt(st.nextToken());
        }

        int count = 0;  // 마실 수 있는 우유의 개수
        int idx = 0;  // 영학이가 방문할 가게 번호
        for (int i = 0; i < N; i++) {
            // 가게 번호와 영학이가 방문한 가게 번호가 일치할 경우
            if (store[i] == (idx % 3)) {
                count++;
                idx++;
            }
        }
        // 결과
        System.out.println(count);
    }
}