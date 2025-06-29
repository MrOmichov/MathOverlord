package org.mromichov.lexer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Lexer {
    private final Map<Character, TokenType> DESIGNATIONS = new HashMap<>();

    private int position = 0;
    private int inputLength = 0;

    public Lexer() {
        this.DESIGNATIONS.put('+', TokenType.PLUS);
        this.DESIGNATIONS.put('-', TokenType.MINUS);
        this.DESIGNATIONS.put('*', TokenType.STAR);
        this.DESIGNATIONS.put('/', TokenType.SLASH);
        this.DESIGNATIONS.put('(', TokenType.LPAREN);
        this.DESIGNATIONS.put(')', TokenType.RPAREN);
    }

    public List<Token> scan(String input) {
        inputLength = input.length();
        List<Token> tokens = new ArrayList<>();

        while (position < inputLength) {
            if (!Character.isWhitespace(input.charAt(position))) tokens.add(nextToken(input));
            else ++position;
        }

        tokens.add(new Token(TokenType.EOF, ""));
        return tokens;
    }

    private Token nextToken(String input) {
        if (Character.isDigit(input.charAt(position))) return nextInteger(input);
        else {
            ++position;
            return new Token(DESIGNATIONS.get(input.charAt(position - 1)), input.substring(position - 1, position));
        }
    }

    private Token nextInteger(String input) {
        StringBuilder builder = new StringBuilder();
        while (position < inputLength && Character.isDigit(input.charAt(position))) {
            builder.append(input.charAt(position));
            ++position;
        }

        return new Token(TokenType.INTEGER, builder.toString());
    }
}
