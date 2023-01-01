public class WhileExp extends Expr{
   public final Expr e1;
   public final Expr e2;

    public WhileExp(Expr _e1, Expr _e2){
        e1 = _e1;
        e2 = _e2;
    }

    public Value eval(Env e) throws EvalError {
        
        while(e1.eval(e) instanceof BoolVal && ((BoolVal)e1.eval(e)).value){
            e2.eval(e);
        }

        return e1.eval(e);
    }

    public String toString() {
        return "while " + e1.toString() + " do " + e2.toString();
    }


}
