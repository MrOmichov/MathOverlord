package org.mromichov.parser.nodes;

public class BinaryOpNode implements Node {
    public String op;
    public Node left;
    public Node right;

    public BinaryOpNode(String op, Node left, Node right) {
        this.op = op;
        this.left = left;
        this.right = right;
    }


    @Override
    public void info() {
        System.out.println("----------------------");
        System.out.println("Binary operation node");

        left.info();
        System.out.println();
        System.out.println(op);
        right.info();
        System.out.println();
        System.out.println("----------------------");
    }

    @Override
    public int evaluate() {
        return switch (op) {
            case "+" -> left.evaluate() + right.evaluate();
            case "-" -> left.evaluate() - right.evaluate();
            case "*" -> left.evaluate() * right.evaluate();
            case "/" -> left.evaluate() / right.evaluate();
            case "^" -> (int) Math.pow(left.evaluate(), right.evaluate());
            default -> 0;
        };
    }
}
