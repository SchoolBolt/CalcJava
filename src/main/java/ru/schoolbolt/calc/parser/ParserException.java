package ru.schoolbolt.calc.parser;

/**
 * Исключительная ситуация, описывающая ошибку разбора
 * математического выражения
 */
public class ParserException extends Exception {
    public ParserException(String message) {
        super(message);
    }
}
