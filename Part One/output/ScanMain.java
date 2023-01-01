public class ScanMain {
    public static void main(String[] args) {
    	SimpleCharStream cstream = new SimpleCharStream(System.in);
    	ProjLangParserTokenManager scanner = new ProjLangParserTokenManager(cstream);
    	try {
    		Token token = scanner.getNextToken();
			while (token.kind != ProjLangParserConstants.EOF) {
				String name = ProjLangParserConstants.tokenImage[token.kind];
				System.out.println("Token: " + name + " Lexeme: " + token.image);
				token = scanner.getNextToken();
			}
		} catch(TokenMgrError e) {
			System.out.println("Scan error:\n" + e.getMessage());
		}
	}
}
