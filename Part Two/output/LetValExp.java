public class LetValExp  extends Expr{
    public final String id;
   public final Expr e1, e2;

    public LetValExp(String _id, Expr _e1, Expr _e2){
        id = _id;
        e1 = _e1;
        e2 = _e2;
    }

    public Value eval(Env e) throws EvalError {
        Value arg1 = e1.eval(e);
        e = e.addBinding(id, arg1);
        return e2.eval(e);
    }

    public String toString() {
        return "let val " + id + " = " + e1.toString() + " in " + e2.toString() + " end";
    }


}
