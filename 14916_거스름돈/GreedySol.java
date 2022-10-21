import java.io.*;

public class GreedySol {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());  // 거스름돈 액수
        int count = 0; // 거스름돈 동전의 개수

        // 거스름돈이 0 이상일 경우
        while (n >= 0) {
            // 거스름돈이 5원으로 나눠줄 수 있는 경우
            if (n % 5 == 0) {
                count += n / 5;
                break;
            }

            // 현재 거스름돈을 5원으로만 나눠줄 수 없는 경우
            n -= 2;
            count++;
        }

        // 현재 거스름돈이 0보다 작을 경우 거슬러 줄 수 없으므로 -1
        System.out.println(n < 0 ? - 1 : count);
    }
}