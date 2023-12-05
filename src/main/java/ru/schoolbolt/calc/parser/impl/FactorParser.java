package ru.schoolbolt.calc.parser.impl;

import ru.schoolbolt.calc.expressions.Expression;
import ru.schoolbolt.calc.parser.InvalidOperationException;
import ru.schoolbolt.calc.parser.ParserException;

/**
 * Парсер символа {@code <factor>} в представленной грамматике
 */
public class FactorParser implements SymbolParser {
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
        return source.get() == '(' || SymbolType.NUMBER.getParser().isApplicable(source);
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
        if (source.get() == '(') {
            SymbolParser exprParser = SymbolType.EXPR.getParser();

            source.next();
            ParserUtils.skipSpaces(source);

            if (!exprParser.isApplicable(source)) {
                throw new ParserException("Invalid expression at " + source.getPosition());
            }

            Expression expr = exprParser.parse(source);

            ParserUtils.skipSpaces(source);

            if (source.atEnd() || source.get() != ')') {
                throw new ParserException("Expected ) at " + source.getPosition());
            }

            source.next();

            return expr;
        }

        return SymbolType.NUMBER.getParser().parse(source);
    }
}
