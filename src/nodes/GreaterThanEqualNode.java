package nodes;

/**
 * Greater than or Equals node for PIPCalc.java
 *
 * Returns true if the left child is greater or equal to the right child.
 */
public class GreaterThanEqualNode extends BooleanOperatorNode {

    public GreaterThanEqualNode(PIPCalcNode left, PIPCalcNode right){
        super(left,right,">=");
    }
    @Override
    public int evaluate() {
        if(leftChild.evaluate() >= rightChild.evaluate()){
            return 1;
        }
        else{
            return 0;
        }
    }
}
