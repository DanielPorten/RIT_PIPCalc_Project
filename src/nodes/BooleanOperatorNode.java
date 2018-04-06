package nodes;

/**
 * Parent class for boolean nodes.
 * All boolean nodes have the same precedence value.
 * They are functionally equivalent to BinaryOperatorNode.java
 */
public abstract class BooleanOperatorNode extends BinaryOperatorNode{
    BooleanOperatorNode(PIPCalcNode left, PIPCalcNode right, String operator){
        super(left,right,Precedence.BOOLEAN,operator);
    }

    @Override
    public int getPrecedence() {
        return Precedence.BOOLEAN.getPrecedence();
    }
}
