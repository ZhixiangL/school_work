/*
 * Compiler.java
 *
 * A starting place for the unnamed language compiler for CSC 435/535
 *
 */

import org.antlr.runtime.*;
import java.io.*;
import AST.*;
import IR.*;

public class Compiler {
	public static void main (String[] args) throws Exception {
		ANTLRInputStream input;

		if (args.length == 0 ) {
			System.out.println("Usage: Compiler filename.ul");
			return;
		}
		else {
			input = new ANTLRInputStream(new FileInputStream(args[0]));
		}

		ulLexer lexer = new ulLexer(input);
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		ulParser parser = new ulParser(tokens);
		Program program = parser.program();
		try {
			program.accept(new TypeVisitor());
			TempVisitor tVisitor = new TempVisitor(args[0]);
			program.accept(tVisitor);
			IRProgram prog = tVisitor.program;
			System.out.println(prog);
		}
		catch (SemanticException e) {
			System.out.println(e);
			// e.printStackTrace();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
