package org.example;

import org.junit.jupiter.api.Test;

import java.nio.charset.StandardCharsets;

import static org.assertj.core.api.Assertions.assertThat;

public class CharacterSetTest {
    @Test
    void name() {
        assertThat(StandardCharsets.UTF_8.name()).isEqualTo("UTF-8");
//        System.out.println(StandardCharsets.UTF_8.name());
    }
}
