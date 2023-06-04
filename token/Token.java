/*
 * Abstração de um Token da linguagem MCPL
 * 
 */
package token;

 public class Token {

    private String lexeme;
    private TokenType type;

    public Token (String lexeme, TokenType type) {
        this.lexeme = lexeme;
        this.type = type;
    }
    public Token (TokenType type) {
        this.type = type;
    }

    //Getters
    public String getLexeme() { return this.lexeme; }
    public TokenType getType() { return this.type; }

    public String toString() {
        return "[" + getLexeme() + ", " + getType() + "]";
    }

}

