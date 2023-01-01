public class ParseMain {
    public static void main(String[] args) {
        try {
            ProjLangParser parser = new ProjLangParser(System.in);
            parser.input();
            System.out.println("Parse successful");
		} catch (Exception e) {
			System.out.println("Parse error:\n" + e.getMessage());
		} catch(TokenMgrError e) {
			System.out.println("Scan error:\n" + e.getMessage());
		}

	}
}