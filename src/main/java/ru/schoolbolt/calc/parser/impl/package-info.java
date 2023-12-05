/**
 * Реализация парсера математических выражений по представленной
 * ниже грамматике
 * <p />
 * <p>
 * <a href="https://en.wikipedia.org/wiki/Backus%E2%80%93Naur_form">BNF:</a>
 * </p>
 * <pre>
 * {@code <expr> ::= <term> + <expr> | <term> - <expr> | <term>}
 * {@code <term> ::= <factor> * <term> | <factor> / <term> | <factor>}
 * {@code <factor> ::= ( <expr> ) | <number>}
 * </pre>
 */
package ru.schoolbolt.calc.parser.impl;
