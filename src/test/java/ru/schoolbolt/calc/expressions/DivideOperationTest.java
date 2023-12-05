package ru.schoolbolt.calc.expressions;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DivideOperationTest {
    @Test
    void givenDivideOperationWithNonZeroDenominator_whenCalledCalculate_thenReturnQuotientOfItsArguments() {
        Expression expression = new DivideOperation(
                new NumberExpression(6),
                new NumberExpression(2)
        );

        assertEquals(3, expression.calculate());
    }

    @Test
    void givenDivideOperationWithZeroDenominator_whenCalledCalculte_thenThrowArithmeticException() {
        Expression expression = new DivideOperation(
                new NumberExpression(1),
                new NumberExpression(0)
        );

        assertThrows(ArithmeticException.class, expression::calculate);
    }
}
