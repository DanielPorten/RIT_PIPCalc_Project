package nodes;

/**
 * Subtraction node for PIPCalc.java
 *
 * Evaluates to the left node minus the right node.
 */
public class SubtractionNode extends BinaryOperatorNode{

    public SubtractionNode (PIPCalcNode left, PIPCalcNode right){
        super(left,right,Precedence.ADD_SUBTRACT,"-");
    }

    @Override
    public int evaluate() {
        return leftChild.evaluate() - rightChild.evaluate();
    }
}