package org.mromichov.parser.nodes;

public class IntegerNode implements Node {
    public String value;

    public IntegerNode(String value) {
        this.value = value;
    }

    @Override
    public void info() {
//        System.out.println("----------------------");
//        System.out.println("Integer node. Value is " + value);
//        System.out.println("----------------------");
        System.out.print(value);
    }

    @Override
    public int evaluate() {
        return Integer.parseInt(value);
    }
}
