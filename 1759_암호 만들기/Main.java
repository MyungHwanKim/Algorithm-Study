import java.util.*;
import java.io.*;

public class Main {
    static String[] str;
    static String[] outs;
    static boolean[] visit;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int L = Integer.parseInt(st.nextToken());  // 서로 다른 암호의 개수
        int C = Integer.parseInt(st.nextToken());  // 문자의 개수
        str = new String[C];  // 문자를 담을 배열
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < C; i++) {
            str[i] = st.nextToken();
        }
        // 사전 순으로 증가해야 하므로 정렬
        Arrays.sort(str);

        outs = new String[L];  // L 길이 만큼의 암호를 담을 배열
        visit = new boolean[C];  // 방문 파악
        password(L, 0);

        // 결과
        System.out.println(sb.toString());
    }

    public static void password(int L, int length) {
        // 현재 암호 길이가 실제 암호 길이와 일치할 경우
        if (L == length) {
            StringBuilder s = new StringBuilder();  // 암호를 담을 StringBuilder
            int count = 0;  // 모음의 개수
            for (String out : outs) {
                // 현재 문자가 모음이라면 count++
                if ("aeiou".contains(out)) {
                    count++;
                }
                s.append(out);
            }
            // 모음의 개수가 1개 이상이고
            // 문자 전체 길이 중 모음의 개수를 뻇을 때 자음의 개수가 2개 이상일 경우에만
            // 암호로 사용 가능
            if (count >= 1 && s.length() - count >= 2) {
                sb.append(s).append("\n");
            }
            return;
        }

        for (int i = 0; i < str.length; i++) {
            // 방문한 문자가 아닌 경우
            if (!visit[i]) {
                // visit 을 true 로 만들면서 중복 제거
                for (int j = 0; j <= i; j++) {
                    visit[j] = true;
                }
                outs[length] = str[i];  // 암호에 사용할 문자 추가
                password(L, length + 1);
                for (int j = 0; j <= i; j++) {
                    visit[j] = false;
                }
            }
        }
    }
}