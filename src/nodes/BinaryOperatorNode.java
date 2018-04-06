package nodes;

/**
 * Parent class for Binary Operator Nodes.
 * These nodes have two children, for which order matters.
 */
public abstract class BinaryOperatorNode implements PIPCalcNode{
    /**
     * The left child of this operator node.
     */
    protected PIPCalcNode leftChild;
    /**
     * The right child of this operator node.
     */
    protected PIPCalcNode rightChild;
    /**
     * The operator node's precedence. This matters for Infix proccessing.
     */
    protected Precedence precedence;
    /**
     * The string representation of this node's operation.
     * i.e. + - * // ==
     */
    protected String operator;

    /**
     * Constructs a binary operator node.
     * @param leftChild The left child of this node.
     * @param rightChild The right child of this node.
     * @param precedence The node's precedence.
     * @param operator The operator for this node.
     */
    public BinaryOperatorNode(PIPCalcNode leftChild, PIPCalcNode rightChild,
                              Precedence precedence, String operator){
        this.leftChild = leftChild;
        this.rightChild = rightChild;
        this.precedence = precedence;
        this.operator = operator;
    }

    public void setLeftChild(PIPCalcNode leftChild) {
        this.leftChild = leftChild;
    }

    public void setRightChild(PIPCalcNode rightChild) {
        this.rightChild = rightChild;
    }

    @Override
    public String toPrefixString() {
        return operator+" "+leftChild.toPrefixString()+" "+rightChild.toPrefixString();
    }

    @Override
    public String toInfixString() {
        return "("+leftChild.toInfixString()+" "+operator+" "+rightChild.toInfixString()+")";
    }

    @Override
    public String toPostfixString() {
        return leftChild.toPostfixString()+" "+rightChild.toPostfixString()+" "+operator;
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
        return NodeType.BinaryOperation;
    }
}
