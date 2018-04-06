package nodes;

/**
 * Greater than node for PIPCalc.java
 *
 * Returns true if the left child is strictly greater than the right child.
 */
public class GreaterThanNode extends BooleanOperatorNode {

    public GreaterThanNode(PIPCalcNode left, PIPCalcNode right){
        super(left,right,">");
    }
    @Override
    public int evaluate() {
        if(leftChild.evaluate() > rightChild.evaluate()){
            return 1;
        }
        else{
            return 0;
        }
    }
}
