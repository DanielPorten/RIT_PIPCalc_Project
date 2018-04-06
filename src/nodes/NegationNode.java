package nodes;

/**
 * Negation node for PIPCalc.java
 *
 * Evaluates to the negative of the child.
 */
public class NegationNode extends UnaryOperatorNode{

    public NegationNode(PIPCalcNode child){
        super(child,Precedence.MULT_DIVIDE,"_");
    }

    @Override
    public int evaluate() {
        return -child.evaluate();
    }
}

