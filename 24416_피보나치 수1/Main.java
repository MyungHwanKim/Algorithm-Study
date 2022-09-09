import java.io.*;

public class Main {

    static int fib(int n) {
        if (n == 1 || n == 2) {
            return 1;
        }
        return fib(n - 1) + fib(n - 2);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        // 재귀 실행 횟수, for문 실행 횟수 값
        System.out.print(fib(n) + " " + (n - 2));
    }
}
