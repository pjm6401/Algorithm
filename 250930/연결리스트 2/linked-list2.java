import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        HashMap<Integer, Node> map = new HashMap<>();
        int n = sc.nextInt();


        int q = sc.nextInt();
        

        for(int i = 1; i<=n; i++){
            map.put(i,new Node(i));
        }

        for(int i = 0; i<q; i++){
            int k = sc.nextInt();

            if(k==1){
                int x = sc.nextInt();
                Node cur = map.get(x);

                Node prevNode = cur.prev;
                Node nextNode = cur.next;

                
                if (prevNode != null) {
                    prevNode.next = nextNode;
                }

                if (nextNode != null) {
                    nextNode.prev = prevNode;
                }

                cur.prev = null;
                cur.next = null;

            }else if(k==2){
                int x = sc.nextInt();
                int y = sc.nextInt();

                Node cur = map.get(x);
                Node node = map.get(y);

                node.next = cur;
                node.prev = cur.prev;

                if(null!= node.next){
                    node.next.prev = node;
                }
                if(null != node.prev){
                    node.prev.next = node;
                }

            }else if(k==3){
                int x = sc.nextInt();
                int y = sc.nextInt();

                Node cur = map.get(x);
                Node node = map.get(y);

                node.prev = cur;
                node.next = cur.next;

                if(null!= node.next){
                    node.next.prev = node;
                }
                if(null != node.prev){
                    node.prev.next = node;
                }

            }else{
                int x = sc.nextInt();
                Node cur = map.get(x);

                if(null != cur.prev){
                    System.out.print(cur.prev.num + " ");
                }else {
                    System.out.print(0 + " ");
                }

                if(null != cur.next){
                    System.out.print(cur.next.num + " ");
                }else {
                    System.out.print(0 + " ");
                }

                System.out.println();
            }
        }

        for(int i = 1; i<=n; i++){
            Node node = map.get(i);
            if(null != node.next){
                System.out.print(node.next.num +" ");
            }else{
                System.out.print(0 +" ");
            }
        }
    }
}

class Node{
    int num;
    Node next,prev;

    public Node(int num){
        this.num = num;
        this.prev = this.next = null;
    }
}