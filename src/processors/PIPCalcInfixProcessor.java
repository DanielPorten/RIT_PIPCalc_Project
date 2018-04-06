package processors;

import nodes.PIPCalcNode;

import java.util.ArrayList;
import java.util.Stack;

/**
 * Infix proccessor for PIPCalc.java
 *
 * Runs an internal postfix processor, and converts an infix expression to postfix.
 */
public class PIPCalcInfixProcessor extends PIPCalcProcessor {
    /**
     * The internal processor.
     */
    private PIPCalcPostfixProcessor internal = new PIPCalcPostfixProcessor();

    /**
     * Constructs a tree from a list of characters.
     * @param tokens list of IerpNodes used to create the pares tree
     */
    @Override
    public void constructTree(ArrayList<String> tokens) {
        ArrayList<String> outputQueue= new ArrayList<>();
        Stack<String> operatorStack = new Stack<>();
        //use shunting-yard algorithm to convert to postfix string
        while (!(tokens.isEmpty())){
            // While there are tokens to process
            String stringToken = tokens.get(0);
            tokens.remove(0);
            // Get the next token and remove it from the tokens.

            if (createPIPCalcNode(stringToken).getNodeType().equals(PIPCalcNode.NodeType.Constant)){
                outputQueue.add(stringToken);
            }
            //If, when we make a node of this token, it's a constant, put it on the output queue.

            else{
                while( !(createPIPCalcNode(stringToken).getNodeType().equals(PIPCalcNode.NodeType.UnaryOperation)) &&
                        !(operatorStack.empty()) &&
                        (createPIPCalcNode(operatorStack.peek()).getPrecedence()
                                <= createPIPCalcNode(stringToken).getPrecedence())) {
                        outputQueue.add(operatorStack.pop());
                    }
                operatorStack.push(stringToken);
            }
            /* Otherwise, while these conditions are true:
            - The current node is not a Unary Operator
            - The operator stack is not empty
            - The node on the top of the stack has a greater precedence than the current node
            Pop the top of the stack into the output queue.

            Then, put the current node on the stack.
            */
        }

        while(!(operatorStack.empty())){
            outputQueue.add(operatorStack.pop());
        }
        // While the operator stack is still not empty, place the tokens on the output queue.
        internal.constructTree(outputQueue);
        //Construct a tree from the output tree in a postfix method.
        this.tree = internal.tree;
    }
}
