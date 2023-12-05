package ru.schoolbolt.calc;

import ru.schoolbolt.calc.expressions.Expression;
import ru.schoolbolt.calc.parser.InvalidOperationException;
import ru.schoolbolt.calc.parser.Parser;
import ru.schoolbolt.calc.parser.ParserException;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Please, enter the mathematical expression containing floating point numbers, operations +, -, *, / or ():");
        System.out.print("> ");

        String input = scanner.nextLine();

        Parser parser = new Parser(input);

        try {
            Expression expression = parser.parse();
            System.out.println(expression.calculate());
        } catch (ParserException e) {
            System.out.println("Parser error: " + e.getMessage());
        } catch (ArithmeticException e) {
            System.out.println("Calculation error: " + e.getMessage());
        } catch (InvalidOperationException e) {
            System.out.println("Programmer error: " + e.getMessage());
            e.printStackTrace();
        } catch (Throwable e) {
            System.out.println("Unknown error: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
