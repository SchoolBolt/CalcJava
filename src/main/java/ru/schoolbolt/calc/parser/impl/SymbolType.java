package ru.schoolbolt.calc.parser.impl;

/**
 * Тип символа для разбора
 */
public enum SymbolType {
    /**
     * символ {@code <expr>}
     */
    EXPR(new ExprParser()),

    /**
     * символ {@code <term>}
     */
    TERM(new TermParser()),

    /**
     * символ {@code <factor>}
     */
    FACTOR(new FactorParser()),

    /**
     * символ {@code <number>}
     */
    NUMBER(new NumberParser());

    private final SymbolParser parser;

    SymbolType(SymbolParser parser) {
        this.parser = parser;
    }

    public SymbolParser getParser() {
        return parser;
    }
}
