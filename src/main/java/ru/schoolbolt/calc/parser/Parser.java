package ru.schoolbolt.calc.parser;

import ru.schoolbolt.calc.expressions.Expression;
import ru.schoolbolt.calc.parser.impl.*;

/**
 * Класс разбора математического выражения как строки
 */
public class Parser {
    private final String source;

    /**
     * Конструктор
     *
     * @param source строка, содержащая математическое выражение
     */
    public Parser(String source) {
        this.source = source;
    }

    /**
     * Метод преобразует строку, переданную в конструктор,
     * в дерево операндов и возвращает указатель на корневой
     * элемент
     *
     * @return корневой элемент дерева операндов
     * @throws ParserException в случае некорректного математического выражения
     * @throws InvalidOperationException в случае ошибки разработчика
     *
     * @see Parser#Parser(String)
     */
    public Expression parse() throws ParserException, InvalidOperationException {
        SourceCursor cursor = new SourceCursor(source);

        ParserUtils.skipSpaces(cursor);

        SymbolParser exprParser = SymbolType.EXPR.getParser();
        if (!exprParser.isApplicable(cursor)) {
            throw new ParserException("Not a valid expression");
        }

        Expression result = exprParser.parse(cursor);

        ParserUtils.skipSpaces(cursor);

        if (!cursor.atEnd()) {
            throw new ParserException("Unexpected symbol at the end of expression at " + cursor.getPosition());
        }

        return result;
    }
}
