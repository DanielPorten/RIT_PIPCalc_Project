package nodes;

/**
 * Square root node for PIPCalc.java
 *
 * Evaluates to the integer square root of the child.
 *
 * Throws an exception if the child is negative.
 * Will crash Text view regardless:
 * this is for GUI display.
 */
public class SquareRootNode extends UnaryOperatorNode {

    public SquareRootNode(PIPCalcNode child){
        super(child,Precedence.POWER,"@");
    }

    @Override
    public int evaluate() throws ArithmeticException{
        if (child.evaluate() < 0){
            throw new ArithmeticException("ERR: Imaginary Number");
        }
        else{
            return (int)Math.sqrt(child.evaluate());
        }
    }
}
