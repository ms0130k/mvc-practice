package org.example;

import org.junit.jupiter.api.Test;

public class GetClassTest {
    @Test
    void getClass와_이어지는() {
        Class<? extends GetClassTest> aClass = getClass();
        System.out.println(aClass);
        System.out.println(aClass.getName());
        System.out.println(aClass.getSimpleName());
        System.out.println(aClass.getPackage());
        System.out.println(aClass.getPackageName());
    }
}
