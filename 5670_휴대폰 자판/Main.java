import java.util.*;
import java.io.*;

class Node {
    HashMap<Character, Node> child;
    int count;  // 문자가 추가된 횟수

    public Node() {
        this.child = new HashMap<>();
        this.count = 0;  // 기존 0으로 초기화
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

            // 현재 노드의 자식노드에 문자가 포함되어 있지 않을 경우
            if (!cur.child.containsKey(c)) {
                cur.child.put(c, new Node());
            }
            cur = cur.child.get(c);
            cur.count += 1;  // 현재 노드의 count 추가
        }
    }

    public double getResult(String[] arr) {
        double result = 0;  // 각 단어를 입력하기 위해 버튼을 눌러야하는 총 횟수

        for (String s : arr) {
            Node cur = this.root;

            int count = 0;  // 단어별로 입력하기 위해 버튼을 눌러야하는 횟수
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);

                if (cur.child.containsKey(c)) {
                    int cnt = cur.count;
                    cur = cur.child.get(c);
                    // 현재 노드의 count 와 이전 노드의 count 가 다를 경우
                    // 버튼을 눌러야 한다.
                    if (cur.count != cnt) {
                        count++;
                    }
                }
            }
            result += count;
        }

        return result;
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String num;

        // 테스트 케이스 수가 존재할 경우
        while ((num = br.readLine()) != null) {
            Trie trie = new Trie();
            int N = Integer.parseInt(num);  // 사전에 속한 단어의 개수
            String[] arr = new String[N];  // 단어를 담을 배열
            for (int i = 0; i < N; i++) {
                String str = br.readLine();  // 단어
                trie.insert(str);  // trie 에 단어 추가
                arr[i] = str;  // 배열에 단어 추가
            }

            // 각 단어를 입력하기 위해 버튼을 눌러야 하는 횟수의 평균
            // 총 버튼 수 / 단어가 들어있는 배열의 길이
            double result = trie.getResult(arr) / arr.length;
            // 소수점 둘째 자리까지 반올림하여 StringBuilder 에 추가
            sb.append(String.format("%.2f", result)).append("\n");
        }

        // 결과
        System.out.println(sb);
    }
}