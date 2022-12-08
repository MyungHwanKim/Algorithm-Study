import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());  // 강의의 수
        int M = Integer.parseInt(st.nextToken());  // 블루레이 개수

        int[] sizes = new int[N];  // 기타 강의의 길이
        int start = 0;  // 시작(강의 길이 중 가장 긴 강의)
        int end = 0;  // 끝(강의 길이의 총합)
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            sizes[i] = Integer.parseInt(st.nextToken());
            end += sizes[i];
            start = Math.max(start, sizes[i]);
        }

        // 시작값이 끝값과 같거나 클 경우 종료
        while (start < end) {
            int mid = start + (end - start) / 2;
            int count = 0;  // 블루레이 개수
            int temp = 0;  // mid 를 넘지 않는 강의 길이
            for (int size : sizes) {
                // 이전의 강의 길이와 현재 강의 길이의 합이
                // mid 보다 클 경우 
                // 블루레이 수를 하나 늘려주고 
                // 강의 길이 값은 0으로 초기화
                if (temp + size > mid) {
                    count++;
                    temp = 0;
                }
                temp += size;
            }

            // 강의 길이 값이 남아 있다면 블루레이 개수 추가
            if (temp > 0) {
                count++;
            }

            // 블루레이 개수가 원하는 블루레이 수와 같거나 작을 경우
            // 끝 값을 mid 값으로 업데이트
            if (count <= M) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }

        // 결과
        System.out.println(start);
    }
}