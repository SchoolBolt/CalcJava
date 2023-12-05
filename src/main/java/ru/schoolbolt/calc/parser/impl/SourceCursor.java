package ru.schoolbolt.calc.parser.impl;

/**
 * Курсор по строке с исходным математическим выражением
 */
public class SourceCursor {
    private final String source;
    private int position;

    /**
     * Конструктор
     * Выставляет текущую позицию курсора в 0
     *
     * @param source строка с исходным математическим выражением
     */
    public SourceCursor(String source) {
        this.source = source;
        this.position = 0;
    }

    /**
     * Метод для получения текущего символа под курсором
     *
     * @return текущий символ
     */
    public char get() {
        return source.charAt(position);
    }

    /**
     * Метод для получения текущей позиции
     *
     * @return текущая позиция
     */
    public int getPosition() {
        return position;
    }

    /**
     * Метод для получения подстроки, начиная с указанной
     * позиции и заканчивая текущей (не включительно)
     *
     * @param from начальная позиция
     * @return подстрока
     */
    public String getSubstring(int from) {
        return source.substring(from, position);
    }

    /**
     * Метод сдвигает курсор к следующему символу, если
     * не достигнут конец строки
     */
    public void next() {
        if (!atEnd()) position++;
    }

    /**
     * Метод проверяает, достигнут ли конец строки
     *
     * @return истина, если конец строки достигнут, ложь -- в обратном случае
     */
    public boolean atEnd() {
        return this.position >= source.length();
    }
}
