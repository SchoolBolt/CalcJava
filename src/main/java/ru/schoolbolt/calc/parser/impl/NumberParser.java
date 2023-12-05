package ru.schoolbolt.calc.parser.impl;

import ru.schoolbolt.calc.expressions.Expression;
import ru.schoolbolt.calc.expressions.NumberExpression;
import ru.schoolbolt.calc.parser.InvalidOperationException;
import ru.schoolbolt.calc.parser.ParserException;

/**
 * Парсер символа {@code <number>} в представленной грамматике
 */
public class NumberParser implements SymbolParser {
    /**
     * Метод проверяет применим ли символ, разбираемый этим парсером,
     * к текущей позиции
     *
     * @param source исходное математическое выражение
     * @return истина, если символ применим, ложь -- в обратном случае
     */
    @Override
    public boolean isApplicable(SourceCursor source) {
        if (source.atEnd()) return false;
        return source.get() >= '0' && source.get() <= '9';
    }

    /**
     * Метод выполянет разбор исходной строки, начиная с указанной позиции
     * и заканчивая концом символа, разбираемого этим парсером
     *
     * @param source исходное математическое выражение
     * @return экземпляр Expression
     * @throws ParserException           в случае некорректного математического выражения
     * @throws InvalidOperationException в случае ошибки разработчика
     */
    @Override
    public Expression parse(SourceCursor source) throws ParserException, InvalidOperationException {
        int from = source.getPosition();

        while (isApplicable(source)) source.next();

        if (!source.atEnd() && source.get() == '.') {
            source.next();

            if (!isApplicable(source)) {
                throw new ParserException("Expected digit at " + source.getPosition());
            }

            while (isApplicable(source)) source.next();
        }

        double value = Double.parseDouble(source.getSubstring(from));
        return new NumberExpression(value);
    }
}
