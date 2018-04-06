package nodes;

/**
 * Node for PIPCalc.java.
 *
 * Evaluates to the sum of the children nodes.
 */
public class AdditionNode extends BinaryOperatorNode{

    public AdditionNode (PIPCalcNode left, PIPCalcNode right){
        super(left,right,Precedence.ADD_SUBTRACT,"+");
    }

    @Override
    public int evaluate() {
        return leftChild.evaluate() + rightChild.evaluate();
    }
}
