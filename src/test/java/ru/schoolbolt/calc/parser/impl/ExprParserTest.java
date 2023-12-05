package ru.schoolbolt.calc.parser.impl;

import org.junit.jupiter.api.Test;
import ru.schoolbolt.calc.expressions.AddOperation;
import ru.schoolbolt.calc.expressions.Expression;
import ru.schoolbolt.calc.expressions.NumberExpression;
import ru.schoolbolt.calc.expressions.SubtractOperation;
import ru.schoolbolt.calc.parser.ParserException;

import static org.junit.jupiter.api.Assertions.*;

class ExprParserTest {
    @Test
    void givenSingleTerm_whenCalledParse_ReturnIt() throws Exception {
        SourceCursor source = new SourceCursor("42");
        SymbolParser parser = new ExprParser();

        assertTrue(parser.isApplicable(source));

        Expression expr = parser.parse(source);

        assertInstanceOf(NumberExpression.class, expr);
        assertEquals(42, expr.calculate());
    }

    @Test
    void givenSumOfTwoTerms_whenCalledParse_ReturnIt() throws Exception {
        SourceCursor source = new SourceCursor("2 + 3");
        SymbolParser parser = new ExprParser();

        assertTrue(parser.isApplicable(source));

        Expression expr = parser.parse(source);

        assertInstanceOf(AddOperation.class, expr);
        assertEquals(5, expr.calculate());
    }

    @Test
    void givenDiffOfTwoTerms_whenCalledParse_ReturnIt() throws Exception {
        SourceCursor source = new SourceCursor("3 - 2");
        SymbolParser parser = new ExprParser();

        assertTrue(parser.isApplicable(source));

        Expression expr = parser.parse(source);

        assertInstanceOf(SubtractOperation.class, expr);
        assertEquals(1, expr.calculate());
    }

    @Test
    void givenTermAndAnotherExpr_whenCalledParse_ReturnIt() throws Exception {
        SourceCursor source = new SourceCursor("2 + 3 - 4");
        SymbolParser parser = new ExprParser();

        assertTrue(parser.isApplicable(source));

        Expression expr = parser.parse(source);

        assertInstanceOf(AddOperation.class, expr);
        assertEquals(1, expr.calculate());
    }

    @Test
    void givenTermAndInvalidArgument_whenCalledParse_thenThrowException() {
        SourceCursor source = new SourceCursor("2 + abc");
        SymbolParser parser = new ExprParser();

        assertTrue(parser.isApplicable(source));

        assertThrows(ParserException.class, () -> parser.parse(source));
    }

    @Test
    void givenTermAndInvalidOperation_whenCalledParse_thenReturnOnlyFirstTerm() throws Exception {
        // remark: it's not ExprParser's responsibility to throw exception here
        SourceCursor source = new SourceCursor("42 #");
        SymbolParser parser = new ExprParser();

        assertTrue(parser.isApplicable(source));

        Expression expr = parser.parse(source);

        assertInstanceOf(NumberExpression.class, expr);
        assertEquals(42, expr.calculate());
    }
}
