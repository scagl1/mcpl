package lexer;
import java.util.ArrayList;

public class AnLex {
    
    public ArrayList<Token.TokenType> lex_evaluate (char[] expression) {
        ArrayList<Token.TokenType> token_list = new ArrayList<>(); // Array de Tokens da expressão avaliada
        
        for (char c : expression) { // 
            if(Character.toString(c).matches("\\d")) {
                token_list.add(Token.TokenType.NUM);
            } else if (Character.toString(c).matches("\\+")) {
                token_list.add(Token.TokenType.OPERATOR);
            } else if (Character.toString(c).matches("-")) {
                token_list.add(Token.TokenType.OPERATOR);
            } else if (Character.toString(c).matches("\\s")) {
                // Ignorar whitespaces
            } else if (Character.toString(c).matches("[abcdefghijklmnopqrstuvwxyz,]")) {
                token_list.add(Token.TokenType.CHAR);
            } else if (Character.toString(c).matches("compare|redtorch|sculk")) { //todo
                token_list.add(Token.TokenType.CONDITIONAL);
            } else if (Character.toString(c).matches("repeater|hopper|observer-this")) { //todo
                token_list.add(Token.TokenType.LOOP);
            } else if (Character.toString(c).matches(";")) {
                token_list.add(Token.TokenType.END_INSTRUCTION);
            } else {
                token_list.add(Token.TokenType.ERROR);
            }
        }

        token_list.add(Token.TokenType.EOF); // Adição do EOF ao fim da lista de Tokens
        return token_list;
    }
}
