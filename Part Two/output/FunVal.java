
public class FunVal extends Value {
    public final String param;
    public Env env;
    public final Expr e1;


    public FunVal(String _param, Expr _e1, Env _env) {
        param = _param;
        env = _env;
        e1 = _e1;
    }

    public String toString() {
	    return "fn";
    }
}
