import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String strN = br.readLine();  // 자연수를 나타내는 문자
        int N = Integer.parseInt(strN);  // 자연수

        int result = 0;  // 결과를 담을 변수
        // N에서 각 자리수의 값이 9일 때 길이만큼 더 적게 탐색할 수 있다.
        for (int i = (N - (strN.length() * 9)); i < N; i++) {
            int sum = i;  // 분해합
            int num = i;
            while (num > 0) {
                sum += num % 10;  // 각 자리수 더하기
                num /= 10;  // num 업데이트
            }

            // 분해합이 N과 같을 때
            // result(결과)에 넣어주고
            // break
            if (sum == N) {
                result = i;
                break;
            }
        }

        // 결과
        System.out.println(result);
    }
}