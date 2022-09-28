public class Q1Tester {
	public static void main(String[] args) {
		// Testing getOp for TokenType results and null result
		TokenType op1 = Q1.getOp('-');
		System.out.println("op1: " + op1);

		TokenType op2 = Q1.getOp('a');
		System.out.println("op1: " + op2);
		// Testing getOp for TokenType String results and null result

		TokenType op3 = Q1.getOp(">=");
		System.out.println("op2: " + op3);

		TokenType op4 = Q1.getOp("a");
		System.out.println("op2: " + op4);
		// Testing getSymbol for TokenType symbol results and null result
		TokenType sym1 = Q1.getSymbol('}');
		System.out.println("symbol: " + sym1);

		TokenType sym2 = Q1.getSymbol('}');
		System.out.println("symbol: " + sym2);
		// Testing getHobbits for TokenType DO or SAY results and null result

		TokenType hobbits1 = Q1.getHobbits("HobbitsDo");
		System.out.println("hobbits: " + hobbits1);

		TokenType hobbits2 = Q1.getHobbits("HobbitDo");
		System.out.println("hobbits: " + hobbits2);
		// Testing isLetter for true or false

		boolean letter1 = Q1.isLetter('Z');
		System.out.println("letter: " + letter1);
		boolean letter2 = Q1.isLetter('3');
		System.out.println("letter: " + letter2);
		// Testing isDigit for true or false

		boolean digit1 = Q1.isDigit('1');
		System.out.println("digit: " + digit1);
		boolean digit2 = Q1.isDigit('z');
		System.out.println("digit: " + digit2);
		// Testing isWhiteSpace for true or false

		boolean whiteSpace1 = Q1.isWhiteSpace(' ');
		System.out.println("whiteSpace: " + whiteSpace1);
		boolean whiteSpace2 = Q1.isWhiteSpace('a');
		System.out.println("whiteSpace: " + whiteSpace2);
		// Testing isLineBreak for true or false

		boolean newline1 = Q1.isLineBreak('\n');
		System.out.println("newline: " + newline1);
		boolean newline2 = Q1.isLineBreak('n');
		System.out.println("newline: " + newline2);

	}
}
