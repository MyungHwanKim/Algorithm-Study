import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());  // 단어의 개수
        int count = 0;  // 그룹 단어의 개수

        for (int i = 0; i < N; i++) {
            // 그룹 단어인지 확인
            if (check()) {
                count++;
            }
        }
        // 결과
        System.out.println(count);
    }

    public static boolean check() throws IOException {
        // 알파벳 26자리 확인 배열
        boolean[] isVisited = new boolean[26];
        int prev = 0;  // 이전 문자
        String word = br.readLine();
        for (int i = 0; i < word.length(); i++) {
            int cur = word.charAt(i);  // 현재 문자
            // 이전 문자와 현재 문자가 다를 경우
            if (prev != cur) {
                // 확인하지 않은 알파벳 문자일 경우
                if (!isVisited[cur - 'a']) {
                    isVisited[cur - 'a'] = true;
                    prev = cur;
                } else {
                    return false;
                }
            }
        }
        return true;
    }
}