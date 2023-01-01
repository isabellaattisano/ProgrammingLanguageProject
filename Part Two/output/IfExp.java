public class IfExp extends Expr{
    public final Expr e;
    public final Expr e1;
    public final Expr e2;
 
     public IfExp(Expr _e, Expr _e1, Expr _e2){
         e = _e;
         e1 = _e1;
         e2 = _e2;
     }
 
     public Value eval(Env env) throws EvalError{
        Value arg1 = e.eval(env);
        if(arg1 instanceof BoolVal) {
        if(((BoolVal)arg1).value){
            return e1.eval(env);
        }
        else 
            return e2.eval(env);
        }
        else throw new EvalError("Evaluation error: test not a boolean");
    }
 
     public String toString() {
         return "if " + e.toString() + " then " + e1.toString() + " else " + e2.toString();
     }
 
 
 }