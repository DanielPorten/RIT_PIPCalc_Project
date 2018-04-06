package nodes;

/**
 * Inequality node for PIPCalc.java
 *
 * Returns true if the left node is strictly different from the right node.
 */
public class NotEqualityNode extends BooleanOperatorNode {

    public NotEqualityNode(PIPCalcNode left, PIPCalcNode right){
        super(left,right,"!=");
    }
    @Override
    public int evaluate() {
        if(leftChild.evaluate() != rightChild.evaluate()){
            return 1;
        }
        else{
            return 0;
        }
    }
}
