package org.mromichov.parser.nodes;

public class ErrorNode implements Node {
    private final String errorMessage;

    public ErrorNode(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    @Override
    public void info() {
        System.out.println("----------------------");
        System.out.println("Error, you stupid user");
        System.out.println(errorMessage);
        System.out.println("----------------------");
    }

    @Override
    public int evaluate() {
        return 1;
    }
}
