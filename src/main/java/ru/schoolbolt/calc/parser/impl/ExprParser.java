package ru.schoolbolt.calc.parser.impl;

import ru.schoolbolt.calc.expressions.AddOperation;
import ru.schoolbolt.calc.expressions.Expression;
import ru.schoolbolt.calc.expressions.SubtractOperation;
import ru.schoolbolt.calc.parser.InvalidOperationException;
import ru.schoolbolt.calc.parser.ParserException;

/**
 * Парсер символа {@code <expr>} в представленной грамматике
 */
public class ExprParser implements SymbolParser {
    /**
     * Метод проверяет применим ли символ, разбираемый этим парсером,
     * к текущей позиции
     *
     * @param source исходное математическое выражение
     * @return истина, если символ применим, ложь -- в обратном случае
     */
    @Override
    public boolean isApplicable(SourceCursor source) {
        return SymbolType.TERM.getParser().isApplicable(source);
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
        SymbolParser termParser = SymbolType.TERM.getParser();
        SymbolParser exprParser = SymbolType.EXPR.getParser();

        Expression left = termParser.parse(source);
        ParserUtils.skipSpaces(source);

        if (source.atEnd()) return left;

        char operation = source.get();

        if (operation != '+' && operation != '-') return left;

        source.next();
        ParserUtils.skipSpaces(source);

        if (!exprParser.isApplicable(source)) {
            throw new ParserException("Invalid expression at " + source.getPosition());
        }

        Expression right = exprParser.parse(source);

        switch (operation) {
            case '+': return new AddOperation(left, right);
            case '-': return new SubtractOperation(left, right);
        }

        throw new InvalidOperationException("Invalid parser state");
    }
}
