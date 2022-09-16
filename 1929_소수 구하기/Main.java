import java.util.*;
import java.io.*;

public class Main {
    static boolean[] isPrime;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        // 소수 판단 boolean 배열
        isPrime = new boolean[N + 1];
        StringBuilder sb = new StringBuilder();
        getPrime();  // 소수 확인 메서드

        for (int i = M; i <= N; i++) {
            // false인 경우 소수이다.
            if (!isPrime[i]) {
                sb.append(i).append("\n");
            }
        }
        System.out.println(sb);
    }

    public static void getPrime() {
        // 0과 1은 소수가 아니므로 true
        isPrime[0] = isPrime[1] = true;

        for (int i = 2; i <= Math.sqrt(isPrime.length); i++) {
            // 이미 소수 판단 후 아닌 경우
            if (isPrime[i]) {
                continue;
            }
            for (int j = i * i; j < isPrime.length; j += i) {
                isPrime[j] = true;
            }
        }
    }
}