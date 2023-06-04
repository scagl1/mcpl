/*
 * Analisador Léxico MCPL
 * 
 */
package lexer;

import token.Token;
import token.TokenType;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AnLex {

    public AnLex(String input) {
        lex_Evaluate(input);
    }

    public AnLex() {}

    private Matcher matcher;

    private ArrayList<Token> tokens = new ArrayList<>();

    // RegExs da linguagem
    private final Pattern numero = Pattern.compile("\\d+");
    private final Pattern caractere = Pattern.compile("");

    // Operadores Aritméticos - +, -, *, /, <<
    private final Pattern soma = Pattern.compile("\\+");
    private final Pattern subtracao = Pattern.compile("-");
    private final Pattern multiplicacao = Pattern.compile("\\*");
    private final Pattern divisao = Pattern.compile("/");
    private final Pattern atribuicao = Pattern.compile("<<");

    // Operadores Lógicos - <, >, <=, >=, !=, ==, and, or, not
    private final Pattern menorque = Pattern.compile("<");
    private final Pattern maiorque = Pattern.compile(">");
    private final Pattern menorouigual = Pattern.compile("<=");
    private final Pattern maiorouigual = Pattern.compile(">=");
    private final Pattern diferentede = Pattern.compile("!=");
    private final Pattern equivalencia = Pattern.compile("==");
    private final Pattern and = Pattern.compile("and");
    private final Pattern or = Pattern.compile("or");
    private final Pattern not = Pattern.compile("not");

    // Tipos de dados - int, boolean, char, float
    private final Pattern intTipo = Pattern.compile("int");
    private final Pattern booleanTipo = Pattern.compile("boolean");
    private final Pattern charTipo = Pattern.compile("char");
    private final Pattern floatTipo = Pattern.compile("float");

    // Condicionais - compare, redtorch, sculk
    private final Pattern compare = Pattern.compile("compare");
    private final Pattern redtorch = Pattern.compile("redtorch");
    private final Pattern sculk = Pattern.compile("sculk");

    // Loop - repeater, hopper, observer-this
    private final Pattern repeater = Pattern.compile("repeater");
    private final Pattern hopper = Pattern.compile("hopper");
    private final Pattern observerthis = Pattern.compile("observerthis");

    private ArrayList<String> div_Substrings(String input) {
        ArrayList<String> strings_List = new ArrayList<>();

        // Definindo o padrão para dividir palavras por espaços e pontuações
        Pattern pattern = Pattern.compile("\\s");
        matcher = pattern.matcher(input);

        int start = 0;
        while (matcher.find()) {
            String token = input.substring(start, matcher.start());
            strings_List.add(token);
            start = matcher.end();
        }

        // Adicionando a última parte da string como um token
        if (start < input.length()) {
            String token = input.substring(start);
            strings_List.add(token);
        }

        return strings_List;
    }

    public ArrayList<Token> lex_Evaluate(String input) {
        ArrayList<String> subStrings = div_Substrings(input);

        for (String string : subStrings) { // Itera todas as substrings encontradas

            //verify_RegEx(string, TokenType.NUM, numero);
            //verify_RegEx(string, TokenType.NUM, caractere);

            // Operadores Aritméticos
            verify_RegEx(string, TokenType.ARITHM_OPERATOR, soma);
            verify_RegEx(string, TokenType.ARITHM_OPERATOR, subtracao);
            verify_RegEx(string, TokenType.ARITHM_OPERATOR, multiplicacao);
            verify_RegEx(string, TokenType.ARITHM_OPERATOR, divisao);
            verify_RegEx(string, TokenType.ARITHM_OPERATOR, atribuicao);

            // Operadores Lógicos
            verify_RegEx(string, TokenType.LOGIC_OPERATOR, menorque);
            verify_RegEx(string, TokenType.LOGIC_OPERATOR, maiorque);
            verify_RegEx(string, TokenType.LOGIC_OPERATOR, menorouigual);
            verify_RegEx(string, TokenType.LOGIC_OPERATOR, maiorouigual);
            verify_RegEx(string, TokenType.LOGIC_OPERATOR, diferentede);
            verify_RegEx(string, TokenType.LOGIC_OPERATOR, equivalencia);
            verify_RegEx(string, TokenType.LOGIC_OPERATOR, and);
            verify_RegEx(string, TokenType.LOGIC_OPERATOR, or);
            verify_RegEx(string, TokenType.LOGIC_OPERATOR, not);

            // Tipos de dados
            verify_RegEx(string, TokenType.DATATYPE, intTipo);
            verify_RegEx(string, TokenType.DATATYPE, booleanTipo);
            verify_RegEx(string, TokenType.DATATYPE, charTipo);
            verify_RegEx(string, TokenType.DATATYPE, floatTipo);

            // Condicionais
            verify_RegEx(string, TokenType.CONDITIONAL, compare);
            verify_RegEx(string, TokenType.CONDITIONAL, redtorch);
            verify_RegEx(string, TokenType.CONDITIONAL, sculk);

            // Loop
            verify_RegEx(string, TokenType.LOOP, repeater);
            verify_RegEx(string, TokenType.LOOP, hopper);
            verify_RegEx(string, TokenType.LOOP, observerthis);

        }

        tokens.add(new Token("EOF", TokenType.EOF));
        return tokens;
    }

    private void verify_RegEx(String string, TokenType tokenType, Pattern pattern) {
        matcher = pattern.matcher(string);

        while (matcher.find()) {
            String substring = string.substring(matcher.start(), matcher.end());
            tokens.add(new Token(substring, tokenType));
        }
    }
}
