package nodes;

/**
 * Multiplication node for PIPCalc.java
 *
 * Evaluates to the multiplication of the two children.
 */
public class MultiplicationNode extends BinaryOperatorNode{

    public MultiplicationNode(PIPCalcNode left, PIPCalcNode right){
        super(left,right,Precedence.MULT_DIVIDE,"*");
    }

    @Override
    public int evaluate() {
        return leftChild.evaluate() * rightChild.evaluate();
    }
}
