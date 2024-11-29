package vol8.solutionB;

class Symbol {
    private final char value;

    public Symbol(char value) {
        this.value = value;
    }

    public char getValue() {
        return value;
    }

    @Override
    public String toString() {
        return Character.toString(value);
    }
}
