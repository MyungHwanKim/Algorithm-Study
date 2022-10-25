import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());  // 과일의 개수
        int L = Integer.parseInt(st.nextToken());  // 스네이크버드의 초기 길이

        int[] length = new int[N];  // 과일의 높이를 담을 배열
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            length[i] = Integer.parseInt(st.nextToken());
        }
        // 스네이크버드의 길이보다 작거나 높은 과일을 먹을 수 있으므로
        // 최대 길이를 위한 오름차순 정렬
        Arrays.sort(length);

        for (int l : length) {
            // 초기 길이와 같거나 작은 높이의 과일일 경우
            if (L >= l) {
                L++;
            } else {
                break;
            }
        }
        // 결과
        System.out.println(L);
    }
}