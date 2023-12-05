package ru.schoolbolt.calc.parser;

/**
 * Исключительная ситуация, описывающая потенциальную
 * ошибку программиста
 */
public class InvalidOperationException extends Exception {
    public InvalidOperationException(String message) {
        super(message);
    }
}
