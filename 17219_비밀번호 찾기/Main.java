import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());  // 저장된 사이트 주소의 수
        int M = Integer.parseInt(st.nextToken());  // 비밀번호를 찾으려는 사이트 주소의 수

        Map<String, String> map = new HashMap<>();  // (주소, 비밀번호) 담을 HashMap
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String address = st.nextToken();  // 주소
            String password = st.nextToken();  // 비밀번호
            map.put(address, password);
        }

        for (int i = 0; i < M; i++) {
            bw.write(map.get(br.readLine()));
            bw.newLine();
        }

        bw.flush();
        bw.close();
    }
}