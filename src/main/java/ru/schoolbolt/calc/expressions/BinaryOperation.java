package ru.schoolbolt.calc.expressions;

/**
 * Общий предок для бинарных операторов
 */
public abstract class BinaryOperation implements Expression {
    protected final Expression left;
    protected final Expression right;

    /**
     * Конструктор
     * Обычно наследуется без изменений в классах конкретных операций
     *
     * @param left  левый операнд
     * @param right правый операнд
     */
    public BinaryOperation(Expression left, Expression right) {
        this.left = left;
        this.right = right;
    }
}
