import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // A의 핸드폰 번호
        char[] A = br.readLine().toCharArray();
        // B의 핸드폰 번호
        char[] B = br.readLine().toCharArray();

        // A, B 합쳐서 16자리이므로 size는 16
        String[] dp = new String[16];

        StringBuilder sbCur = new StringBuilder();
        for (int i = 0; i < A.length; i++) {
            sbCur.append(A[i]);
            sbCur.append(B[i]);
        }
        for (int i = dp.length - 1; i > 0; i--) {
            dp[i] = sbCur.toString();
            StringBuilder sb = new StringBuilder();
            int p = 0;
            while (p != sbCur.length() - 1) {
                // 앞에서부터 순서대로 2개씩 합한 값을 10으로 나눈 나머지를 넣어준다.
                sb.append((sbCur.charAt(p) - '0' + sbCur.charAt(p + 1) - '0') % 10);
                p++;
            }
            // 다시 StringBuilder에 넣어준다.
            sbCur = sb;
        }
        // 최종 결과는 두자리이므로 dp[1]값을 꺼내온다.
        System.out.println(dp[1]);
    }
}
