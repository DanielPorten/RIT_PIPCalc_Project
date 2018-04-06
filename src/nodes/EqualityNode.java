package nodes;

/**
 * Equality node for PIPCalc.java
 *
 * Returns true if the children evaluate to the same amount.
 */
public class EqualityNode extends BooleanOperatorNode {

    public EqualityNode(PIPCalcNode left, PIPCalcNode right){
        super(left,right,"==");
    }
    @Override
    public int evaluate() {
        if(leftChild.evaluate() == rightChild.evaluate()){
            return 1;
        }
        else{
            return 0;
        }
    }
}
