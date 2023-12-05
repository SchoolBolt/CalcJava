package ru.schoolbolt.calc.expressions;

/**
 * Операция сложения
 */
public class AddOperation extends BinaryOperation {
    /**
     * Конструктор
     * Обычно наследуется без изменений в классах конкретных операций
     *
     * @param left  левый операнд
     * @param right правый операнд
     */
    public AddOperation(Expression left, Expression right) {
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
        return left.calculate() + right.calculate();
    }
}
