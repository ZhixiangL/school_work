package IR;

import AST.*;
import Type.*;
import Environment.*;
import java.util.ArrayList;
import java.util.List;

public class TempVisitor {

    private final Environment<String, Type> fEnv;
    private final Environment<String, Temp> vEnv;
    private TempFactory tFactory;
    private LabelFactory lFactory;

    private IRFunction currFunction;
    private IRProgram program;
    private List<IRInstruction> funcInstrs;

    public TempVisitor(String programName){
        this.functionEnvironment = new StackEnvironment<String, Type>();
        this.variableEnvironment = new StackEnvironment<String, Temp>();
        this.program = new IRProgram(programName);

    }

    public Temp visit(AddExpression e){
        Temp lhs = e.leftExpr.accept(this);
        Temp rhs = e.rightExpr.accept(this);
        Temp dest = this.tFactory.getTemp(lhs.type);
        IRInstruction ir = new IRBinaryOp(dest, lhs, rhs, IRBiOp.ADD);
        this.funcInstrs.add(ir);
        TempFactory.returnTemp(lhs);
        TempFactory.returnTemp(rhs);
        return dest;
    }

    public Temp visit(ArrayAssignmentStatement s){
        Temp id = s.arrayReference.id.accept(this);
        Temp index = s.arrayReference.expr.accept(this); 
        Temp expr = s.expr.accept(this);
        IRInstruction assignment = new IRArrayAssignmentInstruction(id, index, expr);
        this.funcInstrs.add(assignment);
        return null;
    }

    public Temp visit(ArrayReference r){
        return null;
    }

    public Temp visit(AssignmentStatement s){
        Temp id = s.id.accept(this);
        Temp expr = s.expr.accept(this);
        IRInstruction assignment = new IRAssignmentInstruction(id, expr);
        this.funcInstrs.add(assignment);
        return null;
    }

    public Temp visit(Block b){
        for (int i = 0; i<b.statementArray.size(); i++) {
            b.statementArray.get(i).accept(this);
        }
        return null;
    }

    public Temp visit(BooleanLiteral l){
        Temp dest = this.tFactory.getTemp(new BooleanType());
        IRInstruction ir = new IRBooleanLiteral(dest, l.value);
        this.funcInstrs.add(ir);
        return dest;
    }

    public Temp visit(CharacterLiteral l){
        Temp dest = this.tFactory.getTemp(new CharType());
        IRInstruction ir = new IRCharacterLiteral(dest, l.value);
        this.funcInstrs.add(ir);
        return dest;
    }

    public Temp visit(Declaration d){
        Type type = d.type.type;
        String name = d.id.name;
        Temp temp = this.tempFactory.getTemp(type, TempClass.PARAMETER, name);
        this.variableEnvironment.add(name, temp);
        this.funcInstrs.add(new IRDeclaration(temp, type));//?????????
        return null;
    }

    public Temp visit(EmptyStatement s){
        return null;
    }

    public Temp visit(EqualExpression e){
        Temp lhs = e.leftExpr.accept(this);
        Temp rhs = e.rightExpr.accept(this);
        Temp dest = this.tFactory.getTemp(lhs.type);
        IRInstruction ir = new IRBinaryOp(dest, lhs, rhs, IRBiOp.EQUAL);
        functionInstr.add(ir);
        TempFactory.returnTemp(lhs);
        TempFactory.returnTemp(rhs);
        return dest;
    }

    public Temp visit(ExpressionStatement s){
        e.expr.accept(this);
        return null;
    }

    public Temp visit(FloatLiteral l){
        Temp dest = this.tFactory.getTemp(new FloatType());
        IRInstruction ir = new IRFloatLiteral(dest, l.value);
        this.funcInstrs.add(ir);
        return dest;
    }

    public Temp visit(FormalParameters p){
        for (int i = 0; i < p.size; i++) {
            p.get(i).accept(this);
        }
        return null;
    }

    public Temp visit(Function f){
        this.variableEnvironment.beginScope();

        this.tFactory = new TempFactory();
        this.lFactory = new LabelFactory();
        this.funcInstrs = new ArrayList<IRInstruction>();
        String name = f.functionDecl.declaration.id.name;
        Type returnType = f.functionDecl.declaration.type.type;
        List<Type> parameterTypes = new ArrayList<Type>();
        for (Declaration d : f.functionDecl.formalParameters) {
            parameterTypes.add(d.type.type);
        }
        this.currentFunction = new IRFunction(name, returnType, parameterTypes);

        f.functionDecl.accept(this);
        f.functionBody.accept(this);

        this.currentFunction.instructions = this.funcInstrs;
        this.currentFunction.tFactory = this.tFactory;
        this.currentFunction.lFactory = this.lFactory;
        this.program.add(this.currentFunction);
        this.variableEnvironment.endScope();
        return null;
    }
//????????????
    public Temp visit(FunctionBody f){
        for (int i = 0; i<f.variableDeclarationArray.size(); i++) {
            f.variableDeclarationArray.get(i).accept(this);
        }

        for (int i = 0; i<f.statementArray.size(); i++) {
            f.statementArray.get(i).accept(this);
        }
 
        // Always insert an empty return instruction
        // at the end of a function body even if it's redundant
        // Instruction returnInstruction = new ReturnInstruction();
        // this.funcInstrs.add(returnInstruction);
        return null;
    }

