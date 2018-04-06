package nodes;

/**
 * A constant node for PIPCalc.java.
 *
 * Evaluates to it's stored value.
 * Has no children.
 */
public class ConstantNode implements PIPCalcNode {

    private int value;
    private Precedence thisPrecedence = Precedence.CONSTANT;

    public ConstantNode(int value){
        this.value = value;
    }

    @Override
    public int evaluate() {
        return value;
    }

    @Override
    public String toPrefixString() {
        return value+"";
    }

    @Override
    public String toInfixString() {
        return value+"";
    }

    @Override
    public String toPostfixString() {
        return value+"";
    }

    @Override
    public int getPrecedence() {
        return thisPrecedence.getPrecedence();
    }
    @Override
    public boolean isOperation() {
        return false;
    }

    @Override
    public NodeType getNodeType() {
        return NodeType.Constant;
    }
}
