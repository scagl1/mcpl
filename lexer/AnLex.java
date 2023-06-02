/*
 * Analisador Léxico
 * 
 */
package lexer;
import java.util.ArrayList;
import token.*;

public class AnLex {

    //
    public ArrayList<Token> lex_Evaluate(char[] expression) {
        ArrayList<Token> token_List = new ArrayList<>();    // Array de Tokens da cadeia de entrada, CONSIDERANDO
                                                            // whitespaces como Tokens

        for (char c : expression) { // 
            if (Character.toString(c).matches("\\d")) {
                token_List.add(new Token(c, TokenType.NUM));
            } else if (Character.toString(c).matches("[+]|-|[*]|[//]")) {
                token_List.add(new Token(c, TokenType.ARITHM_OPERATOR));
            } else if (Character.toString(c).matches("[><]")) {
                token_List.add(new Token(c, TokenType.LOGIC_OPERATOR));
            } else if (Character.toString(c).matches("\\s")) {
                token_List.add(new Token(c, TokenType.WHITESPACE));
            } else if (Character.toString(c).matches("[A-Za-z,`!?@#$%^&|=]")) {
                token_List.add(new Token(c, TokenType.CHAR));
            } else if (Character.toString(c).matches("\\(")) {
                token_List.add(new Token(c, TokenType.PARENTHESIS_BEGIN));
            } else if (Character.toString(c).matches("\\)")) {
                token_List.add(new Token(c, TokenType.PARENTHESIS_END));
            } else if (Character.toString(c).matches("\\{")) {
                token_List.add(new Token(c, TokenType.SCOPE_BEGIN));
            } else if (Character.toString(c).matches("}")) {
                token_List.add(new Token(c, TokenType.SCOPE_END));
            } else if (Character.toString(c).matches(";")) {
                token_List.add(new Token(c, TokenType.END_INSTRUCTION));
            } else {
                token_List.add(new Token(c, TokenType.ERROR));
            }
        }

        token_List.add(new Token(TokenType.EOF)); // Adição do Token "EOF" ao fim da lista de Tokens

        return lex_Evaluate_Strings(token_List);
    }
}
