package tech.comfortheart.formula;

import org.junit.Test;

import java.math.BigDecimal;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by 43391554 on 2017/8/28.
 */
public class SimpleTests {
    @Test
    public void testBigDecimal() {
        BigDecimal num = new BigDecimal("1.245");
        BigDecimal result = num.divide(new BigDecimal(3), 21, BigDecimal.ROUND_HALF_UP );
        System.out.println(result);

        System.out.println(new BigDecimal(String.valueOf(Math.PI)));
        System.out.println(num.setScale(2, BigDecimal.ROUND_HALF_UP));

        BigDecimal num1 = new BigDecimal("1");
        System.out.println(num1.divide(new BigDecimal(365), 21, BigDecimal.ROUND_HALF_UP));
        System.out.println(num1.divide(new BigDecimal(366), 21, BigDecimal.ROUND_HALF_UP));
    }

    @Test
    public void testMap() {
        ConcurrentHashMap<String, String> map = new ConcurrentHashMap<>();
        String hey = map.get("hello");
        assert hey==null;
    }
}
