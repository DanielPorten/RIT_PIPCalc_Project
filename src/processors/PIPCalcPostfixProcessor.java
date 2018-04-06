package processors;

import nodes.BinaryOperatorNode;
import nodes.PIPCalcNode;
import nodes.UnaryOperatorNode;

import java.util.ArrayList;
import java.util.Stack;

/**
 * Postfix processor for PIPCalc.java
 */
public class PIPCalcPostfixProcessor extends PIPCalcProcessor {
    /**
     * Constructs a tree from a list of tokens.
     * @param tokens list of IerpNodes used to create the pares tree
     */
    @Override
    public void constructTree(ArrayList<String> tokens) {
        Stack<PIPCalcNode> operandstack = new Stack<>();

        for (String token: tokens){
            //for each token in the token list
            PIPCalcNode newnode = super.createPIPCalcNode(token);
            //make a node out of it.
            if (!(newnode.getNodeType().equals(PIPCalcNode.NodeType.Constant))){
                //if it isn't a constant node,
                if (newnode.getNodeType().equals(PIPCalcNode.NodeType.UnaryOperation)){
                    UnaryOperatorNode unaryOperatorNode = (UnaryOperatorNode)(newnode);
                    unaryOperatorNode.setChild(operandstack.pop());
                    operandstack.push(unaryOperatorNode);
                }
                //if it's a unary node, get a node from the operand stack and set it to the new node's child.
                else{
                    BinaryOperatorNode binaryOperatornode = (BinaryOperatorNode)(newnode);
                    binaryOperatornode.setRightChild(operandstack.pop());
                    binaryOperatornode.setLeftChild(operandstack.pop());
                    operandstack.push(binaryOperatornode);
                }
                //if it's a binary node, get two nodes from the operand stack and set them to the new node's children
            }
            else{
                operandstack.push(newnode);
            }
            //no matter what, place your new node on the stack
        }
        tree = operandstack.pop();
        //once you've processed all nodes, your tree is the node on the operand stack
    }
}
