import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());  // 단어의 개수
        String[] str = new String[N];  // 단어를 담을 배열
        StringBuilder sb = new StringBuilder();  // 결과를 담을 StringBuilder

        for (int i = 0; i < N; i++) {
            str[i] = br.readLine();
        }

        // 정렬
        Arrays.sort(str, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                // 길이가 같을 경우
                if (o1.length() == o2.length()) {
                    return o1.compareTo(o2);
                }
                return o1.length() - o2.length();
            }
        });

        String temp = "";  // 이전 단어를 담아둘 변수
        for (String s : str) {
            // 이전 변수와 같지 않을 경우
            if (!temp.equals(s)) {
                sb.append(s).append("\n");
                temp = s;
            }
        }
        System.out.println(sb);
    }
}
