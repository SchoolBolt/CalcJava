package ru.schoolbolt.calc.parser.impl;

/**
 * Класс-контейнер вспомогательных методов парсера
 */
public class ParserUtils {
    /**
     * Функция пропуска пробелов в исходной строке, начиная с указанной позиции
     *
     * @param source исходное математическое выражение
     */
    public static void skipSpaces(SourceCursor source) {
        while (!source.atEnd() && source.get() == ' ') source.next();
    }
}
