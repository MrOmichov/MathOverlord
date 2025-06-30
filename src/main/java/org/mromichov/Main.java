package org.mromichov;

import org.mromichov.lexer.Lexer;
import org.mromichov.lexer.Token;
import org.mromichov.parser.Parser;
import org.mromichov.parser.nodes.Node;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Lexer lexer = new Lexer();
        List<Token> tokens = lexer.scan("6 * 3^2 * 2 - 1");
        for (var token : tokens) System.out.println(token);

        System.out.println();
        Parser parser = new Parser(tokens);
        Node root = parser.parse();
        root.info();

        System.out.println(root.evaluate());
        System.out.println(6 * 9 * 2 - 1);
    }


}