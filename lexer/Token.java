package lexer;

public class Token {

    // Tipos de Tokens da linguagem
    enum TokenType {
        NUM,
        OPERATOR,
        CONDITIONAL, // compare, redtorch, sculk
        LOOP, // repeater, hopper, observer-this
        CHAR,
        DATATYPE,
        VAR,
        ERROR,
        END_INSTRUCTION,
        EOF
    }

    private char lexeme;
    private TokenType type;
    
    public Token(char lexeme, TokenType type) {
        this.lexeme = lexeme;
        this.type = type;
    }

    //Getters
    public char getLexeme() { return this.lexeme; }
    public TokenType getType() { return this.type; }

}