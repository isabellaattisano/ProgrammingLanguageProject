
public class BinExp extends Expr {
	public final BinOp op;
	public final Expr n1;
	public final Expr n2;

	public BinExp(BinOp b, Expr n1, Expr n2) {
		op = b;
		this.n1 = n1;
		this.n2 = n2;
	}
	
	public Value eval(Env e) throws EvalError {
		Value arg1 = n1.eval(e);
		Value arg2 = n2.eval(e);
		if(arg1 instanceof IntVal && arg2 instanceof IntVal) {
			switch(op) {
			case PLUS: 
				return new IntVal( ((IntVal) arg1).value + ((IntVal) arg2).value);
			case MINUS:
				return new IntVal( ((IntVal) arg1).value - ((IntVal) arg2).value);

			case DIV:
				return new IntVal( ((IntVal) arg1).value / ((IntVal) arg2).value);

			case TIMES:
				return new IntVal( ((IntVal) arg1).value * ((IntVal) arg2).value);
			
			case LT:
				return new BoolVal( ((IntVal) arg1).value < ((IntVal) arg2).value);
			
			case EQ:
				return new BoolVal( ((IntVal) arg1).value == ((IntVal) arg2).value);
			
			default:
				return null;
			}
		}
		else if (arg1 instanceof BoolVal && arg2 instanceof BoolVal){
            switch(op) {
                case OR: 
                    return new BoolVal( ((BoolVal) arg1).value || ((BoolVal) arg2).value);
                case AND:
                    return new BoolVal( ((BoolVal) arg1).value && ((BoolVal) arg2).value);
					case EQ:
					return new BoolVal( ((BoolVal) arg1).value == ((BoolVal) arg2).value);
				default:
					return null;
       		 }
        }

        else 
			throw new EvalError("Evaluation error: Incompatible arg types");
			
	}

	public String toString() {
			switch(op) {
			case PLUS: 
				return n1.toString() + "+" + n2.toString();
				
			case MINUS:
				return n1.toString() + "-" + n2.toString();

			case DIV:
				return n1.toString() + "/" + n2.toString();

			case TIMES:
				return n1.toString() + "*" + n2.toString();
            case OR: 
                return n1.toString() + "|" + n2.toString();

            case AND:
            return n1.toString() + "&" + n2.toString();
			
			case LT: 
				return n1.toString() + "<" + n2.toString();

			case EQ:
				return n1.toString() + "=" + n2.toString();
			default:
				return null;
			}
		
	}

}
