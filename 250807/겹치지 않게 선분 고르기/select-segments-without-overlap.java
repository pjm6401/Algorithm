import java.util.*;

public class Main {

    static ArrayList<Line> lines = new ArrayList<>();
    static ArrayList<Line> anslines = new ArrayList<>();
    static int lineSize = 0;
    static int lineSizeTemp = 0;
    
    static int max = 0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] segments = new int[n][2];
        for (int i = 0; i < n; i++) {
            int start = sc.nextInt();
            int end = sc.nextInt();
            Line line = new Line(start,end);
            lines.add(line);
        }

        lineSize = lines.size();
        lineSizeTemp = lineSize;

        calc(0);

        System.out.println(max);
    }

    public static void calc(int cnt){
        if(cnt == lineSize){
            int ans = countLine();
            max = Math.max(max,ans);
            return;
        }

        for(int i = 0; i<lineSize; i++){
            Line line = lines.get(cnt);
            anslines.add(line);
            calc(cnt + 1);
            anslines.remove(anslines.size()-1);
        }
    }
    public static int countLine(){
        int max = 0;
        for(int i = 0; i<anslines.size(); i++){
            Line line = lines.get(i);
            int ans = 1;
            for(int j = 0; j<anslines.size(); j++){
                if(i!=j){
                    Line lineTemp = lines.get(j);
                    if(lineTemp.getEnd()<line.getStart() || lineTemp.getStart() > line.getEnd()){
                        ans++;
                    }
                }
            }
            max = Math.max(max,ans);
        }
        return max;
    }
}

class Line {
    int start;
    int end;
    public Line(int start, int end){
        this.start = start;
        this.end = end;
    }

    public int getStart(){
        return start;
    }
    public int getEnd(){
        return end;
    }
}