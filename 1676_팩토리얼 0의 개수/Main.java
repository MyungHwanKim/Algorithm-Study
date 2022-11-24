import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());  // 팩토리얼할 숫자

        int count = 0;
        while (N >= 5) {
            // 2와 5가 만날 때마다 0이 추가된다.
            // 즉, 5의 배수일 때마다 0이 하나씩 추가된다.
            // 하지만, 25인 경우는 5가 2개이므로 하나 더 추가해주어야한다.
            // 그러므로 5로 나눈 몫의 값과 몫을 다시 5로 나눈 값을 더해주면 된다.
            count += N / 5;
            N /= 5;
        }

        // 결과
        System.out.println(count);
    }
}