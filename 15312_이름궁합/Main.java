import java.io.*;

public class Main {
    // 대문자 알파벳 순서대로 획수
    static final int[] alphabetNum = {3, 2, 1, 2, 3, 3, 2
                        , 3, 3, 2, 2, 1, 2, 2, 1, 2
                        , 2, 2, 1, 2, 1, 1, 1, 2, 2, 1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 종민이의 영어 이름
        char[] A = br.readLine().toCharArray();
        // '그녀'의 영어 이름
        char[] B = br.readLine().toCharArray();

        // 두 이름의 길이는 같음이 보장되므로 size는 둘 중 하나의 2배로 하면 된다.
        String[] dp = new String[A.length * 2];

        StringBuilder sbCur = new StringBuilder();
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < alphabetNum.length; j++) {
                // 종민의 이름 알파벳과 같은 값 추가
                if (A[i] - 'A' == j) {
                    sbCur.append(alphabetNum[j]);
                }
            }

            for (int j = 0; j < alphabetNum.length; j++) {
                // 그녀의 이름 알파벳과 같은 값 추가
                if (B[i] - 'A' == j) {
                    sbCur.append(alphabetNum[j]);
                }
            }
        }

        for (int i = dp.length - 1; i >= 1; i--) {
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
