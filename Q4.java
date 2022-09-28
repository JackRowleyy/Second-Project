import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
public class Q4 {
        public static String readFile2String(String fname) {
		String content = null;
		try {
			content = new String(Files.readAllBytes(Paths.get(fname)));
		} catch (IOException e) {
			System.out.println("Fail to read a file");
            
		}
        return content;
    }
        public static void scan(String fname){
            String  prog = readFile2String(fname);
            int n = prog.length();
            int index = 0;
            int lineNumber = 1; // line number
            while (index < n -1){
                char ch = prog.charAt(index);  // current character
                boolean whiteSpace = isWhiteSpace(ch); // boolean to indicate white space
                boolean newline = isLineBreak(ch); // boolean to indicate line break
                TokenType sym = getSymbol(ch); // symbol name or null
                TokenType op = getOp(ch);  // operator name or null
                boolean letter = isLetter(ch);  // boolean to indicate letter
                boolean digit = isDigit(ch);  // boolean to indicate digit whitespace
                char ch_next = prog.charAt(index + 1);
                if(whiteSpace) { // ch is white space
                    index ++;
                    continue;
                    }else if (newline) { // ch is new line
                        lineNumber ++;
                        index++;
                        continue;
                    }else if (sym != null) {
                        System.out.println(lineNumber + ", " + sym +", " + ch);
                        index ++;
                        
                        
                        continue;
                    
                    }else if (op != null || (ch == '!' && ch_next == '=') ) { // ch is an operator, had to include !&= as ! is not an op on its own
                        String symbol = "";
                        if ((ch == '!' && ch_next == '=') || (ch == '<' && ch_next == '=')|| (ch == '>' && ch_next == '=')){ 
                            symbol += ch; // makes a symbol such as <= or >=
                            index++;
                            ch = prog.charAt(index);
                            symbol+= ch;
                            index++;
                            
                            System.out.println(lineNumber + ", " + getOp(symbol) + ", " + symbol); // prints a double op
                            
                        }else {
                            System.out.println(lineNumber +  ", " +getOp(ch) + ", " + ch ); // prints a single op
                            index++;

                    }

                        
                        
                        
                         
                        continue;

                    }else if (letter) { // ch is a letter
                        String word = "";
                        word += ch;
                        index ++;
                        
                        while (isLetter(ch)) {  // use this while loop to identify e.g. the variable name
                            ch = prog.charAt(index);
                            if (isLetter(ch)) {
                                word += ch;
                                index ++;
                            }else {
                                
                                break;
                                
                        }

                    }
                    TokenType keyword = getKeyword(word);
                    TokenType hobbits = getHobbits(word);
                    if ( keyword != null){
                        System.out.println(lineNumber + ", " + keyword + ", " + word);
                        index ++;
                    }else if (hobbits != null){
                        System.out.println(lineNumber + ", " + hobbits + ", " + word);
                        index++;

                    } else {
                        System.out.println(lineNumber + ", " + TokenType.IDENTIFIER + ", "+ word );
                        index++;
                        continue;
                    }
                    continue;
                }else if (digit){
                    String number = "";
                    number += ch;
                    index ++;
                    while (isDigit(ch)){
                        ch = prog.charAt(index);
                        if (isDigit(ch)){
                            number += ch;
                            index++;
                        }else {break;}
                    }
                    System.out.println(lineNumber + ", " + TokenType.INTEGER + ", " + number);
                    continue;
                }else if (ch == '\"') { // the first double quotation of a string literal e.g., "hello world"
                    String str = "";
                    str += '\"';
                    index ++;
                    while (index < n){
                        ch = prog.charAt(index);
                        if (ch != '\"'){
                            str += ch;
                            index++;
                        }else if(ch == '\"'){
                            str += '\"';
                            index++;
                            break;
                        }
                        
                    }
                    System.out.println(lineNumber + ", " + TokenType.STRING + ", " + str);
                    continue;
            }else{
                System.out.println("Encountered something unexpected :" + ch);
                index++;
            }
            


    }
    
}
        public static TokenType getOp(char ch) {
            TokenType o = null;
            switch (ch) {
            case '+':
                o = TokenType.OP_ADD;
                break;
            case '-':
                o = TokenType.OP_SUBTRACT;
                break;
            case '*':
                o = TokenType.OP_MULTIPLY;
                break;
            case '/':
                o = TokenType.OP_DIVIDE;
                break;
            case '%':
                o = TokenType.OP_MOD;
                break;
            case '<':
                o = TokenType.OP_LESS;
                break;
            case '>':
                o = TokenType.OP_GREATER;
                break;
            case '=':
                o = TokenType.OP_ASSIGN;
                break;
    
            }
            return o;
        }
    
        public static TokenType getOp(String s) {
            TokenType str = null;
            switch (s) {
            case "<=":
                str = TokenType.OP_LESSEQUAL;
                break;
            case ">=":
                str = TokenType.OP_GREATEREQUAL;
                break;
            case "==":
                str = TokenType.OP_EQUAL;
                break;
            case "!=":
                str = TokenType.OP_NOTEQUAL;
                break;
    
            }
            return str;
        }
    
        public static TokenType getSymbol(char ch) {
            TokenType t = null;
            switch (ch) {
            case '(':
                t = TokenType.LEFT_PAREN;
                break;
            case ')':
                t = TokenType.RIGHT_PAREN;
                break;
            case '{':
                t = TokenType.LEFT_BRACE;
                break;
            case '}':
                t = TokenType.RIGHT_BRACE;
                break;
            case '[':
                t = TokenType.LEFT_BRACKET;
                break;
            case ']':
                t = TokenType.RIGHT_BRACKET;
                break;
            case ';':
                t = TokenType.SEMICOLON;
                break;
            case ',':
                t = TokenType.COMMA;
                break;
    
            }
            return t;
        }
    
        public static TokenType getKeyword(String s) {
            TokenType str = null;
            switch (s) {
            case "if":
                str = TokenType.KEYWORD_IF;
                break;
            case "else":
                str = TokenType.KEYWORD_ELSE;
                break;
            case "int":
                str = TokenType.KEYWORD_INT;
                break;
            case "String":
                str = TokenType.KEYWORD_STRING;
                break;
            case "public":
                str = TokenType.KEYWORD_PUBLIC;
                break;
            case "class":
                str = TokenType.KEYWORD_CLASS;
                break;
            case "void":
                str = TokenType.KEYWORD_VOID;
                break;
            case "static":
                str = TokenType.KEYWORD_STATIC;
                break;
            }
            return str;
        }
    
        public static TokenType getHobbits(String s) {
            TokenType str = null;
            switch (s) {
            case "HobbitsSay":
                str = TokenType.HOBBITS_SAY;
                break;
            case "HobbitsDo":
                str = TokenType.HOBBITS_DO;
                break;
            }
            return str;
    
        }
    
        public static boolean isLetter(char ch) {
            boolean b = Character.isLetter(ch);
            return b;
    
        }
    
        public static boolean isDigit(char ch) {
            boolean b = Character.isDigit(ch);
            return b;
        }
    
        public static boolean isWhiteSpace(char ch) {
            if (ch == ' ' || ch == '\t') return true;
            else return false;
        }
    
        public static boolean isLineBreak(char ch) {
            boolean b;
            if (ch == '\n'||ch == '\r' ) {
                b = true;
            } else {
                b = false;
            }
    
            return b;
        }
    
        public static void main(String[] args) {
            scan("src/WeeJavaExample.txt"); 
        }
    }
    

