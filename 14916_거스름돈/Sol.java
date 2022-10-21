import java.io.*;

public class Sol {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());  // 거스름돈 액수
        int count = 0; // 거스름돈 동전의 개수

        // 거스름돈이 1원과 3원일 경우
        if (n == 1 || n == 3) {
            System.out.println(-1);
            return;
        }
        // 거스름돈이 5원으로 나누어지면서 2원으로도 나누어줄 수 있는 경우
        if ((n % 5) % 2 == 0) {
            // (5원으로 나눌 수 있는 개수) + (5원으로 나누고 남은 나머지에서 2원으로 나눠준다.
            count += (n / 5) + ((n % 5) / 2);
        } else {
            // 5원으로 나눠주고 2원으로 나눠줄 수 없는 경우
            // 5원을 1번 적게 나눠주고
            // 나머지를 2원으로 나눠준다.
            count += ((n / 5) - 1) + (((n % 5) + 5) / 2);
        }
        // 결과
        System.out.println(count);
    }
}