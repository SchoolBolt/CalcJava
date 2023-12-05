package ru.schoolbolt.calc.parser.impl;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SourceCursorTest {
    @Test
    void givenFreshCursor_whenCalledGetPosition_thenReturn0() {
        SourceCursor source = new SourceCursor("012");

        assertEquals(0, source.getPosition());
        assertEquals('0', source.get());
    }

    @Test
    void givenCursor_whenCalledNext_thenAdvancesPositionBy1() {
        SourceCursor source = new SourceCursor("012");
        source.next();

        assertEquals(1, source.getPosition());
        assertEquals('1', source.get());
    }

    @Test
    void givenCursorWithPosition1BeforeEnd_whenCalledNext_thenAdvancesPositionToTheEnd() {
        SourceCursor source = new SourceCursor("012");
        source.next();
        source.next();
        source.next();

        assertTrue(source.atEnd());
        assertEquals(3, source.getPosition());
    }

    @Test
    void givenCursorAtEnd_whenCalledNext_thenStaysAtEndAndDoNotThrowExceptions() {
        SourceCursor source = new SourceCursor("012");
        source.next();
        source.next();
        source.next();
        source.next();

        assertTrue(source.atEnd());
        assertEquals(3, source.getPosition());
    }

    @Test
    void givenCursorAtEnd_whenCalledGet_thenThrowException() {
        SourceCursor source = new SourceCursor("012");
        source.next();
        source.next();
        source.next();

        assertThrows(StringIndexOutOfBoundsException.class, source::get);
    }

    @Test
    void givenCursorAtSomePosition_whenCalledGetSubstring_thenReturnCorrectSubstring() {
        SourceCursor source = new SourceCursor("0123456");
        for (int i = 0; i < 4; i++) {
            source.next();
        }

        assertEquals(4, source.getPosition());
        assertEquals('4', source.get());
        assertEquals("123", source.getSubstring(1));
    }
}
