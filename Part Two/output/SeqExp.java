public class SeqExp extends Expr {
    public final Expr e1, e2;

    public SeqExp(Expr _e1, Expr _e2){
        e1 = _e1;
        e2 = _e2;
    }
    public Value eval(Env e) throws EvalError { 
        e1.eval(e);
        return e2.eval(e);
    }

    public String toString() {
        String str = "";
        str+=e1.toString() + ";";
        return str + e2.toString();
    }
    
}
