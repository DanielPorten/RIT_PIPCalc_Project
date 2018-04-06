package processors;

import nodes.BinaryOperatorNode;
import nodes.PIPCalcNode;
import nodes.UnaryOperatorNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;

/**
 * Prefix processor for PIPCalc.java
 *
 * Functions similarly to Postfix Processor.
 */
public class PIPCalcPrefixProcessor extends PIPCalcProcessor {

    /**
     * @see PIPCalcPostfixProcessor
     * @param tokens list of IerpNodes used to create the pares tree
     */
    @Override
    public void constructTree(ArrayList<String> tokens) {
        Stack<PIPCalcNode> operandstack = new Stack<>();
        Collections.reverse(tokens);
        //reverse the order of the nodes.
        for (String token: tokens){
            PIPCalcNode newnode = super.createPIPCalcNode(token);
            if (!(newnode.getNodeType().equals(PIPCalcNode.NodeType.Constant))){
                if (newnode.getNodeType().equals(PIPCalcNode.NodeType.UnaryOperation)){
                    UnaryOperatorNode unaryOperatorNode = (UnaryOperatorNode)(newnode);
                    unaryOperatorNode.setChild(operandstack.pop());
                    operandstack.push(unaryOperatorNode);
                }
                else{
                    BinaryOperatorNode binaryOperatornode = (BinaryOperatorNode)(newnode);
                    binaryOperatornode.setLeftChild(operandstack.pop());
                    binaryOperatornode.setRightChild(operandstack.pop());
                    //switch left and right when constructing the tree.
                    operandstack.push(binaryOperatornode);
                }
            }
            else{
                operandstack.push(newnode);
            }
        }
        tree = operandstack.pop();
    }
}
