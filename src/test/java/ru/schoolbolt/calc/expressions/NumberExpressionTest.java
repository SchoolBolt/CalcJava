package ru.schoolbolt.calc.expressions;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NumberExpressionTest {
    @Test
    void givenNumberExpression_whenCalledCalculate_thenReturnsItsValue() {
        Expression expression = new NumberExpression(12.345);

        assertEquals(12.345, expression.calculate());
    }
}
