package nodes;

/**
 * Division node for PIPCalc.java.
 *
 * Evaluates to the left child divided by the right child.
 *
 * Throws an exception if an attempt to divide by zero is detected.
 * Will crash Text view regardless: Exception is implemented for the sake of GUI display.
 * We can just handle the exception by clearing the expression and printing the error
 * to the screen.
 */
public class DivisionNode extends BinaryOperatorNode {

    public DivisionNode(PIPCalcNode left, PIPCalcNode right){
        super(left,right,Precedence.MULT_DIVIDE,"//");
    }
    @Override
    public int evaluate() throws ArithmeticException{
        if (rightChild.evaluate() == 0){
            throw new ArithmeticException("ERR: Divide By Zero");
        }
        else {
            return leftChild.evaluate() / rightChild.evaluate();
        }
    }
}
