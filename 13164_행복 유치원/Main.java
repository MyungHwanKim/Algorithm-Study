import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());  // 유치원에 있는 원생의 수
        int K = Integer.parseInt(st.nextToken());  // 나누려고 하는 조의 개수

        int[] lens = new int[N];  // 원생들의 키를 담을 배열
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            lens[i] = Integer.parseInt(st.nextToken());
        }

        int[] arr = new int[N - 1];  // 다음 사람과의 키 차이를 담을 배열
        for (int i = 1; i < lens.length; i++) {
            arr[i - 1] = lens[i] - lens[i - 1];
        }
        // 키 차이가 작은 순으로 정렬
        Arrays.sort(arr);

        int result = 0;  // 결과
        // K 개의 조를 나타내야하므로 N - K 미만의 차이를
        // 결과에 추가한다.
        for (int i = 0; i < N - K; i++) {
            result += arr[i];
        }

        // 결과
        System.out.println(result);
    }
}