import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Q3 {


	public static String readFile(String fname) {
		String content = null;
		try {
			content = new String(Files.readAllBytes(Paths.get(fname)));
		} catch (IOException e) {
			System.out.println("Fail to read a file");
		}
		
		
		
		
		return content;

	}
	public static String scan(String fname){
		String text = readFile(fname);
		int n = text.length();
		int index = 0;
		while (index<n){
			char ch = text.charAt(index); // current character
			char ch_next = ' '; // next character
			
			if (index<n-1) ch_next = text.charAt(index+1);
			if (ch == '/' && ch_next == '/' ){
				while (ch != '\n'){
					index ++; //ignore characters
					ch = text.charAt(index);
				}
			}
			if(ch == '/' && ch_next == '*'){
				index ++;
				ch = text.charAt(index);
				while (ch != '/' && ch_next != ' ' ){
					
					index ++; //ignore characters
					ch = text.charAt(index );
					
				}
				index ++; //ignore characters
				ch = text.charAt(index );
			}	

		
			
			System.out.print(ch);
			index ++;
			
		
		
		}	
		return text;
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
			t = TokenType.RIGHT_BRACE;
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
		boolean b = Character.isWhitespace(ch);
		return b;
	}

	public static boolean isLineBreak(char ch) {
		boolean b;
		if (ch == '\n') {
			b = true;
		} else {
			b = false;
		}

		return b;
	}


	public static void main(String[] args) {
		System.out.println("## Q3Example1:");
		scan("src/Q3Example1.txt");

		
		System.out.println("\n## Q3Example2:");
		scan("src/Q3Example2.txt");

	
	}
}
