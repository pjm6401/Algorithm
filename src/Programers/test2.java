package Programers;

public class test2 {
    public static void main(String[] args) {
        String t ="3141592";
        String b = "271";
        int count = 0;
        int bInt = Integer.parseInt(b);
        int check = t.length()-b.length()+1;
        System.out.println(check);
        int sbCheck = b.length();
        int [] checkArray = new int[check];

        for (int i = 0; i <check; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = i; j < i+sbCheck; j++){
                sb.append(t.charAt(j));
            }
            int sbInt = Integer.parseInt(sb.toString());
            System.out.println(sbInt);
            if(bInt>=sbInt){
                count++;
            }
        }
        System.out.println(count);
    }
}
