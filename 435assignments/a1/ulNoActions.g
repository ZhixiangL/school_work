grammar ulNoActions;

options {
    backtrack=true;
}

@header
{
    import AST.AddExpression;
    import AST.ArrayAssignmentStatement;
    import AST.ArrayReference;
    import AST.AssignmentStatement;
    import AST.Block;
    import AST.BooleanLiteral;
    import AST.CharacterLiteral;
    import AST.Declaration;
    import AST.EqualyExpression;
    import AST.Expression;
    import AST.ExpressionList;
    import AST.ExpressionStatement;
    import AST.FloatLiteral;
    import AST.FormalParameters;
    import AST.Function;
    import AST.FunctionBody;
    import AST.FunctionCall;
    import AST.FunctionDecl;
    import AST.Identifier;
    import AST.IfStatement;
    import AST.IntegerLiteral;
    import AST.LessThanExpression;
    import AST.Literal;
    import AST.MultiplyExpression;
    import AST.ParenthesesExpression;
    import AST.PrintlnStatement;
    import AST.PrintStatement;
    import AST.Program;
    import AST.ReturnStatement;
    import AST.StatementList;
    import AST.StringLiteral;
    import AST.SubtractExpression;
    import AST.VariableDeclaration;
    import AST.WhileStatement;
    import type.ArrayType;
    import type.BooleanType;
    import type.CharType;
    import type.FloatType;
    import type.IntegerType;
    import type.StringType;
    import type.Type;
    import type.VoidType;
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

program return [Program p]
@init 
{
        p = new Program();
}
        : 
        (f = function {p.add(f);} )+ EOF
	;

function return [Function f]
: 
        fd = functionDecl fb = functionBody
        {
                f = new Function(fd, fb);
        }
	;

functionDecl return [FunctionDecl fd]
: 
        ct = compoundType id = identifier OPARENTHESES fp = formalParameters CPARENTHESES
        {
                Declaration d = new Declaration(ct, id);
                fd = new FunctionDecl(d, fp);
        }
	;

//not sure if this works
formalParameters return [FormalParameters fp] 
@init
{
        fp = new FormalParameters();
}
: 
        (ct1 = compoundType id1 = identifier {fp.add(new Declaration(ct1, id1));} ) 
        (COMMA ct2 = compoundType id2 = identifier {fp.add(new Declaration(ct2, id2));} )*
        |
        ;


functionBody return [FunctionBody fb]
@init
{
        fb = new FunctionBody();
}
: 
        OBRACE (vd = varDecl {fb.addVarDecl(vd);} )* (s = statement {fb.addStatement(s);} )* CBRACE
	;

varDecl return [VariableDeclaration vd]: 
        ct = compoundType id = identifier SEMICOLON
        {
                vd = new VariableDeclaration(ct, id);
        }
        ;

statement return [Statement s]:
        SEMICOLON {s = new Statement();}
         | es = exprStatement {s = es;}
         | is = ifStatement {s = is;}
         | ws = whileStatement {s = ws;}
         | ps = printStatement {s = ps;}
         | pls = printlnStatement {s = pls;}
         | rs = returnStatement {s = rs;}
         | as = assignStatement {s = as;} 
         | ars = arrayAssignStatement {s = ars;}
        ;

exprStatement return [ExpressionStatement es]
: 
        e = expr SEMICOLON
        {
                es = new ExpressionStatement(e);
        }
        ;

ifStatement return [IfStatement is]:
        IF OPARENTHESES e1 = expr CPARENTHESES b1 = block ELSE b2 = block {is = new IfStatement(e1, b1, b2);}
        | IF OPARENTHESES e2 = expr CPARENTHESES b3 = block {} {is = new IfStatement(e2, b3);}
        ;

whileStatement return [WhileStatement ws]: 
        WHILE OPARENTHESES e = expr CPARENTHESES b = block {ws = new WhileStatement(e, b);}
        ;
printStatement return [PrintStatement ps]: 
        PRINT e = expr SEMICOLON {ps = new PrintStatement(e);}
        ;
printlnStatement return [PrintlnStatement pls]: 
        PRINTLN e = expr SEMICOLON {pls = new PrintlnStatement(e);}
        ;
returnStatement return [ReturnStatement rs]
@init
{
        rs = new ReturnStatement();
}
: 
        RETURN (e = expr {rs.addExpression(e);} )? SEMICOLON
        ;
assignStatement return [AssignmentStatement as]: 
        id = identifier EQUAL e = expr SEMICOLON
        {
                as = new AssignmentStatement(id, e);
        }
        ;     

arrayAssignStatement return [ArrayAssignmentStatement ars]:
        ar = arrayRef EQUAL e2 = expr SEMICOLON
        {
                ars = new ArrayAssignmentStatement(ar, e);
        }
        ;

block return [Block b]
@init
{
        b = new Block();
}
: 
        OBRACE (s = statement {b.add(s);})* CBRACE
        ;

expr return [Expression e]
@init{
        Expression it = null;
}
@after{
        e = it;
}
: 
        e1 = expr2 {it = e1;}
        ( DOUBLEEQUAL e2 = expr2 {it = new EqualExpression(it, e2);} )*  
        ;

expr2 return [Expression e]
@init{
        Expression it = null;
}
@after{
        e = it;
}: 
        e1 = expr3 {it = e1;}
        ( LESSTHAN e2 = expr3 {it = new LessThanExpression(it, e2);} )* 
        ;

expr3 return [Expression e]
@init{
        Expression it = null;
}
@after{
        e = it;
}: 
        e1 = expr4 {it = e1;}
        ( op = (PLUS|MINUS) e2 = expr4 
        {
                if (op.getText().equals("+")) {
                        it = new AddExpression(it, e2);
                } else {
                        it = new SubstractExpression(it, e2);
                }
        })* 
        ;

expr4 [Expression e]
@init{
        Expression it = null;
}
@after{
        e = it;
}: 
        e1 = atom {it = e1;}
        ( MULTIPLY e2 = atom {it = new MultiplyExpression(it, e2);})*      
        ;

atom return [Expression e]:    
        i = identifier {e = i;}
        | l = literal {e = l;}
        | f = functionCall {e = f;}
        | a = arrayRef {e = a;}
        | OPARENTHESES ex = expr CPARENTHESES {e = new ParenthesesExpression(ex);}
    ;

functionCall return [FunctionCall fc]:   
        id = identifier OPARENTHESES el = exprList CPARENTHESES
        {
                fc = new FunctionCall(id);
                fc.setExpressionList(el.getExpressionList());
        }
        ;

arrayRef return [ArrayReference ar]:    
        id = identifier OBRACKET e = expr CBRACKET
        {
                ar = new ArrayReference(id, e);
        }
        ;

exprList return [ExpressionList el]
@init {
        el = new ExpressionList();
}
: 
        e1 = expr {el.add(e1);} e2 = (COMMA expr {el.add(e2);} )* 
        | 
        ;

literal return [Literal l]: 
        INTEGERCONSTANT {l = new IntegerLiteral(Integer.parseInt($INTEGERCONSTANT.text));}
        | STRINGCONSTANT {String txt = $STRINGCONSTANT.text; l = new StringLiteral(txt.substring(1, txt.length()-1));}
        | FLOATCONSTANT {l = new FloatLiteral(Float.parseFloat($FLOATCONSTANT.text));}
        | CHARACTERCONSTANT {l = new CharacterLiteral($CHARACTERCONSTANT.text.charAt(1));}
        | TRUE {l = new BooleanLiteral(true);}
        | FALSE {l = new BooleanLiteral(false);}
        ;

identifier return [Identifier id]: 
        ID {id = new Identifier($ID.text);}
	;

compoundType return [Type tn]:	
        t = type {tn = t;}
        |  t2 = type OBRACKET INTEGERCONSTANT CBRACKET {tn = new ArrayType(t2, Integer.parseInt($INTEGERCONSTANT.text));}
	;

type return [Type t]:	
        TYPE
        {
                String ty = $TYPE.text;
                if(ty.equals("int")) {
                        t = new IntegerType();
                } else if(ty.equals("float")) {
                        t = new FloatType();
                } else if(ty.equals("string")) {
                        t = new StringType();
                } else if(ty.equals("char")) {
                        t = new CharType();
                } else if(ty.equals("boolean")) {
                        t = new BooleanType();
                } else if(ty.equals("void")) {
                        t = new VoidType();
                }
        }
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
 * You want to leave these as lAST in the file.  
 * Add new lexical rules above 
 */
WS      : ( '\t' | ' ' | ('\r' | '\n') )+ { $channel = HIDDEN;}
        ;

COMMENT : '//' ~('\r' | '\n')* ('\r' | '\n') { $channel = HIDDEN;}
        ;