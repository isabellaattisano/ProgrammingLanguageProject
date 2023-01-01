public class AssnExpr extends Expr {
	public final String id;
	public final Expr n1;

public AssnExpr(String _id, Expr n1) {
    id = _id;
    this.n1 = n1;
}


public Value eval(Env e) throws EvalError {

    try{
        Value v = e.lookup(id);
        Value arg1 = n1.eval(e);

        if(v instanceof IntVal && arg1 instanceof IntVal || v instanceof BoolVal && arg1 instanceof BoolVal){
            e = e.updateBinding(id, arg1);
            return arg1;
        }
        else 
            throw new EvalError("Incompatible types in assignment");

    }
    catch(UnboundVar uv){
        throw new EvalError("Evaluation error: Unbound variable " + id);
    }
}

public String toString() {
    return id + ":=" + n1.toString();
}

}