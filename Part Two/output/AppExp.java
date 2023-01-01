public class AppExp extends Expr {
    public final String funname;
    public final Expr e1;

    public AppExp(String name, Expr e){
        funname = name;
        e1 = e;
    }


    public Value eval(Env e) throws EvalError {
        try{
            Value v = e.lookup(funname);
            Env env = ((FunVal) v).env;
            if (v instanceof FunVal){
                env = env.addBinding(((FunVal) v).param, e1.eval(e));
                ((FunVal) v).env = env;
                return ((FunVal) v).e1.eval(env);
            }
            else 
                throw new EvalError("Not a function " + funname);

        }
        catch(UnboundVar uv){
            throw new EvalError("Evaluation error: Unbound variable " + funname);
        }

    }

    public String toString() {
        return funname + "(" + e1.toString() + ")";
    }

}
