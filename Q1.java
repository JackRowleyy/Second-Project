public class Q1 {
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
		TokenType op1 = getOp('+');
		System.out.println("op1: " + op1);

		TokenType op2 = getOp("==");
		System.out.println("op2: " + op2);

		TokenType sym = getSymbol('{');
		System.out.println("symbol: " + sym);

		TokenType keyword = getKeyword("int");
		System.out.println("keyword: " + keyword);

		TokenType hobbits = getHobbits("HobbitsSay");
		System.out.println("hobbits: " + hobbits);

		boolean letter = isLetter('a');
		System.out.println("letter: " + letter);

		boolean digit = isDigit('0');
		System.out.println("digit: " + digit);

		boolean whiteSpace = isWhiteSpace(' ');
		System.out.println("whiteSpace: " + whiteSpace);

		boolean newline = isLineBreak('\n');
		System.out.println("newline: " + newline);

	}
}
