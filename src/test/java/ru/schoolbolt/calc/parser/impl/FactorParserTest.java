package ru.schoolbolt.calc.parser.impl;

import org.junit.jupiter.api.Test;
import ru.schoolbolt.calc.expressions.AddOperation;
import ru.schoolbolt.calc.expressions.Expression;
import ru.schoolbolt.calc.expressions.NumberExpression;
import ru.schoolbolt.calc.parser.ParserException;

import static org.junit.jupiter.api.Assertions.*;

class FactorParserTest {
    @Test
    void givenSingleNumber_whenCalledParse_thenReturnIt() throws Exception {
        SourceCursor source = new SourceCursor("42");
        SymbolParser parser = new FactorParser();

        assertTrue(parser.isApplicable(source));

        Expression expr = parser.parse(source);

        assertInstanceOf(NumberExpression.class, expr);
        assertEquals(42, expr.calculate());
    }

    @Test
    void givenSingleNumberInBrackets_whenCalledParse_thenReturnIt() throws Exception {
        SourceCursor source = new SourceCursor("(42)");
        SymbolParser parser = new FactorParser();

        assertTrue(parser.isApplicable(source));

        Expression expr = parser.parse(source);

        assertInstanceOf(NumberExpression.class, expr);
        assertEquals(42, expr.calculate());
    }

    @Test
    void givenExprInBrackets_whenCalledParse_thenReturnIt() throws Exception {
        SourceCursor source = new SourceCursor("(2 + 3)");
        SymbolParser parser = new FactorParser();

        assertTrue(parser.isApplicable(source));

        Expression expr = parser.parse(source);

        assertInstanceOf(AddOperation.class, expr);
        assertEquals(5, expr.calculate());
    }

    @Test
    void givenUnbalancedBrackets_whenCalledParse_thenThrowException() {
        SourceCursor source = new SourceCursor("(2 + 3");
        SymbolParser parser = new FactorParser();

        assertTrue(parser.isApplicable(source));

        assertThrows(ParserException.class, () -> parser.parse(source));
    }

    @Test
    void givenInvalidExprInBrackets_whenCalledParse_thenThrowException() {
        SourceCursor source = new SourceCursor("(asd)");
        SymbolParser parser = new FactorParser();

        assertTrue(parser.isApplicable(source));

        assertThrows(ParserException.class, () -> parser.parse(source));
    }

    @Test
    void givenPaddedWithWhitespacesExprInBrackets_whenCalledParse_thenReturnIt() throws Exception {
        SourceCursor source = new SourceCursor("(   2 + 3  )");
        SymbolParser parser = new FactorParser();

        assertTrue(parser.isApplicable(source));

        Expression expr = parser.parse(source);

        assertInstanceOf(AddOperation.class, expr);
        assertEquals(5, expr.calculate());
    }
}
