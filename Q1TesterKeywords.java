public class Q1TesterKeywords {
	public static void main(String[] args) {
// List testing all keywords in WEEJAVA

		TokenType keyword1 = Q1.getKeyword("if");
		System.out.println("keyword: " + keyword1);

		TokenType keyword2 = Q1.getKeyword("else");
		System.out.println("keyword: " + keyword2);

		TokenType keyword3 = Q1.getKeyword("int");
		System.out.println("keyword: " + keyword3);

		TokenType keyword4 = Q1.getKeyword("String");
		System.out.println("keyword: " + keyword4);

		TokenType keyword5 = Q1.getKeyword("public");
		System.out.println("keyword: " + keyword5);

		TokenType keyword6 = Q1.getKeyword("class");
		System.out.println("keyword: " + keyword6);

		TokenType keyword7 = Q1.getKeyword("void");
		System.out.println("keyword: " + keyword7);

		TokenType keyword8 = Q1.getKeyword("static");
		System.out.println("keyword: " + keyword8);
	}
}
