import java.util.*;
import java.math.BigDecimal;
import java.math.RoundingMode;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int a = sc.nextInt();
        int b = sc.nextInt();

        // BigDecimal로 변환
        BigDecimal bigA = new BigDecimal(a);
        BigDecimal bigB = new BigDecimal(b);

        // 나누기 + scale 지정 없이 먼저 계산
        BigDecimal result = bigA.divide(bigB, 30, RoundingMode.DOWN); // 30자리 계산
        BigDecimal floorResult = result.setScale(20, RoundingMode.DOWN); // 소수점 20자리에서 버림

        System.out.println(floorResult.toPlainString());
    }
}