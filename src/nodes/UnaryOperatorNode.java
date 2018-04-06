package nodes;

/**
 * Unary Operator Node for PIPCalc.java
 *
 * This is a parent class for all nodes with a single child.
 */
public abstract class UnaryOperatorNode implements PIPCalcNode {

    /**
     * The child of this node.
     */
    protected PIPCalcNode child;
    /**
     * The string representation of this node's function.
     */
    protected String operator;
    /**
     * This node's precedence.
     */
    protected Precedence precedence;

    /**
     * Constructs a UnaryOperatorNode
     * @param child The child of this node.
     * @param precedence The string representation of this node's function.
     * @param operator This node's precedence.
     */
    public UnaryOperatorNode(PIPCalcNode child, Precedence precedence, String operator){
        this.child = child;
        this.precedence = precedence;
        this.operator = operator;
    }

    public void setChild(PIPCalcNode child) {
        this.child = child;
    }

    @Override
    public String toPrefixString() {
        return operator+" "+child.toPrefixString();
    }

    @Override
    public String toInfixString() {
        return "("+operator+" "+child.toInfixString()+")";
    }

    @Override
    public String toPostfixString() {
        return child.toPostfixString()+" "+operator;
    }

    @Override
    public int getPrecedence() {
        return precedence.getPrecedence();
    }

    @Override
    public boolean isOperation() {
        return true;
    }

    @Override
    public NodeType getNodeType() {
        return NodeType.UnaryOperation;
    }
}
