// $ANTLR 3.5.2 ul.g 2021-06-10 14:20:15

import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class ulLexer extends Lexer {
	public static final int EOF=-1;
	public static final int CBRACE=4;
	public static final int CBRACKET=5;
	public static final int CHARACTERCONSTANT=6;
	public static final int COMMA=7;
	public static final int COMMENT=8;
	public static final int CPARENTHESES=9;
	public static final int DOUBLEEQUAL=10;
	public static final int ELSE=11;
	public static final int EQUAL=12;
	public static final int FALSE=13;
	public static final int FLOATCONSTANT=14;
	public static final int ID=15;
	public static final int IF=16;
	public static final int INTEGERCONSTANT=17;
	public static final int LESSTHAN=18;
	public static final int MINUS=19;
	public static final int MULTIPLY=20;
	public static final int OBRACE=21;
	public static final int OBRACKET=22;
	public static final int OPARENTHESES=23;
	public static final int PLUS=24;
	public static final int PRINT=25;
	public static final int PRINTLN=26;
	public static final int RETURN=27;
	public static final int SEMICOLON=28;
	public static final int STRINGCONSTANT=29;
	public static final int TRUE=30;
	public static final int TYPE=31;
	public static final int WHILE=32;
	public static final int WS=33;

	// delegates
	// delegators
	public Lexer[] getDelegates() {
		return new Lexer[] {};
	}

	public ulLexer() {} 
	public ulLexer(CharStream input) {
		this(input, new RecognizerSharedState());
	}
	public ulLexer(CharStream input, RecognizerSharedState state) {
		super(input,state);
	}
	@Override public String getGrammarFileName() { return "ul.g"; }

	// $ANTLR start "IF"
	public final void mIF() throws RecognitionException {
		try {
			int _type = IF;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// ul.g:369:4: ( 'if' )
			// ul.g:369:6: 'if'
			{
			match("if"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "IF"

	// $ANTLR start "ELSE"
	public final void mELSE() throws RecognitionException {
		try {
			int _type = ELSE;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// ul.g:372:9: ( 'else' )
			// ul.g:372:11: 'else'
			{
			match("else"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "ELSE"

	// $ANTLR start "TRUE"
	public final void mTRUE() throws RecognitionException {
		try {
			int _type = TRUE;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// ul.g:375:9: ( 'true' )
			// ul.g:375:11: 'true'
			{
			match("true"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "TRUE"

	// $ANTLR start "FALSE"
	public final void mFALSE() throws RecognitionException {
		try {
			int _type = FALSE;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// ul.g:378:9: ( 'false' )
			// ul.g:378:11: 'false'
			{
			match("false"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "FALSE"

	// $ANTLR start "WHILE"
	public final void mWHILE() throws RecognitionException {
		try {
			int _type = WHILE;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// ul.g:381:9: ( 'while' )
			// ul.g:381:11: 'while'
			{
			match("while"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "WHILE"

	// $ANTLR start "PRINT"
	public final void mPRINT() throws RecognitionException {
		try {
			int _type = PRINT;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// ul.g:384:9: ( 'print' )
			// ul.g:384:11: 'print'
			{
			match("print"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "PRINT"

	// $ANTLR start "PRINTLN"
	public final void mPRINTLN() throws RecognitionException {
		try {
			int _type = PRINTLN;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// ul.g:387:9: ( 'println' )
			// ul.g:387:11: 'println'
			{
			match("println"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "PRINTLN"

	// $ANTLR start "RETURN"
	public final void mRETURN() throws RecognitionException {
		try {
			int _type = RETURN;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// ul.g:390:9: ( 'return' )
			// ul.g:390:11: 'return'
			{
			match("return"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "RETURN"

	// $ANTLR start "OPARENTHESES"
	public final void mOPARENTHESES() throws RecognitionException {
		try {
			int _type = OPARENTHESES;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// ul.g:393:14: ( '(' )
			// ul.g:393:16: '('
			{
			match('('); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "OPARENTHESES"

	// $ANTLR start "CPARENTHESES"
	public final void mCPARENTHESES() throws RecognitionException {
		try {
			int _type = CPARENTHESES;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// ul.g:396:14: ( ')' )
			// ul.g:396:16: ')'
			{
			match(')'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "CPARENTHESES"

	// $ANTLR start "OBRACKET"
	public final void mOBRACKET() throws RecognitionException {
		try {
			int _type = OBRACKET;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// ul.g:399:10: ( '[' )
			// ul.g:399:12: '['
			{
			match('['); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "OBRACKET"

	// $ANTLR start "CBRACKET"
	public final void mCBRACKET() throws RecognitionException {
		try {
			int _type = CBRACKET;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// ul.g:402:10: ( ']' )
			// ul.g:402:12: ']'
			{
			match(']'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "CBRACKET"

	// $ANTLR start "OBRACE"
	public final void mOBRACE() throws RecognitionException {
		try {
			int _type = OBRACE;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// ul.g:405:8: ( '{' )
			// ul.g:405:10: '{'
			{
			match('{'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "OBRACE"

	// $ANTLR start "CBRACE"
	public final void mCBRACE() throws RecognitionException {
		try {
			int _type = CBRACE;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// ul.g:408:8: ( '}' )
			// ul.g:408:10: '}'
			{
			match('}'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "CBRACE"

	// $ANTLR start "SEMICOLON"
	public final void mSEMICOLON() throws RecognitionException {
		try {
			int _type = SEMICOLON;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// ul.g:411:11: ( ';' )
			// ul.g:411:13: ';'
			{
			match(';'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "SEMICOLON"

	// $ANTLR start "COMMA"
	public final void mCOMMA() throws RecognitionException {
		try {
			int _type = COMMA;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// ul.g:414:10: ( ',' )
			// ul.g:414:12: ','
			{
			match(','); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "COMMA"

	// $ANTLR start "EQUAL"
	public final void mEQUAL() throws RecognitionException {
		try {
			int _type = EQUAL;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// ul.g:417:9: ( '=' )
			// ul.g:417:11: '='
			{
			match('='); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "EQUAL"

	// $ANTLR start "DOUBLEEQUAL"
	public final void mDOUBLEEQUAL() throws RecognitionException {
		try {
			int _type = DOUBLEEQUAL;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// ul.g:420:13: ( '==' )
			// ul.g:420:15: '=='
			{
			match("=="); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "DOUBLEEQUAL"

	// $ANTLR start "LESSTHAN"
	public final void mLESSTHAN() throws RecognitionException {
		try {
			int _type = LESSTHAN;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// ul.g:423:10: ( '<' )
			// ul.g:423:12: '<'
			{
			match('<'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "LESSTHAN"

	// $ANTLR start "PLUS"
	public final void mPLUS() throws RecognitionException {
		try {
			int _type = PLUS;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// ul.g:426:9: ( '+' )
			// ul.g:426:10: '+'
			{
			match('+'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "PLUS"

	// $ANTLR start "MINUS"
	public final void mMINUS() throws RecognitionException {
		try {
			int _type = MINUS;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// ul.g:429:9: ( '-' )
			// ul.g:429:11: '-'
			{
			match('-'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "MINUS"

	// $ANTLR start "MULTIPLY"
	public final void mMULTIPLY() throws RecognitionException {
		try {
			int _type = MULTIPLY;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// ul.g:432:10: ( '*' )
			// ul.g:432:12: '*'
			{
			match('*'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "MULTIPLY"

	// $ANTLR start "TYPE"
	public final void mTYPE() throws RecognitionException {
		try {
			int _type = TYPE;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// ul.g:436:6: ( 'int' | 'float' | 'char' | 'string' | 'boolean' | 'void' )
			int alt1=6;
			switch ( input.LA(1) ) {
			case 'i':
				{
				alt1=1;
				}
				break;
			case 'f':
				{
				alt1=2;
				}
				break;
			case 'c':
				{
				alt1=3;
				}
				break;
			case 's':
				{
				alt1=4;
				}
				break;
			case 'b':
				{
				alt1=5;
				}
				break;
			case 'v':
				{
				alt1=6;
				}
				break;
			default:
				NoViableAltException nvae =
					new NoViableAltException("", 1, 0, input);
				throw nvae;
			}
			switch (alt1) {
				case 1 :
					// ul.g:436:8: 'int'
					{
					match("int"); 

					}
					break;
				case 2 :
					// ul.g:437:13: 'float'
					{
					match("float"); 

					}
					break;
				case 3 :
					// ul.g:438:13: 'char'
					{
					match("char"); 

					}
					break;
				case 4 :
					// ul.g:439:13: 'string'
					{
					match("string"); 

					}
					break;
				case 5 :
					// ul.g:440:13: 'boolean'
					{
					match("boolean"); 

					}
					break;
				case 6 :
					// ul.g:441:13: 'void'
					{
					match("void"); 

					}
					break;

			}
			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "TYPE"

	// $ANTLR start "INTEGERCONSTANT"
	public final void mINTEGERCONSTANT() throws RecognitionException {
		try {
			int _type = INTEGERCONSTANT;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// ul.g:449:17: ( ( ( '1' .. '9' ) ( '0' .. '9' )* | '0' ) )
			// ul.g:449:19: ( ( '1' .. '9' ) ( '0' .. '9' )* | '0' )
			{
			// ul.g:449:19: ( ( '1' .. '9' ) ( '0' .. '9' )* | '0' )
			int alt3=2;
			int LA3_0 = input.LA(1);
			if ( ((LA3_0 >= '1' && LA3_0 <= '9')) ) {
				alt3=1;
			}
			else if ( (LA3_0=='0') ) {
				alt3=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 3, 0, input);
				throw nvae;
			}

			switch (alt3) {
				case 1 :
					// ul.g:449:20: ( '1' .. '9' ) ( '0' .. '9' )*
					{
					if ( (input.LA(1) >= '1' && input.LA(1) <= '9') ) {
						input.consume();
					}
					else {
						MismatchedSetException mse = new MismatchedSetException(null,input);
						recover(mse);
						throw mse;
					}
					// ul.g:449:30: ( '0' .. '9' )*
					loop2:
					while (true) {
						int alt2=2;
						int LA2_0 = input.LA(1);
						if ( ((LA2_0 >= '0' && LA2_0 <= '9')) ) {
							alt2=1;
						}

						switch (alt2) {
						case 1 :
							// ul.g:
							{
							if ( (input.LA(1) >= '0' && input.LA(1) <= '9') ) {
								input.consume();
							}
							else {
								MismatchedSetException mse = new MismatchedSetException(null,input);
								recover(mse);
								throw mse;
							}
							}
							break;

						default :
							break loop2;
						}
					}

					}
					break;
				case 2 :
					// ul.g:449:44: '0'
					{
					match('0'); 
					}
					break;

			}

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "INTEGERCONSTANT"

	// $ANTLR start "STRINGCONSTANT"
	public final void mSTRINGCONSTANT() throws RecognitionException {
		try {
			int _type = STRINGCONSTANT;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// ul.g:452:15: ( '\\u0022' ( 'a' .. 'z' | 'A' .. 'Z' | ' ' | '0' .. '9' | '!' | ',' | '.' | ':' | '_' | '{' | '}' )+ '\\u0022' )
			// ul.g:452:17: '\\u0022' ( 'a' .. 'z' | 'A' .. 'Z' | ' ' | '0' .. '9' | '!' | ',' | '.' | ':' | '_' | '{' | '}' )+ '\\u0022'
			{
			match('\"'); 
			// ul.g:452:26: ( 'a' .. 'z' | 'A' .. 'Z' | ' ' | '0' .. '9' | '!' | ',' | '.' | ':' | '_' | '{' | '}' )+
			int cnt4=0;
			loop4:
			while (true) {
				int alt4=2;
				int LA4_0 = input.LA(1);
				if ( ((LA4_0 >= ' ' && LA4_0 <= '!')||LA4_0==','||LA4_0=='.'||(LA4_0 >= '0' && LA4_0 <= ':')||(LA4_0 >= 'A' && LA4_0 <= 'Z')||LA4_0=='_'||(LA4_0 >= 'a' && LA4_0 <= '{')||LA4_0=='}') ) {
					alt4=1;
				}

				switch (alt4) {
				case 1 :
					// ul.g:
					{
					if ( (input.LA(1) >= ' ' && input.LA(1) <= '!')||input.LA(1)==','||input.LA(1)=='.'||(input.LA(1) >= '0' && input.LA(1) <= ':')||(input.LA(1) >= 'A' && input.LA(1) <= 'Z')||input.LA(1)=='_'||(input.LA(1) >= 'a' && input.LA(1) <= '{')||input.LA(1)=='}' ) {
						input.consume();
					}
					else {
						MismatchedSetException mse = new MismatchedSetException(null,input);
						recover(mse);
						throw mse;
					}
					}
					break;

				default :
					if ( cnt4 >= 1 ) break loop4;
					EarlyExitException eee = new EarlyExitException(4, input);
					throw eee;
				}
				cnt4++;
			}

			match('\"'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "STRINGCONSTANT"

	// $ANTLR start "FLOATCONSTANT"
	public final void mFLOATCONSTANT() throws RecognitionException {
		try {
			int _type = FLOATCONSTANT;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// ul.g:455:14: ( ( ( '1' .. '9' ) ( '0' .. '9' )* | '0' ) '.' ( '0' .. '9' )+ )
			// ul.g:455:16: ( ( '1' .. '9' ) ( '0' .. '9' )* | '0' ) '.' ( '0' .. '9' )+
			{
			// ul.g:455:16: ( ( '1' .. '9' ) ( '0' .. '9' )* | '0' )
			int alt6=2;
			int LA6_0 = input.LA(1);
			if ( ((LA6_0 >= '1' && LA6_0 <= '9')) ) {
				alt6=1;
			}
			else if ( (LA6_0=='0') ) {
				alt6=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 6, 0, input);
				throw nvae;
			}

			switch (alt6) {
				case 1 :
					// ul.g:455:17: ( '1' .. '9' ) ( '0' .. '9' )*
					{
					if ( (input.LA(1) >= '1' && input.LA(1) <= '9') ) {
						input.consume();
					}
					else {
						MismatchedSetException mse = new MismatchedSetException(null,input);
						recover(mse);
						throw mse;
					}
					// ul.g:455:27: ( '0' .. '9' )*
					loop5:
					while (true) {
						int alt5=2;
						int LA5_0 = input.LA(1);
						if ( ((LA5_0 >= '0' && LA5_0 <= '9')) ) {
							alt5=1;
						}

						switch (alt5) {
						case 1 :
							// ul.g:
							{
							if ( (input.LA(1) >= '0' && input.LA(1) <= '9') ) {
								input.consume();
							}
							else {
								MismatchedSetException mse = new MismatchedSetException(null,input);
								recover(mse);
								throw mse;
							}
							}
							break;

						default :
							break loop5;
						}
					}

					}
					break;
				case 2 :
					// ul.g:455:41: '0'
					{
					match('0'); 
					}
					break;

			}

			match('.'); 
			// ul.g:455:50: ( '0' .. '9' )+
			int cnt7=0;
			loop7:
			while (true) {
				int alt7=2;
				int LA7_0 = input.LA(1);
				if ( ((LA7_0 >= '0' && LA7_0 <= '9')) ) {
					alt7=1;
				}

				switch (alt7) {
				case 1 :
					// ul.g:
					{
					if ( (input.LA(1) >= '0' && input.LA(1) <= '9') ) {
						input.consume();
					}
					else {
						MismatchedSetException mse = new MismatchedSetException(null,input);
						recover(mse);
						throw mse;
					}
					}
					break;

				default :
					if ( cnt7 >= 1 ) break loop7;
					EarlyExitException eee = new EarlyExitException(7, input);
					throw eee;
				}
				cnt7++;
			}

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "FLOATCONSTANT"

	// $ANTLR start "CHARACTERCONSTANT"
	public final void mCHARACTERCONSTANT() throws RecognitionException {
		try {
			int _type = CHARACTERCONSTANT;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// ul.g:458:18: ( '\\u0027' ( 'a' .. 'z' | 'A' .. 'Z' | ' ' | '0' .. '9' | '!' | ',' | '.' | ':' | '_' | '{' | '}' ) '\\u0027' )
			// ul.g:458:20: '\\u0027' ( 'a' .. 'z' | 'A' .. 'Z' | ' ' | '0' .. '9' | '!' | ',' | '.' | ':' | '_' | '{' | '}' ) '\\u0027'
			{
			match('\''); 
			if ( (input.LA(1) >= ' ' && input.LA(1) <= '!')||input.LA(1)==','||input.LA(1)=='.'||(input.LA(1) >= '0' && input.LA(1) <= ':')||(input.LA(1) >= 'A' && input.LA(1) <= 'Z')||input.LA(1)=='_'||(input.LA(1) >= 'a' && input.LA(1) <= '{')||input.LA(1)=='}' ) {
				input.consume();
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				recover(mse);
				throw mse;
			}
			match('\''); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "CHARACTERCONSTANT"

	// $ANTLR start "ID"
	public final void mID() throws RecognitionException {
		try {
			int _type = ID;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// ul.g:461:4: ( ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' )* )
			// ul.g:461:6: ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' )*
			{
			if ( (input.LA(1) >= 'A' && input.LA(1) <= 'Z')||input.LA(1)=='_'||(input.LA(1) >= 'a' && input.LA(1) <= 'z') ) {
				input.consume();
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				recover(mse);
				throw mse;
			}
			// ul.g:461:30: ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' )*
			loop8:
			while (true) {
				int alt8=2;
				int LA8_0 = input.LA(1);
				if ( ((LA8_0 >= '0' && LA8_0 <= '9')||(LA8_0 >= 'A' && LA8_0 <= 'Z')||LA8_0=='_'||(LA8_0 >= 'a' && LA8_0 <= 'z')) ) {
					alt8=1;
				}

				switch (alt8) {
				case 1 :
					// ul.g:
					{
					if ( (input.LA(1) >= '0' && input.LA(1) <= '9')||(input.LA(1) >= 'A' && input.LA(1) <= 'Z')||input.LA(1)=='_'||(input.LA(1) >= 'a' && input.LA(1) <= 'z') ) {
						input.consume();
					}
					else {
						MismatchedSetException mse = new MismatchedSetException(null,input);
						recover(mse);
						throw mse;
					}
					}
					break;

				default :
					break loop8;
				}
			}

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "ID"

	// $ANTLR start "WS"
	public final void mWS() throws RecognitionException {
		try {
			int _type = WS;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// ul.g:469:9: ( ( '\\t' | ' ' | ( '\\r' | '\\n' ) )+ )
			// ul.g:469:11: ( '\\t' | ' ' | ( '\\r' | '\\n' ) )+
			{
			// ul.g:469:11: ( '\\t' | ' ' | ( '\\r' | '\\n' ) )+
			int cnt9=0;
			loop9:
			while (true) {
				int alt9=2;
				int LA9_0 = input.LA(1);
				if ( ((LA9_0 >= '\t' && LA9_0 <= '\n')||LA9_0=='\r'||LA9_0==' ') ) {
					alt9=1;
				}

				switch (alt9) {
				case 1 :
					// ul.g:
					{
					if ( (input.LA(1) >= '\t' && input.LA(1) <= '\n')||input.LA(1)=='\r'||input.LA(1)==' ' ) {
						input.consume();
					}
					else {
						MismatchedSetException mse = new MismatchedSetException(null,input);
						recover(mse);
						throw mse;
					}
					}
					break;

				default :
					if ( cnt9 >= 1 ) break loop9;
					EarlyExitException eee = new EarlyExitException(9, input);
					throw eee;
				}
				cnt9++;
			}

			 _channel = HIDDEN;
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "WS"

	// $ANTLR start "COMMENT"
	public final void mCOMMENT() throws RecognitionException {
		try {
			int _type = COMMENT;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// ul.g:472:9: ( '//' (~ ( '\\r' | '\\n' ) )* ( '\\r' | '\\n' ) )
			// ul.g:472:11: '//' (~ ( '\\r' | '\\n' ) )* ( '\\r' | '\\n' )
			{
			match("//"); 

			// ul.g:472:16: (~ ( '\\r' | '\\n' ) )*
			loop10:
			while (true) {
				int alt10=2;
				int LA10_0 = input.LA(1);
				if ( ((LA10_0 >= '\u0000' && LA10_0 <= '\t')||(LA10_0 >= '\u000B' && LA10_0 <= '\f')||(LA10_0 >= '\u000E' && LA10_0 <= '\uFFFF')) ) {
					alt10=1;
				}

				switch (alt10) {
				case 1 :
					// ul.g:
					{
					if ( (input.LA(1) >= '\u0000' && input.LA(1) <= '\t')||(input.LA(1) >= '\u000B' && input.LA(1) <= '\f')||(input.LA(1) >= '\u000E' && input.LA(1) <= '\uFFFF') ) {
						input.consume();
					}
					else {
						MismatchedSetException mse = new MismatchedSetException(null,input);
						recover(mse);
						throw mse;
					}
					}
					break;

				default :
					break loop10;
				}
			}

			if ( input.LA(1)=='\n'||input.LA(1)=='\r' ) {
				input.consume();
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				recover(mse);
				throw mse;
			}
			 _channel = HIDDEN;
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "COMMENT"

	@Override
	public void mTokens() throws RecognitionException {
		// ul.g:1:8: ( IF | ELSE | TRUE | FALSE | WHILE | PRINT | PRINTLN | RETURN | OPARENTHESES | CPARENTHESES | OBRACKET | CBRACKET | OBRACE | CBRACE | SEMICOLON | COMMA | EQUAL | DOUBLEEQUAL | LESSTHAN | PLUS | MINUS | MULTIPLY | TYPE | INTEGERCONSTANT | STRINGCONSTANT | FLOATCONSTANT | CHARACTERCONSTANT | ID | WS | COMMENT )
		int alt11=30;
		alt11 = dfa11.predict(input);
		switch (alt11) {
			case 1 :
				// ul.g:1:10: IF
				{
				mIF(); 

				}
				break;
			case 2 :
				// ul.g:1:13: ELSE
				{
				mELSE(); 

				}
				break;
			case 3 :
				// ul.g:1:18: TRUE
				{
				mTRUE(); 

				}
				break;
			case 4 :
				// ul.g:1:23: FALSE
				{
				mFALSE(); 

				}
				break;
			case 5 :
				// ul.g:1:29: WHILE
				{
				mWHILE(); 

				}
				break;
			case 6 :
				// ul.g:1:35: PRINT
				{
				mPRINT(); 

				}
				break;
			case 7 :
				// ul.g:1:41: PRINTLN
				{
				mPRINTLN(); 

				}
				break;
			case 8 :
				// ul.g:1:49: RETURN
				{
				mRETURN(); 

				}
				break;
			case 9 :
				// ul.g:1:56: OPARENTHESES
				{
				mOPARENTHESES(); 

				}
				break;
			case 10 :
				// ul.g:1:69: CPARENTHESES
				{
				mCPARENTHESES(); 

				}
				break;
			case 11 :
				// ul.g:1:82: OBRACKET
				{
				mOBRACKET(); 

				}
				break;
			case 12 :
				// ul.g:1:91: CBRACKET
				{
				mCBRACKET(); 

				}
				break;
			case 13 :
				// ul.g:1:100: OBRACE
				{
				mOBRACE(); 

				}
				break;
			case 14 :
				// ul.g:1:107: CBRACE
				{
				mCBRACE(); 

				}
				break;
			case 15 :
				// ul.g:1:114: SEMICOLON
				{
				mSEMICOLON(); 

				}
				break;
			case 16 :
				// ul.g:1:124: COMMA
				{
				mCOMMA(); 

				}
				break;
			case 17 :
				// ul.g:1:130: EQUAL
				{
				mEQUAL(); 

				}
				break;
			case 18 :
				// ul.g:1:136: DOUBLEEQUAL
				{
				mDOUBLEEQUAL(); 

				}
				break;
			case 19 :
				// ul.g:1:148: LESSTHAN
				{
				mLESSTHAN(); 

				}
				break;
			case 20 :
				// ul.g:1:157: PLUS
				{
				mPLUS(); 

				}
				break;
			case 21 :
				// ul.g:1:162: MINUS
				{
				mMINUS(); 

				}
				break;
			case 22 :
				// ul.g:1:168: MULTIPLY
				{
				mMULTIPLY(); 

				}
				break;
			case 23 :
				// ul.g:1:177: TYPE
				{
				mTYPE(); 

				}
				break;
			case 24 :
				// ul.g:1:182: INTEGERCONSTANT
				{
				mINTEGERCONSTANT(); 

				}
				break;
			case 25 :
				// ul.g:1:198: STRINGCONSTANT
				{
				mSTRINGCONSTANT(); 

				}
				break;
			case 26 :
				// ul.g:1:213: FLOATCONSTANT
				{
				mFLOATCONSTANT(); 

				}
				break;
			case 27 :
				// ul.g:1:227: CHARACTERCONSTANT
				{
				mCHARACTERCONSTANT(); 

				}
				break;
			case 28 :
				// ul.g:1:245: ID
				{
				mID(); 

				}
				break;
			case 29 :
				// ul.g:1:248: WS
				{
				mWS(); 

				}
				break;
			case 30 :
				// ul.g:1:251: COMMENT
				{
				mCOMMENT(); 

				}
				break;

		}
	}


	protected DFA11 dfa11 = new DFA11(this);
	static final String DFA11_eotS =
		"\1\uffff\7\35\10\uffff\1\52\4\uffff\4\35\2\60\5\uffff\1\62\10\35\2\uffff"+
		"\4\35\1\60\3\uffff\1\77\13\35\1\uffff\1\113\1\114\5\35\1\77\2\35\1\77"+
		"\2\uffff\1\124\1\77\1\125\1\127\3\35\2\uffff\1\35\1\uffff\1\134\1\77\1"+
		"\35\1\136\1\uffff\1\77\1\uffff";
	static final String DFA11_eofS =
		"\137\uffff";
	static final String DFA11_minS =
		"\1\11\1\146\1\154\1\162\1\141\1\150\1\162\1\145\10\uffff\1\75\4\uffff"+
		"\1\150\1\164\2\157\2\56\5\uffff\1\60\1\164\1\163\1\165\1\154\1\157\2\151"+
		"\1\164\2\uffff\1\141\1\162\1\157\1\151\1\56\3\uffff\1\60\2\145\1\163\1"+
		"\141\1\154\1\156\1\165\1\162\1\151\1\154\1\144\1\uffff\2\60\1\145\1\164"+
		"\1\145\1\164\1\162\1\60\1\156\1\145\1\60\2\uffff\4\60\1\156\1\147\1\141"+
		"\2\uffff\1\156\1\uffff\2\60\1\156\1\60\1\uffff\1\60\1\uffff";
	static final String DFA11_maxS =
		"\1\175\1\156\1\154\1\162\1\154\1\150\1\162\1\145\10\uffff\1\75\4\uffff"+
		"\1\150\1\164\2\157\1\71\1\56\5\uffff\1\172\1\164\1\163\1\165\1\154\1\157"+
		"\2\151\1\164\2\uffff\1\141\1\162\1\157\1\151\1\71\3\uffff\1\172\2\145"+
		"\1\163\1\141\1\154\1\156\1\165\1\162\1\151\1\154\1\144\1\uffff\2\172\1"+
		"\145\1\164\1\145\1\164\1\162\1\172\1\156\1\145\1\172\2\uffff\4\172\1\156"+
		"\1\147\1\141\2\uffff\1\156\1\uffff\2\172\1\156\1\172\1\uffff\1\172\1\uffff";
	static final String DFA11_acceptS =
		"\10\uffff\1\11\1\12\1\13\1\14\1\15\1\16\1\17\1\20\1\uffff\1\23\1\24\1"+
		"\25\1\26\6\uffff\1\31\1\33\1\34\1\35\1\36\11\uffff\1\22\1\21\5\uffff\1"+
		"\30\1\32\1\1\14\uffff\1\27\13\uffff\1\2\1\3\7\uffff\1\4\1\5\1\uffff\1"+
		"\6\4\uffff\1\10\1\uffff\1\7";
	static final String DFA11_specialS =
		"\137\uffff}>";
	static final String[] DFA11_transitionS = {
			"\2\36\2\uffff\1\36\22\uffff\1\36\1\uffff\1\33\4\uffff\1\34\1\10\1\11"+
			"\1\24\1\22\1\17\1\23\1\uffff\1\37\1\32\11\31\1\uffff\1\16\1\21\1\20\3"+
			"\uffff\32\35\1\12\1\uffff\1\13\1\uffff\1\35\1\uffff\1\35\1\27\1\25\1"+
			"\35\1\2\1\4\2\35\1\1\6\35\1\6\1\35\1\7\1\26\1\3\1\35\1\30\1\5\3\35\1"+
			"\14\1\uffff\1\15",
			"\1\40\7\uffff\1\41",
			"\1\42",
			"\1\43",
			"\1\44\12\uffff\1\45",
			"\1\46",
			"\1\47",
			"\1\50",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"\1\51",
			"",
			"",
			"",
			"",
			"\1\53",
			"\1\54",
			"\1\55",
			"\1\56",
			"\1\61\1\uffff\12\57",
			"\1\61",
			"",
			"",
			"",
			"",
			"",
			"\12\35\7\uffff\32\35\4\uffff\1\35\1\uffff\32\35",
			"\1\63",
			"\1\64",
			"\1\65",
			"\1\66",
			"\1\67",
			"\1\70",
			"\1\71",
			"\1\72",
			"",
			"",
			"\1\73",
			"\1\74",
			"\1\75",
			"\1\76",
			"\1\61\1\uffff\12\57",
			"",
			"",
			"",
			"\12\35\7\uffff\32\35\4\uffff\1\35\1\uffff\32\35",
			"\1\100",
			"\1\101",
			"\1\102",
			"\1\103",
			"\1\104",
			"\1\105",
			"\1\106",
			"\1\107",
			"\1\110",
			"\1\111",
			"\1\112",
			"",
			"\12\35\7\uffff\32\35\4\uffff\1\35\1\uffff\32\35",
			"\12\35\7\uffff\32\35\4\uffff\1\35\1\uffff\32\35",
			"\1\115",
			"\1\116",
			"\1\117",
			"\1\120",
			"\1\121",
			"\12\35\7\uffff\32\35\4\uffff\1\35\1\uffff\32\35",
			"\1\122",
			"\1\123",
			"\12\35\7\uffff\32\35\4\uffff\1\35\1\uffff\32\35",
			"",
			"",
			"\12\35\7\uffff\32\35\4\uffff\1\35\1\uffff\32\35",
			"\12\35\7\uffff\32\35\4\uffff\1\35\1\uffff\32\35",
			"\12\35\7\uffff\32\35\4\uffff\1\35\1\uffff\32\35",
			"\12\35\7\uffff\32\35\4\uffff\1\35\1\uffff\13\35\1\126\16\35",
			"\1\130",
			"\1\131",
			"\1\132",
			"",
			"",
			"\1\133",
			"",
			"\12\35\7\uffff\32\35\4\uffff\1\35\1\uffff\32\35",
			"\12\35\7\uffff\32\35\4\uffff\1\35\1\uffff\32\35",
			"\1\135",
			"\12\35\7\uffff\32\35\4\uffff\1\35\1\uffff\32\35",
			"",
			"\12\35\7\uffff\32\35\4\uffff\1\35\1\uffff\32\35",
			""
	};

	static final short[] DFA11_eot = DFA.unpackEncodedString(DFA11_eotS);
	static final short[] DFA11_eof = DFA.unpackEncodedString(DFA11_eofS);
	static final char[] DFA11_min = DFA.unpackEncodedStringToUnsignedChars(DFA11_minS);
	static final char[] DFA11_max = DFA.unpackEncodedStringToUnsignedChars(DFA11_maxS);
	static final short[] DFA11_accept = DFA.unpackEncodedString(DFA11_acceptS);
	static final short[] DFA11_special = DFA.unpackEncodedString(DFA11_specialS);
	static final short[][] DFA11_transition;

	static {
		int numStates = DFA11_transitionS.length;
		DFA11_transition = new short[numStates][];
		for (int i=0; i<numStates; i++) {
			DFA11_transition[i] = DFA.unpackEncodedString(DFA11_transitionS[i]);
		}
	}

	protected class DFA11 extends DFA {

		public DFA11(BaseRecognizer recognizer) {
			this.recognizer = recognizer;
			this.decisionNumber = 11;
			this.eot = DFA11_eot;
			this.eof = DFA11_eof;
			this.min = DFA11_min;
			this.max = DFA11_max;
			this.accept = DFA11_accept;
			this.special = DFA11_special;
			this.transition = DFA11_transition;
		}
		@Override
		public String getDescription() {
			return "1:1: Tokens : ( IF | ELSE | TRUE | FALSE | WHILE | PRINT | PRINTLN | RETURN | OPARENTHESES | CPARENTHESES | OBRACKET | CBRACKET | OBRACE | CBRACE | SEMICOLON | COMMA | EQUAL | DOUBLEEQUAL | LESSTHAN | PLUS | MINUS | MULTIPLY | TYPE | INTEGERCONSTANT | STRINGCONSTANT | FLOATCONSTANT | CHARACTERCONSTANT | ID | WS | COMMENT );";
		}
	}

}
