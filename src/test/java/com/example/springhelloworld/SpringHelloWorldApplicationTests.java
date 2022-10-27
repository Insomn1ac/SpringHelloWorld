package com.example.springhelloworld;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class SpringHelloWorldApplicationTests {

    @Test
    void triggerTest() {
        String one = "1";
        Assertions.assertThat(Integer.parseInt(one)).isEqualTo(1);
    }

}
