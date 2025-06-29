package org.mromichov.lexer;

public class Token {
    public final TokenType tokenType;
    public final String contents;

    public Token(TokenType tokenType, String contents) {
        this.tokenType = tokenType;
        this.contents = contents;
    }

    @Override
    public String toString() {
        return tokenType.name() + " " + contents;
    }
}
