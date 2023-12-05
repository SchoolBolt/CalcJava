package ru.schoolbolt.calc.expressions;

/**
 * Операция деления
 */
public class DivideOperation extends BinaryOperation {
    private static final double PRECISION = 1e-7;

    /**
     * Конструктор
     * Обычно наследуется без изменений в классах конкретных операций
     *
     * @param left  левый операнд
     * @param right правый операнд
     */
    public DivideOperation(Expression left, Expression right) {
        super(left, right);
    }

    /**
     * Метод вычисляет численное значение выражения
     *
     * @return значение выражения как вещественное число
     * @throws ArithmeticException если выражение не вычислимо по законам математики
     */
    @Override
    public double calculate() {
        double numerator = left.calculate();
        double denominator = right.calculate();
        if (Math.abs(denominator) < PRECISION) {
            throw new ArithmeticException("Division by zero");
        }
        return numerator / denominator;
    }
}
