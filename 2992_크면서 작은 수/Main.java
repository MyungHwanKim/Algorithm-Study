import java.io.*;

public class Main {
    static String str;
    static int X;
    static int result = 10000000;  // 가능한 최대 수가 999999이므로 이보다 큰 수인 최대 수 + 1로 설정
    static boolean[] visit;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        str = br.readLine();  // 정수값의 문자열 형태
        X = Integer.parseInt(str);  // 정수값

        visit = new boolean[str.length()];  // 방문 확인

        // X보다 큰 수 중 가장 작은 수 확인
        checkNum(str.length(), "");

        // 결과
        System.out.println(result == 10000000 ? 0 : result);
    }

    public static void checkNum(int len, String s) {
        // 정수값의 길이와 현재 숫자의 길이가 일치할 경우
        if (len == s.length()) {
            // 기존 정수값보다 큰 경우
            // 이전에 구한 결과값과 현재 구한 값과 비교하여 더 작은 값으로 업데이트
            if (X < Integer.parseInt(s)) {
                result = Math.min(result, Integer.parseInt(s));
            }
            return;
        }

        for (int i = 0; i < len; i++) {
            // 사용하지 않은 숫자인 경우
            if (!visit[i]) {
                visit[i] = true;
                checkNum(len, s + str.charAt(i));
                visit[i] = false;
            }
        }
    }
}