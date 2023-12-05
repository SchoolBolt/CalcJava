package ru.schoolbolt.calc.parser.impl;

import org.junit.jupiter.api.Test;
import ru.schoolbolt.calc.expressions.Expression;
import ru.schoolbolt.calc.expressions.NumberExpression;

import static org.junit.jupiter.api.Assertions.*;

class NumberParserTest {
    @Test
    void givenValidIntegerString_whenCalledParse_thenParseCorrectly() throws Exception {
        SourceCursor source = new SourceCursor("42");
        SymbolParser parser = new NumberParser();

        Expression expr = parser.parse(source);

        assertInstanceOf(NumberExpression.class, expr);
        assertEquals(42, expr.calculate());
    }

    @Test
    void givenValidFloatString_whenCalledParse_thenParseCorrectly() throws Exception {
        SourceCursor source = new SourceCursor("3.14");
        SymbolParser parser = new NumberParser();

        Expression expr = parser.parse(source);

        assertInstanceOf(NumberExpression.class, expr);
        assertEquals(3.14, expr.calculate());
    }

    @Test
    void givenNonValidString_whenCalledParse_thenThrowException() {
        SourceCursor source = new SourceCursor("abc");
        SymbolParser parser = new NumberParser();

        assertThrows(NumberFormatException.class, () -> parser.parse(source));
    }
}
