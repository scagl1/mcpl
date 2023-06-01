package main;
import lexer.AnLex;

public class Main {
    public static void main(String[] args) {
        AnLex lexico = new AnLex();
        char[] cadeia = "ola, teste 5;".toCharArray();

        System.out.println(lexico.lex_evaluate(cadeia));
    }
}
