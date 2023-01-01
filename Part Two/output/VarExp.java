public class VarExp extends Expr{
    public final String id;
    public VarExp(String _id){
        id = _id;
    }
    
    public Value eval(Env e) throws EvalError {

    try{
        Value v = e.lookup(id);
        return v;
    }
    catch(UnboundVar uv){
        throw new EvalError("Evaluation error: Unbound variable " + id);
    }
    }

    public String toString() {
        return id;
    }

}