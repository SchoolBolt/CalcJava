package ru.schoolbolt.calc.parser.impl;

import ru.schoolbolt.calc.expressions.Expression;
import ru.schoolbolt.calc.parser.InvalidOperationException;
import ru.schoolbolt.calc.parser.ParserException;

/**
 * Парсер отдельного символа грамматики
 */
public interface SymbolParser {
    /**
     * Метод проверяет применим ли символ, разбираемый этим парсером,
     * к текущей позиции
     *
     * @param source исходное математическое выражение
     * @return истина, если символ применим, ложь -- в обратном случае
     */
    boolean isApplicable(SourceCursor source);

    /**
     * Метод выполянет разбор исходной строки, начиная с указанной позиции
     * и заканчивая концом символа, разбираемого этим парсером
     *
     * @param source исходное математическое выражение
     * @return экземпляр Expression
     * @throws ParserException в случае некорректного математического выражения
     * @throws InvalidOperationException в случае ошибки разработчика
     */
    Expression parse(SourceCursor source) throws ParserException, InvalidOperationException;
}
