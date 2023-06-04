/*
 * Main do código-fonte
 * 
 */

package main;

import lexer.*;
import token.*;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        String input = "int sculk < boolean > + - / *  << < repeater not and char float"; // Input teste
        ArrayList<Token> tokens = new AnLex().lex_Evaluate(input);

        System.out.println("{");
        for (Token token : tokens) {
            System.out.println(token.toString() + " ");
        }
        System.out.print("}");
    }
}
