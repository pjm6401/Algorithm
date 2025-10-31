import java.util.Scanner;

public class Main {
    // 한 노드를 나타내는 클래스입니다.
    static class Node {
        // 문자열을 값으로 가집니다.
        String data;
        Node prev, next;

        // 생성자를 사용하여 Node를 초기화합니다.
        public Node(String data) {
            this.data = data;
            this.prev = null;
            this.next = null;
        }
    }

    // 두 노드를 연결해줍니다.
    public static void connect(Node s, Node e) {
        if (s != null) s.next = e;
        if (e != null) e.prev = s;
    }

    // target 뒤에 s를 삽입합니다.
    public static void insertNext(Node target, Node s) {
        connect(s, target.next);
        connect(target, s);
    }

    // target 앞에 s를 삽입합니다.
    public static void insertPrev(Node target, Node s) {
        connect(target.prev, s);
        connect(s, target);
    }

    // target의 이전 노드, target, target의 다음 노드의 값을 출력합니다.
    public static void printNode(Node target) {
        String n = "(Null)";

        // 이전 노드가 존재하지 않는다면, Null을 출력합니다.
        // 아니라면, 이전 노드의 값을 출력합니다.
        if (target.prev == null) System.out.print(n + " ");
        else System.out.print(target.prev.data + " ");

        // target의 값을 출력합니다.
        System.out.print(target.data + " ");

        // 다음 노드가 존재하지 않는다면, Null을 출력합니다.
        if (target.next == null) System.out.println(n);
        else System.out.println(target.next.data);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 맨 처음 문자열을 입력 받습니다.
        String sInit = sc.nextLine();

        // 맨 처음 존재하는 노드를 만듭니다.
        Node cur = new Node(sInit);

        // 연산의 개수를 입력 받습니다.
        int n = sc.nextInt();

        while (n-- > 0) {
            int option = sc.nextInt();

            // option이 1이라면, cur의 앞에 노드를 삽입합니다.
            if (option == 1) {
                // 삽입할 노드를 만듭니다.
                String data = sc.next();
                Node target = new Node(data);

                // cur의 앞에 삽입합니다.
                insertPrev(cur, target);
            }

            // option이 2라면, cur의 뒤에 노드를 삽입합니다.
            if (option == 2) {
                // 삽입할 노드를 만듭니다.
                String data = sc.next();
                Node target = new Node(data);

                // cur의 뒤에 삽입합니다.
                insertNext(cur, target);
            }

            if (option == 3) {
                // cur의 이전 노드가 존재한다면, cur을 cur의 이전 노드로 변경합니다.
                if (cur.prev != null) cur = cur.prev;
            }

            if (option == 4) {
                // cur의 다음 노드가 존재한다면, cur을 cur의 다음 노드로 변경합니다.
                if (cur.next != null) cur = cur.next;
            }

            // 매 연산이 진행될 때마다 cur의 값을 출력합니다.
            printNode(cur);
        }

        sc.close();
    }
}
