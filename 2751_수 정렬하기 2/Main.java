import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());  // 수의 개수
        StringBuilder sb = new StringBuilder();

        int[] arr = new int[N]; // 수를 담을 배열
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr); // 정렬
        for(int item: arr) {
            sb.append(item).append("\n");
        }
        System.out.println(sb);
    }
}