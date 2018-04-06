package nodes;

/**
 * Exponential node for PIPCalc.java.
 *
 * Evaluates to the left node raised to the power of the right node.
 */
public class PowerNode extends BinaryOperatorNode{

    public PowerNode(PIPCalcNode left, PIPCalcNode right){
        super(left,right,Precedence.POWER,"^");
    }

    @Override
    public int evaluate() {
        return (int)Math.pow(leftChild.evaluate(),rightChild.evaluate());
    }
}

