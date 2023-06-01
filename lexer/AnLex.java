/*
 * Analisador Léxico
 * 
 */
package lexer;
import java.util.ArrayList;
import token.Token;

public class AnLex {
    
    public ArrayList<Token> lex_evaluate (char[] expression) {
        ArrayList<Token> token_List = new ArrayList<>(); // Array de Tokens da cadeia de entrada
        ArrayList<Token> token_List_Output = new ArrayList<>(); // Array de Tokens de saída, considerando whitespaces
                                                                // como Tokens
        
        for (char c : expression) { // 
            if(Character.toString(c).matches("\\d")) {
                token_List.add(Token.NUM);
                token_List_Output.add(Token.NUM);
            } else if (Character.toString(c).matches("[+]|-|[*]|[//]")) {
                token_List.add(Token.ARITHM_OPERATOR);
                token_List_Output.add(Token.ARITHM_OPERATOR);
            } else if (Character.toString(c).matches("[><]")) {
                token_List.add(Token.LOGIC_OPERATOR);
                token_List_Output.add(Token.LOGIC_OPERATOR);
            } else if (Character.toString(c).matches("\\s")) {
                // Ignorar whitespaces em token_List
                token_List.add(Token.WHITESPACE);
            } else if (Character.toString(c).matches("[A-Za-z,`@#$%^&|=]")) {
                token_List.add(Token.CHAR);
                token_List_Output.add(Token.CHAR);
            } else if (Character.toString(c).matches("\\(")) {
                token_List.add(Token.PARENTHESIS_BEGIN);
                token_List_Output.add(Token.PARENTHESIS_BEGIN);
            } else if (Character.toString(c).matches("\\)")) {
                token_List.add(Token.PARENTHESIS_END);
                token_List_Output.add(Token.PARENTHESIS_END);
            } else if (Character.toString(c).matches("\\{")) {
                token_List.add(Token.SCOPE_BEGIN);
                token_List_Output.add(Token.SCOPE_BEGIN);
            } else if (Character.toString(c).matches("}")) {
                token_List.add(Token.SCOPE_END);
                token_List_Output.add(Token.SCOPE_END);
            } else if (Character.toString(c).matches(";")) {
                token_List.add(Token.END_INSTRUCTION);
                token_List_Output.add(Token.END_INSTRUCTION);
            } else {
                token_List.add(Token.ERROR);
                token_List_Output.add(Token.ERROR);
            }
        }

        token_List.add(Token.EOF); // Adição do Token "EOF" ao fim da lista de Tokens
        token_List_Output.add(Token.EOF);
        return token_List_Output;
    }
}
