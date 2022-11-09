import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());  // 세로 길이
        int M = Integer.parseInt(st.nextToken());  // 가로 길이

        String[] board = new String[N];  // 보드
        for (int i = 0; i < N; i++) {
            board[i] = br.readLine();
        }

        // 다시 칠해야 하는 정사각형 개수의 최솟값
        int minCount = Integer.MAX_VALUE;
        for (int i = 0; i <= N - 8; i++) {
            for (int j = 0; j <= M - 8; j++) {
                int count = getCount(i, j, board);
                // 방금 구한 개수와 기존 최솟값과 비교하여 더 작은 값으로 업데이트
                minCount = Math.min(minCount, count);
            }
        }
        // 결과
        System.out.println(minCount);
    }

    public static int getCount(int row, int col, String[] board) {
        // 체스판이 가질 수 있는 경우
        // 둘 중 하나씩 번갈아가면서 만들어져야 한다.
        String[] check = {"WBWBWBWB", "BWBWBWBW"};

        // check 0번째 인덱스를 W로 시작했기 때문에
        // 흰색의 개수를 파악
        int WCount = 0;
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                // 보드판의 색과 check 의 색과 다를 경우
                // 다시 칠해야 하는 흰색 개수를 추가
                if (board[row + i].charAt(col + j) != check[(row + i) % 2].charAt(j)) {
                    WCount++;
                }
            }
        }

        // 무조건 8 * 8 크기의 체스판으로 파악하기 때문에
        // 총 개수는 64이다. 그래서 64 - 흰색의 개수 = 검은색의 개수이다.
        return Math.min(WCount, 64 - WCount);
    }
}