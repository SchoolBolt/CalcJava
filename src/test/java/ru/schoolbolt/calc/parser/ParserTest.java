package ru.schoolbolt.calc.parser;

import org.junit.jupiter.api.Test;
import ru.schoolbolt.calc.expressions.Expression;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ParserTest {
    @Test
    void basicTest() throws Exception {
        Parser parser = new Parser("2 + 2 * 2");
        Expression expression = parser.parse();

        assertEquals(6, expression.calculate());
    }

    @Test
    void basicTest2() throws Exception {
        Parser parser = new Parser("(2 + 2) * 2");
        Expression expression = parser.parse();

        assertEquals(8, expression.calculate());
    }
}
