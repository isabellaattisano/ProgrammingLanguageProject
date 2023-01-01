public class LetFunExp extends Expr {
    public final String funname, param;
    public final Expr e1, e2;

    public LetFunExp(String _id1, String _id2, Expr _e1, Expr _e2){
        funname = _id1;
        param = _id2;
        e1 = _e1;
        e2 = _e2;
    }


    public Value eval(Env e) throws EvalError {
        e = e.addBinding(funname, new FunVal(param, e1, e));
        e = e.updateBinding(funname, new FunVal(param, e1, e));
        return e2.eval(e);
    }

    public String toString() {
        return "let fun " + funname + "(" + param + ") = " + e1.toString()+ " in " + e2.toString() +  " end ";
    }

}