    public Temp visit(FunctionCall f){}

    public Temp visit(FunctionDecl f){
        f.formalParameters.accept(this);
        return null;
    }

    public Temp visit(Identifier i){
        return variableEnvironment.lookup(i.id);
    }

    public Temp visit(IfStatement s){
        IRInstruction ir;
        IRLabel l1 = this.lFactory.getLabel();
        IRLabel l2 = this.lFactory.getLabel();
        Temp t = s.expr.accept(this);
        if (this.tFactory.isParameterOrLocal(t)){
            Temp t2 = this.tFactory.getTemp(new BooleanType());
            ir = new IRAssignmentInstruction(t2, t);
            this.funcInstrs.add(ir);
            t = t2;
        }
        ir = new IRUnaryOp(t,t, IRUOp.INVERT);
        this.funcInstrs.add(ir);
        ir = new IRIfStatement(t, l1);
        this.funcInstrs.add(ir);
        s.ifBlock.accept(this);
        ir = new IRIfGoto(l2);
        this.funcInstrs.add(ir);
        this.funcInstrs.add(l1);
        if (s.elseBlock != null) {
            s.elseBlock.accept(this);
        }
        this.funcInstrs.add(l2);
        return null;
    }

    public Temp visit(IntegerLiteral l){
        Temp dest = this.tFactory.getTemp(new IntegerType());
        IRInstruction ir = new IRIntegerLiteral(dest, l.value);
        this.funcInstrs.add(ir);
        return dest;
    }
    public Temp visit(LessThanExpression e){
        Temp lhs = e.leftExpr.accept(this);
        Temp rhs = e.rightExpr.accept(this);
        Temp dest = this.tFactory.getTemp(lhs.type);
        IRInstruction ir = new IRBinaryOp(dest, lhs, rhs, IRBiOp.LESSTHAN);
        functionInstr.add(ir);
        TempFactory.returnTemp(lhs);
        TempFactory.returnTemp(rhs);
        return dest;
    }
    public Temp visit(MultiplyExpression e){
        Temp lhs = e.leftExpr.accept(this);
        Temp rhs = e.rightExpr.accept(this);
        Temp dest = this.tFactory.getTemp(lhs.type);
        IRInstruction ir = new IRBinaryOp(dest, lhs, rhs, IRBiOp.MULTIPLY);
        functionInstr.add(ir);
        TempFactory.returnTemp(lhs);
        TempFactory.returnTemp(rhs);
        return dest;
    }
    public Temp visit(ParenthesesExpression e){
        return p.expr.accept(this);
    }
    public Temp visit(PrintlnStatement s){}
    public Temp visit(PrintStatement s){}

    public Temp visit(Program p){
        this.fEnvironment.beginScope();

        for (int i = 0; i<p.size; i++) {
            Declaration d = p.funcList.get(i).functionDecl.declaration;
            String fName = d.id.id;
            Type fType = d.type.type;
            this.fEnvironment.add(fName, fType);
        }
        for (int i = 0; i<p.size; i++) {
            p.funcList.get(i).accept(this);
        }

        this.fEnvironment.endScope();
        return null;
    }
    public Temp visit(ReturnStatement s){}
    public Temp visit(StringLiteral l){
        Temp dest = this.tFactory.getTemp(new StringType());
        IRInstruction ir = new IRStringLiteral(dest, l.value);
        this.funcInstrs.add(ir);
        return dest;
    }
    public Temp visit(SubstractExpression e){
        Temp lhs = e.leftExpr.accept(this);
        Temp rhs = e.rightExpr.accept(this);
        Temp dest = this.tFactory.getTemp(lhs.type);
        IRInstruction ir = new IRBinaryOp(dest, lhs, rhs, IRBiOp.SUBSTRACT);
        functionInstr.add(ir);
        TempFactory.returnTemp(lhs);
        TempFactory.returnTemp(rhs);
        return dest;
    }
    public Temp visit(TypeNode t){
        return null;
    }

    public Temp visit(VariableDeclaration d){
        Type type = d.type.type;
        String name = d.id.name;
        Temp temp = this.tempFactory.getTemp(type, TempClass.LOCAL, name);
        this.variableEnvironment.add(name, temp);
        this.funcInstrs.add(new IRDeclaration(temp, type));//?????????
        return null;
    }

    public Temp visit(WhileStatement s){
        IRInstruction ir;
        IRLabel l1 = this.lFactory.getLabel();
        IRLabel l2 = this.lFactory.getLabel();
        Temp t = s.expr.accept(this);
        if (this.tFactory.isParameterOrLocal(t)){
            Temp t2 = this.tFactory.getTemp(new BooleanType());
            ir = new IRAssignmentInstruction(t2, t);
            this.funcInstrs.add(ir);
            t = t2;
        }
        ir = new IRUnaryOp(t,t, IRUOp.INVERT);
        this.funcInstrs.add(ir);
        this.funcInstrs.add(l2);
        ir = new IRIfStatement(t, l1);
        this.funcInstrs.add(ir);
        s.block.accept(this);
        ir = new IRIfGoto(l2);
        this.funcInstrs.add(ir);
        this.funcInstrs.add(l1);
        return null;
    }
}
