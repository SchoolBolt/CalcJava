package ru.schoolbolt.calc.expressions;

/**
 * Общий предок всех математических выражений
 */
public interface Expression {
    /**
     * Метод вычисляет численное значение выражения
     *
     * @return значение выражения как вещественное число
     * @throws ArithmeticException если выражение не вычислимо по законам математики
     */
    double calculate();
}
