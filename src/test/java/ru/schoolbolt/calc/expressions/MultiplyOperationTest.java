package ru.schoolbolt.calc.expressions;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MultiplyOperationTest {
    @Test
    void givenMultiplyOperation_whenCalledCalculate_thenReturnProductOfItsArguments() {
        Expression expression = new MultiplyOperation(
                new NumberExpression(2),
                new NumberExpression(3)
        );

        assertEquals(6, expression.calculate());
    }
}
