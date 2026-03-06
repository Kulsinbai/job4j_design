package ru.job4j.assertj;

import org.assertj.core.data.Index;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

class SimpleConvertTest {
    @Test
    void checkArray() {
        SimpleConvert simpleConvert = new SimpleConvert();
        String[] array = simpleConvert.toArray("first", "second", "three", "four", "five");
        assertThat(array).hasSize(5)
                .contains("second")
                .contains("first", Index.atIndex(0))
                .containsAnyOf("zero", "second", "six")
                .doesNotContain("first", Index.atIndex(1));
    }

    @Test
    void checkList() {
        SimpleConvert simpleConvert = new SimpleConvert();
        List<String> list = simpleConvert.toList("first", "second", "three", "four", "five", "six");
        assertThat(list).isNotEmpty()
                .hasSize(6)
                .contains("five", "six", "second", "four")
                .containsExactly("first", "second", "three", "four", "five", "six")
                .containsExactlyInAnyOrder("six", "five", "four", "three", "second", "first")
                .startsWith("first", "second");
    }

    @Test
    void checkSet() {
        SimpleConvert simpleConvert = new SimpleConvert();
        Set<String> set = simpleConvert.toSet("first", "second", "second", "three", "six");
        assertThat(set).isNotEmpty()
                .contains("six", "three", "second")
                .containsExactlyInAnyOrder("first", "second", "three", "six")
                .doesNotContain("seven");
    }

    @Test
    void checkMap() {
        SimpleConvert simpleConvert = new SimpleConvert();
        Map<String, Integer> map = simpleConvert.toMap("first", "second", "three");
        assertThat(map).isNotEmpty()
                .hasSize(3)
                .containsKeys("first", "second", "three")
                .containsValues(0, 1, 2)
                .containsEntry("first", 0)
                .doesNotContainKey("six")
                .doesNotContainValue(4);
    }
}
