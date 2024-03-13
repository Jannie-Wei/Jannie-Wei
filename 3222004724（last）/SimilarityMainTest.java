package org.example;

import org.junit.Before;
import org.junit.Test;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class SimilarityMainTest {

    private SimilarityMain similarityMainUnderTest;

    @Before
    public void setUp() throws NoSuchFieldException, IllegalAccessException {
        similarityMainUnderTest = new SimilarityMain("string1", "string2");// 初始化待测试的 SimilarityMain 对象，并传入两个字符串

        // 创建实际的 vectorMap 对象
        Map<Character, int[]> vectorMap = new HashMap<>();
        vectorMap.put('s', new int[]{1, 0});// 将字符's'的向量加入Map
        vectorMap.put('t', new int[]{1, 1});
        vectorMap.put('r', new int[]{1, 0});
        vectorMap.put('i', new int[]{1, 1});
        vectorMap.put('n', new int[]{1, 0});
        vectorMap.put('g', new int[]{1, 0});
        vectorMap.put('1', new int[]{1, 0});
        vectorMap.put('2', new int[]{0, 1});

        // 使用反射将 vectorMap 设置为 SimilarityMain 类中的 vectorMap
        Field vectorMapField = similarityMainUnderTest.getClass().getDeclaredField("vectorMap");// 获取 SimilarityMain 类中的 vectorMap 字段
        vectorMapField.setAccessible(true);// 设置字段可访问
        vectorMapField.set(similarityMainUnderTest, vectorMap);// 将创建的实际 vectorMap 对象设置到 similarityMainUnderTest 对象中的 vectorMap 字段
    }

    @Test
    public void testSimilarity() {
        // 运行测试
        final double result = similarityMainUnderTest.similarity();// 调用待测试对象的 similarity 方法得到相似度计算结果

        // 验证结果
        double expected = 0.4364357804719848;// 预期的相似度计算结果
        assertEquals(expected, result, 0.001);// 使用断言验证实际结果和预期结果是否一致，允许误差为0.001

        // 打印实际结果和预期结果
        System.out.println("实际结果：" + result);
        System.out.println("预期结果：" + expected);
    }
}