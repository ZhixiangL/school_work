package AST;

import java.lang.StringBuilder;

public class PrettyPrintVisitor implements Visitor {
    private int indentationDepth;

    public PrettyPrintVisitor() {
        this.indentationDepth = 1;
    }

    public void visit(AddExpression e) {
        e.leftExpr.accept(this);
        System.out.print("+");
        e.rightExpr.accept(this);
    }

    public void visit(ArrayAssignmentStatement s) {
        this.printIndentation();
        s.arrayReference.accept(this);
        System.out.print("=");
        s.expr.accept(this);
        System.out.println(";");
    }

    public void visit(ArrayReference r) {
        r.id.accept(this);
        System.out.print("[");
        r.expr.accept(this);
        System.out.print("]");
    }

    public void visit(AssignmentStatement s) {
        this.printIndentation();
        s.id.accept(this);
        System.out.print("=");
        s.expr.accept(this);
        System.out.println(";");
    }

    public void visit(Block b) {
        this.printIndentation();
        System.out.println("{");
        this.indentationDepth++;
        for (int i = 0; i<b.statementArray.size(); i++) {
            b.statementArray.get(i).accept(this);
        }
        this.indentationDepth--;
        this.printIndentation();
        System.out.println("}");
    }

    public void visit(BooleanLiteral l) {
        System.out.print(l.value);
    }

    public void visit(CharacterLiteral l) {
        System.out.print("\'");
        System.out.print(l.value);
        System.out.print("\'");
    }

    public void visit(Declaration d) {
        d.type.accept(this);
        d.id.accept(this);
    }

    public void visit(EmptyStatement s) {
        this.printIndentation();
        System.out.println(";");
    }

    public void visit(EqualExpression e) {
        e.leftExpr.accept(this);
        System.out.print("==");
        e.rightExpr.accept(this);
    }

    public void visit(ExpressionList e) {
        Expression expr;
        for (int i = 0; i < e.size; i++) {
            expr = e.get(i);
            expr.accept(this);
            if (i < e.size - 1) {
                System.out.print(",");
            }
        }
    }

    public void visit(ExpressionStatement s) {
        this.printIndentation();
        s.expr.accept(this);
        System.out.println(";");
    }

    public void visit(FloatLiteral l) {
        System.out.print(l.value);
    }

    public void visit(FormalParameters p) {
        Declaration d;
        for (int i = 0; i < p.size; i++) {
            d = p.get(i);
            d.accept(this);
            if (i < p.size - 1) {
                System.out.print(", ");
            }
        }
    }

    public void visit(Function f) {
        f.functionDecl.accept(this);
        f.functionBody.accept(this);
    }

    public void visit(FunctionBody f) {
        System.out.println("{");
        for (int i = 0; i<f.variableDeclarationArray.size(); i++) {
            f.variableDeclarationArray.get(i).accept(this);
        }
        if (f.variableDeclarationArray.size() > 0) {
            System.out.println();
        }
        for (int i = 0; i<f.statementArray.size(); i++) {
            f.statementArray.get(i).accept(this);
        }
        System.out.println("}");
    }

    public void visit(FunctionCall f) {
        f.id.accept(this);
        System.out.print("(");
        for (int i = 0; i<f.expressionList.size(); i++) {
            f.expressionList.get(i).accept(this);
            if (i < f.expressionList.size() - 1) {
                System.out.print(",");
            }
        }
        System.out.print(")");
    }

    public void visit(FunctionDecl f) {
        f.declaration.accept(this);
        System.out.print(" (");
        f.formalParameters.accept(this);
        System.out.println(")");
    }

    public void visit(Identifier i) {
        System.out.print(i.id);
    }

    public void visit(IfStatement s) {
        this.printIndentation();
        System.out.print("if (");
        s.expr.accept(this);
        System.out.println(")");
        s.ifBlock.accept(this);
        if (s.elseBlock != null) {
            this.printIndentation();
            System.out.println("else");
            s.elseBlock.accept(this);
        }
    }

    public void visit(IntegerLiteral l) {
        System.out.print(l.value);
    }

    public void visit(LessThanExpression e) {
        e.leftExpr.accept(this);
        System.out.print("<");
        e.rightExpr.accept(this);

    }

    public void visit(MultiplyExpression e) {
        e.leftExpr.accept(this);
        System.out.print("*");
        e.rightExpr.accept(this);
    }

    public void visit(ParenthesesExpression e) {
        System.out.print("(");
        e.expr.accept(this);
        System.out.print(")");
    }

    public void visit(PrintlnStatement s) {
        this.printIndentation();
        System.out.print("println ");
        s.expr.accept(this);
        System.out.println(";");
    }

    public void visit(PrintStatement s) {
        this.printIndentation();
        System.out.print("print ");
        s.expr.accept(this);
        System.out.println(";");
    }

    public void visit(Program p) {
        for (int i = 0; i<p.size; i++) {
            p.funcList.get(i).accept(this);
            if (i < p.size-1) {
                System.out.println();
            }
        }
    }

    public void visit(ReturnStatement s) {
        this.printIndentation();
        System.out.print("return");
        if (s.expr != null) {
            System.out.print(" ");
            s.expr.accept(this);
        }
        System.out.println(";");
    }

    public void visit(StringLiteral l) {
        System.out.print("\"");
        System.out.print(l.value);
        System.out.print("\"");
    }

    public void visit(SubstractExpression e) {
        e.leftExpr.accept(this);
        System.out.print("-");
        e.rightExpr.accept(this);
    }

    public void visit(TypeNode t) {
        System.out.print(t.type + " ");
    }

    public void visit(VariableDeclaration d) {
        this.printIndentation();
        d.type.accept(this);
        d.id.accept(this);
        System.out.println(";");
    }

    public void visit(WhileStatement s) {
        this.printIndentation();
        System.out.print("while (");
        s.expr.accept(this);
        System.out.println(")");
        s.block.accept(this);
    }

    private final void printIndentation() {
        int totalIndentation = 4 * this.indentationDepth;
        StringBuilder sb = new StringBuilder(totalIndentation);
        for (int i = 0; i < totalIndentation; i++) {
            sb.append(" ");
        }
        String spaces = sb.toString();
        System.out.print(spaces);
    }
}
