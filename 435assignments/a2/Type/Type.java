package Type;

public abstract class Type {
    public abstract String toString();

    public abstract boolean equals(Object o);

    public String toChar() {
        if (this instanceof ArrayType) {
            return "A" + ((ArrayType)this).type.toChar();
        } else if (this.equals(new BooleanType())) {
            return "Z";
        } else if (this.equals(new CharType())) {
            return "C";
        } else if (this.equals(new FloatType())) {
            return "F";
        } else if (this.equals(new IntegerType())) {
            return "I";
        } else if (this.equals(new StringType())) {
            return "U";
        } else if (this.equals(new VoidType())) {
            return "V";
        } else {
            assert false : "Should never get here";
            return "B";
        }
    }
}
