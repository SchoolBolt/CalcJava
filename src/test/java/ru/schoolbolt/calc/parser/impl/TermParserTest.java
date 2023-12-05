package ru.schoolbolt.calc.parser.impl;

import org.junit.jupiter.api.Test;
import ru.schoolbolt.calc.expressions.*;
import ru.schoolbolt.calc.parser.ParserException;

import static org.junit.jupiter.api.Assertions.*;

class TermParserTest {
    @Test
    void givenSingleFactor_whenCalledParse_ReturnIt() throws Exception {
        SourceCursor source = new SourceCursor("42");
        SymbolParser parser = new TermParser();

        assertTrue(parser.isApplicable(source));

        Expression expr = parser.parse(source);

        assertInstanceOf(NumberExpression.class, expr);
        assertEquals(42, expr.calculate());
    }

    @Test
    void givenProductOfTwoFactors_whenCalledParse_ReturnIt() throws Exception {
        SourceCursor source = new SourceCursor("2 * 3");
        SymbolParser parser = new TermParser();

        assertTrue(parser.isApplicable(source));

        Expression expr = parser.parse(source);

        assertInstanceOf(MultiplyOperation.class, expr);
        assertEquals(6, expr.calculate());
    }

    @Test
    void givenQuotientOfTwoFactors_whenCalledParse_ReturnIt() throws Exception {
        SourceCursor source = new SourceCursor("6 / 2");
        SymbolParser parser = new TermParser();

        assertTrue(parser.isApplicable(source));

        Expression expr = parser.parse(source);

        assertInstanceOf(DivideOperation.class, expr);
        assertEquals(3, expr.calculate());
    }

    @Test
    void givenFactorAndAnotherTerm_whenCalledParse_ReturnIt() throws Exception {
        SourceCursor source = new SourceCursor("2 * 3 * 4");
        SymbolParser parser = new TermParser();

        assertTrue(parser.isApplicable(source));

        Expression expr = parser.parse(source);

        assertInstanceOf(MultiplyOperation.class, expr);
        assertEquals(24, expr.calculate());
    }

    @Test
    void givenFactorAndInvalidArgument_whenCalledParse_thenThrowException() {
        SourceCursor source = new SourceCursor("2 * abc");
        SymbolParser parser = new TermParser();

        assertTrue(parser.isApplicable(source));

        assertThrows(ParserException.class, () -> parser.parse(source));
    }

    @Test
    void givenFactorAndInvalidOperation_whenCalledParse_thenReturnOnlyFirstFactor() throws Exception {
        // remark: it's not TermParser's responsibility to throw exception here
        SourceCursor source = new SourceCursor("42 #");
        SymbolParser parser = new TermParser();

        assertTrue(parser.isApplicable(source));

        Expression expr = parser.parse(source);

        assertInstanceOf(NumberExpression.class, expr);
        assertEquals(42, expr.calculate());
    }
}