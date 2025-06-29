package org.mromichov;

import org.mromichov.lexer.Lexer;
import org.mromichov.lexer.Token;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Lexer lexer = new Lexer();
        List<Token> tokens = lexer.scan("(123 * 345) - 58 / 100");
        for (var token : tokens) System.out.println(token);
    }
}