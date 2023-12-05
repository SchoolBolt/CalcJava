package ru.schoolbolt.calc.parser.impl;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ParserUtilsTest {
    @Test
    void givenStringWith3Spaces_whenCalledSkipSpacesAtTheStartOfThem_thenAdvancePositionIn3() {
        SourceCursor source = new SourceCursor("0   4");
        source.next();
        ParserUtils.skipSpaces(source);

        assertEquals(4, source.getPosition());
        assertEquals('4', source.get());
    }

    @Test
    void givenStringWith1Space_whenCalledSkipSpacesAtIt_thenAdvancePositionIn1() {
        SourceCursor source = new SourceCursor("0 2");
        source.next();
        ParserUtils.skipSpaces(source);

        assertEquals(2, source.getPosition());
        assertEquals('2', source.get());
    }

    @Test
    void givenStringWithSpacesAtTheEnd_whenCalledSkipSpacesAtTheStartOfThem_thenAdvancePositionUntilTheEndAndNotThrowException() {
        SourceCursor source = new SourceCursor("0   ");
        source.next();
        ParserUtils.skipSpaces(source);

        assertTrue(source.atEnd());
    }

    @Test
    void givenStringWithNoSpaces_whenCalledSkipSpaces_thenDoNotAdvancePosition() {
        SourceCursor source = new SourceCursor("01234");
        source.next();
        ParserUtils.skipSpaces(source);

        assertEquals(1, source.getPosition());
        assertEquals('1', source.get());
    }
}
