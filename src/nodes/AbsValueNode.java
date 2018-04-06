package nodes;

/**
 * Node for PIPCalc.java.
 *
 * Evaluates to the absolute value of the child.
 */
public class AbsValueNode extends UnaryOperatorNode {

    public AbsValueNode(PIPCalcNode child){
        super(child,Precedence.MULT_DIVIDE,"|");
    }

    @Override
    public int evaluate() {
        if (child.evaluate() < 0){
            return -child.evaluate();
        }
        else{
            return child.evaluate();
        }
    }
}
