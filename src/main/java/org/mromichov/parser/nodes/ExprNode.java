package org.mromichov.parser.nodes;

import org.mromichov.lexer.Token;

public class ExprNode implements Node {
    public Node node;

    @Override
    public void info() {
        System.out.println("----------------------");
        System.out.println("Expression node");

        node.info();

        System.out.println("----------------------");
    }

    @Override
    public int evaluate() {
        return node.evaluate();
    }
}
