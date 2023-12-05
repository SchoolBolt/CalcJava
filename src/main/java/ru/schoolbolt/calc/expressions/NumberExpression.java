package ru.schoolbolt.calc.expressions;

/**
 * Числовая константа как математическое выражение
 */
public class NumberExpression implements Expression {
    private final double value;

    /**
     * Конструктор
     *
     * @param value значение числовой константы
     */
    public NumberExpression(double value) {
        this.value = value;
    }

    /**
     * Метод вычисляет численное значение выражения
     *
     * @return значение выражения как вещественное число
     * @throws ArithmeticException если выражение не вычислимо по законам математики
     */
    @Override
    public double calculate() {
        return value;
    }
}
