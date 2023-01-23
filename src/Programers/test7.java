package Programers;

import java.util.Arrays;
import java.util.*;
import java.util.stream.Collectors;

public class test7 {
    public static void main(String[] args) {
        int n = 5;
        int [] stage= {1,2,2,1,3};
        Map<Integer, Double> map = new HashMap<>();
        int [] result = new int[n];
        int length = stage.length;
        for (int i = 1; i <= n; i++) {
            int rate = 0;
            for (int k : stage) {
                if (i == k) {
                    rate++;
                }
            }
            if(rate==0){
                map.put(i,0.0);
            }
            else {
                double s = (double) rate / length;
                length = length - rate;
                map.put(i, s);
            }
        }
        List<Integer> listKeySet = new ArrayList<>(map.keySet());
        Collections.sort(listKeySet, (value1, value2) -> (map.get(value2).compareTo(map.get(value1))));
        int i =0;
        for(Integer key : listKeySet) {
            result[i] = key;
            i++;
            System.out.println("key : " + key + " , " + "value : " + map.get(key));
        }
        System.out.println(map);
        System.out.println(Arrays.toString(result));
    }
}
