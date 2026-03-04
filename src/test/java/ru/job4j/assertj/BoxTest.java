package ru.job4j.assertj;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class BoxTest {

    @Test
    void isThisSphere() {
        Box box = new Box(0, 10);
        String name = box.whatsThis();
        assertThat(name).isEqualTo("Sphere");
        assertThat(name).startsWith("S");
        assertThat(name).contains("Sphere");
    }

    @Test
    void whenCubeThen8Vertices() {
        Box box = new Box(8, 5);
        int vertices = box.getNumberOfVertices();
        assertThat(vertices).isEqualTo(8);
        assertThat(vertices).isPositive();
        assertThat(vertices).isGreaterThan(4);
    }

    @Test
    void whenCubeThenExist() {
        Box box = new Box(8, 5);
        boolean exist = box.isExist();
        assertThat(exist).isTrue();
    }

    @Test
    void whenWrongFigureThenNotExist() {
        Box box = new Box(3, 5);
        boolean exist = box.isExist();
        assertThat(exist).isFalse();
    }

    @Test
    void whenCubeEdge2ThenArea24() {
        Box box = new Box(8, 2);
        double area = box.getArea();
        assertThat(area).isEqualTo(24);
        assertThat(area).isPositive();
        assertThat(area).isGreaterThan(10);
    }
}