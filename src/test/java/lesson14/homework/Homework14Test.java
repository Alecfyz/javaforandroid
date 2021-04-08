package lesson14.homework;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import java.util.stream.Stream;


class Homework14Test {

    private Homework14 homework;

    @BeforeAll
    static void init() {
        System.out.println("Гдавное начало");
    }

    @AfterAll
    static void end() {
        System.out.println("Гдавное окнчание");
    }

    @BeforeEach
    void startup() {
        System.out.println("Hачало теста");
        homework = new Homework14();
    }

    @AfterEach
    void shutdown() {
        System.out.println("Окнчание теста");
    }

    @ParameterizedTest
    @MethodSource("dataset1")
    void paramTestcheckQuad(Integer[] expresArr1, Integer[] srcArr) {
        Assertions.assertArrayEquals(expresArr1, homework.checkQuad(srcArr));

    }

    static Stream<Arguments> dataset1() {
        return Stream.of(
                Arguments.arguments(new Integer[]{5, 6}, new Integer[]{1, 2, 2, 4, 64, 7, 9, 889, 3, 4, 5, 6}),  // correct
                Arguments.arguments(new Integer[]{}, new Integer[]{1, 2, 2, 64, 7, 9, 889, 3, 5, 6}),     // "4" absent
                Arguments.arguments(new Integer[]{}, new Integer[]{1, 2, 2, -4, 7, 9, 889, 3, 5, 6}),     // "4" is absent but "-4" is present
                Arguments.arguments(new Integer[]{9}, new Integer[]{1, 2, 2, 4, 9}),               // correct
                Arguments.arguments(new Integer[]{}, new Integer[]{1, 2, 3, 4}),                 // nothing after "4"
                Arguments.arguments(new Integer[]{99, 34, 24, 45, 55}, new Integer[]{1, 2, 2, 4, 5, -4, 4, 99, 34, 24, 45, 55}),  // negativ but numbers after "4"
                Arguments.arguments(new Integer[]{}, new Integer[]{1, 2, 2, 4, 5, -4, 4})              // negativ  & nothing after "4"
        );
    }

    @ParameterizedTest
    @MethodSource("dataset2")
    void paramTestcheckOneFourArr(boolean res, Integer[] srcArr) {
       Assertions.assertEquals(res, homework.checkOneFourArr(srcArr));

    }

    static Stream<Arguments> dataset2() {
        return Stream.of(
                Arguments.arguments(true, new Integer[]{1, 4, 4, 1, 1, 4, 1, 4, 1}),
                Arguments.arguments(false, new Integer[]{1, 1, 1, 1, 1, 1, 1}),
                Arguments.arguments(false, new Integer[]{4, 4, 4, 4, 4, 4}),
                Arguments.arguments(false, new Integer[]{4, 4, 1, 4, 1, 1, 1, 4, 1, 4, 2, 4})
        );
    }

}