package com.shuidihuzhu.java;

import com.shuidihuzhu.java.function.FunctionMethod;
import org.junit.Test;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * Lambda表达式 函数式(Functional)接口
 *
 * @Author : gehuadong@shuidihuzhu.com
 * @Date : 2020/4/12 17:32
 */
public class LambdaTest {

    /**
     * 消费型
     */
    @Test
    public void test01() {
        String username = "荀彧";
        consumerMethod01(username, new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println(s);
            }
        });

        consumerMethod01(username, s -> System.out.println(s));
    }

    /**
     * @param username
     * @param consumer
     */
    public void consumerMethod01(String username, Consumer<String> consumer) {
        consumer.accept(username);
    }

    /**
     * 供给型接口
     */
    @Test
    public void test02() {
        String username = "荀彧";
        System.out.println(supplierMethod01(new Supplier<String>() {
            @Override
            public String get() {
                return username;
            }
        }));

        System.out.printf(supplierMethod01(() -> username));
    }

    public String supplierMethod01(Supplier<String> supplier) {
        return supplier.get();
    }

    /**
     * 函数型接口
     */
    @Test
    public void test03() {
        String username = "荀彧";
        System.out.println(functionMethod01(username, new Function<String, String>() {
            @Override
            public String apply(String s) {
                return "我叫" + s;
            }
        }));

        System.out.println(functionMethod01(username, (s) -> "我叫" + s));
    }

    public String functionMethod01(String username, Function<String, String> function) {
        return function.apply(username);
    }

    /**
     * 断定型接口
     */
    @Test
    public void test04() {
        String username = "荀彧";
        System.out.println(predicateMethod01(username, (s) -> "荀彧".equals(s)));
    }

    public boolean predicateMethod01(String username, Predicate<String> predicate) {
        return predicate.test(username);
    }

    /**
     * 自定义函数式接口
     */
    @Test
    public void test05() {
        functionMethod(new FunctionMethod() {
            @Override
            public void method01() {
                System.out.println("自定义功能性接口1");
            }
        });

        functionMethod(() -> System.out.println("自定义功能性接口2"));
    }

    public void functionMethod(FunctionMethod functionMethod) {
        functionMethod.method01();
    }
}
