package nodes;

/**
 * Less than or equals node for PIPCalc.java
 *
 * Returns true if the left child is less than or equal to the right child.
 */
public class LessThanEqualNode extends BooleanOperatorNode {

    public LessThanEqualNode(PIPCalcNode left, PIPCalcNode right){
        super(left,right,"<=");
    }
    @Override
    public int evaluate() {
        if(leftChild.evaluate() <= rightChild.evaluate()){
            return 1;
        }
        else{
            return 0;
        }
    }
}
