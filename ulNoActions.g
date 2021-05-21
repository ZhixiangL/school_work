grammar ulNoActions;

options {
    backtrack=true;
}
		
@members
{
protected void mismatch (IntStream input, int ttype, BitSet follow)
        throws RecognitionException
{
        throw new MismatchedTokenException(ttype, input);
}
public Object recoverFromMismatchedSet (IntStream input,
                                      RecognitionException e,
                                      BitSet follow)
        throws RecognitionException
{
        reportError(e);
        throw e;
}
}

@rulecatch {
        catch (RecognitionException ex) {
                reportError(ex);
                throw ex;
        }
}

/*
 * This is a subset of the ulGrammar to show you how
 * to make new production rules.
 * You will need to:
 *  - change type to be compoundType and include appropriate productions
 *  - introduce optional formalParameters
 *  - change functionBody to include variable declarations and statements 
 */

program : 
        function+ EOF
	;

function: 
        functionDecl functionBody
	;

functionDecl: 
        compoundType identifier OPARENTHESES formalParameters CPARENTHESES
	;

formalParameters: 
        compoundType identifier moreFormals*
        |
        ;

moreFormals: 
        COMMA compoundType identifier
        ;

functionBody: 
        OBRACE varDecl* statement* CBRACE
	;

varDecl: 
        compoundType identifier SEMICOLON
        ;

statement:
        SEMICOLON
         | exprStatement
         | ifStatement
         | whileStatement
         | printStatement
         | printlnStatement
         | returnStatement
         | assignStatement 
         | arrayAssignStatement
        ;

exprStatement: 
        expr SEMICOLON
        ;
ifStatement:
        IF OPARENTHESES expr CPARENTHESES block elsePart
        ;
elsePart:
        ELSE block 
        |
        ;
whileStatement: 
        WHILE OPARENTHESES expr CPARENTHESES block 
        ;
printStatement: 
        PRINT expr SEMICOLON
        ;
printlnStatement: 
        PRINTLN expr SEMICOLON
        ;
returnStatement: 
        RETURN expr? SEMICOLON
        ;
assignStatement: 
        identifier EQUAL expr SEMICOLON
        ;     

arrayAssignStatement:
        identifier OBRACKET expr CBRACKET EQUAL expr SEMICOLON
        ;

block: 
        OBRACE statement* CBRACE
        ;

expr: 
        expr2 ( DOUBLEEQUAL expr2 )*  
        ;
expr2: 
        expr3 ( LESSTHAN expr3 )* 
        ;
expr3:  
        expr4 ( (PLUS|MINUS) expr4 )* 
        ;

expr4:  
        atom ( MULTIPLY atom )*      
        ;

atom:    
        identifier
        | literal 
        | functionCall
        | arrayRef
        | OPARENTHESES expr CPARENTHESES 
    ;

functionCall:   
        identifier OPARENTHESES exprList CPARENTHESES
        ;

arrayRef:    
        identifier OBRACKET expr CBRACKET
        ;

exprList: 
        expr exprMore* 
        | 
        ;

exprMore:       
        COMMA expr
        ;

literal: 
        INTEGERCONSTANT
        | STRINGCONSTANT
        | FLOATCONSTANT 
        | CHARACTERCONSTANT
        | TRUE
        | FALSE
        ;

identifier : 
        ID
	;

compoundType:	
        type
        |  type OBRACKET INTEGERCONSTANT CBRACKET
	;

type:	
        TYPE
	;

/* Lexer */
	 
IF	: 'if'
	;

ELSE    : 'else'
        ;

TRUE    : 'true'
        ;

FALSE   : 'false'
        ;

WHILE   : 'while'
        ;

PRINT   : 'print'
        ;

PRINTLN : 'println'
        ;

RETURN  : 'return'
        ;

OPARENTHESES : '('
        ;

CPARENTHESES : ')'
        ;

OBRACKET : '['
        ;

CBRACKET : ']'
        ;

OBRACE : '{'
        ;

CBRACE : '}'
        ;

SEMICOLON : ';'
        ;    

COMMA    : ','
        ;       

EQUAL   : '='
        ;

DOUBLEEQUAL : '=='
        ;

LESSTHAN : '<'
        ;

PLUS    :'+'
        ;

MINUS   : '-'
        ;

MULTIPLY : '*'
        ;

/* Fixme: add the other types here */
TYPE	: 'int'
          | 'float'
          | 'char'
          | 'string'
          | 'boolean'
          | 'void'
	; 
/*
 * FIXME:
 * Change this to match the specification for identifier
 * 
 */

INTEGERCONSTANT : (('1'..'9')('0'..'9')* | '0')
        ;

STRINGCONSTANT: '\u0022' ('a'..'z' | 'A'..'Z' | ' '|'0'..'9' | '!'|','|'.'|':'|'_'|'{'|'}')+ '\u0022'
        ;

FLOATCONSTANT: (('1'..'9')('0'..'9')* | '0') '.' ('0'..'9')+
        ;

CHARACTERCONSTANT: '\u0027' ('a'..'z' | 'A'..'Z'|' '|'0'..'9' | '!'|','|'.'|':'|'_'|'{'|'}') '\u0027'
        ;

ID	: ('a'..'z'|'A'..'Z'|'_') ('a'..'z'|'A'..'Z'|'0'..'9'|'_')* 
	;

/* These two lines match whitespace and comments 
 * and ignore them.
 * You want to leave these as last in the file.  
 * Add new lexical rules above 
 */
WS      : ( '\t' | ' ' | ('\r' | '\n') )+ { $channel = HIDDEN;}
        ;

COMMENT : '//' ~('\r' | '\n')* ('\r' | '\n') { $channel = HIDDEN;}
        ;