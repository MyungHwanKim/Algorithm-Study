import java.util.*;
import java.io.*;

class Node {
    HashMap<Character, Node> child;
    boolean isTerminal;

    public Node() {
        this.child = new HashMap<>();
        this.isTerminal = false;
    }
}

class Trie {
    Node root;

    public Trie() {
        this.root = new Node();
    }

    public void insert(String str) {
        Node cur = this.root;

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);

            cur.child.putIfAbsent(c, new Node());
            cur = cur.child.get(c);

            if (i == str.length() - 1) {
                cur.isTerminal = true;
                break;
            }
        }
    }

    public int search(String str) {
        Node cur = this.root;

        int count = 0;  // isTerminal 개수
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);

            if (cur.child.containsKey(c)) {
                cur = cur.child.get(c);
            }

            if (cur.isTerminal) {
                count++;
            }
        }

        // 결과
        return count;
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());  // 테스트 케이스 수

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < T; i++) {
            int n = Integer.parseInt(br.readLine());  // 전화번호 수

            Trie trie = new Trie();

            String[] numbers = new String[n];  // 전화번호를 담을 배열
            for (int j = 0; j < n; j++) {
                String number = br.readLine();
                numbers[j] = number;  // 배열에 전화번호 추가
                trie.insert(number);  // 트라이에 전화번호 추가
            }

            boolean check = true;  // 일관성 파악
            for (String num : numbers) {
                // isTerminal 의 개수 파악
                int count = trie.search(num);

                // search 를 통해 isTerminal 개수가 2개 이상이라면
                // 일관성이 없는 목록이므로
                // "NO" 를 StringBuilder 에 담고
                // check 를 false 로 바꾼 후 종료
                if (count > 1) {
                    sb.append("NO");
                    check = false;
                    break;
                }
            }

            // 일관성이 있다면 "YES" 를 담는다.
            if (check) {
                sb.append("YES");
            }
            sb.append("\n");
        }

        // 결과
        System.out.println(sb);
    }
}