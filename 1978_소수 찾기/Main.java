import java.util.*;
import java.io.*;

public class Main {
    static boolean[] isCheck;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());  // 수의 개수
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];  // 입력된 수의 배열
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        isCheck = new boolean[1001];  // 조건 : 최대 1000 이하의 자연수
        primeCheck();  // 소수 확인 메서드
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            // false 이면 소수이므로 count를 늘려준다.
            if (!isCheck[arr[i]]) {
                count++;
            }
        }
        System.out.println(count);
    }

    public static void primeCheck() {
        isCheck[0] = true;
        isCheck[1] = true;
        for (int i = 2; i < Math.sqrt(isCheck.length); i++) {
            // 소수가 아닌 경우
            if (isCheck[i]) {
                continue;
            }
            for (int j = i * i; j < isCheck.length; j += i) {
                isCheck[j] = true;
            }
        }
    }
}