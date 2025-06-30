package org.mromichov.parser;

import org.mromichov.lexer.Token;
import org.mromichov.lexer.TokenType;
import org.mromichov.parser.nodes.BinaryOpNode;
import org.mromichov.parser.nodes.ErrorNode;
import org.mromichov.parser.nodes.IntegerNode;
import org.mromichov.parser.nodes.Node;

import java.util.List;

public class Parser {
    private final List<Token> tokens;
    private int position = 0;

    private Token current;


    public Parser(List<Token> tokens) {
        this.tokens = tokens;
        this.current = tokens.getFirst();
    }

    public Node parse() {
        Node root = parseExpr();
        return root;
    }

    private Node parseExpr() {
        Node node = parseTerm();

        while (current.tokenType == TokenType.PLUS || current.tokenType == TokenType.MINUS) {
            String operator = current.contents;
            next();
            node = new BinaryOpNode(operator, node, parseTerm());
        }
        return node;
    }

    private Node parseTerm() {
        Node node = parseFactor();

        while (current.tokenType == TokenType.STAR || current.tokenType == TokenType.SLASH) {
            String operator = current.contents;
            next();
            node = new BinaryOpNode(operator, node, parseFactor());
        }
        return node;
    }

    private Node parseFactor() {
        Node node;
        if (current.tokenType == TokenType.INTEGER) {
            node = new IntegerNode(current.contents);
            next();
        } else if (current.tokenType == TokenType.LPAREN) {
            next();
            node = parseExpr();
            next();
            // TODO Обработать правую скобку
        } else node = new ErrorNode("Error while parsing factor");

        if (current.tokenType == TokenType.CARET) {
            next();
            node = new BinaryOpNode("^", node, parseFactor());
        }

        return node;
    }

    private void next() {
        ++position;
        current = tokens.get(position);
    }
}
