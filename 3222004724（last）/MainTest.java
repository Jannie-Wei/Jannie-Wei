package org.example;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import java.text.DecimalFormat;
import java.util.concurrent.TimeUnit;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class MainTest {

    @Test
    @Timeout(value = 2000, unit = TimeUnit.MILLISECONDS)
    public void testMain() {
        DecimalFormat df = new DecimalFormat("0.00");
        double d1 = 0.342453;
        String formattedValue = df.format(d1);

        // 检查格式化后的值是否符合预期
        assertEquals("0.34", formattedValue);
    }
}
