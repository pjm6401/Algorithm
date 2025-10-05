import java.util.*;

class Element implements Comparable<Element> {
    int y, index;
    public Element(int y, int index) {
        this.y = y;
        this.index = index;
    }
    @Override
    public int compareTo(Element e) {
        if(this.y == e.y) 
            return this.index - e.index;
        return this.y - e.y;
    }
}

class Pair implements Comparable<Pair>{
    int y, v, x, idx;

    public Pair(int y, int v, int x, int idx){
        this.y = y;
        this.v = v;
        this.x = x;
        this.idx = idx;
    }

    @Override
    public int compareTo(Pair p){
        return this.x - p.x;  // ✅ x 기준 정렬
    } 
}

public class Main {
    static ArrayList<Pair> list = new ArrayList<>();
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            int y = sc.nextInt();
            int x1 = sc.nextInt();
            int x2 = sc.nextInt();

            list.add(new Pair(y, 1, x1, i));   // 시작점
            list.add(new Pair(y, -1, x2, i));  // 끝점
        }
        Collections.sort(list);

        TreeSet<Element> set = new TreeSet<>();
        HashSet<Integer> setH = new HashSet<>();
        
        for(int i = 0; i < list.size(); i++){
            int y = list.get(i).y;
            int x = list.get(i).x;
            int v = list.get(i).v;
            int idx = list.get(i).idx;

            if(v == 1){
                set.add(new Element(y, idx));  // 시작: 추가
            } else {
                set.remove(new Element(y, idx));  // 끝: 제거
            }
            
            if(!set.isEmpty()){
                int visibleIdx = set.first().index;
                setH.add(visibleIdx);
            }
        }
        
        System.out.println(setH.size());
    }
}