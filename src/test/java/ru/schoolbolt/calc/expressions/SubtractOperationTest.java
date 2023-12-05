package ru.schoolbolt.calc.expressions;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SubtractOperationTest {
    @Test
    void givenSubtractOperation_whenCalledCalculate_thenReturnDifferenceBetweenItsArguments() {
        Expression sub = new SubtractOperation(
                new NumberExpression(3),
                new NumberExpression(2)
        );

        assertEquals(1, sub.calculate());
    }
}
