package nodes;

/**
 * Less than node for PIPCalc.java
 *
 * Returns true if the left child is strictly less than the right child.
 */
public class LessThanNode extends BooleanOperatorNode {

    public LessThanNode(PIPCalcNode left, PIPCalcNode right){
        super(left,right,"<");
    }
    @Override
    public int evaluate() {
        if(leftChild.evaluate() < rightChild.evaluate()){
            return 1;
        }
        else{
            return 0;
        }
    }
}
