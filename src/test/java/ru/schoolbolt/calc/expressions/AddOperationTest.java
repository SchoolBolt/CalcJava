package ru.schoolbolt.calc.expressions;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AddOperationTest {
    @Test
    void givenAddOperation_whenCalledCalculate_thenReturnSumOfItsArguments() {
        Expression add = new AddOperation(
                new NumberExpression(2),
                new NumberExpression(3)
        );

        assertEquals(5, add.calculate());
    }
}
