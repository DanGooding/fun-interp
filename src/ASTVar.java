class ASTVar extends ASTNode {
    private final String name;

    ASTVar(String name) {
        this.name = name;
    }

    @Override
    Value evaluate(Environment env) {
        if (env.hasName(name)) {
            return env.lookup(name);
        }
        throw new TypeErrorException(String.format("unbound variable '%s'", name));
    }

    @Override
    public String toString() {
        return name;
    }
}
