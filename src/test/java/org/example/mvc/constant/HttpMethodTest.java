package org.example.mvc.constant;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

@Slf4j
class HttpMethodTest {
    @Test
    void valueOf() {
        assertThat(HttpMethod.valueOf("GET")).isEqualTo(HttpMethod.GET);
        assertThatThrownBy(() -> HttpMethod.valueOf("get"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}