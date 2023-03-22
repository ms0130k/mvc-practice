package org.example;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class EnumTest {
    private static final Logger log = LoggerFactory.getLogger(EnumTest.class);
    enum Test {
        GET, POST, post
    }

    @org.junit.jupiter.api.Test
    void name() {
        assertThat(Test.valueOf("GET")).isEqualTo(Test.GET);
        assertThat(Test.valueOf("post")).isEqualTo(Test.post);
        assertThrows(IllegalArgumentException.class, () -> Test.valueOf("get"));
    }
}
